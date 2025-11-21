package com.payroll.controller;

import com.payroll.dao.UserDAO;
import com.payroll.model.User;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/UpdateUser")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String role = request.getParameter("role");

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setRole(role);

        boolean updated = UserDAO.updateUser(user);

        if (updated) {
            response.sendRedirect("viewUsers.jsp");
        } else {
            response.getWriter().println("Error updating user.");
        }
    }
}
