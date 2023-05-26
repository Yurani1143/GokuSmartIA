package Model;

import java.util.Objects;

public class Nodo2 {
  
    /**
     * Matriz de enteros que representa el estado del mundo en este nodo
     */
    private int[][] estadoMundo;
    
    /**
     * Posición i (fila) de Goku en la matriz
     */
    private int i;

    /**
     * Posición j (fila) de Goku en la matriz
     */
    private int j;

    /**
     * Número de semillas que Goku lleva en este nodo
     */
    private int semillasGoku;

	/**
     * Número de esferas en el estado del mundo en este nodo
     */
    private int esferasMundo;

    /**
     * Nodo padre de este nodo
     */
    private Nodo2 padre;

    /**
     * Operador que se aplicó para llegar a este nodo
     */
    private String operadorAplicado;
    
    /**
     * Nivel/profundidad del nodo en el árbol de búsqueda
     */
    private int level;

    /**
     * Costo del camino desde la raíz a este nodo
     */
    private int costo;

    
    /**
     * Constructor de la clase Nodo
     * @param estadoMundo
     * @param i
     * @param j
     */
    public Nodo2(int[][] estadoMundo, int i, int j) {
        
        this.estadoMundo = estadoMundo;
        this.i = i;
        this.j = j;
        this.semillasGoku = 0;
        this.esferasMundo = 2;
        this.padre = null;
        this.operadorAplicado = null;
        this.level = 0;
        this.costo = 0;
    }

    /**
     * Constructor de la clase Nodo
     * @param estadoMundo
     * @param i
     * @param j
     * @param semillasMundo
     * @param esferas
     * @param padre
     * @param operador
     * @param level
     * @param costo
     */
    public Nodo2(
        int[][] estadoMundo, int i, int j, int semillasGoku, int esferas,
        Nodo2 padre, String operadorAplicado, int level, int costo) {
        
        this.estadoMundo = estadoMundo;
        this.i = i;
        this.j = j;
        this.semillasGoku = semillasGoku;
        this.esferasMundo = esferas;
        this.padre = padre;
        this.operadorAplicado = operadorAplicado;
        this.level = level;
        this.costo = costo;
    }

    /**
     * @return estado del mundo en este nodo
     */
    public int[][] getEstadoMundo() {
        return estadoMundo;
    }

    /**
     * @return posición i (fila) de Goku en la matriz
     */
    public int getI() {
        return i;
    }
    
    /**
     * @return posición j (columna) de Goku en la matriz
     */
    public int getJ() {
        return j;
    }

    /**
     * @return cantidad de semillas que Goku lleva en este nodo
     */
    public int getSemillasGoku() {
		return semillasGoku;
	}

    /**
     * @return cantidad de esferas del mundo en este nodo
     */
    public int getEsferasMundo() {
        return esferasMundo;
    }

    /**
     * @return padre del nodo
     */
    public Nodo2 getPadre() {
        return padre;
    }

    /**
     * @return operador que se aplicó para llegar a este nodo
     */
    public String getOperadorAplicado() {
        return operadorAplicado;
    }

    /**
     * @return level / profundidad del nodo en el árbol de búsqueda
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return el costo del camino desde la raíz hasta este nodo
     */
    public int getCosto() {
        return costo;
    }

    /**
     * Aplica un operador al estado del mundo en este nodo, generando un nuevo Nodo
     * o null si el operador no es aplicable
     * @param operadorAplicar
     * @return nuevoNodo
     */
    public Nodo2 aplicarOperador(String operadorAplicar) {
        
        Nodo2 nuevoNodo = null;
        int nuevoI = i;
        int nuevoJ = j;
        int nuevoSemillasGoku = semillasGoku;
        int nuevoEsferasMundo = esferasMundo;
        int nuevoCosto = costo;
        
        switch (operadorAplicar) {
            case "ARRIBA":
                nuevoI = i - 1;
                if (fueraDeRango(nuevoI, nuevoJ)) return null;
                nuevoSemillasGoku = calcSemillasGoku(nuevoI, nuevoJ);
                nuevoEsferasMundo = calcEsferasMundo(nuevoI, nuevoJ);
                nuevoCosto = calcCosto(nuevoI, nuevoJ);
                break;
            case "ABAJO":
                nuevoI = i + 1;
                if (fueraDeRango(nuevoI, nuevoJ)) return null;
                nuevoSemillasGoku = calcSemillasGoku(nuevoI, nuevoJ);
                nuevoEsferasMundo = calcEsferasMundo(nuevoI, nuevoJ);
                nuevoCosto = calcCosto(nuevoI, nuevoJ);
                break;
            case "IZQUIERDA":
                nuevoJ = j - 1;
                if (fueraDeRango(nuevoI, nuevoJ)) return null;
                nuevoSemillasGoku = calcSemillasGoku(nuevoI, nuevoJ);
                nuevoEsferasMundo = calcEsferasMundo(nuevoI, nuevoJ);
                nuevoCosto = calcCosto(nuevoI, nuevoJ);
                break;
            case "DERECHA":
                nuevoJ = j + 1;
                if (fueraDeRango(nuevoI, nuevoJ)) return null;
                nuevoSemillasGoku = calcSemillasGoku(nuevoI, nuevoJ);
                nuevoEsferasMundo = calcEsferasMundo(nuevoI, nuevoJ);
                nuevoCosto = calcCosto(nuevoI, nuevoJ);
                break;
            default:
                break;
        }

        if (
            estadoMundo[nuevoI][nuevoJ] == 1 ||
            seDevuelve(operadorAplicar) &&
            !(estadoMundo[nuevoI][nuevoJ] == 5 ||
            estadoMundo[nuevoI][nuevoJ] == 6)
        ){
            return null;
        }

        int[][] nuevoEstadoMundo = new int[estadoMundo.length][estadoMundo[0].length];
        for (int i = 0; i < estadoMundo.length; i++) {
            for (int j = 0; j < estadoMundo[0].length; j++) {
                nuevoEstadoMundo[i][j] = estadoMundo[i][j];
            }
        }

        nuevoEstadoMundo[nuevoI][nuevoJ] = 2;

        int ocupantePrevioCasilla = (!Objects.isNull(padre)) ? padre.getEstadoMundo()[i][j] : 0;
        
        if(esEnemigo(ocupantePrevioCasilla) && padre.getSemillasGoku() == 0){
            nuevoEstadoMundo[i][j] = ocupantePrevioCasilla;
        }
        else{
            nuevoEstadoMundo[i][j] = 0;
        }

        nuevoNodo = new Nodo2(
            nuevoEstadoMundo, nuevoI, nuevoJ, nuevoSemillasGoku,
            nuevoEsferasMundo, this, operadorAplicar, level + 1, nuevoCosto
        );

        return nuevoNodo;
    }

    /**
     * @param operadorAplicar
     * @return true si el operador a aplicar es el opuesto al operador que se aplicó
     * para llegar a este nodo
     */
    private boolean seDevuelve(String operadorAplicar) {
        
        if(Objects.isNull(padre)) return false;
        switch (operadorAplicado) {
            case "ARRIBA":
                return operadorAplicar.equals("ABAJO");
            case "ABAJO":
                return operadorAplicar.equals("ARRIBA");
            case "IZQUIERDA":
                return operadorAplicar.equals("DERECHA");
            case "DERECHA":
                return operadorAplicar.equals("IZQUIERDA");
            default:
                return false;
        }
    }

    /**
     * @param i
     * @param j
     * @return costo de moverse a la posición i, j
     */
    private int calcCosto(int i, int j){

        switch (estadoMundo[i][j]) {
            case 1:
                return Integer.MAX_VALUE;
            case 3:
                return ( semillasGoku >= 1 ) ? costo + 1 : costo + 4;
            case 4:
                return ( semillasGoku >= 1 ) ? costo + 1 : costo + 7;
            default:
                return costo + 1;
        }
    }

    /**
     * @param i
     * @param j
     * @return semillas de Goku al moverse a i,j
     */
    private int calcSemillasGoku(int i, int j){

        switch (estadoMundo[i][j]) {
            case 3:
                return semillasGoku > 0 ? semillasGoku - 1 : semillasGoku;
            case 4:
                return semillasGoku > 0 ? semillasGoku - 1 : semillasGoku;
            case 5:
                return semillasGoku + 1;
            default:
                return semillasGoku;
        }
    }

    /**
     * @param i
     * @param j
     * @return esferas en el mundo al moverse a i,j
     */
    private int calcEsferasMundo(int i, int j){

        switch (estadoMundo[i][j]) {
            case 6:
                return esferasMundo - 1;
            default:
                return esferasMundo;
        }
    }

    /**
     * @param ocupantePrevioCasilla
     * @return true si el ocupante de la casilla es un enemigo, false en caso contrario
     */
    private boolean esEnemigo(int ocupantePrevioCasilla) {
        
        int[] enemigos = {3, 4};
        for (int enemigo : enemigos) {
            if (ocupantePrevioCasilla == enemigo) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param i
     * @param j
     * @return true si la posición i,j está fuera del rango del mundo
     */
    private boolean fueraDeRango(int i, int j) {
        return i < 0 || i >= estadoMundo.length || j < 0 || j >= estadoMundo[0].length;
    }
}
