package Model;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/* Clase que implementa el algoritmo de búsqueda no informada, por costo uniforme */
public class AEstrella {

    /**
     * Cola de nodos a visitar
     */
    private PriorityQueue<Nodo2> cola;

    /**
     * Camino desde la raíz hasta el objetivo
     */
    private Stack<Nodo2> path;

    /**
     * Cantidad de nodos expandidos
     */
    private int cantNodosExpandidos;

    /**
     * Profundidad del árbol de búsqueda
     */
    private int profundidad;

    /**
     * Indica si se llegó al objetivo
     */
    private boolean llegoObjetivo;

    private int esferaX;
    private int esferaY;
    private int esferaX2;
    private int esferaY2;

    /**
     * Constructor de la clase CostoUniforme
     */
    public AEstrella(int esferaX, int esferaY, int esferaX2, int esferaY2) {
        
        this.esferaX = esferaX;
        this.esferaY = esferaY;
        this.esferaX2 = esferaX2;
        this.esferaY2 = esferaY2;
        this.cola = new PriorityQueue<Nodo2>(
            Comparator.comparingDouble(nodo -> valorHeuristica(nodo) + (double) nodo.getCosto())
        );
        this.path = new Stack<Nodo2>();
        this.cantNodosExpandidos = 0;
        this.profundidad = 0;
        this.llegoObjetivo = false;
    }

    /**
     * Método que implementa el algoritmo de búsqueda por costo uniforme
     */
    public void buscar(Nodo2 raiz) {

        cola.add(raiz);

        while (!cola.isEmpty()) {

            Nodo2 nodoActual = cola.poll();

            if (esObjetivo(nodoActual)) {
                llenarCamino(nodoActual);
                break;
            }
            else {

                Nodo2 hijoArr, hijoDer, hijoAba, hijoIzq;

                hijoArr = nodoActual.aplicarOperador("ARRIBA");
                if (hijoArr != null) {
                    cola.add(hijoArr);
                }

                hijoDer = nodoActual.aplicarOperador("DERECHA");
                if (hijoDer != null) {
                    cola.add(hijoDer);
                }

                hijoAba = nodoActual.aplicarOperador("ABAJO");
                if (hijoAba != null) {
                    cola.add(hijoAba);
                }

                hijoIzq = nodoActual.aplicarOperador("IZQUIERDA");
                if (hijoIzq != null) {
                    cola.add(hijoIzq);
                }

                cantNodosExpandidos += 1;

                if (hijoArr.getLevel() > profundidad) {
                    profundidad = hijoArr.getLevel();
                }
            }
        }
    }

    /**
     * Método que retorna el camino desde el nodo meta hasta el objetivo
     */
    private void llenarCamino(Nodo2 nodoMeta) {
            
        Nodo2 nodo = nodoMeta;
        while (nodo != null) {
            path.push(nodo);
            nodo = nodo.getPadre();
        }
    }

    /**
     * @param nodoActual
     * @return true si el nodo actual es el objetivo, false en caso contrario
     */
    private boolean esObjetivo(Nodo2 nodoActual) {
        
        if (nodoActual.getEsferas() == 0) {
            llegoObjetivo = true;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @param nodo
     * @return valor de la heurística en el nodo
     */
    private double valorHeuristica(Nodo2 nodo) {
        return distanciaEuclidiana(nodo);
    }

    private double distanciaEuclidiana(Nodo2 nodo) {
        double d1 = Math.sqrt(Math.pow((nodo.getI() - esferaX), 2.0) + Math.pow((nodo.getJ() - esferaY), 2.0));
        double d2 = Math.sqrt(Math.pow((nodo.getI() - esferaX2), 2.0) + Math.pow((nodo.getJ() - esferaY2), 2.0));
        if (d1 <= d2) {
            return d1;
        } else {
            return d2;
        }
    }
}
