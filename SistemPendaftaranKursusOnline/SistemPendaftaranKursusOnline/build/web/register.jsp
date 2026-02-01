<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrasi Peserta</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            padding: 20px 0;
        }
        .register-card {
            background: white;
            border-radius: 15px;
            padding: 40px;
            box-shadow: 0 20px 40px rgba(0,0,0,0.1);
        }
        .form-icon {
            color: #667eea;
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="register-card">
                    <div class="text-center mb-4">
                        <h2>Registrasi Peserta Baru</h2>
                        <p class="text-muted">Isi formulir di bawah untuk membuat akun baru</p>
                    </div>
                    
                    <!-- Tampilkan error message -->
                    <% 
                    String error = request.getParameter("error");
                    if (error != null) {
                        String errorMessage = "";
                        if (error.equals("empty")) {
                            errorMessage = "Semua field harus diisi!";
                        } else if (error.equals("email_exists")) {
                            errorMessage = "Email sudah terdaftar!";
                        } else if (error.equals("password_mismatch")) {
                            errorMessage = "Password dan konfirmasi password tidak cocok!";
                        } else {
                            errorMessage = "Terjadi kesalahan saat registrasi!";
                        }
                    %>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <%= errorMessage %>
                        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    </div>
                    <% } %>
                    
                    <!-- Tampilkan success message -->
                    <% 
                    String success = request.getParameter("success");
                    if (success != null && success.equals("true")) {
                    %>
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        Registrasi berhasil! Silakan <a href="index.jsp" class="alert-link">login</a>.
                        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    </div>
                    <% } %>
                    
                    <form action="RegisterServlet" method="POST">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label class="form-label">
                                        <i class="bi bi-person form-icon"></i> Nama Lengkap *
                                    </label>
                                    <input type="text" class="form-control" name="nama" 
                                           placeholder="Masukkan nama lengkap" required>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label class="form-label">
                                        <i class="bi bi-envelope form-icon"></i> Email *
                                    </label>
                                    <input type="email" class="form-control" name="email" 
                                           placeholder="contoh: nama@email.com" required>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label class="form-label">
                                        <i class="bi bi-lock form-icon"></i> Password *
                                    </label>
                                    <input type="password" class="form-control" name="password" 
                                           placeholder="Minimal 6 karakter" required>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label class="form-label">
                                        <i class="bi bi-lock-fill form-icon"></i> Konfirmasi Password *
                                    </label>
                                    <input type="password" class="form-control" name="confirm_password" 
                                           placeholder="Ulangi password" required>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label class="form-label">
                                        <i class="bi bi-telephone form-icon"></i> No. Telepon/HP *
                                    </label>
                                    <input type="tel" class="form-control" name="no_hp" 
                                           placeholder="Contoh: 08123456789" required>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label class="form-label">
                                        <i class="bi bi-geo-alt form-icon"></i> Alamat
                                    </label>
                                    <textarea class="form-control" name="alamat" rows="2" 
                                              placeholder="Masukkan alamat lengkap"></textarea>
                                </div>
                            </div>
                        </div>
                        
                        <div class="mb-4">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="agreeTerms" required>
                                <label class="form-check-label" for="agreeTerms">
                                    Saya setuju dengan <a href="#" data-bs-toggle="modal" data-bs-target="#termsModal">syarat dan ketentuan</a>
                                </label>
                            </div>
                        </div>
                        
                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-success btn-lg">
                                <i class="bi bi-person-plus"></i> Daftar Sekarang
                            </button>
                            <a href="index.jsp" class="btn btn-outline-secondary">
                                <i class="bi bi-arrow-left"></i> Kembali ke Login
                            </a>
                        </div>
                    </form>
                    
                    <div class="text-center mt-4">
                        <p class="text-muted">
                            Sudah punya akun? <a href="index.jsp" class="text-decoration-none">Login di sini</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Terms Modal -->
    <div class="modal fade" id="termsModal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Syarat dan Ketentuan</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <p>Dengan mendaftar, Anda menyetujui:</p>
                    <ol>
                        <li>Mengisi data dengan benar dan jujur</li>
                        <li>Menjaga kerahasiaan akun</li>
                        <li>Mematuhi aturan kursus yang diikuti</li>
                        <li>Bertanggung jawab atas semua aktivitas di akun Anda</li>
                    </ol>
                    <p>Sistem berhak menonaktifkan akun yang melanggar ketentuan.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Tutup</button>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    
    <script>
        // Validasi password match
        document.querySelector('form').addEventListener('submit', function(e) {
            const password = document.querySelector('input[name="password"]').value;
            const confirmPassword = document.querySelector('input[name="confirm_password"]').value;
            
            if (password !== confirmPassword) {
                e.preventDefault();
                alert('Password dan konfirmasi password tidak cocok!');
                return false;
            }
            
            if (password.length < 6) {
                e.preventDefault();
                alert('Password minimal 6 karakter!');
                return false;
            }
            
            return true;
        });
    </script>
</body>
</html>