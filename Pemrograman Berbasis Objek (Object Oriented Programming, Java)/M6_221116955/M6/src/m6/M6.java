/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m6;

import java.util.ArrayList;
import java.util.Scanner;

public class M6 {
    public static void menuAwalBruh(){
        System.out.println("***Gugu Drive***");
        System.out.println("1. Login");
        System.out.println("0. Exit");
        System.out.print(">>");
    }
    
    public static boolean kembar(ArrayList<String> listuser, String user){
        for(int i =0;i<listuser.size();i++){
            if(listuser.get(i).equals(user)){
                return false;
            }
        }
        
        return true;
    }
    
    public static int getAccountID(ArrayList<String> listuser, String user){
        for(int i =0;i<listuser.size();i++){
            if(listuser.get(i).equals(user)){
                return i;
            }
        }
        return -1;
    }
    
    public static void menuUser(String u, String p){
        System.out.println("Welcome "+u);
        System.out.println("1. My Files");
        System.out.println("2. Other Files");
        System.out.println("0. Logout");
        System.out.print(">>");
    }
    
    public static ArrayList<Files> takeDrive(ArrayList<Files> database, ArrayList<Files> userDrive, int user_ID){
        userDrive.clear();
        for(int i =0;i<database.size();i++){
            if(database.get(i).getOwner()==user_ID){
                userDrive.add(database.remove(i));
            }
        }
        return userDrive;
    }
    
    public static ArrayList<Files> reDexDrive(ArrayList<Files> database, ArrayList<Files> userDrive){
        for(int i =0;i<userDrive.size();i++){
            database.add(userDrive.get(i));
        }
        userDrive.clear();
        return userDrive;
    }
    
    public static void FilesMenu(ArrayList<Files> UserFile){
        System.out.println("***My Files***");
        for(int i =0;i<UserFile.size();i++){
            System.out.println((i+1)+". "+UserFile.get(i).getName()+"."+UserFile.get(i).getType());
        }
        System.out.println("0. Back");
        System.out.print(">>");
    }
    
    public static ArrayList<Files> addNew(ArrayList<Files> userDrive, String file_user, int user_id){
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        System.out.print("Tipe data : ");
        String newType = scStr.nextLine();
        if(newType.equalsIgnoreCase("mp3")){
            System.out.print("Duration : ");
            int newDur = scInt.nextInt();
            userDrive.add(new mp3(newDur,file_user,"mp3",user_id));
            System.out.println("Item Added!");
            return userDrive;
        }
        else if(newType.equalsIgnoreCase("jpg")){
            System.out.print("Color : ");
            String newCol = scStr.nextLine();
            userDrive.add(new jpg(newCol,file_user,"jpg",user_id));
            System.out.println("Item Added!");
            return userDrive;
        }
        else if(newType.equalsIgnoreCase("mp4")){
            System.out.print("Color : ");
            String newCol = scStr.nextLine();
            System.out.print("Duration : ");
            int newDur = scInt.nextInt();
            userDrive.add(new mp4(newCol,newDur,file_user,"mp4",user_id));
            System.out.println("Item Added!");
            return userDrive;
        }
        else{
            System.out.println("Invalid file type.");
            return userDrive;
        }
    }
    
    public static void seeFileDesc(Files x){
        System.out.println(x.getName()+"."+x.getType()+"'s description");
        System.out.println("Name : "+x.getName());
        System.out.println("Type : "+x.getType());
        if(x.getType().equals("jpg")){
            jpg temp = (jpg)x;
            System.out.println("Color : "+temp.getColor());
        }
        else if(x.getType().equals("mp3")){
            mp3 temp = (mp3)x;
            System.out.println("Duration : "+temp.getDuration());
        }
        else if(x.getType().equals("mp4")){
            mp4 temp = (mp4)x;
            System.out.println("Color : "+temp.getColor());
            System.out.println("Duration : "+temp.getDuration());
        }
        System.out.println("0. Back");
        System.out.print(">>");
    }
    
    public static void seeFile(Files x){
        System.out.println("Edit "+x.getName()+"."+x.getType());
        if(x.getType().equals("jpg")){
            System.out.println("1. Edit Nama");
            System.out.println("2. Edit Color");
            System.out.println("0. Back");
            System.out.print(">>");
        }
        else if(x.getType().equals("mp3")){
            System.out.println("1. Edit Nama");
            System.out.println("2. Edit Duration");
            System.out.println("0. Back");
            System.out.print(">>");
        }
        else if(x.getType().equals("mp4")){
            System.out.println("1. Edit Nama");
            System.out.println("2. Edit Color");
            System.out.println("3. Edit Duration");
            System.out.println("0. Back");
            System.out.print(">>");
        }
    }
    
    public static void main(String[] args) {
        ArrayList<String> listuser = new ArrayList<String>();
        ArrayList<String> listpass = new ArrayList<String>();
        ArrayList<Files> DATABASE = new ArrayList<Files>();
        ArrayList<Files> UserDrive = new ArrayList<Files>();
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        boolean run = true;
        while(run){
            menuAwalBruh();
            int pilmen = scInt.nextInt();
            if(pilmen==1){
                System.out.print("Username : ");
                String userlog = scStr.nextLine();
                System.out.print("Password : ");
                String passlog = scStr.nextLine();
                boolean newUser = kembar(listuser,userlog);
                if(newUser){
                    listuser.add(userlog);
                    listpass.add(passlog);
                    System.out.println("User Registered!");
                }
                else{
                    boolean Logged_in = false;
                    String u = "";
                    String p = "";
                    int ACC_ID = getAccountID(listuser,userlog);
                    if(listpass.get(ACC_ID).equals(passlog)){
                        System.out.println("Login Success!");
                        Logged_in = true;
                        u = userlog;
                        p = passlog;
                    }
                    else{
                        System.out.println("Username atau Password salah");
                    }
                    if(Logged_in){
                        boolean run_shit = true;
                        UserDrive = takeDrive(DATABASE,UserDrive,ACC_ID);
                        while(run_shit){
                            menuUser(u,p);
                            boolean syntaxCommand = false;
                            String command = "";
                            String piluser = scStr.nextLine();
                            if(piluser.length()>2){
                                command = piluser.substring(0, 3);
                                syntaxCommand = true;
                            }
                            if(piluser.equals("1")){
                                FilesMenu(UserDrive);
                                int dexFile = scInt.nextInt();
                                if(dexFile>UserDrive.size()){
                                    System.out.println("Invalid Index!");
                                }
                                else{
                                    int kunjungan = dexFile-1;
                                    Files x = UserDrive.get(kunjungan);
                                    seeFileDesc(x);
                                    int typeOfFile =0;
                                    if(UserDrive.get(kunjungan).getType().equals("jpg")){
                                        typeOfFile = 1;
                                    }
                                    else if(UserDrive.get(kunjungan).getType().equals("mp3")){
                                        typeOfFile = 2;
                                    }
                                    else if(UserDrive.get(kunjungan).getType().equals("mp4")){
                                        typeOfFile = 3;
                                    }
                                    int piledit = scInt.nextInt();
                                    if(piledit==1){
                                        
                                    }
                                    else if(piledit==2&&typeOfFile == 1){
                                        
                                    }
                                    else if(piledit==2&&typeOfFile == 2){
                                        
                                    }
                                    else if(piledit==2&&typeOfFile == 3){
                                        
                                    }
                                }
                            }
                            else if(piluser.equals("2")){
                                
                            }
                            else if(piluser.equals("0")){
                                run_shit=false;
                            }
                            else if(syntaxCommand){
                                System.out.println(command);
                                if(command.equalsIgnoreCase("add")){
                                    if(piluser.length()<4){
                                        System.out.println("Invalid file name");
                                    }
                                    else{
                                        System.out.println("Size = "+UserDrive.size());
                                        String file_name = piluser.substring(4);
                                        UserDrive = addNew(UserDrive, file_name,ACC_ID);
                                        System.out.println(UserDrive.size());
                                    }
                                }
                                else{
                                    System.out.println("Invalid command syntax..");
                                }
                            }
                        }
                    }
                }
            }
            else if(pilmen==0){
                run=false;
            }
        }
    }
    
}
