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
public class Group {
    private String chat;
    private ArrayList<String> members = new ArrayList<String>();
    private String groupname;
    private String groupcode;
    private ArrayList<Chat> groupchat = new ArrayList<Chat>();

    public Group(String groupname, String groupcode) {
        this.groupname = groupname;
        this.groupcode = groupcode;
    }

    public void JoinGroup(String username){
        members.add(username);
        
    }
    
    public int MemberCount(){
        return members.size();
    }
    
    public boolean isMember(String username){
        boolean cek = false;
        for(int i =0;i<members.size();i++){
            if(username.equals(members.get(i))){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    public void seeMember(){
        for(int i =0;i<members.size();i++){
            System.out.println((i+1)+". "+members.get(i));
        }
    }
    
    public void removeMember(int index){
        members.remove(index);
    }
    
    public void SeeChat(String username){
        for(int i =0;i<groupchat.size();i++){
            if(groupchat.get(i).getUsername().equals(username)){
                System.out.println("You: "+groupchat.get(i).getMsg());
            }
            else{
                System.out.println(groupchat.get(i).getFirstname()+" "+groupchat.get(i).getLastname()+": "+groupchat.get(i).getMsg());
            }
        }
    }
    
    public void sendChat(String msg, String username, String firstname, String lastname){
        groupchat.add(new Chat(msg,username,firstname,lastname));
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode;
    }
    
    public boolean cekIfJoined(String username){
        boolean cek = false;
        for(int i =0;i<members.size();i++){
            if(members.get(i).equals(username)){
                cek=true;
                break;
            }
        }
        return cek;
    }
    
    public String getMemberName(int index){
        return members.get(index);
    }
    
}
