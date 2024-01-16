/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.entity.Brand;

public class BrandDAO {
    private Connection connection;

    public BrandDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Brand> getAllBrands() {
        List<Brand> brandList = new ArrayList<>();
        String sql = "SELECT * FROM Brands";
        
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Brand brand = new Brand();
                brand.setBrandID(resultSet.getInt("BrandID"));
                brand.setBrandName(resultSet.getString("BrandName"));

                brandList.add(brand);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return brandList;
    }

    public Brand getBrandById(int brandID) {
        String sql = "SELECT * FROM Brands WHERE BrandID = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, brandID);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Brand brand = new Brand();
                    brand.setBrandID(resultSet.getInt("BrandID"));
                    brand.setBrandName(resultSet.getString("BrandName"));
                    return brand;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return null;
    }

    public void addBrand(Brand brand) {
        String sql = "INSERT INTO Brands (BrandName) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, brand.getBrandName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public void updateBrand(Brand brand) {
        String sql = "UPDATE Brands SET BrandName = ? WHERE BrandID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, brand.getBrandName());
            statement.setInt(2, brand.getBrandID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public void deleteBrand(int brandID) {
        String sql = "DELETE FROM Brands WHERE BrandID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, brandID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    // Add other methods as needed

    // Remember to handle exceptions appropriately
}
