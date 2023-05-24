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
public class Contact {
    private String username;
    private String firstname;
    private String lastname;
    private ArrayList<Chat> pm = new ArrayList<Chat>();
    public Contact(String username, String firstname, String lastname) {
        this.username = username;
        this.firstname =firstname;
        this.lastname = lastname;
    }
    
    public void seeChat(String currentuser, String firstname, String lastname){
        System.out.println("=======================");
        System.out.println("Chat with "+firstname+" "+lastname);
        System.out.println("=======================");
        for(int i =0;i<pm.size();i++){
            if(pm.get(i).getUsername().equals(currentuser)){
                System.out.println("You : "+pm.get(i).getMsg());
            }
            else{
                System.out.println(firstname+" "+lastname+ " : " + pm.get(i).getMsg());
            }
        }
        System.out.println("=======================");
        System.out.println("0. Back");
        System.out.println("=======================");
        System.out.print(">> ");
    }
    
    public void newChat(String newMsg, String sentby, String firstname, String lastname){
        pm.add(new Chat(newMsg,sentby,firstname,lastname));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    
    
    
}
