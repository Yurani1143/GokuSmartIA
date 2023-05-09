package gokusmartia;

public class Nodo {
  
    int x;
    int y;  
    int level;
    Nodo parent;

    public Nodo(int x, int y, int level, Nodo parent) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.parent = parent;
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
    
}
