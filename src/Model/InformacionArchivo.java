/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nicolas
 */
public class InformacionArchivo {
    Nodo goku;
    Nodo esfera1;
    Nodo esfera2;
    int matriz[][];

    public InformacionArchivo(Nodo goku, Nodo esfera1, Nodo esfera2, int[][] matriz) {
        this.goku = goku;
        this.esfera1 = esfera1;
        this.esfera2 = esfera2;
        this.matriz = matriz;
    }

    public Nodo getGoku() {
        return goku;
    }

    public void setGoku(Nodo goku) {
        this.goku = goku;
    }

    public Nodo getEsfera1() {
        return esfera1;
    }

    public void setEsfera1(Nodo esfera1) {
        this.esfera1 = esfera1;
    }

    public Nodo getEsfera2() {
        return esfera2;
    }

    public void setEsfera2(Nodo esfera2) {
        this.esfera2 = esfera2;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    
}
