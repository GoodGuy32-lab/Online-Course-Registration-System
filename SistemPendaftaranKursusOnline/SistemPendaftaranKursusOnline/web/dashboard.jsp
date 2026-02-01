<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Peserta"%>
<%
    // Cek apakah user sudah login
    Peserta user = (Peserta) session.getAttribute("user");
    if (user == null) {
        // Jika belum login, redirect ke index
        response.sendRedirect("index.jsp?error=not_logged_in");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="dashboard.jsp">Kursus Online</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="dashboard.jsp">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="peserta">Peserta</a>  <!-- Ganti dari view/peserta/list.jsp -->
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="kursus">Kursus</a>    <!-- Ganti dari view/kursus/list.jsp -->
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="pendaftaran">Pendaftaran</a>  <!-- Ganti dari view/pendaftaran/list.jsp -->
                    </li>
                </ul>
                <div class="navbar-text me-3">
                    Halo, <strong><%= user.getNamaPeserta() %></strong>
                </div>
                <a href="logout.jsp" class="btn btn-outline-light">Logout</a>
            </div>
        </div>
    </nav>

    <div class="container mt-4">
        <h2>Dashboard Sistem</h2>
        <p class="text-muted">Selamat datang, <%= user.getNamaPeserta() %>!</p>
        
        <div class="row mt-4">
            <div class="col-md-4 mb-3">
                <div class="card bg-primary text-white">
                    <div class="card-body">
                        <h5 class="card-title">Peserta</h5>
                        <h2>${pesertaCount}</h2>
                        <a href="peserta" class="text-white">Lihat Data →</a>  <!-- Ganti -->
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <div class="card bg-success text-white">
                    <div class="card-body">
                        <h5 class="card-title">Kursus</h5>
                        <h2>3</h2>
                        <a href="kursus" class="text-white">Lihat Data →</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <div class="card bg-info text-white">
                    <div class="card-body">
                        <h5 class="card-title">Pendaftaran</h5>
                        <h2>3</h2>
                        <a href="pendaftaran" class="text-white">Lihat Data →</a>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="card mt-4">
            <div class="card-header">
                <h5>Informasi Akun</h5>
            </div>
            <div class="card-body">
                <table class="table">
                    <tr>
                        <th>Nama</th>
                        <td><%= user.getNamaPeserta() %></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td><%= user.getEmail() %></td>
                    </tr>
                    <tr>
                        <th>No. HP</th>
                        <td><%= user.getNoHp() %></td>
                    </tr>
                    <tr>
                        <th>Alamat</th>
                        <td><%= user.getAlamat() != null ? user.getAlamat() : "-" %></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>