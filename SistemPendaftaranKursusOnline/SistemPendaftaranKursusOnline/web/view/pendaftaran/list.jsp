<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Pendaftaran"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
    List<Pendaftaran> pendaftaranList = (List<Pendaftaran>) request.getAttribute("pendaftaranList");
    if (pendaftaranList == null) {
        response.sendRedirect("../pendaftaran");
        return;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Data Pendaftaran</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
</head>
<body>
    <div class="container mt-4">
        <h2><i class="bi bi-clipboard-check"></i> Data Pendaftaran</h2>
        <a href="../SistemPendaftaranKursusOnline/dashboard.jsp" class="btn btn-secondary mb-3">
            <i class="bi bi-arrow-left"></i> Kembali ke Dashboard
        </a>
        
        <div class="card shadow">
            <div class="card-header bg-info text-white">
                <h5 class="mb-0">Daftar Pendaftaran Kursus</h5>
            </div>
            <div class="card-body">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tanggal</th>
                            <th>Peserta</th>
                            <th>Kursus</th>
                            <th>Biaya</th>
                            <th>Status Pembayaran</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Pendaftaran p : pendaftaranList) { 
                            String paymentClass = "";
                            String statusClass = "";
                            
                            switch(p.getStatusPembayaran()) {
                                case "LUNAS":
                                    paymentClass = "success";
                                    break;
                                case "MENUNGGU_VERIFIKASI":
                                    paymentClass = "warning";
                                    break;
                                default:
                                    paymentClass = "danger";
                            }
                            
                            switch(p.getStatusPendaftaran()) {
                                case "TERVERIFIKASI":
                                    statusClass = "success";
                                    break;
                                case "DITOLAK":
                                    statusClass = "danger";
                                    break;
                                default:
                                    statusClass = "secondary";
                            }
                        %>
                        <tr>
                            <td><%= p.getIdPendaftaran() %></td>
                            <td><%= sdf.format(p.getTanggalDaftar()) %></td>
                            <td><%= p.getNamaPeserta() %></td>
                            <td><%= p.getNamaKursus() %></td>
                            <td>Rp <%= String.format("%,.0f", p.getBiayaKursus()) %></td>
                            <td>
                                <span class="badge bg-<%= paymentClass %>">
                                    <%= p.getStatusPembayaran() %>
                                </span>
                            </td>
                            <td>
                                <span class="badge bg-<%= statusClass %>">
                                    <%= p.getStatusPendaftaran() %>
                                </span>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
                
                <div class="mt-3">
                    <% 
                    int totalLunas = 0;
                    double totalPendapatan = 0;
                    
                    for (Pendaftaran p : pendaftaranList) {
                        if ("LUNAS".equals(p.getStatusPembayaran())) {
                            totalLunas++;
                            totalPendapatan += p.getBiayaKursus();
                        }
                    }
                    %>
                    <strong>Statistik:</strong><br>
                    - Total pendaftaran: <%= pendaftaranList.size() %><br>
                    - Pembayaran lunas: <%= totalLunas %><br>
                    - Total pendapatan: Rp <%= String.format("%,.0f", totalPendapatan) %>
                </div>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>