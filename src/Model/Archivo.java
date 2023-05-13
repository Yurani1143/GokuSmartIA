/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class Archivo {
    Nodo goku;
    Nodo esfera1;
    Nodo esfera2;
    int matriz[][];

    public Archivo(Nodo goku, Nodo esfera1, Nodo esfera2, int[][] matriz) {
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
    
    public static Archivo abrirArchivo(){
       Archivo info = new Archivo(null, null, null, null);
       List<Nodo> nodos = new ArrayList<>();
       int[][] matriz = new int [10][10];
       
       try{            
           BufferedReader lector = new BufferedReader(new FileReader("matriz.txt"));            

           String linea; 
           int i=0;
           // solo lee la matriz.
           while(i < 10){   
               linea = lector.readLine();
               String[] cadena = linea.split(" "); 
               for (int j=0; j<10; j++) {
                   matriz[i][j] = Integer.parseInt(cadena[j]); // asigna un String a cada posicion (i,j) de la matriz.
                   if(matriz[i][j] == 6){
                       nodos.add(new Nodo(i, j, 0, null, nodos));
                   }else if(matriz[i][j] == 2){
                       info.setGoku(new Nodo(i, j, 0, null, nodos));
                   }
               } 
               i++; // siguiente fila.
           }
           lector.close();
           info.setEsfera1(nodos.get(0));
           info.setEsfera2(nodos.get(1));
           info.setMatriz(matriz);
       }
       catch(IOException e){
           System.err.println(e);
       }
       return info;        
   }
}
