<%@ page import="com.payroll.model.Employee" %>
<%@ page import="com.payroll.dao.EmployeeDAO" %>
<%@ page import="com.payroll.model.User" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"EMPLOYEE".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
    }

    Employee emp = EmployeeDAO.getEmployeeById(user.getId());

    if (emp == null) {
%>
<!DOCTYPE html>
<html>
<head>
    <title>My Profile</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="alert alert-danger text-center">
        Employee details not found!
    </div>

    <div class="text-center">
        <a href="employeeDashboard.jsp" class="btn btn-secondary">Back to Dashboard</a>
    </div>
</div>

</body>
</html>

<%
        return;
    }
%>

<html>
<head>
    <title>My Profile</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white text-center">
            <h3>My Profile</h3>
        </div>

        <div class="card-body">

            <table class="table table-bordered table-striped">
                <tr><th>ID</th><td><%= emp.getId() %></td></tr>
                <tr><th>Name</th><td><%= emp.getName() %></td></tr>
                <tr><th>Designation</th><td><%= emp.getDesignation() %></td></tr>
                <tr><th>Basic Salary</th><td>₹ <%= emp.getBasicSalary() %></td></tr>
                <tr><th>HRA</th><td>₹ <%= emp.getHra() %></td></tr>
                <tr><th>DA</th><td>₹ <%= emp.getDa() %></td></tr>
                <tr><th>PF</th><td>₹ <%= emp.getPf() %></td></tr>
            </table>

            <div class="text-end">
                <a href="employeeDashboard.jsp" class="btn btn-secondary">
                    Back to Dashboard
                </a>
            </div>

        </div>
    </div>

</div>

</body>
</html>
