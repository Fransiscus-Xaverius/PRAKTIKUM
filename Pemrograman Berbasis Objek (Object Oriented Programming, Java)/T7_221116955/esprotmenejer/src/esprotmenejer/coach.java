/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esprotmenejer;

/**
 *
 * @author Frans
 */
public class coach {
    private String name;
    private boolean signed;

    public coach(String name) {
        this.name = name;
        this.signed=false;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }
    
    public void Fire() {
        this.signed = false;
    }
    
    public void Sign() {
        this.signed = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
