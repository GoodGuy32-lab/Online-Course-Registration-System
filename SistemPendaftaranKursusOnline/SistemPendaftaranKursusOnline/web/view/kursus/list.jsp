<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Kursus"%>
<%
    List<Kursus> kursusList = (List<Kursus>) request.getAttribute("kursusList");
    if (kursusList == null) {
        response.sendRedirect("../kursus/list.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Data Kursus</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
</head>
<body>
    <div class="container mt-4">
        <h2><i class="bi bi-book-half"></i> Data Kursus</h2>
        <a href="../SistemPendaftaranKursusOnline/dashboard.jsp" class="btn btn-secondary mb-3">
            <i class="bi bi-arrow-left"></i> Kembali ke Dashboard
        </a>
        
        <div class="row">
            <% for (Kursus kursus : kursusList) { %>
            <div class="col-md-4 mb-4">
                <div class="card h-100 shadow">
                    <div class="card-header bg-success text-white">
                        <h5 class="mb-0"><%= kursus.getNamaKursus() %></h5>
                    </div>
                    <div class="card-body">
                        <p><strong>Kode:</strong> <%= kursus.getKodeKursus() %></p>
                        <p><strong>Kategori:</strong> <%= kursus.getKategori() %></p>
                        <p><strong>Durasi:</strong> <%= kursus.getDurasi() %> jam</p>
                        <p><strong>Biaya:</strong> Rp <%= String.format("%,.0f", kursus.getBiaya()) %></p>
                        <p><strong>Kuota:</strong> <%= kursus.getKuota() %> peserta</p>
                        
                        <% if (kursus.getDeskripsi() != null && !kursus.getDeskripsi().isEmpty()) { %>
                        <p><strong>Deskripsi:</strong> 
                            <%= kursus.getDeskripsi().length() > 100 ? 
                                kursus.getDeskripsi().substring(0, 100) + "..." : 
                                kursus.getDeskripsi() %>
                        </p>
                        <% } %>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-sm btn-info">
                            <i class="bi bi-eye"></i> Detail
                        </button>
                        <button class="btn btn-sm btn-warning">
                            <i class="bi bi-pencil"></i> Edit
                        </button>
                        <button class="btn btn-sm btn-success">
                            <i class="bi bi-person-plus"></i> Daftar
                        </button>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
        
        <div class="mt-3">
            <strong>Total: <%= kursusList.size() %> kursus tersedia</strong>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>