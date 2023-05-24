/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netflex;

/**
 *
 * @author Frans
 */
public abstract class Type {
    protected String title;

    public Type(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public abstract void addGenre(String x);
    
    public abstract void AddShit(Movie x, String y);
    
    public abstract void EditRating(int x);
    
}
