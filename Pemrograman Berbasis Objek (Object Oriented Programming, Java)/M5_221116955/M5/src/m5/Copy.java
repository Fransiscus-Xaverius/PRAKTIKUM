/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m5;

/**
 *
 * @author Frans
 */
public class Copy  extends Tool{
    
    private String copyString="";
    
    public Copy(String name) {
        super(name);
    }
    
    @Override
    public String doToolShit(String str, int start, int end, String copas){
        this.copyString=str.substring(start, end+1);
        return this.copyString;
    }
    
    
}
