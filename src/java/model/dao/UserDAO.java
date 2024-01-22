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
import model.database.DatabaseConnector;
import model.entity.User;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }
    
     public User checkLogIn(String email, String password) {
    try {
        Connection con = DatabaseConnector.getConnection();
        String sql = "SELECT * FROM Users WHERE Email = ? AND CONVERT(VARCHAR(MAX), Password) = ?";
       

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    User user = new User(rs.getString("Username"), rs.getString("Password"), rs.getString("Email"), rs.getString("Address"), rs.getString("Phone"),rs.getString("Role"));
                    return user;
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception appropriately
    }
    return null;
}
  

     
     
     
    public void addUser(User user) {
        String sql = "INSERT INTO Users (Username, Password, Email, Address, Phone, Role) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getPhone());
            statement.setString(6, user.getRole());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public User getUserById(int userId) {
        String sql = "SELECT * FROM Users WHERE UserID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();
                    user.setUserID(resultSet.getInt("UserID"));
                    user.setUsername(resultSet.getString("Username"));
                    user.setPassword(resultSet.getString("Password"));
                    user.setEmail(resultSet.getString("Email"));
                    user.setAddress(resultSet.getString("Address"));
                    user.setPhone(resultSet.getString("Phone"));
                    user.setRole(resultSet.getString("Role"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("UserID"));
                user.setUsername(resultSet.getString("Username"));
                user.setPassword(resultSet.getString("Password"));
                user.setEmail(resultSet.getString("Email"));
                user.setAddress(resultSet.getString("Address"));
                user.setPhone(resultSet.getString("Phone"));
                user.setRole(resultSet.getString("Role"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return userList;
    }

   public boolean updateUserProfile(User user) {
    String sql = "UPDATE Users SET Username = ?, Password = ?, Email = ?, Address = ?, Phone = ? WHERE UserID = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getAddress());
        statement.setString(5, user.getPhone());
        statement.setInt(6, user.getUserID()); // Corrected index, should be 6

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0; // If rowsUpdated > 0, the update was successful

    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception appropriately
    }
    return false;
}
   
      /* public void addUser(User user) {
        String sql = "INSERT INTO Users (Username, Password, Email, Address, Phone, Role) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getPhone());
            statement.setString(6, user.getRole());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    } */


    public void deleteUser(int userId) {
        String sql = "DELETE FROM Users WHERE UserID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
    public boolean checkUserExist(String email, String username) {
    String query = "SELECT COUNT(*) FROM Users WHERE Email = ? OR Username = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, email);
        statement.setString(2, username);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Returns true if either email or username exists
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle SQL exception appropriately
    }
    return false; // Returns false if there is an SQL error or neither email nor username is found
}

}

