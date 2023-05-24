/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m2_221116955;

/**
 *
 * @author Frans
 */
public class Penjual {
    private String nama,password;
    private int saldo, jumlahbarang;
    private Barang[] listbarang = new Barang[100];

    public Penjual(String nama, String password, int saldo, int jumlahbarang) {
        this.nama = nama;
        this.saldo = saldo;
        this.jumlahbarang = jumlahbarang;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getJumlahbarang() {
        return jumlahbarang;
    }

    public void setJumlahbarang(int jumlahbarang) {
        this.jumlahbarang = jumlahbarang;
    }

    public Barang[] getListbarang() {
        return listbarang;
    }

    public void setListbarang(Barang[] listbarang) {
        this.listbarang = listbarang;
    }
    
    
    
}
