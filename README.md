# GokuSmartIA

Primer proyecto del curso Inteligencia Artificial.

El objetivo de Goku es encontrar dos esferas del dragón en un espacio de 10x10
casillas, usando algoritmos de inteligencia artificial. En el ambiente hay casillas donde pueden haber
enemigos que afectan el bienestar de Goku, pero también se cuenta con semillas del ermitaño que lo
favorecen. Considere la siguiente abstracción del mundo representado por medio de una cuadrícula
de 10x10.

En cada búsqueda que emprenda, Goku podrá realizar desplazamientos simples tales como moverse
arriba, abajo, izquierda, y derecha. El costo de cada movimiento es de 1 a una casilla vacía. Si
Goku pasa por una casilla donde hay un freezer sin tener semilla del ermitaño el costo es 4. De este
valor, 3 unidades corresponden al daño que le ocasiona freezer y 1 unidad se debe al desplazamiento.
Si Goku tiene semilla y llega a una casilla con freezer el costo es 1, es decir, en este último caso el
enemigo no le haría ningún daño y solamente se tiene en cuenta el costo del desplazamiento. Si Goku
pasa por una casilla donde hay un cell sin tener semilla del ermitaño el costo total es 7 (6 unidades
por el daño causado por cell y 1 unidad por el desplazamiento), y si tiene semilla el costo es 1 que
corresponde al desplazamiento. Si Goku pasa por una casilla donde hay enemigo (cell o freezer) y no
tiene semilla, dicho enemigo seguirá existiendo en esa casilla. En caso de que sí tenga semilla, el
enemigo ya no aparecerá más en esa celda. Las semillas del ermitaño se pueden ir acumulando si se
toman varias durante el recorrido. Cuando se llega a una casilla donde está cell o freezer y Goku
tiene semilla, automáticamente la usará, es decir, no puede decidir si usa, o no, la semilla. La búsqueda
termina cuando Goku encuentre las dos esferas.

La información del mundo se representa como una matriz de 10x10 en la que en cada celda se tiene
uno de los siguientes números:

- 0 si es una casilla libre
- 1 si es un muro
- 2 si el punto donde inicia Goku
- 3 si es un freezer
- 4 si es un cell
- 5 si es una semilla del ermitaño
- 6 si es una esfera del dragón

## Ejecución del proyecto

1. Para cargar un nuevo archivo txt se debe ingresar a la clase llamada "Archivo" de la carpeta "Model", buscar la función "abrirArchivo" y en la siguiente línea reemplazar el nombre
BufferedReader lector = new BufferedReader(new FileReader("nombre.txt"))

Ejemplo
BufferedReader lector = new BufferedReader(new FileReader("Prueba1.txt")); 

Nota: El archivo txt debe estar en la misma carpeta del proyecto.

2. Ejecutar de nuevo el proyecto