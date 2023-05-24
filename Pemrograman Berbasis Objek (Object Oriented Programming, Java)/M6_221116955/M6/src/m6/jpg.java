/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m6;

/**
 *
 * @author Frans
 */
public class jpg extends Files implements ShitToDo{
    private String color;

    public jpg(String color, String name, String type, int owner) {
        super(name, type, owner);
        this.color = color;
    }
    
    @Override
    public void seeDesc(){
        System.out.println("Name : "+this.name);
        System.out.println("Type : "+this.type);
        System.out.println("Color : "+this.color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
