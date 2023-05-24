/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m7;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Frans
 * @param <T>
 */
public class Matrix <T>{
    private ArrayList<T> isi;
    private String name;
    private int tipe;
    private Scanner sc = new Scanner(System.in);
    private Scanner scStr = new Scanner(System.in);

    public Matrix(String name, int tipe) {
        this.name = name;
        this.isi = new ArrayList();
        this.tipe = tipe;
    }
    
    public ArrayList<T> getIsi() {
        return isi;
    }
    
    public void seeIsi(){
        for(int i =0;i<9;i++){
            System.out.print(this.isi.get(i));
            if(i==2||i==5||i==8){
                System.out.println("");
            }
            else{
                System.out.print(" ");
            }
        }
    }
    
    public void EditIsi(){
        this.isi.clear();
    }

    public void setIsi(ArrayList<T> isi) {
        this.isi = isi;
    }
    
    public void add(T elemen){
        this.isi.add(elemen);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTipe() {
        return tipe;
    }

    public void setTipe(int tipe) {
        this.tipe = tipe;
    }
    
    
    
}
