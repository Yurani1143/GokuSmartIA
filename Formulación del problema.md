# Goku Smart

## Formulación del problema

- ### Estado
Un estado es una matríz de 10x10, donde cada posición puede tener un valor de 0 a 6, con
  - 0 si es una casilla libre
  - 1 si es un muro
  - 2 si el punto donde inicia Goku
  - 3 si es un freezer
  - 4 si es un cell
  - 5 si es una semilla del ermitaño
  - 6 si es una esfera del dragón

- ### Estado inicial
El estado inicial es la matríz que entra desde el archivo de texto.

- ### Operadores
Los operadores son las acciones que puede realizar Goku, que son:
  - Moverse arriba
  - Moverse abajo
  - Moverse a la izquierda
  - Moverse a la derecha

- ### Prueba de meta
La prueba de meta es una función que verifica si el estado actual es un estado meta, es decir, si Goku ha tomado dos esferas del dragón (no hay 6 en el estado actual).

- ### Costo de ruta
El costo es la suma de los costos de cada una de las acciones individuales a lo largo de una ruta.
En cada caso, el costo de una acción es:
  - 1 si es una casilla libre
  - 1 si es una semilla del ermitaño
  - 4 si es un freezer sin semilla
  - 1 si es un freezer con semilla
  - 7 si es un cell sin semilla
  - 1 si es un cell con semilla

- ### Heurística

La herística consiste en tomar la distancia euclideana entre Goku y la esfera del dragón más cercana.