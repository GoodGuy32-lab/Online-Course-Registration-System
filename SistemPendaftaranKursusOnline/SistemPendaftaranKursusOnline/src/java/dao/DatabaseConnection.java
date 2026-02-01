package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Ganti dengan konfigurasi MySQL Anda
    private static final String URL = "jdbc:mysql://localhost:3306/db_kursus_online";
    private static final String USER = "root";      // username MySQL
    private static final String PASSWORD = "";      // password MySQL
    
    // Load driver saat class dipanggil
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading MySQL Driver: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Method untuk mendapatkan koneksi
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
    
    // Method untuk test koneksi
    public static void main(String[] args) {
        System.out.println("Testing database connection...");
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("SUCCESS: Database connected!");
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("FAILED: Cannot connect to database");
        }
    }
}