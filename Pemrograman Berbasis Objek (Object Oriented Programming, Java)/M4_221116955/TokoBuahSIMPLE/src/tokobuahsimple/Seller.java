/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tokobuahsimple;
import java.util.ArrayList;
/**
 *
 * @author Frans
 */
public class Seller extends User{
    private int Saldo;
    private String stallname;
    private ArrayList<Buah> listbuah = new ArrayList<Buah>();

    public Seller(String stallname, String username, String password) {
        super(username, password);
        this.Saldo = 0;
        this.stallname = stallname;
    }

    public int getSaldo() {
        return Saldo;
    }
    
    public void SeeBuah(){
        for(int i =0;i<listbuah.size();i++){
            System.out.println(listbuah.get(i).getNama()+" - "+listbuah.get(i).getHarga()+" - "+listbuah.get(i).getStock());
        }
    }
    
    public void addBuah(String nama, int harga, int stock){
        listbuah.add(new Buah(nama,harga,stock));
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public String getStallname() {
        return stallname;
    }

    public void setStallname(String stallname) {
        this.stallname = stallname;
    }
    
    public String getUsername(){
        return super.getUsername();
    }
    
    public String getPassword(){
        return super.getPassword();
    }
    
}
