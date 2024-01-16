package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.BrandDAO;
import model.entity.Brand;
import model.entity.Product;

public class ProductDAO {
    private Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public void addProduct(Product product) {
        String sql = "INSERT INTO Products (ProductName, Price, ProductDescription, StockQuantity, BrandID, ImageURL) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getProductName());
            statement.setBigDecimal(2, product.getPrice());
            statement.setString(3, product.getProductDescription());
            statement.setInt(4, product.getStockQuantity());
            statement.setInt(5, product.getBrand().getBrandID());
            statement.setString(6, product.getImageURL());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public Product getProductById(int productId) {
        String sql = "SELECT * FROM Products WHERE ProductID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToProduct(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM Products";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Product product = mapResultSetToProduct(resultSet);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return productList;
    }

    public void updateProduct(Product product) {
        String sql = "UPDATE Products SET ProductName = ?, Price = ?, ProductDescription = ?, " +
                     "StockQuantity = ?, BrandID = ?, ImageURL = ? WHERE ProductID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getProductName());
            statement.setBigDecimal(2, product.getPrice());
            statement.setString(3, product.getProductDescription());
            statement.setInt(4, product.getStockQuantity());
            statement.setInt(5, product.getBrand().getBrandID());
            statement.setString(6, product.getImageURL());
            statement.setInt(7, product.getProductID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public void deleteProduct(int productId) {
        String sql = "DELETE FROM Products WHERE ProductID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    private Product mapResultSetToProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setProductID(resultSet.getInt("ProductID"));
        product.setProductName(resultSet.getString("ProductName"));
        product.setPrice(resultSet.getBigDecimal("Price"));
        product.setProductDescription(resultSet.getString("ProductDescription"));
        product.setStockQuantity(resultSet.getInt("StockQuantity"));

        BrandDAO brandDAO = new BrandDAO(connection);
        Brand brand = brandDAO.getBrandById(resultSet.getInt("BrandID"));
        product.setBrand(brand);

        product.setImageURL(resultSet.getString("ImageURL"));

        return product;
    }
}
