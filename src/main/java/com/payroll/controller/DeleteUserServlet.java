package com.payroll.controller;

import com.payroll.dao.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/DeleteUser")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get user ID to delete
        int id = Integer.parseInt(request.getParameter("id"));

        // Call DAO to delete
        boolean deleted = UserDAO.deleteUser(id);

        if (deleted) {
            response.sendRedirect("viewUsers.jsp");
        } else {
            response.getWriter().println("Error deleting user.");
        }
    }
}
