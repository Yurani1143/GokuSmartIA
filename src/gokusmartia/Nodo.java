package gokusmartia;

public class Nodo {
  
    int x;
    int y;  
    int level;

    public Nodo(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
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
}
