package com.payroll.controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.payroll.dao.EmployeeDAO;
import com.payroll.model.Employee;

@WebServlet("/UpdateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String designation = request.getParameter("designation");
        double basicSalary = Double.parseDouble(request.getParameter("basic_salary"));
        double hra = Double.parseDouble(request.getParameter("hra"));
        double da = Double.parseDouble(request.getParameter("da"));
        double pf = Double.parseDouble(request.getParameter("pf"));

        Employee emp = new Employee(id, name, designation, basicSalary, hra, da, pf);

        boolean updated = EmployeeDAO.updateEmployee(emp);

        if (updated) {
            response.sendRedirect("viewEmployees.jsp");
        } else {
            response.getWriter().println("Error updating employee.");
        }
    }
}
