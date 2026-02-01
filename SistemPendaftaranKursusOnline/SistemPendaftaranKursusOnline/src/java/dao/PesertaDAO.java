package dao;

import model.Peserta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PesertaDAO {
    
    // Method untuk mendapatkan semua peserta
    public List<Peserta> getAllPeserta() {
        List<Peserta> pesertaList = new ArrayList<>();
        String sql = "SELECT * FROM peserta ORDER BY nama_peserta";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Peserta peserta = new Peserta();
                peserta.setIdPeserta(rs.getInt("id_peserta"));
                peserta.setNamaPeserta(rs.getString("nama_peserta"));
                peserta.setEmail(rs.getString("email"));
                peserta.setPassword(rs.getString("password"));
                peserta.setNoHp(rs.getString("no_hp"));
                peserta.setAlamat(rs.getString("alamat"));
                peserta.setCreatedAt(rs.getTimestamp("created_at"));
                
                pesertaList.add(peserta);
            }
            
        } catch (SQLException e) {
            System.out.println("Error getting peserta: " + e.getMessage());
            e.printStackTrace();
        }
        
        return pesertaList;
    }
    
            // Method untuk menambahkan peserta baru (REGISTRASI)
        public boolean addPeserta(Peserta peserta) {
            System.out.println("Adding new peserta: " + peserta.getEmail());

            String sql = "INSERT INTO peserta (nama_peserta, email, password, no_hp, alamat) VALUES (?, ?, MD5(?), ?, ?)";

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, peserta.getNamaPeserta());
                pstmt.setString(2, peserta.getEmail());
                pstmt.setString(3, peserta.getPassword()); // Password akan di-MD5
                pstmt.setString(4, peserta.getNoHp());
                pstmt.setString(5, peserta.getAlamat());

                int rows = pstmt.executeUpdate();
                System.out.println("Rows affected: " + rows);

                return rows > 0;

            } catch (SQLException e) {
                System.out.println("Error adding peserta: " + e.getMessage());

                // Cek jika error karena duplicate email
                if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("email")) {
                    System.out.println("Duplicate email detected: " + peserta.getEmail());
                }

                e.printStackTrace();
                return false;
            }
        }

        // Method untuk cek email sudah ada (untuk validasi)
        public boolean isEmailExists(String email) {
            String sql = "SELECT COUNT(*) as count FROM peserta WHERE email = ?";

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, email);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    return rs.getInt("count") > 0;
                }

            } catch (SQLException e) {
                System.out.println("Error checking email: " + e.getMessage());
                e.printStackTrace();
            }

            return false;
        }
    
        // Method untuk login - PERBAIKI INI
     public Peserta login(String email, String password) {
         System.out.println("DAO.login() called with email: " + email);

         String sql = "SELECT * FROM peserta WHERE email = ? AND password = MD5(?)";

         try (Connection conn = DatabaseConnection.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql)) {

             System.out.println("Database connected: " + (conn != null));

             pstmt.setString(1, email);
             pstmt.setString(2, password);

             System.out.println("Executing query: " + sql);
             System.out.println("Parameters: email=" + email + ", password=" + password);

             ResultSet rs = pstmt.executeQuery();

             if (rs.next()) {
                 System.out.println("User found in database");
                 Peserta peserta = new Peserta();
                 peserta.setIdPeserta(rs.getInt("id_peserta"));
                 peserta.setNamaPeserta(rs.getString("nama_peserta"));
                 peserta.setEmail(rs.getString("email"));
                 peserta.setPassword(rs.getString("password"));
                 peserta.setNoHp(rs.getString("no_hp"));
                 peserta.setAlamat(rs.getString("alamat"));

                 System.out.println("User details: " + peserta.getNamaPeserta() + ", " + peserta.getEmail());
                 return peserta;
             } else {
                 System.out.println("No user found with email=" + email);
                 // Coba tanpa MD5 (mungkin password tidak di-MD5)
                 return loginWithoutMD5(email, password);
             }

         } catch (SQLException e) {
             System.out.println("SQL Error in login: " + e.getMessage());
             e.printStackTrace();
         }

         return null;
     }

     // Tambahkan method untuk login tanpa MD5
     private Peserta loginWithoutMD5(String email, String password) {
         System.out.println("Trying login without MD5...");

         String sql = "SELECT * FROM peserta WHERE email = ? AND password = ?";

         try (Connection conn = DatabaseConnection.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql)) {

             pstmt.setString(1, email);
             pstmt.setString(2, password);

             ResultSet rs = pstmt.executeQuery();

             if (rs.next()) {
                 System.out.println("User found (without MD5)");
                 Peserta peserta = new Peserta();
                 peserta.setIdPeserta(rs.getInt("id_peserta"));
                 peserta.setNamaPeserta(rs.getString("nama_peserta"));
                 peserta.setEmail(rs.getString("email"));
                 peserta.setPassword(rs.getString("password"));
                 peserta.setNoHp(rs.getString("no_hp"));
                 peserta.setAlamat(rs.getString("alamat"));
                 return peserta;
             }

         } catch (SQLException e) {
             System.out.println("SQL Error in loginWithoutMD5: " + e.getMessage());
         }

         return null;
     }
     
            // Get peserta by ID
       public Peserta getPesertaById(int id) {
           String sql = "SELECT * FROM peserta WHERE id_peserta = ?";

           try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

               pstmt.setInt(1, id);
               ResultSet rs = pstmt.executeQuery();

               if (rs.next()) {
                   Peserta peserta = new Peserta();
                   peserta.setIdPeserta(rs.getInt("id_peserta"));
                   peserta.setNamaPeserta(rs.getString("nama_peserta"));
                   peserta.setEmail(rs.getString("email"));
                   peserta.setPassword(rs.getString("password"));
                   peserta.setNoHp(rs.getString("no_hp"));
                   peserta.setAlamat(rs.getString("alamat"));
                   peserta.setCreatedAt(rs.getTimestamp("created_at"));
                   return peserta;
               }

           } catch (SQLException e) {
               System.out.println("Error getting peserta by ID: " + e.getMessage());
               e.printStackTrace();
           }

           return null;
       }
}