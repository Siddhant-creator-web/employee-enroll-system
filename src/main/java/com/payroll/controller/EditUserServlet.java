package com.payroll.controller;

import com.payroll.dao.UserDAO;
import com.payroll.model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/EditUser")
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get user ID from request
        int id = Integer.parseInt(request.getParameter("id"));

        // Fetch user from database
        User user = UserDAO.getUserById(id);

        // Set user as request attribute
        request.setAttribute("user", user);

        // Forward to editUser.jsp
        RequestDispatcher rd = request.getRequestDispatcher("editUser.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Optionally handle post here if you want to update directly
    }
}
