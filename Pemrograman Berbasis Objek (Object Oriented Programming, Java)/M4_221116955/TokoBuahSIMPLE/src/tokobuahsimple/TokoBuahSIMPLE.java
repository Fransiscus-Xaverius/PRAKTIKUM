/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tokobuahsimple;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Frans
 */
public class TokoBuahSIMPLE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean run = true;
        ArrayList<Buyer> listbuyer = new ArrayList<Buyer>();
        ArrayList<Seller> listseller = new ArrayList<Seller>();
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        boolean admin = false;
        while(run){
            String loginuser,loginpass;
            System.out.println("====Toko buah====");
            System.out.print("Username: ");
            loginuser = scStr.nextLine();
            System.out.print("Password: ");
            loginpass = scStr.nextLine();
            if(loginpass.equals(loginuser)&&loginpass.equals("admin")||loginpass.equals(loginuser)&&loginpass.equals("Admin")||loginpass.equals(loginuser)&&loginpass.equals("ADMIN")){
                admin=true;
                while(admin){
                    System.out.println("====Toko buah====");
                    System.out.println("Welcome admin!");
                    System.out.println("1. Register Seller");
                    System.out.println("2. Register Buyer");
                    System.out.println("3. List User");
                    System.out.println("4. List Buah");
                    System.out.println("5. TopUp User");
                    System.out.println("0. Logout");
                    System.out.print(">>");
                    int piladmin = scInt.nextInt();
                    if(piladmin==1){
                        System.out.println("---Register Seller---");
                        System.out.print("Username : ");
                        String temp = scStr.nextLine();
                        System.out.print("Password : ");
                        String temp1 = scStr.nextLine();
                        System.out.print("Stall Name : ");
                        String temp2 = scStr.nextLine();
                        boolean kembar = false;
                        for(int i =0;i<listseller.size();i++){
                            String cek1 = listseller.get(i).getUsername();
                            String cek2 = listseller.get(i).getStallname();
                            if(cek1.equals(temp)||cek2.equals(temp2)){
                                kembar = true;
                                break;
                            }
                        }
                        if(kembar){
                            System.out.println("Username/Stall name is already used.");
                        }
                        else{
                            listseller.add(new Seller(temp2,temp,temp1));
                            System.out.println("Register Success!");
                        }
                    }
                    else if (piladmin==2){
                        System.out.println("---Register Buyer---");
                        System.out.print("Username : ");
                        String temp = scStr.nextLine();
                        System.out.print("Password : ");
                        String temp1 = scStr.nextLine();
                        boolean kembar = false;
                        for(int i =0;i<listbuyer.size();i++){
                            if(listbuyer.get(i).getUsername().equals(temp)){
                                kembar = true;
                                break;
                            }
                        }
                        for(int i =0;i<listseller.size();i++){
                            if(listseller.get(i).getUsername().equals(temp)){
                                kembar = true;
                                break;
                            }
                        }
                        if(!kembar){
                            listbuyer.add(new Buyer(temp,temp1));
                        }
                        else{
                            System.out.println("Username sudah terpakai!");
                        }
                    }
                    else if (piladmin==3){
                        boolean listing = true;
                        int index = 1;
                        while(listing){
                            for(int i =0;i<listbuyer.size();i++){
                                String name = listbuyer.get(i).getUsername();
                                String pass = listbuyer.get(i).getPassword();
                                System.out.println(index+". "+name+" - "+pass+" - "+"Buyer");
                                index++;
                            }
                            for(int i =0;i<listseller.size();i++){
                                String name = listseller.get(i).getUsername();
                                String pass = listseller.get(i).getPassword();
                                String stallname = listseller.get(i).getStallname();
                                System.out.println(index+". "+name+" - "+pass+" - Seller ["+stallname+"]");
                                index++;
                            }
                            listing = false;
                        }
                    }
                    else if (piladmin==4){
                        
                    }
                    else if (piladmin==5){
                        System.out.println("---TopUp Buyer---");
                        int panjangList = 1;
                        for(int i =0;i<listbuyer.size();i++){
                            String name = listbuyer.get(i).getUsername();
                            System.out.println(panjangList+". "+name);
                            panjangList++;
                        }
                        for(int i =0;i<listseller.size();i++){
                            String name = listseller.get(i).getUsername();
                            System.out.println(panjangList+". "+name);
                            panjangList++;
                        }
                        System.out.print(">>");
                        int pilTopUp = scInt.nextInt();
                        if(pilTopUp==0||pilTopUp>listbuyer.size()){
                            System.out.println("Invalid Index");
                        }
                        else{
                            System.out.print("Saldo: ");
                            int tambahan = scInt.nextInt();
                            if(tambahan<=0){
                                System.out.println("Invalid TopUp");
                            }
                            else{
                                int currentsaldo = listbuyer.get(pilTopUp-1).GetSaldo();
                                currentsaldo+=tambahan;
                                listbuyer.get(pilTopUp-1).setSaldo(currentsaldo);
                                System.out.println("Successfully added "+tambahan+" to saldo!");
                            }
                        }
                    }
                    else if (piladmin==0){
                        admin=false;
                    }
                }
            }
            else{
                boolean foundinbuyer = false;
                boolean foundinseller=false;
                int index = -1;
                for(int i =0;i<listbuyer.size();i++){
                    if(loginuser.equals(listbuyer.get(i).getUsername())&&loginpass.equals(listbuyer.get(i).getPassword())){
                        foundinbuyer=true;
                        index = i;
                    }
                }
                for(int i =0;i<listseller.size();i++){
                    if(loginuser.equals(listseller.get(i).getUsername())&&loginpass.equals(listseller.get(i).getPassword())){
                        foundinseller=true;
                        index = i;
                    }
                }
                if(!foundinbuyer&&!foundinseller){
                    System.out.println("Username tidak terdaftar!");
                }
                else{
                    if(foundinbuyer){
                        boolean buying = true;
                        while(buying){
                            System.out.println("===Toko Buah===");
                            System.out.println("Welcome "+loginuser);
                            System.out.println("Saldo : "+listbuyer.get(index).GetSaldo());
                            System.out.println("1. Buy Buah");
                            System.out.println("2. List Buah");
                            System.out.println("0.Logout");
                            System.out.print(">>");
                            int pilBuyer = scInt.nextInt();
                            if(pilBuyer==0){
                                buying=false;
                            }
                            else if (pilBuyer==1){
                                
                            }
                            else if (pilBuyer==2){
                                
                            }
                        }
                    }
                    else{
                        boolean selling = true;
                        while(selling){
                            System.out.println("===Toko Buah===");
                            System.out.println("Welcome ["+listseller.get(index).getStallname()+"] "+loginpass);
                            System.out.println("Saldo : "+listseller.get(index).getSaldo());
                            System.out.println("1. Sell Buah");
                            System.out.println("2. List Buah");
                            System.out.println("0. Logout");
                            System.out.print(">>");
                            int pilselling = scInt.nextInt();
                            if(pilselling==0){
                                selling=false;
                            }
                            else if (pilselling==1){
                                System.out.println("---Sell Buah---");
                                System.out.print("Nama: ");
                                String name = scStr.nextLine();
                                System.out.print("Harga: ");
                                int price = scInt.nextInt();
                                System.out.print("Stock: ");
                                int stock = scInt.nextInt();
                                listseller.get(index).addBuah(name, price, stock);
                            }
                            else if (pilselling==2){
                                System.out.println("---List Buah---");
                                listseller.get(index).SeeBuah();
                            }
                        }
                    }
                }
            }
        }
    }
    
}
