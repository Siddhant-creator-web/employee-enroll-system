<%@ page language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center" style="height: 100vh;">
    
    <div class="card shadow p-4" style="width: 350px;">

        <h3 class="text-center mb-3">Login</h3>

        <form method="post" action="Login">

            <div class="mb-3">
                <label class="form-label">Username</label>
                <input type="text" name="username" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Password</label>
                <input type="password" name="password" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">Login</button>
        </form>

        <% if (request.getAttribute("error") != null) { %>
            <div class="alert alert-danger mt-3 text-center">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>

    </div>

</div>

</body>
</html>
