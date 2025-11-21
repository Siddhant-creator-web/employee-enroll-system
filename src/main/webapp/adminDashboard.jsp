<%@ page import="com.payroll.model.User" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"ADMIN".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<div class="container mt-5">

    <div class="card shadow p-4">
        <h2 class="text-center mb-3">ADMIN Dashboard</h2>
        <h5 class="text-center text-muted">Welcome, <%= user.getUsername() %>!</h5>

        <hr>

        <ul class="list-group">

            <li class="list-group-item">
                <a href="addUser.jsp" class="text-decoration-none">Add New User (Admin / HR / Employee)</a>
            </li>

            <li class="list-group-item">
                <a href="manageUsers.jsp" class="text-decoration-none">Manage Users</a>
            </li>

            <li class="list-group-item">
                <a href="viewEmployees.jsp" class="text-decoration-none">Manage Employees</a>
            </li>

            <li class="list-group-item">
                <a href="reports.jsp" class="text-decoration-none">Generate Reports</a>
            </li>

            <li class="list-group-item">
                <a href="Logout" class="text-danger text-decoration-none">Logout</a>
            </li>

        </ul>

    </div>
</div>
