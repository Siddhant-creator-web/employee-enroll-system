<%@ page import="java.util.*, com.payroll.model.User, com.payroll.dao.UserDAO" %>
<%@ page session="true" %>

<%
    // Only ADMIN can edit/delete users
    User currentUser = (User) session.getAttribute("user");
    if (currentUser == null || !"ADMIN".equals(currentUser.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<User> users = UserDAO.getAllUsers();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Manage Users</title>

    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2 class="text-primary">Manage Users</h2>
        <a href="addUser.jsp" class="btn btn-success">+ Add New User</a>
    </div>

    <div class="card shadow">
        <div class="card-body">

            <table class="table table-bordered table-striped text-center align-middle">
                <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Actions</th>
                </tr>
                </thead>

                <tbody>
                <%
                    for (User u : users) {
                %>
                <tr>
                    <td><%= u.getId() %></td>
                    <td><%= u.getUsername() %></td>
                    <td><span class="badge bg-info text-dark"><%= u.getRole() %></span></td>

                    <td>

                        <!-- Edit Button -->
                        <form action="EditUser" method="get" class="d-inline">
                            <input type="hidden" name="id" value="<%= u.getId() %>">
                            <button type="submit" class="btn btn-sm btn-primary">Edit</button>
                        </form>

                        <!-- Delete Button -->
                        <form action="DeleteUser" method="post" class="d-inline"
                              onsubmit="return confirm('Are you sure you want to delete this user?');">
                            <input type="hidden" name="id" value="<%= u.getId() %>">
                            <button type="submit" class="btn btn-sm btn-danger">Delete</button>
                        </form>

                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>

            </table>

        </div>
    </div>

    <div class="mt-3">
        <a href="adminDashboard.jsp" class="btn btn-secondary">Back to Dashboard</a>
    </div>

</div>

</body>
</html>
