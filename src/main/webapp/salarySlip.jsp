<%@ page language="java" import="com.payroll.model.Employee, com.payroll.model.User, com.payroll.dao.EmployeeDAO" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");

    if (user == null || !"EMPLOYEE".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }

    Employee emp = EmployeeDAO.getEmployeeById(user.getId());

    if (emp == null) {
%>
        <h3 class="text-danger text-center mt-5">Employee data not found.</h3>
<%
        return;
    }

    double totalSalary = emp.getBasicSalary() + emp.getHra() + emp.getDa() - emp.getPf();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Salary Slip</title>

    <!-- Bootstrap CDN -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white text-center">
            <h3>Salary Slip</h3>
        </div>

        <div class="card-body">

            <table class="table table-bordered">
                <tr><th>Employee ID</th><td><%= emp.getId() %></td></tr>
                <tr><th>Name</th><td><%= emp.getName() %></td></tr>
                <tr><th>Designation</th><td><%= emp.getDesignation() %></td></tr>
                <tr><th>Basic Salary</th><td>₹ <%= emp.getBasicSalary() %></td></tr>
                <tr><th>HRA</th><td>₹ <%= emp.getHra() %></td></tr>
                <tr><th>DA</th><td>₹ <%= emp.getDa() %></td></tr>
                <tr><th>PF</th><td>₹ <%= emp.getPf() %></td></tr>
                <tr class="table-success">
                    <th>Total Salary</th>
                    <td><strong><%= totalSalary %></strong></td>
                </tr>
            </table>

            <div class="d-flex justify-content-between mt-4">
                <a href="SalarySlip?id=<%= emp.getId() %>" target="_blank" class="btn btn-success">
                    Download PDF
                </a>

                <a href="EmployeeDashboard.jsp" class="btn btn-secondary">
                    Back to Dashboard
                </a>
            </div>

        </div>
    </div>

</div>

</body>
</html>
