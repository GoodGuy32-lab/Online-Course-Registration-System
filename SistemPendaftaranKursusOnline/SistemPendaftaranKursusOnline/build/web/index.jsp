<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sistem Pendaftaran Kursus Online</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            height: 100vh;
            display: flex;
            align-items: center;
        }
        .login-card {
            background: white;
            border-radius: 15px;
            padding: 40px;
            box-shadow: 0 20px 40px rgba(0,0,0,0.1);
        }
        .test-account {
            background-color: #f8f9fa;
            border-radius: 8px;
            padding: 15px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="login-card">
                    <h2 class="text-center mb-4">Sistem Pendaftaran Kursus Online</h2>
                    
                    <!-- Tampilkan error message -->
                    <% 
                    String error = request.getParameter("error");
                    if (error != null) {
                        String errorMessage = "";
                        if (error.equals("empty")) {
                            errorMessage = "Email dan password harus diisi!";
                        } else if (error.equals("invalid")) {
                            errorMessage = "Email atau password salah!";
                        } else if (error.equals("not_logged_in")) {
                            errorMessage = "Silakan login terlebih dahulu!";
                        } else {
                            errorMessage = "Terjadi kesalahan saat login!";
                        }
                    %>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <%= errorMessage %>
                        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    </div>
                    <% } %>
                    
                    <!-- Tampilkan success message -->
                    <% 
                    String message = request.getParameter("message");
                    if (message != null) {
                        String successMessage = "";
                        if (message.equals("registered")) {
                            successMessage = "Registrasi berhasil! Silakan login.";
                        } else if (message.equals("logged_out")) {
                            successMessage = "Anda telah logout.";
                        }
                    %>
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        <%= successMessage %>
                        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    </div>
                    <% } %>
                    
                    <form action="login" method="POST">
                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="email" class="form-control" name="email" placeholder="Masukkan email" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input type="password" class="form-control" name="password" placeholder="Masukkan password" required>
                        </div>
                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-primary">Login</button>
                            <a href="register.jsp" class="btn btn-outline-success">Registrasi Akun Baru</a>
                        </div>
                    </form>
                    
                    <hr class="my-4">
                    
                    <div class="test-account">
                        <p class="text-center mb-2"><strong>Akun Demo:</strong></p>
                        <div class="row text-center">
                            <div class="col-6">
                                <small><strong>Admin</strong></small><br>
                                <code>admin@email.com</code><br>
                                <code>admin123</code>
                            </div>
                            <div class="col-6">
                                <small><strong>Peserta</strong></small><br>
                                <code>budi@email.com</code><br>
                                <code>password123</code>
                            </div>
                        </div>
                    </div>
                    
                    <div class="text-center mt-3">
                        <a href="dashboard.jsp" class="btn btn-outline-secondary btn-sm">
                            Coba akses dashboard langsung
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>