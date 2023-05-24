/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m5;

/**
 *
 * @author Frans
 */
public class Tool {
    protected String name;

    public Tool(String name) {
        this.name = name;
    }
    
    public String doToolShit(String str, int start, int end, String copas){
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String ReturnTool(){
        return "invalid";
    }
    
}
