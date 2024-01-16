-- Tạo Cơ sở dữ liệu
drop database WatchStore


CREATE DATABASE WatchStore;
USE WatchStore;

-- Tạo bảng Users để lưu thông tin người dùng
CREATE TABLE Users (
    UserID INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Username NVARCHAR(50) UNIQUE NOT NULL,
    Password TEXT NOT NULL,
	Email NVARCHAR(100) NOT NULL,
	Address NVARCHAR(100) NOT NULL,
	Phone NVARCHAR(100) NOT NULL,
    Role NVARCHAR(50) NOT NULL
);

-- Tạo bảng Categories để lưu thông tin danh mục sản phẩm
CREATE TABLE Categories (
    CategoryID INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    CategoryName NVARCHAR(50) NULL
);

-- Tạo bảng Brands để lưu thông tin thương hiệu sản phẩm
CREATE TABLE Brands (
    BrandID INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    BrandName NVARCHAR(50) NULL
);

-- Tạo bảng Products để lưu thông tin sản phẩm
CREATE TABLE Products (
    ProductID INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    ProductName NVARCHAR(100) NULL,
    Price DECIMAL(10, 2) NULL,
	ProductDescription NVARCHAR(100) NULL,
    StockQuantity INT NULL,
	BrandID INT FOREIGN KEY REFERENCES Brands(BrandID),
	ImageURL NVARCHAR(100) NULL,
);

-- Tạo bảng ProductCategories để quản lý mối quan hệ nhiều-nhiều giữa Products và Categories
CREATE TABLE ProductCategories (
    ProductCategoryID INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    ProductID INT FOREIGN KEY REFERENCES Products(ProductID) NOT NULL,
    CategoryID INT FOREIGN KEY REFERENCES Categories(CategoryID) NOT NULL
);


-- Tạo bảng ShoppingCart để lưu thông tin giỏ hàng
CREATE TABLE ShoppingCart (
    CartID INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    UserID INT FOREIGN KEY REFERENCES Users(UserID) NOT NULL,
    ProductID INT FOREIGN KEY REFERENCES Products(ProductID) NOT NULL,
    Quantity INT NULL
);

-- Tạo bảng Feedback để lưu đánh giá sản phẩm
CREATE TABLE Feedback (
    FeedbackID INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    UserID INT FOREIGN KEY REFERENCES Users(UserID) NOT NULL,
    ProductID INT FOREIGN KEY REFERENCES Products(ProductID) NOT NULL,
    Comment NVARCHAR(MAX) NULL,
    Rating INT NULL
);

-- Tạo bảng Orders để lưu thông tin đơn hàng
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    UserID INT FOREIGN KEY REFERENCES Users(UserID) NOT NULL,
    OrderDate DATETIME NULL,
);

-- Tạo bảng OrderDetails để lưu chi tiết đơn hàng
CREATE TABLE OrderDetails (
    OrderDetailID INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    OrderID INT FOREIGN KEY REFERENCES Orders(OrderID) NOT NULL,
    ProductID INT FOREIGN KEY REFERENCES Products(ProductID) NOT NULL,
    Quantity INT NULL,
    Subtotal DECIMAL(10, 2) NULL
);
