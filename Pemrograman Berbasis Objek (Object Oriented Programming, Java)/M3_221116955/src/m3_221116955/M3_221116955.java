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

    public static void menu(){
        System.out.println("== LIME ==");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Exit");
        System.out.print(">>");
    }
    
    public static void menuregister(String[] username, String[] pass){
        Scanner scan = new Scanner(System.in);
        System.out.println("Username :");
        username[0] = scan.nextLine();
        System.out.println("Password :");
        pass[0] = scan.nextLine();
    }
    
    public static void main(String[] args) {
        boolean run = true;
        Scanner scanstr = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);
        String[] pass = new String[1];
        String[] username = new String[1];
        ArrayList<User> listuser = new ArrayList<User>();
        String cekusername = "";
        String cekpass = "";
        while(run){
            menu();
            int pil = scanint.nextInt();
            if(pil==1){
                menuregister(username,pass);
                if(listuser.size()==0){
                    listuser.add(new User(username[0],pass[0]));
                }
                else{
                    boolean unique = true;
                    for(int i =0;i<listuser.size();i++){
                        cekusername = listuser.get(i).getUsername();
                        if(cekusername==username[0]){
                            unique = false;
                            break;
                        }
                    }
                    if(unique){
                        listuser.add(new User(username[0],pass[0]));
                    }
                    else{
                       System.out.println("Username sudah terpakai! gunakan username lain!");
                    }
                }
            }
            else if(pil==2){
                
            }
            else if(pil==9){
                run=false;
            }
        }
    }
    
}
