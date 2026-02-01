package controller;

import dao.PesertaDAO;
import model.Peserta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            System.out.println("=== LOGIN ATTEMPT ===");
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
            
            if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
                System.out.println("Email atau password kosong");
                response.sendRedirect("index.jsp?error=empty");
                return;
            }
            
            PesertaDAO dao = new PesertaDAO();
            System.out.println("PesertaDAO created");
            
            Peserta peserta = dao.login(email, password);
            System.out.println("Login result: " + (peserta != null ? "SUCCESS" : "FAILED"));
            
            if (peserta != null) {
                System.out.println("User logged in: " + peserta.getNamaPeserta());
                
                // Create session
                HttpSession session = request.getSession();
                session.setAttribute("user", peserta);
                session.setAttribute("user_id", peserta.getIdPeserta());
                session.setAttribute("user_name", peserta.getNamaPeserta());
                
                System.out.println("Session created, redirecting to dashboard...");
                response.sendRedirect("dashboard.jsp");
            } else {
                System.out.println("Login failed - redirecting to index with error");
                response.sendRedirect("index.jsp?error=invalid");
            }
            
        } catch (Exception e) {
            System.out.println("ERROR in LoginServlet: " + e.getMessage());
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            out.println("<a href='index.jsp'>Kembali</a>");
        }
    }
}