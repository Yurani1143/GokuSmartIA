package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AlgoritmosDeBusquedaNoInformada {

    public static List<Nodo> busquedaPorAmplitud(int[][] matriz, Nodo goku) {
        int n = matriz.length;
        int m = matriz[0].length;
        int[][] matrizInterna = new int[n][m];
        boolean[][] visitado = new boolean[n][m];
        Queue<Nodo> cola = new LinkedList<>();
        List<Nodo> nodosExpandidos = new ArrayList<>();
        List<Nodo> path = new ArrayList<>();
        visitado[goku.x][goku.y] = true;
        cola.add(new Nodo(goku.x, goku.y, 0, null, nodosExpandidos));
        int nEsferas = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
             matrizInterna[i][j] =  matriz[i][j];   
            }
        }
        while (!cola.isEmpty()) {
            Nodo nodoActual = cola.poll();
            nodosExpandidos.add(nodoActual);

            if (matrizInterna[nodoActual.x][nodoActual.y] == 6) {
                nEsferas++;
                cola.clear();
                cola.add(nodoActual);
                System.out.println("\n¡Goku encontró la Esfera del Dragón! en la casilla: (" + nodoActual.x + ", " + nodoActual.y + ")");
                //JOptionPane.showMessageDialog(null, "\n¡Goku encontró la Esfera del Dragón! en la casilla: (" + nodoActual.x + ", " + nodoActual.y + ")");
                System.out.println("Nodos expandidos: " + nodosExpandidos.size());
                for (Nodo nodoExpandido : nodosExpandidos) {
                    System.out.print("[" + nodoExpandido.x + "," + nodoExpandido.y + "]");
                }

                System.out.println("");
                System.out.println("Profundidad del árbol: " + nodoActual.level + "\n");

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (visitado[i][j] == true) {
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
                //cola.add(new Nodo(nodoActual.x, nodoActual.y, nodoActual.level));
                if (nEsferas == 2) {
                    System.out.println("Goku ha encontrado las 2 esferas del Dragón");

                    return path;
                }
                path.clear();
            }

            // Expandir vecinos
            if (nodoActual.x > 0 && !visitado[nodoActual.x - 1][nodoActual.y] && matrizInterna[nodoActual.x - 1][nodoActual.y] != 1) {
                visitado[nodoActual.x - 1][nodoActual.y] = true;
                cola.add(new Nodo(nodoActual.x - 1, nodoActual.y, nodoActual.level + 1, nodoActual, nodosExpandidos));
            }
            if (nodoActual.x < n - 1 && !visitado[nodoActual.x + 1][nodoActual.y] && matrizInterna[nodoActual.x + 1][nodoActual.y] != 1) {
                visitado[nodoActual.x + 1][nodoActual.y] = true;
                cola.add(new Nodo(nodoActual.x + 1, nodoActual.y, nodoActual.level + 1, nodoActual, nodosExpandidos));
            }
            if (nodoActual.y > 0 && !visitado[nodoActual.x][nodoActual.y - 1] && matrizInterna[nodoActual.x][nodoActual.y - 1] != 1) {
                visitado[nodoActual.x][nodoActual.y - 1] = true;
                cola.add(new Nodo(nodoActual.x, nodoActual.y - 1, nodoActual.level + 1, nodoActual, nodosExpandidos));
            }
            if (nodoActual.y < m - 1 && !visitado[nodoActual.x][nodoActual.y + 1] && matrizInterna[nodoActual.x][nodoActual.y + 1] != 1) {
                visitado[nodoActual.x][nodoActual.y + 1] = true;
                cola.add(new Nodo(nodoActual.x, nodoActual.y + 1, nodoActual.level + 1, nodoActual, nodosExpandidos));
            }
        }

        System.out.println("Goku no pudo encontró Esferas del Dragón");
        return path;
    }

    public static List<Nodo> busquedaPorProfundidad(int[][] matriz, Nodo goku) {

        int n = matriz.length;
        int m = matriz[0].length;
        int[][] matrizInterna = new int[n][m];
        boolean[][] visitado = new boolean[n][m];
        Stack<Nodo> pila = new Stack<>();
        List<Nodo> nodosExpandidos = new ArrayList<>();
        List<Nodo> path = new ArrayList<>();
        int nEsferas = 0;
        Nodo nodoInicial = new Nodo(goku.x, goku.y, 0, null, nodosExpandidos);
        pila.push(nodoInicial);
        nodosExpandidos.add(nodoInicial);
        visitado[goku.x][goku.y] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
             matrizInterna[i][j] =  matriz[i][j];   
            }
        }
        
        while (!pila.empty()) {
            Nodo nodoActual = pila.pop();

            if (matrizInterna[nodoActual.x][nodoActual.y] == 6) {

                nEsferas++;
                pila.clear();
                pila.push(nodoActual);

                System.out.println("Goku encontró la Esfera del Dragón en la posición (" + nodoActual.x + ", " + nodoActual.y + ")");

                System.out.println("Nodos expandidos: " + nodosExpandidos.size());
                for (Nodo nodosExpandido : nodosExpandidos) {
                    System.out.print("[" + nodosExpandido.x + "," + nodosExpandido.y + "]");
                }
                System.out.println("");
                System.out.println("Profundidad del árbol: " + nodoActual.level);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (visitado[i][j] == true) {
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
                matrizInterna[nodoActual.x][nodoActual.y] = 6;
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
                //cola.add(new Nodo(nodoActual.x, nodoActual.y, nodoActual.level));
                if (nEsferas == 2) {
                    System.out.println("Goku ha encontrado las 2 esferas del Dragón");

                    return path;
                }
                path.clear();
            }
            // Agrega los nodos hijos a la pila
            if (nodoActual.x > 0 && !visitado[nodoActual.x - 1][nodoActual.y] && matrizInterna[nodoActual.x - 1][nodoActual.y] != 1) {
                visitado[nodoActual.x - 1][nodoActual.y] = true;
                Nodo hijo = new Nodo(nodoActual.x - 1, nodoActual.y, nodoActual.level + 1, nodoActual, nodosExpandidos);
                pila.push(hijo);
                nodosExpandidos.add(hijo);
            }
            if (nodoActual.x < n - 1 && !visitado[nodoActual.x + 1][nodoActual.y] && matrizInterna[nodoActual.x + 1][nodoActual.y] != 1) {
                visitado[nodoActual.x + 1][nodoActual.y] = true;
                Nodo hijo = new Nodo(nodoActual.x + 1, nodoActual.y, nodoActual.level + 1, nodoActual, nodosExpandidos);
                pila.push(hijo);
                nodosExpandidos.add(hijo);
            }
            if (nodoActual.y > 0 && !visitado[nodoActual.x][nodoActual.y - 1] && matrizInterna[nodoActual.x][nodoActual.y - 1] != 1) {
                visitado[nodoActual.x][nodoActual.y - 1] = true;
                Nodo hijo = new Nodo(nodoActual.x, nodoActual.y - 1, nodoActual.level + 1, nodoActual, nodosExpandidos);
                pila.push(hijo);
                nodosExpandidos.add(hijo);
            }
            if (nodoActual.y < m - 1 && !visitado[nodoActual.x][nodoActual.y + 1] && matrizInterna[nodoActual.x][nodoActual.y + 1] != 1) {
                visitado[nodoActual.x][nodoActual.y + 1] = true;
                Nodo hijo = new Nodo(nodoActual.x, nodoActual.y + 1, nodoActual.level + 1, nodoActual, nodosExpandidos);
                pila.push(hijo);
                nodosExpandidos.add(hijo);
            }
        }

        System.out.println("Goku no pudo encontró Esferas del Dragón");
        System.out.println("Número de nodos expandidos: " + nodosExpandidos.size());
        System.out.println("Profundidad del árbol: " + nodosExpandidos.get(nodosExpandidos.size() - 1).level);
        return path;
    }

}
