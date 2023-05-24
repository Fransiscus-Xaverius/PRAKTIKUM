/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m3_221116955;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Frans
 */
public class M3_221116955 {
    //wow sederhana sekali!
    
    public static void printkal(){
        System.out.println("======= MARCH =======");
        System.out.println("Su M  T  W  Th F  Sa");
        System.out.println("      1  2  3  4  5");
        System.out.println("6  7  8  9  10 11 12");
        System.out.println("13 14 15 16 17 18 19");
        System.out.println("20 21 22 23 24 25 26");
        System.out.println("27 28 29 30 31");
        System.out.println("=====================");
        System.out.println("88. Summary");
        System.out.println("99. Summary (Important)");
        System.out.println("=====================");
        System.out.print(">> ");
    }
    
    public static void main(String[] args) {
        ArrayList<Tanggal> t = new ArrayList<Tanggal>();
        boolean run = true;
        Scanner scanint = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);
        int ukuran = 0;
        while(run){
            printkal();
            Integer pil = scanint.nextInt();
            if(pil==88){
                System.out.println("====================");
                for(int i =0;i<t.size();i++){
                    System.out.println("");
                    t.get(i).seeSchedule1();
                    System.out.println(""); 
                }
            }
            else if(pil==99){
                
            }
            else{
                int index = pil-1;
                int pil2 = -1;
                if(ukuran==0){
                    boolean check = true;
                    t.add(new Tanggal(pil));
                        System.out.println("Date = "+pil+" Maret 2022");
                        System.out.println("//// Schedule ////");
                        System.out.println("///////////////////");
                        System.out.println("1. Add Schedule");
                        System.out.println("2. Edit");
                        System.out.println("3. Delete");
                        System.out.println("0. Back");
                        pil2 = scanint.nextInt();
                        ukuran++;
                        if(pil2>0&&pil2<4){
                            if(pil2==1){
                            System.out.print("Masukkan Jam mulai :");
                            Integer jamawal = scanint.nextInt();
                            System.out.print("Masukkan Menit Mulai");
                            Integer menitawal = scanint.nextInt();
                            System.out.print("Masukkan Jam Berakhir :");
                            Integer jamakhir = scanint.nextInt();
                            System.out.print("Masukkan Menit Berakhir :");
                            Integer menitakhir = scanint.nextInt();
                            System.out.print("Masukkan nama aktivitas :");
                            String namaaktivitas = scanStr.nextLine();
                            t.get(index).newSchedule(jamawal, jamakhir, menitawal, menitakhir,namaaktivitas);
                            check=false;
                            }
                            else if(pil2==2){
                                
                            }
                            else if(pil2==3){
                                System.out.println("Which schedule would you like to delete?");
                                int x = scanint.nextInt()-1;
                                t.get(index).deleteSchedule(x);
                            }
                        }
                }
                else{
                    System.out.println("Date = "+pil+" Maret 2022");
                    System.out.println("//// Schedule ////");
                    t.get(index).seeSchedule();
                    System.out.println("///////////////////");
                    System.out.println("1. Add Schedule");
                    System.out.println("2. Edit");
                    System.out.println("3. Delete");
                    System.out.println("0. Back");
                    pil2 = scanint.nextInt();
                    if(pil2>0&&pil2<4){
                            if(pil2==1){
                            System.out.print("Masukkan Jam mulai :");
                            Integer jamawal = scanint.nextInt();
                            System.out.print("Masukkan Menit Mulai");
                            Integer menitawal = scanint.nextInt();
                            System.out.print("Masukkan Jam Berakhir :");
                            Integer jamakhir = scanint.nextInt();
                            System.out.print("Masukkan Menit Berakhir :");
                            Integer menitakhir = scanint.nextInt();
                            System.out.print("Masukkan nama aktivitas :");
                            String namaaktivitas = scanStr.nextLine();
                            t.get(index).newSchedule(jamawal, jamakhir, menitawal, menitakhir,namaaktivitas);
                            }
                            else if(pil2==2){
                                
                            }
                            else if(pil2==3){
                                System.out.println("Which schedule would you like to delete?");
                                int x = scanint.nextInt()-1;
                                t.get(index).deleteSchedule(x);
                            }
                        }
                }
            }
        }
    }
    
}
