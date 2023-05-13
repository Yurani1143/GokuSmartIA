/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

public class Nodo {
  
    public int x;
    public int y;  
    public int level;
    public Nodo parent;
    public List<Nodo> nodosExpandidos;

    public Nodo(int x, int y, int level, Nodo parent, List<Nodo> nodosExpandidos) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.parent = parent;
        this.nodosExpandidos = nodosExpandidos;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Nodo getParent() {
        return parent;
    }

    public void setParent(Nodo parent) {
        this.parent = parent;
    }
    
    public List<Nodo> getNodosExpandidos() {
        return nodosExpandidos;
    }

    public void setNodosExpandidos(List<Nodo> nodosExpandidos) {
        this.nodosExpandidos = nodosExpandidos;
    }
    
}