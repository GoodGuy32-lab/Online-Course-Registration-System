package model;

import java.util.Date;

public class Kursus {
    private int idKursus;
    private String kodeKursus;
    private String namaKursus;
    private String kategori;
    private int durasi;
    private double biaya;
    private int kuota;
    private String deskripsi;
    private Date createdAt;
    
    // Constructors
    public Kursus() {}
    
    public Kursus(String kodeKursus, String namaKursus, String kategori, int durasi, double biaya, int kuota, String deskripsi) {
        this.kodeKursus = kodeKursus;
        this.namaKursus = namaKursus;
        this.kategori = kategori;
        this.durasi = durasi;
        this.biaya = biaya;
        this.kuota = kuota;
        this.deskripsi = deskripsi;
    }
    
    // Getters and Setters
    public int getIdKursus() { return idKursus; }
    public void setIdKursus(int idKursus) { this.idKursus = idKursus; }
    
    public String getKodeKursus() { return kodeKursus; }
    public void setKodeKursus(String kodeKursus) { this.kodeKursus = kodeKursus; }
    
    public String getNamaKursus() { return namaKursus; }
    public void setNamaKursus(String namaKursus) { this.namaKursus = namaKursus; }
    
    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }
    
    public int getDurasi() { return durasi; }
    public void setDurasi(int durasi) { this.durasi = durasi; }
    
    public double getBiaya() { return biaya; }
    public void setBiaya(double biaya) { this.biaya = biaya; }
    
    public int getKuota() { return kuota; }
    public void setKuota(int kuota) { this.kuota = kuota; }
    
    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
    
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}