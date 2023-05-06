
package gokusmartia;

public class GokuSmartIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 5; // tamaño de la matriz
        int m = 5;   
        int esferaX = 0; // coordenadas de la esfera del dragón
        int esferaY = 4;
        int[][] matrix = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
        };
        //int[][] matriz = crearMatriz(n, m, esferaX, esferaY);
        System.out.println("Matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Busqueda por amplitud");
        AlgoritmosDeBusquedaNoInformada.busquedaPorAmplitud(matrix, esferaX, esferaY);
        System.out.println("\nBusqueda por profundidad");
        AlgoritmosDeBusquedaNoInformada.busquedaPorProfundidad(matrix, esferaX, esferaY);
    }
    
}
