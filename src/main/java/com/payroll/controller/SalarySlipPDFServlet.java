package com.payroll.controller;

import com.payroll.dao.EmployeeDAO;
import com.payroll.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.OutputStream;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

@WebServlet("/SalarySlip")
public class SalarySlipPDFServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int empId = Integer.parseInt(request.getParameter("id"));
        Employee emp = EmployeeDAO.getEmployeeById(empId);

        if (emp == null) {
            response.getWriter().println("Employee not found");
            return;
        }

        // Set response type for PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=salarySlip.pdf");

        try (OutputStream out = response.getOutputStream()) {

            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Title (NO CENTER ALIGNMENT)
            Paragraph title = new Paragraph("Salary Slip")
                    .setBold()
                    .setFontSize(20);
            document.add(title);

            // Employee Details
            document.add(new Paragraph("Employee ID: " + emp.getId()));
            document.add(new Paragraph("Name: " + emp.getName()));
            document.add(new Paragraph("Designation: " + emp.getDesignation()));
            document.add(new Paragraph("Basic Salary: " + emp.getBasicSalary()));
            document.add(new Paragraph("HRA: " + emp.getHra()));
            document.add(new Paragraph("DA: " + emp.getDa()));
            document.add(new Paragraph("PF: " + emp.getPf()));

            double totalSalary = emp.getBasicSalary() + emp.getHra() + emp.getDa() - emp.getPf();
            document.add(new Paragraph("Net Salary: " + totalSalary).setBold());

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
