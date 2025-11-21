package com.payroll.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.payroll.model.User;

public class UserDAO {

    private static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/payroll_db", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    
   
    
    
    public static User getUserById(int id) {
        User user = null;
        String query = "SELECT * FROM users WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password")); // plain text
                user.setRole(rs.getString("role"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    
 // Inside UserDAO.java
    public static User login(String username, String password) {
        User user = null;

        String query = "SELECT * FROM users WHERE username=? AND password=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    
    // ADD NEW USER
    public static boolean addUser(User user) {
        boolean status = false;

        String query = "INSERT INTO users(username, password, role) VALUES (?,?,?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // GET USER BY USERNAME (for login)
    public static User getUserByUsername(String username) {
        User user = null;

        String query = "SELECT * FROM users WHERE username=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    // GET ALL USERS
    public static List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        String query = "SELECT * FROM users";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User u = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                );
                list.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE USER
    public static boolean updateUser(User user) {
        boolean status = false;
        String query = "UPDATE users SET username=?, password=?, role=? WHERE id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.setInt(4, user.getId());

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }


    // DELETE USER
    public static boolean deleteUser(int id) {
        boolean status = false;

        String query = "DELETE FROM users WHERE id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    

}
