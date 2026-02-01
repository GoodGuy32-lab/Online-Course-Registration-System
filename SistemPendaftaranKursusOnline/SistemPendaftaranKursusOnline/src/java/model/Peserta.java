package model;

import java.util.Date;

public class Peserta {
    private int idPeserta;
    private String namaPeserta;
    private String email;
    private String password;
    private String noHp;
    private String alamat;
    private Date createdAt;
    
    // Constructors
    public Peserta() {}
    
    public Peserta(String namaPeserta, String email, String password, String noHp, String alamat) {
        this.namaPeserta = namaPeserta;
        this.email = email;
        this.password = password;
        this.noHp = noHp;
        this.alamat = alamat;
    }
    
    // Getters and Setters
    public int getIdPeserta() { return idPeserta; }
    public void setIdPeserta(int idPeserta) { this.idPeserta = idPeserta; }
    
    public String getNamaPeserta() { return namaPeserta; }
    public void setNamaPeserta(String namaPeserta) { this.namaPeserta = namaPeserta; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }
    
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}