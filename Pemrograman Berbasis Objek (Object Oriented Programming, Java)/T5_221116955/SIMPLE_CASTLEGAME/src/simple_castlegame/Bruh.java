/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simple_castlegame;

/**
 *
 * @author Frans
 */
public class Bruh {
    private String name;
    private boolean built;
    private String AssignedTroop;
    private int CostPerUnit;

    public Bruh(String name, boolean built, String AssignedTroop, int CostPerUnit) {
        this.name = name;
        this.built = built;
        this.AssignedTroop = AssignedTroop;
        this.CostPerUnit = CostPerUnit;
    }

    public Bruh(String name, boolean built) {
        this.name = name;
        this.built = built;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBuilt() {
        return built;
    }

    public void setBuilt(boolean built) {
        this.built = built;
    }

    public String getAssignedTroop() {
        return AssignedTroop;
    }

    public void setAssignedTroop(String AssignedTroop) {
        this.AssignedTroop = AssignedTroop;
    }

    public int getCostPerUnit() {
        return CostPerUnit;
    }

    public void setCostPerUnit(int CostPerUnit) {
        this.CostPerUnit = CostPerUnit;
    }
    
    
    
}
