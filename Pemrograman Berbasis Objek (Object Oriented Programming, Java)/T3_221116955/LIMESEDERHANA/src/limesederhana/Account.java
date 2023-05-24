/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limesederhana;

import java.util.ArrayList;
/**
 *
 * @author Frans
 */
public class Account {
    private String username;
    private String password;
    private String Frontname;
    private String Backname;
    private ArrayList<Contact> kontak = new ArrayList<Contact>();
    private ArrayList<String> recentchat = new ArrayList<String>();
    private ArrayList<String> recentContactFirstName = new ArrayList<String>();
    private ArrayList<String> recentContactLastName = new ArrayList<String>();
    private ArrayList<Integer> indexrecent = new ArrayList<Integer>();

    public Account(String username, String password, String Frontname, String Backname) {
        this.username = username;
        this.password = password;
        this.Frontname = Frontname;
        this.Backname = Backname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void SeeContacts(){
        for(int i =0;i<kontak.size();i++){
            System.out.println((i+1)+". "+kontak.get(i).getFirstname()+" "+kontak.get(i).getLastname());
        }
    }
    
    public void addContact(String contactname, String firstname, String lastname){
        kontak.add(new Contact(contactname, firstname, lastname));
        
    }
    
    public void deleteContact(int index){
        kontak.remove(index);
    }
    
    public int jumlahkontak(){
        return kontak.size();
    }
    
    public String getContactName(int index){
        return kontak.get(index).getUsername();
    }
    
    public String getFirstName(int index){
       return kontak.get(index).getFirstname(); 
    }
    
    public String getLastName(int index){
       return kontak.get(index).getLastname();
    }
    
    public void getChat(String currentuser, String contactname, int index, String firstname, String lastname){
        kontak.get(index).seeChat(currentuser, firstname, lastname);
    }
    
    public void SendChat(String newMsg, String sentby, int index, String firstname, String lastname){
        kontak.get(index).newChat(newMsg, sentby, firstname, lastname);
    }
    
    public String getOwnFName(){
        return this.Frontname;
    }
    
    public String getOwnLName(){
        return this.Backname;
    }
    
    public void UpdateRecentChat(String msg, String fcontactname, String lcontactname, Integer contactindex){
       recentchat.add(0, msg);
       recentContactFirstName.add(0, fcontactname);
       recentContactLastName.add(0, lcontactname);
       indexrecent.add(0,contactindex);
    }
    
    public void seeRecentChat(){
        for(int i =0;i<recentchat.size();i++){
            System.out.print(recentContactFirstName.get(i)+" ");
            System.out.print(recentContactLastName.get(i));
            System.out.print(" - ");
            System.out.println(recentchat.get(i));
        }
    }
    
    public int getChatIndex(int index){
        return indexrecent.get(index);
    }
    
    public int AmountOfRecentChat(){
        return indexrecent.size();
    }

    public String getFrontname() {
        return Frontname;
    }

    public void setFrontname(String Frontname) {
        this.Frontname = Frontname;
    }

    public String getBackname() {
        return Backname;
    }

    public void setBackname(String Backname) {
        this.Backname = Backname;
    }
    
    
    
}
