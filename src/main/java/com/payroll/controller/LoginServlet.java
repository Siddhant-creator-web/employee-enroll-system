package com.payroll.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import com.payroll.dao.UserDAO;
import com.payroll.model.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = UserDAO.login(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Redirect based on role
            switch (user.getRole()) {
                case "ADMIN":
                    response.sendRedirect("adminDashboard.jsp");
                    break;

                case "HR":
                    response.sendRedirect("hrDashboard.jsp");
                    break;

                case "EMPLOYEE":
                    response.sendRedirect("employeeDashboard.jsp");
                    break;

                default:
                    response.sendRedirect("login.jsp?error=Invalid Role");
            }

        } else {
            response.sendRedirect("login.jsp?error=Invalid Credentials");
        }
    }
}
