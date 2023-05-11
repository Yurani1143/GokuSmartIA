package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;


public class BusquedaAvara {

    public static void busquedaAvara(int[][] matriz, int esferaX, int esferaY, int esferaX2,  int esferaY2) {

        int n = matriz.length;
        int m = matriz[0].length;
        boolean[][] visitado = new boolean[n][m];
        PriorityQueue<Nodo> cola = new PriorityQueue<Nodo>
        (Comparator.comparingInt(nodo -> distanciaEuclidiana(nodo, esferaX, esferaY, esferaX2, esferaY2)));
        List<Nodo> nodosExpandidos = new ArrayList<>();
        int nEsferas = 0;
        Nodo nodoInicial = new Nodo(2, 8, 0, null);
        cola.add(nodoInicial);
        nodosExpandidos.add(nodoInicial);
        visitado[2][8] = true;
    
        while (!cola.isEmpty()) {
            Nodo nodoActual = cola.poll();
    
            if (matriz[nodoActual.x][nodoActual.y] == 6) {
    
                nEsferas++;
                cola.clear();
                cola.add(nodoActual);
                
                System.out.println("Goku encontró la Esfera del Dragón en la posición (" + nodoActual.x + ", " + nodoActual.y + ")");
    
                System.out.println("Nodos expandidos: " + nodosExpandidos.size());
                for (Nodo nodosExpandido : nodosExpandidos) {
                    System.out.print("[" + nodosExpandido.x + "," + nodosExpandido.y + "]");
                }
                System.out.println("");
                System.out.println("Profundidad del árbol: " + nodoActual.level);
    
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (visitado[i][j]) {
                            System.out.print("0 ");
                        } else {
                            System.out.print("1 ");
                        }
                    }
                    System.out.println();
                }
                System.out.println("");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        visitado[i][j] = false;
                    }
                }
    
                visitado[nodoActual.x][nodoActual.y] = true;
                matriz[nodoActual.x][nodoActual.y] = 0;
    
                List<Nodo> path = new ArrayList<>();
                Nodo nodoCamino = nodoActual;
    
                while (nodoCamino != null) {
                    path.add(nodoCamino);
                    nodoCamino = nodoCamino.parent;
                }
                Collections.reverse(path);
                System.out.print("Camino: ");
    
                for (int i = 0; i < path.size(); i++) {
                    System.out.print("[" + path.get(i).x + "," + path.get(i).y + "]");
                }
                System.out.println("");
                path.clear();

                if (nEsferas == 2) {
                    return;
                }
            }
            /*
            0 libre
            1 muro
            2 donde inicia goku
            3 freezer
            4 cell
            5 semilla
            6 esfera
             */
            // Agrega los nodos hijos a la pila
           
            if (nodoActual.x > 0 && !visitado[nodoActual.x - 1][nodoActual.y] && matriz[nodoActual.x - 1][nodoActual.y] != 1) {
                visitado[nodoActual.x - 1][nodoActual.y] = true;
                Nodo hijo = new Nodo(nodoActual.x - 1, nodoActual.y, nodoActual.level + 1, nodoActual);
                cola.add(hijo);
                nodosExpandidos.add(hijo);
            }
            if (nodoActual.x < n - 1 && !visitado[nodoActual.x + 1][nodoActual.y] && matriz[nodoActual.x + 1][nodoActual.y] != 1) {
                visitado[nodoActual.x + 1][nodoActual.y] = true;
                Nodo hijo = new Nodo(nodoActual.x + 1, nodoActual.y, nodoActual.level + 1, nodoActual);
                cola.add(hijo);
                nodosExpandidos.add(hijo);
            }
            if (nodoActual.y > 0 && !visitado[nodoActual.x][nodoActual.y - 1] && matriz[nodoActual.x][nodoActual.y - 1] != 1) {
                visitado[nodoActual.x][nodoActual.y - 1] = true;
                Nodo hijo = new Nodo(nodoActual.x, nodoActual.y - 1, nodoActual.level + 1, nodoActual);
                cola.add(hijo);
                nodosExpandidos.add(hijo);
            }
            if (nodoActual.y < m - 1 && !visitado[nodoActual.x][nodoActual.y + 1] && matriz[nodoActual.x][nodoActual.y + 1] != 1) {
                visitado[nodoActual.x][nodoActual.y + 1] = true;
                Nodo hijo = new Nodo(nodoActual.x, nodoActual.y + 1, nodoActual.level + 1, nodoActual);
                cola.add(hijo);
                nodosExpandidos.add(hijo);
            }
             }
             System.out.println("Goku no encontró la Esfera del Dragón :(");
             System.out.println("Nodos expandidos: " + nodosExpandidos.size());
                for (Nodo nodosExpandido : nodosExpandidos) {
                    System.out.print("[" + nodosExpandido.x + "," + nodosExpandido.y + "]");
                }
        }


    //Funcion que calcula la distancia euclidianan entre dos puntos.
    public static int distanciaEuclidiana(Nodo nodo, int esferaX, int esferaY, int esferaX2, int esferaY2) {
      int d1 = (int) Math.sqrt((nodo.x - esferaX) * (nodo.x - esferaX) + (nodo.y - esferaY) * (nodo.y - esferaY));
      int d2 = (int) Math.sqrt((nodo.x - esferaX2) * (nodo.x - esferaX2) + (nodo.y - esferaY2) * (nodo.y - esferaY2));
      if(d1 <= d2){
        return d1;
      }else{
     return d2;
    }
    }
   
}

