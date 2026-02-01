package dao;

import model.Kursus;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KursusDAO {
    
    // Get all kursus
    public List<Kursus> getAllKursus() {
        List<Kursus> kursusList = new ArrayList<>();
        String sql = "SELECT * FROM kursus ORDER BY nama_kursus";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Kursus kursus = new Kursus();
                kursus.setIdKursus(rs.getInt("id_kursus"));
                kursus.setKodeKursus(rs.getString("kode_kursus"));
                kursus.setNamaKursus(rs.getString("nama_kursus"));
                kursus.setKategori(rs.getString("kategori"));
                kursus.setDurasi(rs.getInt("durasi"));
                kursus.setBiaya(rs.getDouble("biaya"));
                kursus.setKuota(rs.getInt("kuota"));
                kursus.setDeskripsi(rs.getString("deskripsi"));
                kursus.setCreatedAt(rs.getTimestamp("created_at"));
                
                kursusList.add(kursus);
            }
            
        } catch (SQLException e) {
            System.out.println("Error getting kursus: " + e.getMessage());
            e.printStackTrace();
        }
        
        return kursusList;
    }
    
    // Get kursus by ID
    public Kursus getKursusById(int id) {
        String sql = "SELECT * FROM kursus WHERE id_kursus = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Kursus kursus = new Kursus();
                kursus.setIdKursus(rs.getInt("id_kursus"));
                kursus.setKodeKursus(rs.getString("kode_kursus"));
                kursus.setNamaKursus(rs.getString("nama_kursus"));
                kursus.setKategori(rs.getString("kategori"));
                kursus.setDurasi(rs.getInt("durasi"));
                kursus.setBiaya(rs.getDouble("biaya"));
                kursus.setKuota(rs.getInt("kuota"));
                kursus.setDeskripsi(rs.getString("deskripsi"));
                return kursus;
            }
            
        } catch (SQLException e) {
            System.out.println("Error getting kursus by ID: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    // Add new kursus
    public boolean addKursus(Kursus kursus) {
        String sql = "INSERT INTO kursus (kode_kursus, nama_kursus, kategori, durasi, biaya, kuota, deskripsi) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, kursus.getKodeKursus());
            pstmt.setString(2, kursus.getNamaKursus());
            pstmt.setString(3, kursus.getKategori());
            pstmt.setInt(4, kursus.getDurasi());
            pstmt.setDouble(5, kursus.getBiaya());
            pstmt.setInt(6, kursus.getKuota());
            pstmt.setString(7, kursus.getDeskripsi());
            
            int rows = pstmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            System.out.println("Error adding kursus: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}