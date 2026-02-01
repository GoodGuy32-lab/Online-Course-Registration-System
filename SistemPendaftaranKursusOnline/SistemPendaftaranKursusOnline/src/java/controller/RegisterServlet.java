package controller;

import dao.PesertaDAO;
import model.Peserta;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Ambil parameter dari form
        String nama = request.getParameter("nama");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        String noHp = request.getParameter("no_hp");
        String alamat = request.getParameter("alamat");
        
        System.out.println("=== REGISTRATION ATTEMPT ===");
        System.out.println("Nama: " + nama);
        System.out.println("Email: " + email);
        System.out.println("No HP: " + noHp);
        
        // Validasi input
        if (nama == null || nama.isEmpty() || 
            email == null || email.isEmpty() || 
            password == null || password.isEmpty() ||
            confirmPassword == null || confirmPassword.isEmpty() ||
            noHp == null || noHp.isEmpty()) {
            
            System.out.println("Validation failed: Empty fields");
            response.sendRedirect("register.jsp?error=empty");
            return;
        }
        
        // Validasi password match
        if (!password.equals(confirmPassword)) {
            System.out.println("Validation failed: Password mismatch");
            response.sendRedirect("register.jsp?error=password_mismatch");
            return;
        }
        
        // Validasi password length
        if (password.length() < 6) {
            System.out.println("Validation failed: Password too short");
            response.sendRedirect("register.jsp?error=password_short");
            return;
        }
        
        try {
            // Buat object Peserta
            Peserta peserta = new Peserta();
            peserta.setNamaPeserta(nama);
            peserta.setEmail(email);
            peserta.setPassword(password); // Akan di-MD5 di DAO
            peserta.setNoHp(noHp);
            peserta.setAlamat(alamat != null ? alamat : "");
            
            // Simpan ke database
            PesertaDAO dao = new PesertaDAO();
            
            // Cek apakah email sudah terdaftar
            if (isEmailExists(dao, email)) {
                System.out.println("Registration failed: Email exists");
                response.sendRedirect("register.jsp?error=email_exists");
                return;
            }
            
            // Tambah peserta baru
            boolean success = dao.addPeserta(peserta);
            
            if (success) {
                System.out.println("Registration SUCCESS for: " + email);
                response.sendRedirect("register.jsp?success=true");
            } else {
                System.out.println("Registration FAILED for: " + email);
                response.sendRedirect("register.jsp?error=database");
            }
            
        } catch (Exception e) {
            System.out.println("Registration ERROR: " + e.getMessage());
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=server");
        }
    }
    
    // Method untuk cek email sudah ada
    private boolean isEmailExists(PesertaDAO dao, String email) {
    return dao.isEmailExists(email);
}
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect ke form register
        response.sendRedirect("register.jsp");
    }
}