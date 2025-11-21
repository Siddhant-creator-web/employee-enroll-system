package com.payroll.controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import com.payroll.dao.EmployeeDAO;

@WebServlet("/DeleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String idParam = request.getParameter("id");

            if (idParam != null) {
                int id = Integer.parseInt(idParam);
                EmployeeDAO.deleteEmployee(id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Redirect back to list page
        response.sendRedirect("viewEmployees.jsp");
    }
}
