/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m3_221116955;
import java.util.ArrayList;

public class Tanggal {
    private int date;
    private ArrayList<Integer> jammulai = new ArrayList<Integer>();
    private ArrayList<Integer> jamstop = new ArrayList<Integer>();
    private ArrayList<Integer> menitmulai = new ArrayList<Integer>(); 
    private ArrayList<Integer> menitstop = new ArrayList<Integer>();
    private ArrayList<String> aktivitas = new ArrayList<String>();
    private boolean terisi = false;
    private int jum = 0;

    public Tanggal(int date) {
        this.date = date;
    }
    
    public void newSchedule(Integer jamawal, Integer jamakhir, Integer menitawal, Integer menitakhir, String newaktif){
        jammulai.add(jamawal);
        jamstop.add(jamakhir);
        menitmulai.add(menitawal);
        menitstop.add(menitakhir);
        aktivitas.add(newaktif);
        terisi = true;
    }
    
    public void seeSchedule(){
        if(terisi){
            for(int i =0;i<jammulai.size();i++){
                System.out.print((i+1)+". "+jammulai.get(i));
                System.out.print("."+menitmulai.get(i));
                System.out.print(" - "+jamstop.get(i));
                System.out.print("."+menitstop.get(i));
                System.out.println(" "+aktivitas.get(i));
            }
        }
    }
    
    public void seeSchedule1(){
        if(terisi){
            System.out.println(date+" Maret 2022");
            for(int i =0;i<jammulai.size();i++){
                System.out.print(jammulai.get(i));
                System.out.print("."+menitmulai.get(i));
                System.out.print(" - "+jamstop.get(i));
                System.out.print("."+menitstop.get(i));
                System.out.println(" "+aktivitas.get(i));
            }
        }
    }
    
    public void deleteSchedule(int ind){
        jammulai.remove(ind-1);
        jamstop.remove(ind-1);
        menitmulai.remove(ind-1);
        menitstop.remove(ind-1);
        aktivitas.remove(ind-1);
    }
    
}
