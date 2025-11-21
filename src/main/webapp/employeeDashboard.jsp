<%@ page import="com.payroll.model.User" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"EMPLOYEE".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow p-4" style="max-width: 700px; margin: auto;">
        
        <h2 class="text-center mb-3">Employee Dashboard</h2>

        <div class="alert alert-info text-center">
            Welcome, <strong><%= user.getUsername() %></strong>!
        </div>

        <ul class="list-group">
            <li class="list-group-item">
                <a href="viewProfile.jsp" class="text-decoration-none">My Profile</a>
            </li>

            <li class="list-group-item">
                <a href="salarySlip.jsp" class="text-decoration-none">My Salary Slip</a>
            </li>

            <li class="list-group-item">
                <a href="Logout" class="text-decoration-none text-danger">Logout</a>
            </li>
        </ul>

    </div>

</div>

</body>
</html>
