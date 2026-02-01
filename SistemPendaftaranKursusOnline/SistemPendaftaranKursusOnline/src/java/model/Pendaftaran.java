package model;

import java.util.Date;

public class Pendaftaran {
    private int idPendaftaran;
    private Date tanggalDaftar;
    private String statusPembayaran;
    private String metodePembayaran;
    private String buktiPembayaran;
    private String statusPendaftaran;
    private int idPeserta;
    private int idKursus;
    private Date createdAt;
    
    // Untuk join
    private String namaPeserta;
    private String namaKursus;
    private double biayaKursus;
    
    // Getters and Setters
    public int getIdPendaftaran() { return idPendaftaran; }
    public void setIdPendaftaran(int idPendaftaran) { this.idPendaftaran = idPendaftaran; }
    
    public Date getTanggalDaftar() { return tanggalDaftar; }
    public void setTanggalDaftar(Date tanggalDaftar) { this.tanggalDaftar = tanggalDaftar; }
    
    public String getStatusPembayaran() { return statusPembayaran; }
    public void setStatusPembayaran(String statusPembayaran) { this.statusPembayaran = statusPembayaran; }
    
    public String getMetodePembayaran() { return metodePembayaran; }
    public void setMetodePembayaran(String metodePembayaran) { this.metodePembayaran = metodePembayaran; }
    
    public String getBuktiPembayaran() { return buktiPembayaran; }
    public void setBuktiPembayaran(String buktiPembayaran) { this.buktiPembayaran = buktiPembayaran; }
    
    public String getStatusPendaftaran() { return statusPendaftaran; }
    public void setStatusPendaftaran(String statusPendaftaran) { this.statusPendaftaran = statusPendaftaran; }
    
    public int getIdPeserta() { return idPeserta; }
    public void setIdPeserta(int idPeserta) { this.idPeserta = idPeserta; }
    
    public int getIdKursus() { return idKursus; }
    public void setIdKursus(int idKursus) { this.idKursus = idKursus; }
    
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    
    public String getNamaPeserta() { return namaPeserta; }
    public void setNamaPeserta(String namaPeserta) { this.namaPeserta = namaPeserta; }
    
    public String getNamaKursus() { return namaKursus; }
    public void setNamaKursus(String namaKursus) { this.namaKursus = namaKursus; }
    
    public double getBiayaKursus() { return biayaKursus; }
    public void setBiayaKursus(double biayaKursus) { this.biayaKursus = biayaKursus; }
}