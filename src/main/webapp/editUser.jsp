<%@ page import="com.payroll.model.User" %>
<%@ page session="true" %>

<%
    User currentUser = (User) session.getAttribute("user");
    if (currentUser == null || !"ADMIN".equals(currentUser.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }

    User user = (User) request.getAttribute("user");
    if (user == null) {
        response.sendRedirect("viewUsers.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow p-4" style="max-width: 600px; margin: auto;">
        <h3 class="text-center mb-4">Edit User</h3>

        <form action="UpdateUser" method="post">

            <input type="hidden" name="id" value="<%= user.getId() %>">

            <div class="mb-3">
                <label class="form-label">Username</label>
                <input 
                    type="text" 
                    name="username" 
                    value="<%= user.getUsername() %>" 
                    required 
                    class="form-control">
            </div>

            <div class="mb-3">
                <label class="form-label">Role</label>
                <select name="role" class="form-select" required>
                    <option value="ADMIN" <%= "ADMIN".equals(user.getRole()) ? "selected" : "" %>>Admin</option>
                    <option value="HR" <%= "HR".equals(user.getRole()) ? "selected" : "" %>>HR</option>
                    <option value="EMPLOYEE" <%= "EMPLOYEE".equals(user.getRole()) ? "selected" : "" %>>Employee</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary w-100">Update User</button>

        </form>

        <div class="text-center mt-3">
            <a href="viewUsers.jsp" class="btn btn-outline-secondary btn-sm">Back to Users List</a>
        </div>
    </div>

</div>

</body>
</html>
