<%@ page import="java.util.*, com.payroll.dao.EmployeeDAO, com.payroll.model.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>

    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">
        <div class="card-header bg-primary text-white text-center">
            <h3>Employee List</h3>
        </div>

        <div class="card-body">

            <table class="table table-bordered table-striped text-center align-middle">
                <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Designation</th>
                    <th>Basic Salary</th>
                    <th>HRA</th>
                    <th>DA</th>
                    <th>PF</th>
                    <th>Actions</th>
                </tr>
                </thead>

                <tbody>
                <%
                    List<Employee> list = EmployeeDAO.getAllEmployees();
                    for (Employee e : list) {
                %>
                <tr>
                    <td><%= e.getId() %></td>
                    <td><%= e.getName() %></td>
                    <td><%= e.getDesignation() %></td>
                    <td>₹ <%= e.getBasicSalary() %></td>
                    <td>₹ <%= e.getHra() %></td>
                    <td>₹ <%= e.getDa() %></td>
                    <td>₹ <%= e.getPf() %></td>
                    <td>
                        <a href="editEmployee.jsp?id=<%= e.getId() %>"
                           class="btn btn-sm btn-warning">
                            Edit
                        </a>

                        <a href="DeleteEmployee?id=<%= e.getId() %>"
                           class="btn btn-sm btn-danger ms-2"
                           onclick="return confirm('Are you sure you want to delete this employee?');">
                            Delete
                        </a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>

            <div class="text-start mt-3">
                <a href="adminDashboard.jsp" class="btn btn-secondary">
                    Back to Dashboard
                </a>
            </div>

        </div>
    </div>

</div>

</body>
</html>
