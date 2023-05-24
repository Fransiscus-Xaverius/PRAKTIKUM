/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package restopalingsederhana;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Frans
 */
public class RestoPalingSederhana {

    public static void LoginMenu(){
        System.out.println("Restoran Shesh");
        System.out.println("1. Login Admin");
        System.out.println("2. Login Staff");
        System.out.println("0. Exit");
        System.out.print(">>");
    }
    
    public static void menuAdmin(Admin admin){
        System.out.println("Restoran Shesh");
        System.out.println("Welcome Admin!");
        System.out.println("Saldo : Rp. "+admin.getSaldo());
        System.out.println("1. Tambah Menu");
        System.out.println("2. Daftar Menu");
        System.out.println("3. Semua Transaksi");
        System.out.println("0. Log Out");
        System.out.print(">>");
    }
    
    public static void menuStaff(){
        System.out.println("Restoran Shesh");
        System.out.println("Welcome Staff!");
        System.out.println("1. Tambah Menu");
        System.out.println("2. Daftar Menu");
        System.out.println("0. Log Out");
        System.out.print(">>");
    }
    
    public static void addItem(ArrayList<Item> listitem, int x){
        Scanner scInt = new Scanner(System.in); 
        Scanner scStr = new Scanner(System.in); 
        System.out.println("=Tambah Menu=");
        System.out.print("Nama : ");
        String ItemName = scStr.nextLine();
        System.out.print("Harga : ");
        int ItemPrice = scInt.nextInt();
        System.out.print("Jenis [makanan/minuman] : ");
        String type = scStr.nextLine();
        int tipe = 0;
        boolean valid = true;
        if(type.equalsIgnoreCase("makanan")){
            tipe=1;
        }
        else if(type.equalsIgnoreCase("minuman")){
            tipe=2;
        }
        if(tipe==1){
            valid = true;
        }
        else if(tipe==2){
            valid = true;
        }
        else{
            valid = false;
        }
        if(valid){
            System.out.print("Deskripsi : ");
            String desc = scStr.nextLine();
            if(tipe==1){
                Makanan newitem = new Makanan(ItemName,ItemPrice,desc);
                newitem.generate(x);
                listitem.add(newitem);
                System.out.println(newitem.getKode()+" sukses ditambahkan!");
                x++;
            }
            else if(tipe==2){
                Minuman newitem = new Minuman(ItemName,ItemPrice,desc);
                newitem.generate(x);
                listitem.add(newitem);
                System.out.println(newitem.getKode()+" sukses ditambahkan!");
                x++;
            }
        }
        else{
            System.out.println("Invalid item type. Item is not [makanan/minuman]");
        }
    }
    
    public static void seeMenu(ArrayList<Item> listitem){
        System.out.println("=Daftar Menu=");
        for(int i =0;i<listitem.size();i++){
            System.out.println((i+1)+". "+listitem.get(i).getNama()+" - Rp. "+listitem.get(i).getHarga());
        }
        System.out.println("0. Back");
        System.out.print(">>");
    }
    
    public static void detailMenuAdmin(Item item){
         Scanner sc = new Scanner(System.in); 
        System.out.println("=Detail "+item.getNama()+"=");
        System.out.println("ID : "+item.getKode());
        System.out.println("Nama : "+item.getNama());
        System.out.println("Harga : "+item.getHarga());
        if(item instanceof Makanan){
            System.out.println("Jenis : Makanan");
        }
        else{
            System.out.println("Jenis : Minuman");
        }
        System.out.println("Deskripsi : "+item.getDesc());
        System.out.println("==============");
        System.out.println("1. Edit Nama");
        System.out.println("2. Edit Harga");
        System.out.println("3. Edit Deskripsi");
        System.out.println("4. Delete Menu");
        System.out.println("0. Back");
        System.out.print(">>");
    }
    
    public static void detailMenuStaff(Item item){
        Scanner sc = new Scanner(System.in); 
        System.out.println("=Detail "+item.getNama()+"=");
        System.out.println("Nama : "+item.getNama());
        System.out.println("Harga : "+item.getHarga());
        if(item instanceof Makanan){
            System.out.println("Jenis : Makanan");
        }
        else{
            System.out.println("Jenis : Minuman");
        }
        System.out.println("Deskripsi : "+item.getDesc());
        System.out.println("==============");
        System.out.print("Press Enter to Continue");
        sc.nextLine();
    }
    
    public static void main(String[] args) {
        Scanner scInt = new Scanner(System.in); 
        Scanner scStr = new Scanner(System.in); 
        boolean run = true;
        Admin admin = new Admin(0);
        ArrayList<Item> listitem = new ArrayList<Item>();
        int x = 1;
        while(run){
            LoginMenu();
            int pilLogin = scInt.nextInt();
            if(pilLogin==1){
                boolean logAdmin = true;
                while(logAdmin){
                    menuAdmin(admin);
                    int pilAdmin = scInt.nextInt();
                    if(pilAdmin==1){
                        addItem(listitem,x);
                    }
                    else if(pilAdmin==2){
                        boolean menu = true;
                        while(menu){
                            seeMenu(listitem);
                            int pilmenu = scInt.nextInt();
                            if(pilmenu==0){
                                menu=false;
                            }
                            else{
                                pilmenu=pilmenu-1;
                                if(pilmenu<0||pilmenu>listitem.size()-1){
                                    System.out.println("Invalid index!");
                                }
                                else{
                                    Item temp = listitem.get(pilmenu);
                                    boolean seeingDetail = true;
                                    while(seeingDetail){
                                        detailMenuAdmin(temp);
                                        int pilDetail = scInt.nextInt();
                                        if(pilDetail==1){
                                            System.out.print("Nama : ");
                                            String newName = scStr.nextLine();
                                            listitem.get(pilmenu).setNama(newName);
                                            if(listitem.get(pilmenu) instanceof Makanan){
                                                Makanan T = (Makanan)listitem.get(pilmenu);
                                                T.generate(x);
                                                x++;
                                            }
                                            else{
                                                Minuman T = (Minuman)listitem.get(pilmenu);
                                                T.generate(x);
                                                x++;
                                            }
                                        }
                                        else if(pilDetail==2){
                                            boolean changeharga = true;
                                            int newHarga = 0;
                                            while(changeharga){
                                                System.out.print("Harga : ");
                                                newHarga = scInt.nextInt();
                                                if(newHarga>0){
                                                    changeharga=false;
                                                }
                                                else{
                                                    System.out.println("Invalid nominal!");
                                                }
                                            }
                                            listitem.get(pilmenu).setHarga(newHarga);
                                        }
                                        else if(pilDetail==3){
                                            System.out.print("Deskripsi : ");
                                            String newDesc = scStr.nextLine();
                                            listitem.get(pilmenu).setDesc(newDesc);
                                        }
                                        else if(pilDetail==4){
                                            listitem.remove(pilmenu);
                                            seeingDetail=false;
                                        }
                                        else if(pilDetail==0){
                                            seeingDetail=false;
                                        }
                                    }
                                }
                            }
                        } 
                    }
                    else if(pilAdmin==3){

                    }
                    else if(pilAdmin==0){
                        logAdmin=false;
                    }
                }
            }
            else if(pilLogin==2){
                boolean logStaff = true;
                while(logStaff){
                    menuStaff();
                    int pilstaff = scInt.nextInt();
                    if(pilstaff==0){
                        logStaff=false;
                    }
                    else if(pilstaff==1){
                        
                    }
                    else if(pilstaff==2){
                        boolean menu = true;
                        while(menu){
                            seeMenu(listitem);
                            int pilmenu = scInt.nextInt();
                            if(pilmenu==0){
                                menu=false;
                            }
                            else{
                                pilmenu=pilmenu-1;
                                if(pilmenu<0||pilmenu>listitem.size()-1){
                                    System.out.println("Invalid Index!");
                                }
                                else{
                                    detailMenuStaff(listitem.get(pilmenu));
                                }
                            }
                        }
                        
                    }
                }
            }
            else if(pilLogin==0){
                run=false;
            }
        }
    }
    
}
