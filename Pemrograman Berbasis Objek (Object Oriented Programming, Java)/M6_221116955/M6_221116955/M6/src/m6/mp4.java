/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m6;

/**
 *
 * @author Frans
 */
public class mp4 extends Files implements ShitToDo{
    private String color;
    private int duration;

    public mp4(String color, int duration, String name, String type, int owner) {
        super(name, type, owner);
        this.color = color;
        this.duration = duration;
    }
    
    @Override
    public void seeDesc(){
        System.out.println("Name : "+this.name);
        System.out.println("Type : "+this.type);
        System.out.println("Color : "+this.color);
        System.out.println("Duration : "+this.duration);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
    
    
}
