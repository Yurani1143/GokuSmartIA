/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import static Model.AlgoritmosDeBusquedaNoInformada.pintarNuevaMatriz;
import Model.Nodo;
import java.awt.Rectangle;
import java.util.List;
import java.util.TimerTask;
import javax.swing.*;

public class Tablero extends JFrame{
                
    public Tablero() {
        
    }
        
    public JLabel[][] dibujarTablero(int[][] laberinto, JPanel panel){
        
        panel.repaint(); // re-dibuja el tamaño del tablero m*n
        JLabel[][] tablero = new JLabel[10][10];
        
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                tablero[i][j] = new JLabel();
                tablero[i][j].setOpaque(true);
                tablero[i][j].setBounds(new Rectangle(50, 50)); // se dibuja como un rectangulo.
                ImageIcon imagen = seleccionarIcono(laberinto[i][j]);
                tablero[i][j].setLocation(j*50, i*50);
                tablero[i][j].setIcon(imagen);
                panel.add(tablero[i][j]);
            }
            
        }
        return tablero;
    }
    
    public void movimientoGoku(int matriz[][], List<Nodo> path, int c, JPanel panel) {
        matriz[path.get(c).x][path.get(c).y] = 2;
        dibujarTablero(matriz, panel);    
    }
    
    public ImageIcon seleccionarIcono(int laberinto){
        ImageIcon imagen;
        switch (laberinto){
            case 0:
                imagen = new ImageIcon("src/img/casillaLibre.png");
                break;
            case 1:
                imagen = new ImageIcon("src/img/muro2.jpg");
                break;
            case 2:
                imagen = new ImageIcon("src/img/goku.png");
                break;
            case 3:
                imagen = new ImageIcon("src/img/friezer.png");
                break;
            case 4:
                imagen = new ImageIcon("src/img/cell.png");
                break;
            case 5:
                imagen = new ImageIcon("src/img/semillaErmitaño.png");
                break;
            case 6:
                imagen = new ImageIcon("src/img/esfera.png"); 
                break;
            default:
                imagen = new ImageIcon("src/img/casillaLibre.png");
        }
        return imagen;
    }
}
