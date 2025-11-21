package com.payroll.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.payroll.model.Employee;

public class EmployeeDAO {

    // ---- DATABASE CONNECTION ----
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

    
    
    
    // ---- ADD EMPLOYEE ----
    public static boolean addEmployee(Employee e) {
        boolean status = false;

        String query = "INSERT INTO employees (name, designation, basic_salary, hra, da, pf) VALUES (?,?,?,?,?,?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, e.getName());
            ps.setString(2, e.getDesignation());
            ps.setDouble(3, e.getBasicSalary());
            ps.setDouble(4, e.getHra());
            ps.setDouble(5, e.getDa());
            ps.setDouble(6, e.getPf());

            status = ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    // ---- GET ALL EMPLOYEES ----
    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();

        String query = "SELECT * FROM employees";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee e = new Employee();

                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setDesignation(rs.getString("designation"));
                e.setBasicSalary(rs.getDouble("basic_salary"));
                e.setHra(rs.getDouble("hra"));
                e.setDa(rs.getDouble("da"));
                e.setPf(rs.getDouble("pf"));

                list.add(e);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    // ---- GET EMPLOYEE BY ID ----
    public static Employee getEmployeeById(int id) {
        Employee emp = null;

        String query = "SELECT * FROM employees WHERE id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setDesignation(rs.getString("designation"));
                emp.setBasicSalary(rs.getDouble("basic_salary"));
                emp.setHra(rs.getDouble("hra"));
                emp.setDa(rs.getDouble("da"));
                emp.setPf(rs.getDouble("pf"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return emp;
    }

 // ---- DELETE EMPLOYEE ----
    public static boolean deleteEmployee(int id) {
        boolean status = false;

        String query = "DELETE FROM employees WHERE id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    
    // ---- UPDATE EMPLOYEE ----
    public static boolean updateEmployee(Employee emp) {
        boolean status = false;

        String query =
            "UPDATE employees SET name=?, designation=?, basic_salary=?, hra=?, da=?, pf=? WHERE id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDesignation());
            ps.setDouble(3, emp.getBasicSalary());
            ps.setDouble(4, emp.getHra());
            ps.setDouble(5, emp.getDa());
            ps.setDouble(6, emp.getPf());
            ps.setInt(7, emp.getId());

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
