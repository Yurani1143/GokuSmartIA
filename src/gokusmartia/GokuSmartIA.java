
package gokusmartia;

import java.util.Timer;
import java.util.TimerTask;

public class GokuSmartIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 10; // tamaño de la matriz
        int m = 10;   
        int esferaX = 4; // coordenadas de la esfera del dragón
        int esferaY = 0;
        /*
            0 libre
            1 muro
            2 donde inicia goku
            3 freezer
            4 cell
            5 semilla
            6 esfera
            */
        int[][] matrix = {
            {0,5,3,1,1,1,1,1,1,1},
            {0,1,0,0,1,0,0,0,1,1},
            {0,1,1,0,3,5,1,0,2,0},
            {0,1,1,1,3,1,1,1,1,0},
            {6,0,0,0,0,0,0,0,0,0},
            {1,1,4,1,1,1,1,1,1,0},
            {1,1,0,4,4,0,0,1,1,5},
            {1,1,0,0,1,1,0,1,1,0},
            {0,0,0,0,1,1,5,0,0,0},
            {1,1,1,6,1,1,0,1,1,1}
        };
        
        //int[][] matriz = crearMatriz(n, m, esferaX, esferaY);
        System.out.println("Matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        
        System.out.println("\nBUSQUEDA POR AMPLITUD\n");
        AlgoritmosDeBusquedaNoInformada.busquedaPorAmplitud(matrix, esferaX, esferaY);
        //System.out.println("\nBUSQUEDA POR PROFUNDIDAD\n");
        //AlgoritmosDeBusquedaNoInformada.busquedaPorProfundidad(matrix, esferaX, esferaY);
    }
    
}
