<%@ page import="com.payroll.model.User" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"ADMIN".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<div class="container mt-5">
    <div class="card shadow-lg p-4 mx-auto" style="max-width: 500px;">
        <h3 class="text-center mb-4">Add New User</h3>

        <form action="AddUser" method="post">

            <div class="mb-3">
                <label class="form-label">Username</label>
                <input type="text" name="username" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Password</label>
                <input type="text" name="password" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Role</label>
                <select name="role" class="form-select">
                    <option value="ADMIN">Admin</option>
                    <option value="HR">HR</option>
                    <option value="EMPLOYEE">Employee</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary w-100">Create User</button>

        </form>
    </div>
</div>
