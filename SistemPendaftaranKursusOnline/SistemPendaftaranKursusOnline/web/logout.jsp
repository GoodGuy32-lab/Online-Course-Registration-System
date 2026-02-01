<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Hapus semua session
    session.invalidate();
    
    // Redirect ke halaman login
    response.sendRedirect("index.jsp?message=logged_out");
%>