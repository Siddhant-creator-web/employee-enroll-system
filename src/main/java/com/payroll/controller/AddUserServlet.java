package com.payroll.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.payroll.dao.UserDAO;
import com.payroll.model.User;

@WebServlet("/AddUser")
public class AddUserServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        User newUser = new User(username, password, role);

        boolean result = UserDAO.addUser(newUser);

        if (result) {
            response.sendRedirect("manageUsers.jsp");
        } else {
            response.sendRedirect("addUser.jsp?error=1");
        }
    }
}
