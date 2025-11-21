<%@ page import="com.payroll.dao.EmployeeDAO" %>
<%@ page import="com.payroll.model.Employee" %>

<%
    String idParam = request.getParameter("id");

    if (idParam == null || idParam.trim().isEmpty()) {
        out.println("<h3 class='text-danger text-center mt-4'>Invalid Request: Employee ID missing!</h3>");
        return;
    }

    int id = Integer.parseInt(idParam);
    Employee emp = EmployeeDAO.getEmployeeById(id);

    if (emp == null) {
        out.println("<h3 class='text-danger text-center mt-4'>Employee not found!</h3>");
        return;
    }
%>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<div class="container mt-5">
    <div class="card shadow p-4">
        <h3 class="mb-4 text-center">Edit Employee Details</h3>

        <form action="UpdateEmployee" method="post">

            <input type="hidden" name="id" value="<%= emp.getId() %>">

            <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="text" name="name" value="<%= emp.getName() %>" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Designation</label>
                <input type="text" name="designation" value="<%= emp.getDesignation() %>" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Basic Salary</label>
                <input type="number" name="basic_salary" value="<%= emp.getBasicSalary() %>" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">HRA</label>
                <input type="number" name="hra" value="<%= emp.getHra() %>" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">DA</label>
                <input type="number" name="da" value="<%= emp.getDa() %>" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">PF</label>
                <input type="number" name="pf" value="<%= emp.getPf() %>" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">Update</button>

        </form>
    </div>
</div>
