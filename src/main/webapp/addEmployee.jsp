<!-- Add this Bootstrap CDN in your <head> -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<div class="container mt-5">
    <div class="card shadow-lg p-4">
        <h3 class="text-center mb-4">Add Employee</h3>

        <form action="AddEmployee" method="post">

            <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="text" name="name" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Designation</label>
                <input type="text" name="designation" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Basic Salary</label>
                <input type="number" name="basicSalary" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">HRA</label>
                <input type="number" name="hra" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">DA</label>
                <input type="number" name="da" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">PF</label>
                <input type="number" name="pf" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">Add Employee</button>

        </form>
    </div>
</div>

