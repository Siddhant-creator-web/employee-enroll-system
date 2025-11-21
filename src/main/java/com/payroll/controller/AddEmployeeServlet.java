package com.payroll.controller;

import com.payroll.dao.EmployeeDAO;
import com.payroll.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/AddEmployee")
public class AddEmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        System.out.println("AddEmployeeServlet Called");

        String name = req.getParameter("name");
        String des = req.getParameter("designation");
        double basic = Double.parseDouble(req.getParameter("basicSalary"));
        double hra = Double.parseDouble(req.getParameter("hra"));
        double da = Double.parseDouble(req.getParameter("da"));
        double pf = Double.parseDouble(req.getParameter("pf"));

        Employee e = new Employee();
        e.setName(name);
        e.setDesignation(des);
        e.setBasicSalary(basic);
        e.setHra(hra);
        e.setDa(da);
        e.setPf(pf);

        // FIXED: addEmployee instead of updateEmployee
        EmployeeDAO.addEmployee(e);

        res.sendRedirect("viewEmployees.jsp");
    }
}
