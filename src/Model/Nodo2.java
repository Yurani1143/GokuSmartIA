package Model;

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
     * Número de semillas en el estado del mundo en este nodo
     */
    private int semillasMundo;

    /**
     * Número de semillas que Goku lleva en este nodo
     */
    private int semillasGoku;

    /**
     * Número de esferas en el estado del mundo en este nodo
     */
    private int esferas;

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
        this.semillasMundo = contarSemillasMundo();
        this.semillasGoku = 0;
        this.esferas = 2;
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
        int[][] estadoMundo, int i, int j, int semillasMundo, int semillasGoku, int esferas,
        Nodo2 padre, String operadorAplicado, int level, int costo) {
        
        this.estadoMundo = estadoMundo;
        this.i = i;
        this.j = j;
        this.semillasMundo = semillasMundo;
        this.semillasGoku = semillasGoku;
        this.esferas = esferas;
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
     * @return cantidad de esferas del mundo en este nodo
     */
    public int getEsferas() {
        return esferas;
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
     * @param operadorAplicar
     * @return nuevoNodo
     */
    public Nodo2 aplicarOperador(String operadorAplicar) {
        
        Nodo2 nuevoNodo = null;
        int nuevoI = i;
        int nuevoJ = j;
        int nuevoSemillasMundo = semillasMundo;
        int nuevoSemillasGoku = semillasGoku;
        int nuevoEsferas = esferas;
        int nuevoCosto = costo;
        
        switch (operadorAplicado) {
            case "ARRIBA":
                nuevoI = i - 1;
                nuevoSemillasMundo = calcSemillasMundo(nuevoI, nuevoJ);
                nuevoSemillasGoku = calcSemillasGoku(nuevoI, nuevoJ);
                nuevoEsferas = calcEsferas(nuevoI, nuevoJ);
                nuevoCosto = calcCosto(nuevoI, nuevoJ);
                break;
            case "ABAJO":
                nuevoI = i + 1;
                nuevoSemillasMundo = calcSemillasMundo(nuevoI, nuevoJ);
                nuevoSemillasGoku = calcSemillasGoku(nuevoI, nuevoJ);
                nuevoEsferas = calcEsferas(nuevoI, nuevoJ);
                nuevoCosto = calcCosto(nuevoI, nuevoJ);
                break;
            case "IZQUIERDA":
                nuevoJ = j - 1;
                nuevoSemillasMundo = calcSemillasMundo(nuevoI, nuevoJ);
                nuevoSemillasGoku = calcSemillasGoku(nuevoI, nuevoJ);
                nuevoEsferas = calcEsferas(nuevoI, nuevoJ);
                nuevoCosto = calcCosto(nuevoI, nuevoJ);
                break;
            case "DERECHA":
                nuevoJ = j + 1;
                nuevoSemillasMundo = calcSemillasMundo(nuevoI, nuevoJ);
                nuevoSemillasGoku = calcSemillasGoku(nuevoI, nuevoJ);
                nuevoEsferas = calcEsferas(nuevoI, nuevoJ);
                nuevoCosto = calcCosto(nuevoI, nuevoJ);
                break;
            default:
                break;
        }

        int[][] nuevoEstadoMundo = estadoMundo.clone();
        nuevoEstadoMundo[i][j] = 0;

        nuevoEstadoMundo[nuevoI][nuevoJ] = 1;

        nuevoNodo = new Nodo2(
            nuevoEstadoMundo, nuevoI, nuevoJ, nuevoSemillasMundo, nuevoSemillasGoku,
            nuevoEsferas, this, operadorAplicar, level + 1, nuevoCosto
        );

        return nuevoNodo;
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
     * @return semillas del mundo al moverse a i,j
     */
    private int calcSemillasMundo(int i, int j){

        switch (estadoMundo[i][j]) {
            case 5:
                return semillasMundo - 1;
            default:
                return semillasMundo;
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
                return semillasGoku - 1;
            case 4:
                return semillasGoku - 1;
            case 5:
                return semillasGoku + 1;
            default:
                return semillasGoku;
        }
    }

    /**
     * @param i
     * @param j
     * @return esferas al moverse a i,j
     */
    private int calcEsferas(int i, int j){

        switch (estadoMundo[i][j]) {
            case 6:
                return esferas - 1;
            default:
                return esferas;
        }
    }

    /**
     * @return cantidad de semillas en el mundo en este nodo (usado en nodo inicial)
     */
    private int contarSemillasMundo() {
        
        int cantidad = 0;
        for (int i = 0; i < estadoMundo.length; i++) {
            for (int j = 0; j < estadoMundo[0].length; j++) {
                if (estadoMundo[i][j] == 2) {
                    cantidad++;
                }
            }
        }

        return cantidad;
    }
}
