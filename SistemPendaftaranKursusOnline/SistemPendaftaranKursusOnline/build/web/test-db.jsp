<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.PesertaDAO"%>
<%@page import="model.Peserta"%>
<%@page import="java.util.List"%>
<%
    PesertaDAO dao = new PesertaDAO();
    List<Peserta> pesertaList = dao.getAllPeserta();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Database</title>
</head>
<body>
    <h1>Test Database Connection</h1>
    
    <h2>Data Peserta di Database:</h2>
    <% if (pesertaList.isEmpty()) { %>
        <p>Tidak ada data peserta</p>
    <% } else { %>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Nama</th>
                <th>Email</th>
                <th>Password (MD5)</th>
                <th>No. HP</th>
            </tr>
            <% for (Peserta p : pesertaList) { %>
            <tr>
                <td><%= p.getIdPeserta() %></td>
                <td><%= p.getNamaPeserta() %></td>
                <td><%= p.getEmail() %></td>
                <td><%= p.getPassword() %></td>
                <td><%= p.getNoHp() %></td>
            </tr>
            <% } %>
        </table>
    <% } %>
    
    <h2>Test Login:</h2>
    <form action="login" method="POST">
        Email: <input type="text" name="email" value="admin@email.com"><br>
        Password: <input type="password" name="password" value="admin123"><br>
        <input type="submit" value="Test Login">
    </form>
    
    <br>
    <a href="index.jsp">Kembali ke Login</a>
</body>
</html>