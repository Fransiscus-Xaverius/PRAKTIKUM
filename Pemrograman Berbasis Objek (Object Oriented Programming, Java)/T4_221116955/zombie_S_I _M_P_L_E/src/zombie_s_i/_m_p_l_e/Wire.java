/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombie_s_i._m_p_l_e;

/**
 *
 * @author Frans
 */
public class Wire {
    private int x,y,turn;

    public Wire(int x, int y, int turn) {
        this.x = x;
        this.y = y;
        this.turn = turn;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
    
    public void countdown(){
        this.turn= this.turn-1;
    }
}
