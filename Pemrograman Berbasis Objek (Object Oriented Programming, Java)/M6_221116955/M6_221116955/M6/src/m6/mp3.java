/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m6;


public class mp3 extends Files implements ShitToDo{
    private int duration;

    public mp3(int duration, String name, String type, int owner) {
        super(name, type, owner);
        this.duration = duration;
    }
    
    @Override
    public void seeDesc(){
        System.out.println("Name : "+this.name);
        System.out.println("Type : "+this.type);
        System.out.println("Duration : "+this.duration);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    
}
