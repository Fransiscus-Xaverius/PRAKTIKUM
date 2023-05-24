/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m5;

/**
 *
 * @author Frans
 */
public class Cut  extends Tool{

    private String cutString="";
    
    public Cut(String name) {
        super(name);
    }
    
    @Override
    public String doToolShit(String str, int start, int end, String copas){
        this.cutString=str.substring(start, end+1);
        StringBuilder beforeTool = new StringBuilder(str);
        StringBuilder AfterRemoval = beforeTool.delete(start,end+1);
        str = AfterRemoval.toString();
        return str;
    }
    
    @Override
    public String ReturnTool(){
        return cutString;
    }
}
