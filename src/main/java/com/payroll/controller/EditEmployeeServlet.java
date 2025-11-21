package com.payroll.controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.payroll.dao.EmployeeDAO;
import com.payroll.model.Employee;

@WebServlet("/EditEmployee")
public class EditEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Employee emp = EmployeeDAO.getEmployeeById(id);  // MUST MATCH DAO METHOD NAME

        if (emp == null) {
            response.getWriter().println("❌ Employee NOT found with ID: " + id);
            return;
        }

        request.setAttribute("employee", emp);
        request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
    }
}
