/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m2_221116955;

import java.util.Scanner;
/**
 *
 * @author Frans
 */
public class M2_221116955 {
    
    public static void mainmenu(){
        System.out.println("== ItemQu ==");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Exit");
        System.out.print(">>");
    }

    public static void main(String[] args) {
        boolean run = true;
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String loginuser,loginpass;
        String reguser,regpass;
        Penjual[] penjual= new Penjual[100];
        User[] pembeli= new User[100];
        int jumlahuser = 0;
        int jumlahpenjual =0;
        boolean admin = false;
        boolean confirmtype=false;
        while(run){
            mainmenu();
            int pilmenu = scan.nextInt();
            if(pilmenu==1){
                boolean login=true;
                while(login){
                    System.out.println("===Login ItemQu===");
                    System.out.print("Username :");
                    loginuser = scan2.nextLine();
                    System.out.print("Password :");
                    loginpass = scan2.nextLine();
                    if(loginuser.equals("admin")&&loginpass.equals("admin")){
                        admin=true;
                        if(admin==true){
                            while(admin){
                                int piladmin;
                                System.out.println("===Admin ItemQu===");
                                System.out.println("1. Lihat Semua User");
                                System.out.println("2. Lihat Semua Barang");
                                System.out.println("3. Tambah Saldo User");
                                System.out.println("0. Back");
                                System.out.print(">>");
                                piladmin = scan.nextInt();
                                if(piladmin==0){
                                    admin=false;
                                }
                                else if(piladmin==1){
                                    System.out.println("-List User ItemQu-");
                                    for(int i =0;i<jumlahuser;i++){
                                        String namauser = pembeli[i].getUsername();
                                        int saldouser = pembeli[i].getSaldo();
                                        System.out.println(namauser+" - "+saldouser+" - Pembeli");
                                    }
                                    for(int i =0;i<jumlahpenjual;i++){
                                        String namauser = penjual[i].getNama();
                                        int saldouser = penjual[i].getSaldo();
                                        System.out.println(namauser+" - "+saldouser+" - Penjual");
                                    }
                                }
                            }
                        }
                    }
                    else{
                        boolean loginpenjual = false;
                        boolean loginpembeli = false;
                        boolean samepass = false;
                        boolean sameuser = false;
                        int usertype = 0;
                        int indexuser=101;
                        String cekpass="",cekuser="";
                        for(int i =0;i<jumlahuser;i++){
                            cekpass = pembeli[i].getPassword();
                            cekuser = pembeli[i].getUsername();
                            if(cekpass.equals(loginuser)){
                                samepass=true;
                            }
                            if(cekuser.equals(cekuser)){
                                sameuser=true;
                                indexuser=i;
                            }
                        }
                        if(sameuser==true&&samepass==true){
                            loginpembeli=true;
                        }
                        else if(sameuser==true&&samepass==false){
                            System.out.println("Password tidak sama.");
                        }
                        else if(sameuser==false){
                            System.out.println("Username Tidak terdaftar.");
                        }
                        samepass=false;
                        sameuser=false;
                        for(int i =0;i<jumlahpenjual;i++){
                            cekpass = penjual[i].getPassword();
                            cekuser = penjual[i].getNama();
                            if(cekpass.equals(loginuser)){
                                samepass=true;
                            }
                            if(cekuser.equals(cekuser)){
                                sameuser=true;
                                indexuser=i;
                            }
                        }
                        if(sameuser==true&&samepass==true){
                            loginpenjual=true;
                        }
                        else if(sameuser==true&&samepass==false){
                            System.out.println("Password tidak sama.");
                        }
                        else if(sameuser==false){
                            System.out.println("Username Tidak terdaftar.");
                        }
                        if(loginpenjual==true){
                            
                        }
                        else if(loginpembeli==true){
                            while(loginpembeli){
                                String namapembeli = pembeli[indexuser].getUsername();
                                int pilpembeli;
                                int saldopembeli = pembeli[indexuser].getSaldo();
                                System.out.println("===Pembeli ItemQu===");
                                System.out.println("Selamat datang" +namapembeli);
                                System.out.print("Saldo :"+saldopembeli);
                                System.out.println("1. beli barang");
                                System.out.println("0. Logout");
                                System.out.print(">>");
                                pilpembeli = scan.nextInt();
                            }
                        }
                        else if(loginpenjual==true){
                            while(loginpenjual){
                                String namapenjual = penjual[indexuser].getNama();
                                int pilpenjual;
                                int saldopenjual = pembeli[indexuser].getSaldo();
                                System.out.println("===Penjual ItemQu===");
                                System.out.println("Selamat datang" +namapenjual);
                                System.out.print("Saldo :"+saldopenjual);
                                System.out.println("1. Tambah Barang jual");
                                System.out.println("2. Hapus Barang jual");
                                System.out.println("0. Logout");
                                System.out.print(">>");
                                pilpenjual = scan.nextInt();
                            }
                        }
                    }
                }
            }
            else if (pilmenu==2){
                    System.out.println("===Register ItemQu===");
                    System.out.print("Username : ");
                    reguser = scan2.nextLine();
                    System.out.print("Password : ");
                    regpass = scan2.nextLine();
                    System.out.println("Confirm Password : ");
                    String confirmpass = scan2.nextLine();
                    if(confirmpass.equals(regpass)){
                        confirmtype=true;
                    }
                    while(confirmtype){
                        System.out.println("Penjual(1) atau Pembeli(2)?");
                        System.out.print(">>");
                        int tipeuser = scan.nextInt();
                        boolean kembar=true;
                        if(tipeuser==1){
                            for(int i =0;i<jumlahpenjual;i++){
                                String cekkembar = penjual[i].getNama();
                                if(cekkembar.equals(reguser)){
                                    kembar=true;
                                }
                                else{
                                    kembar=false;
                                }
                            }
                             for(int i =0;i<jumlahuser;i++){
                                String cekkembar = pembeli[i].getUsername();
                                if(cekkembar.equals(reguser)){
                                    kembar=true;
                                }
                                else{
                                    kembar=false;
                                }
                            }
                            if(kembar==true){
                                penjual[jumlahpenjual]=new Penjual(reguser,regpass,1000,0);
                                jumlahpenjual++;
                            }
                            else{
                                System.out.println("Username sama!");
                            }
                            confirmtype=false;
                        }
                        else if(tipeuser==2){
                            
                            for(int i =0;i<jumlahuser;i++){
                                String cekkembar = pembeli[i].getUsername();
                               if(cekkembar.equals(reguser)){
                                    kembar=true;
                                }
                                else{
                                    kembar=false;
                                }
                            }
                            for(int i =0;i<jumlahpenjual;i++){
                                String cekkembar = penjual[i].getNama();
                                if(cekkembar.equals(reguser)){
                                    kembar=true;
                                }
                                else{
                                    kembar=false;
                                }
                            }
                            if(kembar==true){
                                pembeli[jumlahuser]=new User(reguser,regpass,1000);
                                jumlahuser++;
                            }
                            else{
                                System.out.println("Username sama!");
                            }
                            confirmtype=false;
                                    
                        }
                    }
            }
            else if (pilmenu==0){
                run=false;
            }
            
        }
    }
    
}
