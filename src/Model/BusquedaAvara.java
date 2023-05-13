package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;

public class BusquedaAvara {

    public static List<Nodo> busquedaAvara(int[][] matriz, Nodo goku, Nodo esfera1, Nodo esfera2) {
        System.out.println("AVARAAAA");
        int n = matriz.length;
        int m = matriz[0].length;
        int[][] matrizInterna = new int[n][m];
        boolean[][] visitado = new boolean[n][m];
        PriorityQueue<Nodo> cola = new PriorityQueue<Nodo>(Comparator.comparingInt(nodo -> distanciaEuclidiana(nodo, esfera1.x, esfera1.y, esfera2.x, esfera2.y)));
        List<Nodo> nodosExpandidos = new ArrayList<>();
        List<Nodo> path = new ArrayList<>();
        int nEsferas = 0;
        Nodo nodoInicial = new Nodo(goku.x, goku.y, 0, null, nodosExpandidos);
        cola.add(nodoInicial);
        nodosExpandidos.add(nodoInicial);
        visitado[goku.x][goku.y] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrizInterna[i][j] = matriz[i][j];
            }
        }

        while (!cola.isEmpty()) {
            Nodo nodoActual = cola.poll();

            if (matrizInterna[nodoActual.x][nodoActual.y] == 6) {

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
                matrizInterna[nodoActual.x][nodoActual.y] = 0;
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

                if (nEsferas == 2) {
                    return path;
                }
                path.clear();
            }

            if (nodoActual.x > 0 && !visitado[nodoActual.x - 1][nodoActual.y] && matrizInterna[nodoActual.x - 1][nodoActual.y] != 1) {
                visitado[nodoActual.x - 1][nodoActual.y] = true;
                Nodo hijo = new Nodo(nodoActual.x - 1, nodoActual.y, nodoActual.level + 1, nodoActual, nodosExpandidos);
                cola.add(hijo);
                nodosExpandidos.add(hijo);
            }
            if (nodoActual.x < n - 1 && !visitado[nodoActual.x + 1][nodoActual.y] && matrizInterna[nodoActual.x + 1][nodoActual.y] != 1) {
                visitado[nodoActual.x + 1][nodoActual.y] = true;
                Nodo hijo = new Nodo(nodoActual.x + 1, nodoActual.y, nodoActual.level + 1, nodoActual, nodosExpandidos);
                cola.add(hijo);
                nodosExpandidos.add(hijo);
            }
            if (nodoActual.y > 0 && !visitado[nodoActual.x][nodoActual.y - 1] && matrizInterna[nodoActual.x][nodoActual.y - 1] != 1) {
                visitado[nodoActual.x][nodoActual.y - 1] = true;
                Nodo hijo = new Nodo(nodoActual.x, nodoActual.y - 1, nodoActual.level + 1, nodoActual, nodosExpandidos);
                cola.add(hijo);
                nodosExpandidos.add(hijo);
            }
            if (nodoActual.y < m - 1 && !visitado[nodoActual.x][nodoActual.y + 1] && matrizInterna[nodoActual.x][nodoActual.y + 1] != 1) {
                visitado[nodoActual.x][nodoActual.y + 1] = true;
                Nodo hijo = new Nodo(nodoActual.x, nodoActual.y + 1, nodoActual.level + 1, nodoActual, nodosExpandidos);
                cola.add(hijo);
                nodosExpandidos.add(hijo);
            }
        }
        System.out.println("Goku no encontró la Esfera del Dragón :(");
        System.out.println("Nodos expandidos: " + nodosExpandidos.size());
        for (Nodo nodosExpandido : nodosExpandidos) {
            System.out.print("[" + nodosExpandido.x + "," + nodosExpandido.y + "]");
        }
        return path;
    }

    //Funcion que calcula la distancia euclidianan entre dos puntos.
    public static int distanciaEuclidiana(Nodo nodo, int esferaX, int esferaY, int esferaX2, int esferaY2) {
        int d1 = (int) Math.sqrt((nodo.x - esferaX) * (nodo.x - esferaX) + (nodo.y - esferaY) * (nodo.y - esferaY));
        int d2 = (int) Math.sqrt((nodo.x - esferaX2) * (nodo.x - esferaX2) + (nodo.y - esferaY2) * (nodo.y - esferaY2));
        if (d1 <= d2) {
            return d1;
        } else {
            return d2;
        }
    }

}
