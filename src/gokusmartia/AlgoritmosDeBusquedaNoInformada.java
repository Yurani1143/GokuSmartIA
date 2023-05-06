package gokusmartia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AlgoritmosDeBusquedaNoInformada {

    public static void busquedaPorAmplitud(int[][] matriz, int esferaX, int esferaY) {
        int n = matriz.length;
        int m = matriz[0].length;
        boolean[][] visitado = new boolean[n][m];
        Queue<Nodo> cola = new LinkedList<>();
        List<Nodo> nodosExpandidos = new ArrayList<>();

        visitado[0][0] = true;
        cola.add(new Nodo(0, 0, 0));

        while (!cola.isEmpty()) {
            Nodo nodoActual = cola.poll();
            nodosExpandidos.add(nodoActual);

            if (nodoActual.x == esferaX && nodoActual.y == esferaY) {
                System.out.println("¡Goku encontró la Esfera del Dragón!");
                System.out.println("Nodos expandidos: " + nodosExpandidos.size());
                for (int i = 0; i < nodosExpandidos.size(); i++) {
                    System.out.print("[" + nodosExpandidos.get(i).x + "," + nodosExpandidos.get(i).y + "]");
                }
                System.out.println("");
                System.out.println("Profundidad del árbol: " + nodoActual.level);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(visitado[i][j] + " ");
                    }
                    System.out.println();
                }
                return;
            }

            // Expandir vecinos
            if (nodoActual.x > 0 && !visitado[nodoActual.x - 1][nodoActual.y] && matriz[nodoActual.x - 1][nodoActual.y] == 1) {
                visitado[nodoActual.x - 1][nodoActual.y] = true;
                cola.add(new Nodo(nodoActual.x - 1, nodoActual.y, nodoActual.level + 1));
            }
            if (nodoActual.x < n - 1 && !visitado[nodoActual.x + 1][nodoActual.y] && matriz[nodoActual.x + 1][nodoActual.y] == 1) {
                visitado[nodoActual.x + 1][nodoActual.y] = true;
                cola.add(new Nodo(nodoActual.x + 1, nodoActual.y, nodoActual.level + 1));
            }
            if (nodoActual.y > 0 && !visitado[nodoActual.x][nodoActual.y - 1] && matriz[nodoActual.x][nodoActual.y - 1] == 1) {
                visitado[nodoActual.x][nodoActual.y - 1] = true;
                cola.add(new Nodo(nodoActual.x, nodoActual.y - 1, nodoActual.level + 1));
            }
            if (nodoActual.y < m - 1 && !visitado[nodoActual.x][nodoActual.y + 1] && matriz[nodoActual.x][nodoActual.y + 1] == 1) {
                visitado[nodoActual.x][nodoActual.y + 1] = true;
                cola.add(new Nodo(nodoActual.x, nodoActual.y + 1, nodoActual.level + 1));
            }
        }

        System.out.println("Goku no encontró la Esfera del Dragón :(");
    }

    public static void busquedaPorProfundidad(int[][] matriz, int esferaX, int esferaY) {
        int n = matriz.length;
        int m = matriz[0].length;
        boolean[][] visitado = new boolean[n][m];
        Stack<Nodo> pila = new Stack<>();
        List<Nodo> nodosExpandidos = new ArrayList<>();

        Nodo nodoInicial = new Nodo(0, 0, 0);
        pila.push(nodoInicial);
        nodosExpandidos.add(nodoInicial);
        visitado[0][0] = true;

        while (!pila.empty()) {
            Nodo nodoActual = pila.pop();

            if (matriz[nodoActual.x][nodoActual.y] == 1 && nodoActual.x == esferaX && nodoActual.y == esferaY) {
                System.out.println("Goku encontró la Esfera del Dragón en la posición (" + esferaX + ", " + esferaY + ")");

                System.out.println("Nodos expandidos: " + nodosExpandidos.size());
                for (int i = 0; i < nodosExpandidos.size(); i++) {
                    System.out.print("[" + nodosExpandidos.get(i).x + "," + nodosExpandidos.get(i).y + "]");
                }
                System.out.println("");
                System.out.println("Profundidad del árbol: " + nodoActual.level);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(visitado[i][j] + " ");
                    }
                    System.out.println();
                }
                return;
            }

            // Agrega los nodos hijos a la pila
            if (nodoActual.x > 0 && !visitado[nodoActual.x - 1][nodoActual.y] && matriz[nodoActual.x - 1][nodoActual.y] == 1) {
                visitado[nodoActual.x - 1][nodoActual.y] = true;
                Nodo hijo = new Nodo(nodoActual.x - 1, nodoActual.y, nodoActual.level + 1);
                pila.push(hijo);
                nodosExpandidos.add(hijo);
            } 
            if (nodoActual.x < n - 1 && !visitado[nodoActual.x + 1][nodoActual.y] && matriz[nodoActual.x + 1][nodoActual.y] == 1) {
                visitado[nodoActual.x + 1][nodoActual.y] = true;
                Nodo hijo = new Nodo(nodoActual.x + 1, nodoActual.y, nodoActual.level + 1);
                pila.push(hijo);
                nodosExpandidos.add(hijo);
            }
            if (nodoActual.y > 0 && !visitado[nodoActual.x][nodoActual.y - 1] && matriz[nodoActual.x][nodoActual.y - 1] == 1) {
                visitado[nodoActual.x][nodoActual.y - 1] = true;
                Nodo hijo = new Nodo(nodoActual.x, nodoActual.y - 1, nodoActual.level + 1);
                pila.push(hijo);
                nodosExpandidos.add(hijo);
            }
            if (nodoActual.y < m - 1 && !visitado[nodoActual.x][nodoActual.y + 1] && matriz[nodoActual.x][nodoActual.y + 1] == 1) {
                visitado[nodoActual.x][nodoActual.y + 1] = true;
                Nodo hijo = new Nodo(nodoActual.x, nodoActual.y + 1, nodoActual.level + 1);
                pila.push(hijo);
                nodosExpandidos.add(hijo);
            }
        }

        System.out.println("Goku no pudo encontrar la Esfera del Dragón en la posición (" + esferaX + ", " + esferaY + ")");
        System.out.println("Número de nodos expandidos: " + nodosExpandidos.size());
        System.out.println("Profundidad del árbol: " + nodosExpandidos.get(nodosExpandidos.size() - 1).level);
    }

}
