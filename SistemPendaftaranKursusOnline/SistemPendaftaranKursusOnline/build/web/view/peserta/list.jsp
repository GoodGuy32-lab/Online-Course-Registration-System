<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Peserta"%>
<%
    List<Peserta> pesertaList = (List<Peserta>) request.getAttribute("pesertaList");
    if (pesertaList == null) {
        response.sendRedirect("../peserta");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Data Peserta</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
</head>
<body>
    <div class="container mt-4">
        <h2><i class="bi bi-people-fill"></i> Data Peserta</h2>
        <a href="dashboard.jsp" class="btn btn-secondary mb-3">
            <i class="bi bi-arrow-left"></i> Kembali ke Dashboard
        </a>
        
        <div class="card shadow">
            <div class="card-header bg-primary text-white">
                <h5 class="mb-0">Daftar Peserta</h5>
            </div>
            <div class="card-body">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nama Peserta</th>
                            <th>Email</th>
                            <th>No. HP</th>
                            <th>Alamat</th>
                            <th>Aksi</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Peserta peserta : pesertaList) { %>
                        <tr>
                            <td><%= peserta.getIdPeserta() %></td>
                            <td><strong><%= peserta.getNamaPeserta() %></strong></td>
                            <td><%= peserta.getEmail() %></td>
                            <td><%= peserta.getNoHp() %></td>
                            <td>
                                <% 
                                String alamat = peserta.getAlamat();
                                if (alamat != null && alamat.length() > 30) {
                                    out.print(alamat.substring(0, 30) + "...");
                                } else if (alamat != null) {
                                    out.print(alamat);
                                } else {
                                    out.print("-");
                                }
                                %>
                            </td>
                            <td>
                                <button class="btn btn-sm btn-info" title="Lihat">
                                    <i class="bi bi-eye"></i>
                                </button>
                                <button class="btn btn-sm btn-warning" title="Edit">
                                    <i class="bi bi-pencil"></i>
                                </button>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
                
                <div class="mt-3">
                    <strong>Total: <%= pesertaList.size() %> peserta</strong>
                </div>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>