/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restopalingsederhana;

/**
 *
 * @author Frans
 */
public class Makanan extends Item{

    public Makanan(String nama, int harga, String desc) {
        super(nama, harga, desc);
    }
    
    public void generate(int x){
        String gcode = "MA";
        boolean more = false;
        if(this.nama.contains(" ")){
            more=true;
        }
        String front = "";
        if(!more){
            front = this.nama.substring(0, 2);
        }
        else{
            front = this.nama.substring(0, 1);
        }
        String ctr = Integer.toString(x);
        gcode+=front;
        gcode+=ctr;
        String end = gcode.toUpperCase();
        this.kode=end;
    }
    
}
