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
public class Buyer extends User {
    private int saldo;
    private ArrayList<String> cart = new ArrayList<String>();
    
    public Buyer(String username, String password) {
        super(username, password);
        this.saldo = 0;
    }
    
    public String getUsername(){
        return super.getUsername();
    }
    
    public String getPassword(){
        return super.getPassword();
    }
    
    public int GetSaldo(){
        return this.saldo;
    }
    
    public void setSaldo(int saldo){
        this.saldo = saldo;
    }
}
