package dao;

import model.Pendaftaran;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PendaftaranDAO {
    
    // Get all pendaftaran dengan join
    public List<Pendaftaran> getAllPendaftaran() {
        List<Pendaftaran> pendaftaranList = new ArrayList<>();
        String sql = "SELECT p.*, ps.nama_peserta, k.nama_kursus, k.biaya " +
                    "FROM pendaftaran p " +
                    "JOIN peserta ps ON p.id_peserta = ps.id_peserta " +
                    "JOIN kursus k ON p.id_kursus = k.id_kursus " +
                    "ORDER BY p.tanggal_daftar DESC";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Pendaftaran pendaftaran = new Pendaftaran();
                pendaftaran.setIdPendaftaran(rs.getInt("id_pendaftaran"));
                pendaftaran.setTanggalDaftar(rs.getDate("tanggal_daftar"));
                pendaftaran.setStatusPembayaran(rs.getString("status_pembayaran"));
                pendaftaran.setMetodePembayaran(rs.getString("metode_pembayaran"));
                pendaftaran.setBuktiPembayaran(rs.getString("bukti_pembayaran"));
                pendaftaran.setStatusPendaftaran(rs.getString("status_pendaftaran"));
                pendaftaran.setIdPeserta(rs.getInt("id_peserta"));
                pendaftaran.setIdKursus(rs.getInt("id_kursus"));
                pendaftaran.setCreatedAt(rs.getTimestamp("created_at"));
                
                // Data dari join
                pendaftaran.setNamaPeserta(rs.getString("nama_peserta"));
                pendaftaran.setNamaKursus(rs.getString("nama_kursus"));
                pendaftaran.setBiayaKursus(rs.getDouble("biaya"));
                
                pendaftaranList.add(pendaftaran);
            }
            
        } catch (SQLException e) {
            System.out.println("Error getting pendaftaran: " + e.getMessage());
            e.printStackTrace();
        }
        
        return pendaftaranList;
    }
    
    // Add new pendaftaran
    public boolean addPendaftaran(Pendaftaran pendaftaran) {
        String sql = "INSERT INTO pendaftaran (tanggal_daftar, status_pembayaran, metode_pembayaran, " +
                    "bukti_pembayaran, status_pendaftaran, id_peserta, id_kursus) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDate(1, new java.sql.Date(pendaftaran.getTanggalDaftar().getTime()));
            pstmt.setString(2, pendaftaran.getStatusPembayaran());
            pstmt.setString(3, pendaftaran.getMetodePembayaran());
            pstmt.setString(4, pendaftaran.getBuktiPembayaran());
            pstmt.setString(5, pendaftaran.getStatusPendaftaran());
            pstmt.setInt(6, pendaftaran.getIdPeserta());
            pstmt.setInt(7, pendaftaran.getIdKursus());
            
            int rows = pstmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            System.out.println("Error adding pendaftaran: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}