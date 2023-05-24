/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esprotmenejer;
import java.util.ArrayList;

/**
 *
 * @author Frans
 * @param <T>
 */
public class Team <T>{
    private ArrayList <T> member;
    private String name;
    private int game;
    private int score;
    private coach c;

    public Team(ArrayList<T> member, String name, int game, coach c) {
        this.member = member;
        this.name = name;
        this.game = game;
        this.c = c;
        this.score=0;
    }

    public Team(ArrayList<T> member, String name, int game) {
        this.member = member;
        this.name = name;
        this.game = game;
        this.c = new coach("");
        this.score=0;
    }

    public ArrayList<T> getMember() {
        return member;
    }

    public void setMember(ArrayList<T> member) {
        this.member = member;
    }

    public String getName() {
        return name;
    }
    
    public boolean hasCoach(){
        if(this.c.equals("")){
            return false;
        }
        else{
            return true;
        }
    }
    
    public boolean isFull(){
        boolean roster = false;
        if(this.game==3){
            if(this.member.size()==4){
                roster = true;
            }
        }
        else{
            if(this.member.size()==5){
                roster=true;
            }
        }
        return roster;
    }
    
    public void add(T player){
        this.member.add(player);
    }
    
    public void spar(){
        this.score+=50;
    }
    
    public int CalcScore(){
        int total =0;
        total +=this.score;
        boolean bonusScore = true;
        if(this.game==1){
            for(int i =0;i<member.size();i++){
                int pWorth = 0;
                VALORANT p = (VALORANT) member.get(i);
                pWorth+=p.getAim();
                pWorth+=p.getComms();
                total+=pWorth;
            }
            boolean[] roles = new boolean[4];
            for(int i =0;i<roles.length;i++){
                roles[i]=false;
            }
            for(int i =0;i<member.size();i++){
                VALORANT p = (VALORANT) member.get(i);
                String Role = p.getRole();
                if(Role.equals("Duelist")){
                    roles[0]=true;
                }
                else if(Role.equals("Initiator")){
                    roles[1]=true;
                }
                else if(Role.equals("Sentinel")){
                    roles[2]=true;
                }
                else if(Role.equals("Controller")){
                    roles[3]=true;
                }
            }
            for(int i =0;i<roles.length;i++){
                if(roles[i]==false){
                    bonusScore=false;
                }
            }
        }
        else if(this.game==2){
            for(int i=0;i<member.size();i++){
                int pWorth = 0;
                Dota p = (Dota) member.get(i);
                pWorth+=p.getComms();
                total+=pWorth;
            }
            for(int i =0;i<member.size();i++){
                Dota p = (Dota) member.get(i);
                String role = p.getRole();
                    for(int j =0;j<member.size();j++){
                        Dota p2 = (Dota) member.get(j);
                        String role2 = p2.getRole();
                        if(role2.equals(role)&&i!=j){
                            bonusScore=false;
                        }
                }
            }
        }
        else{
            for(int i =0;i<member.size();i++){
                int pWorth = 0;
                PUBG p = (PUBG) member.get(i);
                pWorth+=p.getComms();
                pWorth+=p.getAim();
                pWorth+=p.getLuck();
                total+=pWorth;
            }
            bonusScore=false;
        }
        if(bonusScore){
            total+=100;
        }
        return total;
    }
    
    public void seeMembers(){
        if(this.game==1){
            for(int i =0;i<member.size();i++){
                VALORANT p = (VALORANT) member.get(i);
                System.out.println(p.getFirstname()+"\""+p.getIgn()+"\""+p.getLastname());
            }
        }
        else if(this.game==2){
            for(int i=0;i<member.size();i++){
                Dota p = (Dota) member.get(i);
                System.out.println(p.getFirstname()+"\""+p.getIgn()+"\""+p.getLastname());
            }
        }
        else{
            for(int i =0;i<member.size();i++){
                PUBG p = (PUBG) member.get(i);
                System.out.println(p.getFirstname()+" \""+p.getIgn()+"\" "+p.getLastname());
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGame() {
        return game;
    }
    
    public String seeGame(){
        if(this.game==1){
            return "VALORANT";
        }
        else if(this.game==2){
            return "DOTA";
        }
        else{
            return "PUBG";
        }
    }

    public void setGame(int game) {
        this.game = game;
    }  

    public coach getC() {
        return c;
    }

    public void setC(coach c) {
        this.c = c;
    }
}
