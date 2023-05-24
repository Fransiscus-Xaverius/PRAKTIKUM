/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m5;

/**
 *
 * @author Frans
 */
public class Delete extends Tool{

    public Delete(String name) {
        super(name);
    }
    
    @Override
    public String doToolShit(String str, int start, int end, String copas){
        StringBuilder beforeTool = new StringBuilder(str);
        StringBuilder AfterRemoval = beforeTool.delete(start,end);
        str = AfterRemoval.toString();
        return str;
    }
}
