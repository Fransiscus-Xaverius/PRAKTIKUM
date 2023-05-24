/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m5;

/**
 *
 * @author Frans
 */
public class Paste extends Tool{

    public Paste(String name) {
        super(name);
    }
    
    @Override
    public String doToolShit(String str, int start, int end, String copas){
        String newString = str+copas;
        str = newString;
        return str;
    }
    
    
    
}
