/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netflex;

import java.util.ArrayList;

/**
 *
 * @author Frans
 */
public class User {
    private String username;
    private String password;
    private ArrayList<Type> watchList = new ArrayList<Type>();
    private ArrayList<Type> history = new ArrayList<Type>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    public ArrayList<Type> getWatchList() {
        return watchList;
    }

    public void setWatchList(ArrayList<Type> watchList) {
        this.watchList = watchList;
    }

    public ArrayList<Type> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Type> history) {
        this.history = history;
    }
    
    
    
}
