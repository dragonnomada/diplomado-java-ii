# Sesión 1.B - Pseudocódigos y Algoritmos de Búsqueda y Ordenamiento

![Logo CIC](./figuras/logo.png)

    Diplomado de Java - Módulo I
    Departamento de Diplomados y Extensión Profesional
    Centro de Investigación en Cómputo
    Instituto Politécnico Nacional

---

[![Alan Badillo Salas](https://avatars.githubusercontent.com/u/79223578?s=40&v=4 "Alan Badillo Salas")](https://github.com/dragonnomada) Por [Alan Badillo Salas](https://github.com/dragonnomada)

---

## Introducción

En esta sesión revisaremos el uso de **pseudocódigos** para modelar soluciones a algoritmos que sean más fáciles de implementar.

También revisaremos los principales algoritmos de *búsqueda* y *ordenamiento*.

Usaremos [PSeInt](http://pseint.sourceforge.net) para poder implementar de forma real los pseudocódigos y generar sus respectivos diagramas de flujo.

En esta sesión se definirán las Prácticas 1 y 2, basadas en los algoritmos de ordenamiento por mezcla y el ordenamiento rápido, respectivamente.

Puedes consultar las prácticas en la siguiente tabla.

Práctica | Tipo de Práctica | Fecha Límite de Entrega
--- | --- | ---
[Práctica 1](../practicas/pactica1.md) | En Equipo (1~3) | 25 de abril de 2022
[Práctica 2](../practicas/pactica2.md) | En Equipo (1~3) | 25 de abril de 2022

## Pesudocódigos

Hasta ahora hemos descrito algoritmos en forma de texto. Pero definamos algunos operadores comúnes para formar una sintaxis más precisa.

Los **pseudocódigos** nos permiten difinir algoritmos en  texto de una manera más formal. Se basa en definir un conjunto de palabras clave usadas para explicar en una forma más técnica los algoritmos. Sus principales ventajas son la aplicación casi directa a un lenguaje de programación. Por lo tanto, estos podrían variar de acuerdo al lenguaje de programación objetivo.

> Tabla de principales palabras reservadas en un Pseudocódigo

Palabra | Significado
--- | ---
`DEFINIR` | Se refiere a la declaración de una variable.
`COMO` | Especifíca el tipo de dato que se usará en una variable.
`DIMENSIÓN` | Especifíca la dimensión de una variable en caso de usarse como lista.
`SI` | Se refiere a una condición que podría seguir, como una comparación o un valor lógico (*predicado*) puesto como condición.
`ENTONCES` | Se refiere a las instrucciones anidadas en caso que la condición o ciclo se satisfaga.
`PARA` | Se refiere al proceso de repetir una serie de pasos descritos.
`MIENTRAS` | Se refiere al proceso de repetir una serie de pasos mientras una condición se cumpla.
`LEE` | Se refiere a la capacidad de leer el valor desde el usuario (generalmente el teclado).
`IMPRIMIR` | Se refiere a imprimir en pantalla el valor o texto descritos.
`ROMPE` | Se refiere a la capacidad de romper el ciclo inmediato anterior.
`CONTINÚA` | Se refiere a la capacidad de detener los siguientes pasos y volver a evaluar la condición o iteración del ciclo inmediato.
`DETENER` | Se refiere a la capacidad de detener el algoritmo y producir una salida.
`IR A` | Se refiere a la capacidad de detener los siguientes pasos y volver a evaluar los pasos desde el marcador anterior.
`<-` | También conocido como `ASIGNA`, permite asignar un valor o resultado a una variable.
`EVALUA` | Se refiere a la capacidad de llamar a un sub-algoritmo y devolver el resultado de su ejecución.
`SELECCIONA` | Se refiere a acceder a un elemento de una lista, se suele usar `[i]` para extraer el valor en un índice.

* **Nota:** Generalmente el `IR A` no está implementado en lenguajes modernos.

Veamos algunos ejemplos.

> Sumar dos números enteros

    DEFINIR a COMO entero;
	DEFINIR b COMO entero;
	DEFINIR c COMO entero;
	
	IMPRIMIR "Dame A:";
	LEER a;
	
	IMPRIMIR "Dame B:";
	LEER b;
	
	c <- a + b;
	
	IMPRIMIR "C = " c;

> Sumar los números de una lista de enteros

    DEFINIR lista COMO entero;
	DIMENSION lista[5];
	
	lista[0] <- 2;
	lista[1] <- 6;
	lista[2] <- 5;
	lista[3] <- 3;
	lista[4] <- 1;

    DEFINIR suma COMO entero;
	
	suma <- 0;
	
	DEFINIR i COMO entero;
	
	PARA i <- 0 HASTA 4 CON PASO 1 ENTONCES
		suma <- suma + lista[i];
	FIN PARA
	
	IMPRIMIR "La suma es: " suma;

### Ejercicio 2.1

* Crea un pseudocódigo que lea el radio de un círculo y determine su perímetro.
* Crea un pseudocódigo que lea el radio de un círculo y determine su área.
* Crea un pseudocódigo que lea la temperatura en grados Centígrados y calcular la temperatura en grados Farenheit.

## Estructuras Condicionales

La estructura condicional sirve para determinar si una serie de pasos serán realizados basados en una condición.

    SINTAXIS: 
    
    SI <condición> ENTONCES
        ...
    FIN SI

Para construir condiciones podemos realizar comparaciones lógicas, como igualdades o desigualdades, determinar si es mayor, mayor o igual, menor o menor o igual. También podemos unir varios predicados lógicos con conjunciones (`Y`), disyunciones (`O`) o negaciones (`NO`). En la siguiente tabla se resumen algunos símbolos usados.

Operador | Significado
--- | ---
`=` | Determina si dos valores son iguales
`<>` | Determina si dos valores son distintos
`>` | Determina si una valor es mayor estricto
`>=` | Determina si una valor es mayor o igual
`<` | Determina si una valor es menor estricto
`<=` | Determina si una valor es menor o igual
`Y` | Determina si dos predicados son verdaderos
`O` | Determina si algún predicado es verdadero
`NO` | Determina si algún predicado no es verdadero

Veamos algunos ejemplos.

> Determinar si es mayor de edad

    DEFINIR edad COMO entero;
	
	IMPRIMIR "Dame la edad:";
    LEER edad;
	
    SI edad >= 18 ENTONCES
        IMPRIMIR "Es mayor de edad";
	SINO
		IMPRIMIR "No es mayor de edad";
    FIN SI

> Determinar si `x` está en el intervalo de `[1, 5) o de (10, 15]`

    DEFINIR x COMO real;

    IMPRIMIR "Dame un número:";
    LEER x;

    SI (x >= 1 Y x < 5) O (x > 10 Y x <= 15) ENTONCES
        IMPRIMIR "Está en el intervalo";
    SINO
        IMPRIMIR "No está en el intervalo";
    FIN SI

### Ejercicio 2.2

* Solicitar el peso y determinar si es mayor a `80`.
* Solicitar la temperatura y determinar si está entre `15` y `23` o entre `30` y `34`.
* Solicitar dos números e imprimir el mayor.

## Iteradores

El iterador es una estructura que permite repetir una serie de pasos determinados por un valor llamado el iterando. Al cual se le determinará un valor inicial y un valor final, así como los incrementos que tendrá en cada iteración.

    SINTAXIS:

    PARA <iterando> <- <valor inicial> HASTA <valor final> CON PASO <valor incremento> HACER
        ...
    FIN PARA

Los iteradores son útiles para recorrer listas o hacer cálculos determinísticos. Veamos algunos ejemplos.

> Sumar los primeros `N` números enteros

    DEFINIR N COMO entero;

    IMPRIMIR "Dame N:";
    LEER N;

    DEFINIR suma COMO entero;

    suma <- 0;

    DEFINIR n COMO entero;

    PARA n <- 1 HASTA N CON PASO 1 HACER
        suma <- suma + n;
    FIN PARA

> Calcular primeros `N` números de Fibonacci

    DEFINIR N COMO entero;

    IMPRIMIR "Dame N:";
    LEER N;

    DEFINIR a COMO entero;
    DEFINIR b COMO entero;
    DEFINIR c COMO entero;

    a <- 1;
    b <- 1;

    IMPRIMIR a;
    IMPRIMIR b;

    DEFINIR i COMO entero;

    PARA i <- 3 HASTA N CON PASO 1 HACER
        c <- a + b;
        a <- b;
        b <- c;
        IMPRIMIR c;
    FIN PARA

### Ejercicio 2.3

* Calcular la suma de los cuadrados `1` y `100`.
* Calcular la suma de los números pares entre `1` y `100`.
* Leer una lista de tamaño `10` e imprimirla al revés.
* Calcular la suma de los números pares en una lista de tamaño `N` (leer los valores).

## Ciclos Condicionales

El ciclo condicional o estructura *MIENTRAS*, permite repetir una serie de pasos mientras una condición se cumpla. Estos ciclos son útiles cúando no estamos seguros de cuántas iteraciones deberían ocurrir, sino que basamos su repetición hasta que la condición ya no se satisfaga.

    SINTAXIS:

    MIENTRAS <condición> HACER
        ...
    FINMIENTRAS

Algunas veces necesitaremos varias condiciones enlazadas para determinar si la condición aún se cumple y necesitaremos garantizar que la primer condición se cumpla.

También podrían ocurrir indeterminaciones, por ejemplo, si olvidamos incrementar algún contador o actualizar la condición.

Veamos algunos ejemplos.

> Leer un número mientras no sea positivo estricto

    DEFINIR x COMO entero;

    x <- 0;

    MIENTRAS x <= 0 Hacer
        IMPRIMIR "Dame un número positivo estricto:";
        LEER x;
    FINMIENTRAS

> Sumar los múltiplos de `3` mientras su suma sea menor a `500`

    DEFINIR n COMO entero;

    n <- 3;

    DEFINIR suma COMO entero;

    suma <- 0

    MIENTRAS suma < 500 HACER
        suma <- suma + n;
        n <- n * 3
    FINMIENTRAS

    IMPRIMIR "Último múltiplo: " n;
    IMPRIMIR "La suma es: " suma;

### Ejercicio 2.4

* Lee una lista de tamaño `N` dada por el usuario y suma los elementos mientras la suma sea menor `50` o ya no hayan más elementos en la lista. Imprime cuántos elementos fueron sumados.
* Calcula cuántos múltiplos de `2` caben en `81`.

## Búsqueda del Menor

Para encontrar el menor elemento en una lista de números, deberemos recorrer cada elemento y guardar el menor de ellos. Generalmente se supone que el menor elemento es el primero.

    ALGORITMO: Buscar el menor elemento en una lista de números

    ENTRADA:
    - La lista de elmentos (`lista_entrada`)

    SALIDA:
    - El menor elemento

    PROCEDIMIENTO:
    1. INICIO
    2. N <- TAMAÑO lista_entrada
    3. menor <- lista_entrada[0]
    4. PARA i <- 0 HASTA N - 1 CON PASO 1 HACER
        4.1 SI lista_entrada[i] < menor ENTONCES
            4.1.1 menor <- lista_entrada[i]
    5. IMPRIMIR menor
    6. FIN

### Ejercicio 2.5

* Genera el pseudocódigo del algoritmo de búsqueda.
* Genera el diagrama de flujo del algoritmo de búsqueda.
* Adapta el algoritmo para imprimir también el índice del número menor (`indice_menor`).

## Búsqueda de los Extremos

Podemos determinar el menor y el mayor haciendo un ordenamiento previo de la lista y consultando el primer elemento de la lista ordenada (`menor`) y el último elemento de la lista ordenada (`mayor`).

    ALGORITMO: Buscar los extremos de una lista de números

    ENTRADA:
    - La lista de elmentos (`lista_entrada`)

    SALIDA:
    - El menor y mayor elemento

    PROCEDIMIENTO:
    1. INICIO
    2. N <- TAMAÑO lista_entrada
    3. [ORDENA LA LISTA DE FORMA ASCENDENTE]
    4. menor <- lista_ordenada[0]
    5. mayor <- lista_ordenada[N - 1]
    6. IMPRIMIR "Menor: " menor;
    7. IMPRIMIR "Mayor: " mayor;
    8. FIN

### Ejercicio 2.6

* Determina el algoritmo para ordenar una lista de forma ascendente buscando el menor. Deberás reemplazar a la izquierda los elementos a partir del índice menor hasta el final menos uno y determinar que el nuevo valor de la lista disminuye en uno.
* Genera el pseudocódigo del algoritmo de búsqueda de extremos.
* Genera el diagrama de flujo del algoritmo de búsqueda de extremos.
* Adapta el algoritmo para que sea descendente.

## Búsqueda de los `K` Menores

En una lista ordenada podemos calcular copiar a otra lista de tamaño `K` los primeros elementos de la lista ordenada, para tener los `K` valores menores de la lista. Esto es útil cuándo queremos saber el `Top K` inferior de la lista.

    ALGORITMO: Buscar los `K` Menores de una lista de números

    ENTRADA:
    - La lista de elmentos (`lista_entrada`)

    SALIDA:
    - La lista de los `K` elementos menores

    PROCEDIMIENTO:
    1. INICIO
    2. N <- TAMAÑO lista_entrada
    3. [ORDENA LA LISTA DE FORMA ASCENDENTE]
    4. DEFINIR lista_k_menores DE DIMENSIÓN K
    5. PARA i <- 0 HASTA K CON PASO 1 HACER
        5.1 lista_k_menores[i] <- lista_ordenada[i]
    6. PARA i <- 0 HASTA K CON PASO 1 HACER
        6.1 IMPRIMIR "Menor " i ": " lista_k_menores[i];
    7. FIN

### Ejercicio 2.7

* Genera el pseudocódigo del algoritmo de los `K-Menores`.
* Genera el diagrama de flujo del algoritmo de los `K-Menores`.
* Calcula la suma de los `K-Menores` en la lista.

## Búsqueda de los `K` Extremos

Una variante del algoritmo de búsqueda de los `K-Menores` es el de los `K-Extremos`, el cuál nos dará la lista de los `K` elementos menores y los `K` elementos mayores. Esta es útil para descartar los valores centrales y enfocarnos en los extremos. Por ejemplo, para determinar la asíntota inferior de los datos, en el caso que los extremos tiendan a cero.

    ALGORITMO: Buscar los `K` Extremos de una lista de números

    ENTRADA:
    - La lista de elmentos (`lista_entrada`)

    SALIDA:
    - La lista de los `K` elementos menores y los `K` elementos mayores

    PROCEDIMIENTO:
    1. INICIO
    2. N <- TAMAÑO lista_entrada
    3. [ORDENA LA LISTA DE FORMA ASCENDENTE]
    4. DEFINIR lista_k_menores DE DIMENSIÓN K
    4. DEFINIR lista_k_mayores DE DIMENSIÓN K
    5. PARA i <- 0 HASTA K CON PASO 1 HACER
        5.1 lista_k_menores[i] <- lista_ordenada[i]
        5.1 lista_k_mayores[i] <- lista_ordenada[N - 1 - K + i]
    6. PARA i <- 0 HASTA K CON PASO 1 HACER
        6.1 IMPRIMIR "Menor " i ": " lista_k_menores[i];
        6.1 IMPRIMIR "Mayor " i ": " lista_k_mayores[i];
    7. FIN

### Ejercicio 2.8

* Genera el pseudocódigo del algoritmo de los `K-Extremos`.
* Genera el diagrama de flujo del algoritmo de los `K-Extremos`.
* Calcula el promedio de los `K-Menores` en la lista.
* Calcula el promedio de los `K-Mayores` en la lista.
* Calcula el promedio de los `K-Menores` y los `K-Mayores` en la lista.
    - ¿Qué representa este promedio?

## Búsqueda de los `K` Centrales

La búsqueda de los `K-Centrales` es un algoritmo que nos permitirá obtener la lista los `K` valores al centro ideal de la lista. Deberemos calcular el índice central (`p`) y con este calcular el índice de límite inferior (`p - K / 2`) y el índice de límite superior (`p + K / 2`). Se recomienda considerar el caso en que la lista sea impar, en el que la lista sea par, en el que `K` sea impar y en el que `K` sea par.

    [CASO 1]

    ENTRADA: 
        [1 2 3 4 5 6 7 8 9 10] 
        K <- 2

    SALIDA:
        [5 6]
        IZQUIERDA <- 4
        DERECHA <- 4

    [CASO 2]

    ENTRADA: 
        [1 2 3 4 5 6 7 8 9 10] 
        K <- 3

    SALIDA:
        [4 5 6]
        IZQUIERDA <- 3
        DERECHA <- 4
    
    [CASO 3]

    ENTRADA: 
        [1 2 3 4 5 6 7 8 9 10 11] 
        K <- 2

    SALIDA:
        [5 6]
        IZQUIERDA <- 4
        DERECHA <- 5
    
    [CASO 4]

    ENTRADA: 
        [1 2 3 4 5 6 7 8 9 10 11] 
        K <- 3

    SALIDA:
        [5 6 7]
        IZQUIERDA <- 4
        DERECHA <- 4

### Ejercicio 2.9

* Genera el algoritmo de los `K-Centrales`.
* Genera el pseudocódigo del algoritmo de los `K-Centrales`.
* Genera el diagrama de flujo del algoritmo de los `K-Centrales`.
* Adapta el algoritmo para que `K` se calcule automáticamente dejando `L` valores a la izquierda y `L` valores a la derecha siempre.

## Búsqueda de los Consecutivos

El algoritmo para buscar números consecutivos es útil en algunas áreas como la genética para encontrar marcadores. El algoritmo consiste en imprimir índices inicial y final de números consecutivos (al menos dos) encontrados en una lista desordenada. 

    [CASO 1]

    ENTRADA:
        [1 2 4 3 5 6 7 3 2 2 1 3 4 6 7]

    SALIDA:
        0 >> 1
        4 >> 6
        11 >> 12
        13 >> 14
    
    [CASO 2]
        
    ENTRADA:
        [1 2 3 4 1 2 3 4 5 7 8 9 2 3 1 2 3]

    SALIDA:
        0 >> 3
        4 >> 11
        14 >> 16

### Ejercicio 2.10

* Genera el algoritmo de los `Consecutivos`.
* Genera el pseudocódigo del algoritmo de los `Consecutivos`.
* Genera el diagrama de flujo del algoritmo de los `Consecutivos`.
* Adapta el algoritmo para reportar en la salida el tamaño de cada consecutivo (`INICIAL >> FINAL (TAMAÑO)`).

## Ordenamiento de Bubuja

El algoritmo burbuja consiste en suponer que los valores dentro de una lista de números son atrapados mediante una burbuja, la cuál subirá cada iteración dejando en cada iteración la burbuja más grande al final de la lista.

El algoritmo recorre en cada iteración cada pareja de números de índices consecutivos, entonces determina intercambiarlos, si el valor siguiente es menor al actual.

    # ORDENAMIENTO BURBUJA

    DEFINIR N COMO ENTERO;
    
    IMPRIMIR "Dame el tamaño de la lista a ordenar:";
    LEER N;

    DEFINIR lista COMO ENTERO;
    DIMENSION lista[N];

    DEFINIR i COMO ENTERO;

    // Capturamos el valor de cada posición en la lista
    PARA i <- 0 HASTA N - 1 CON PASO 1 HACER
        IMPRIMIR "Dame el valor de la lista en la posición " i ":";
        LEER lista[i];
    FIN PARA

    // COMIENZA ORDENAMIENTO BURBUJA

    DEFINIR burbuja_actual COMO ENTERO;
    DEFINIR burbuja_siguiente COMO ENTERO;

    DEFINIR j COMO ENTERO;

    // Iteramos N veces, en cada una aseguramos la burbuja más grande al final
    PARA i <- 0 HASTA N - 1 CON PASO 1 HACER

        // Recorremos cada pareja (actual y siguiente)
        // desde `0` hasta `N - 2` (las parejas serán [0, 1], [1, 2], ..., [N-2, N-1])
        PARA j <- 0 HASTA N - 2 CON PASO 1 HACER

            // Recuperamos el valor de la burbuja actual y la siguiente
            burbuja_actual = lista[j];
            burbuja_siguiente = lista[j + 1];
        
            // Comprobamos si la burbuja actual es mayor a la siguiente
            SI burbuja_actual > burbuja_siguiente ENTONCES
                // Intercambiamos las burbujas en la lista
                lista[j] = burbuja_siguiente;
                lista[j + 1] = burbuja_actual;
            FIN SI

        FIN PARA

    FIN PARA

    // Imprimimos la lista, ahora ordenada
    PARA i <- 0 HASTA N - 1 CON PASO 1 HACER

        IMPRIMIR lista[i];

    FIN PARA

### Ejercicio 2.11

* Modifica el pseudocódigo para imprimir una tabla como la siguiente para anotar los valores de `i`, `j`, `burbuja_actual` (`ba`), `j + 1`, `burbuja_siguiente` (`bs`), si ocurre el intercambio (`<>`) y la lista al final de la iteración `j`. Llena los valores del resultado de ordenar la lista `[3 2 1 6 5 4 3]`.

> Ejemplo de la tabla al ordenar la lista `[2 1 4 3 5 2]`

`i` | `j` | `ba` | `j + 1` | `bs` | `<>` | `lista`
--- | --- | --- | --- | --- | --- | ---
0 | 0 | **2** | 1 | **1** | SI | `[1 2 4 3 5 2]`
0 | 1 | **2** | 2 | **4** | NO | `[1 2 4 3 5 2]`
0 | 2 | **4** | 3 | **3** | SI | `[1 2 3 4 5 2]`
0 | 3 | **4** | 4 | **5** | NO | `[1 2 3 4 5 2]`
0 | 4 | **5** | 5 | **2** | SI | `[1 2 3 4 2 5]`
`-` | `-` | `-` | `-` | `-` | `-` | `-` 
1 | 0 | **1** | 1 | **2** | NO | `[1 2 3 4 2 5]`
1 | 1 | **2** | 2 | **3** | NO | `[1 2 3 4 2 5]`
1 | 2 | **3** | 3 | **4** | NO | `[1 2 3 4 2 5]`
1 | 3 | **4** | 4 | **2** | SI | `[1 2 3 2 4 5]`
1 | 4 | **4** | 5 | **5** | NO | `[1 2 3 2 4 5]`
`-` | `-` | `-` | `-` | `-` | `-` | `-` 
2 | 0 | **1** | 1 | **2** | NO | `[1 2 3 2 4 5]`
2 | 1 | **2** | 2 | **3** | NO | `[1 2 3 2 4 5]`
2 | 2 | **3** | 3 | **2** | SI | `[1 2 2 3 4 5]`
2 | 3 | **3** | 4 | **4** | NO | `[1 2 2 3 4 5]`
2 | 4 | **4** | 5 | **5** | NO | `[1 2 2 3 4 5]`
`-` | `-` | `-` | `-` | `-` | `-` | `-` 
3 | 0 | **1** | 1 | **2** | NO | `[1 2 3 2 4 5]`
3 | 1 | **2** | 2 | **2** | NO | `[1 2 3 2 4 5]`
3 | 2 | **2** | 3 | **3** | NO | `[1 2 2 3 4 5]`
3 | 3 | **3** | 4 | **4** | NO | `[1 2 2 3 4 5]`
3 | 4 | **4** | 5 | **5** | NO | `[1 2 2 3 4 5]`
`-` | `-` | `-` | `-` | `-` | `-` | `-` 
4 | 0 | **1** | 1 | **2** | NO | `[1 2 3 2 4 5]`
4 | 1 | **2** | 2 | **2** | NO | `[1 2 3 2 4 5]`
4 | 2 | **2** | 3 | **3** | NO | `[1 2 2 3 4 5]`
4 | 3 | **3** | 4 | **4** | NO | `[1 2 2 3 4 5]`
4 | 4 | **4** | 5 | **5** | NO | `[1 2 2 3 4 5]`
`-` | `-` | `-` | `-` | `-` | `-` | `-` 
5 | 0 | **1** | 1 | **2** | NO | `[1 2 3 2 4 5]`
5 | 1 | **2** | 2 | **2** | NO | `[1 2 3 2 4 5]`
5 | 2 | **2** | 3 | **3** | NO | `[1 2 2 3 4 5]`
5 | 3 | **3** | 4 | **4** | NO | `[1 2 2 3 4 5]`
5 | 4 | **4** | 5 | **5** | NO | `[1 2 2 3 4 5]`


## Ordenamiento de Insersión

El método de ordenamiento por inserción consiste en recorrer cada elemento y preguntar si hay un elemento mayor que él detrás, para insertarlo después del que ya no sea mayor.

    # ORDENAMIENTO POR INSERCIÓN

    DEFINIR N COMO ENTERO;
    
    IMPRIMIR "Dame el tamaño de la lista a ordenar:";
    LEER N;
	
    DEFINIR lista COMO ENTERO;
    DIMENSION lista[N];
	
    DEFINIR i COMO ENTERO;
	
    // Capturamos el valor de cada posición en la lista
    PARA i <- 0 HASTA N - 1 CON PASO 1 HACER
        IMPRIMIR "Dame el valor de la lista en la posición " i ":";
        LEER lista[i];
    FIN PARA
	
    // COMIENZA ORDENAMIENTO POR INSERCIÓN
	
    DEFINIR valor COMO ENTERO;
    DEFINIR posicion COMO ENTERO;
	
    DEFINIR j COMO ENTERO;
    DEFINIR k COMO ENTERO;
	
    // Recorremos cada índice en la lista
    PARA i <- 0 HASTA N - 1 CON PASO 1 HACER
		
        // Buscamos la posición dónde insertar el valor del `i-ésimo` elemento
        valor <- lista[i];
        posicion <- i;
		
        // Comenzamos a buscar un valor mayor a nuestro valor actual
        PARA j <- 0 HASTA i - 1 CON PASO 1 HACER
			
            // Si hay un valor anterior más grande y no es el primero encontrado, entonces
            SI lista[j] >= valor Y posicion > j ENTONCES
                // actualizamos la posición donde se debería insertar
                posicion <- j;
            FIN SI
			
        FIN PARA
		
        // Recorremos los elementos a la derecha, desde nuestra posición actual,
        // hasta la posición donde se debería insertar
        PARA k <- i HASTA posicion + 1 CON PASO -1 HACER
            // Recorremos el valor a la derecha
            lista[k] = lista[k - 1];
        FIN PARA
		
        // Insertamos el valor actual en la posición que le corresponde
        lista[posicion] = valor;
		
    FIN PARA
	
	// Imprimimos la lista, ahora ordenada
    PARA i <- 0 HASTA N - 1 CON PASO 1 HACER
        IMPRIMIR lista[i];
    FIN PARA

### Ejercicio 2.12

* Modifica el pseudocódigo para imprimir la lista antes de recorrer los elementos a la derecha y después de hacerlo.

> Ejemplo de la tabla del cambio de listas antes de recorrer a la derecha, para la la lista `[2 1 4 3 5 2]`

`i` | Lista Actual | Lista Siguiente
--- | --- | ---
0 | `[2 1 4 3 5 2]` | `[1 2 4 3 5 2]`
1 | `[1 2 4 3 5 2]` | `[1 2 4 3 5 2]`
2 | `[1 2 4 3 5 2]` | `[1 2 3 4 5 2]`
3 | `[1 2 3 4 5 2]` | `[1 2 3 4 5 2]`
4 | `[1 2 3 4 5 2]` | `[1 2 3 4 5 2]`
5 | `[1 2 3 4 5 2]` | `[1 2 2 3 4 5]`

## Ordenamiento de Mezcla (*Mergesort*)

El algoritmo de mezcla consiste en separar los valores en dos sublistas, izquierda y derecha, las cuales se ordenarán recursivamente, para después mezclarlas de forma ordenada.

Este algoritmo al ser recursivo requiere de dos piezas. La primera es un subproceso proceso que ordene una lista del índice `l` al índice `r`. Y otro subproceso que mezcle los valores desde `l` hasta `r` separados por `m`.

    # ORDENAMIENTO POR MEZCLA

    SUBPROCESO Mezclar (lista_entrada, l, m, r)
	
        IMPRIMIR "MEZCLAR (" l " " m " " r ")";
        
        DEFINIR Nl COMO ENTERO;
        DEFINIR Nr COMO ENTERO;
        
        Nl <- m - l;
        Nr <- r - m + 1;
        
        IMPRIMIR Nl " " Nr;
        
        DEFINIR Ml COMO ENTERO;
        DEFINIR Mr COMO ENTERO;
        
        Ml <- Nl;
        Mr <- Nr;
        
        SI Ml <= 0 ENTONCES
            Ml <- 1;
        FIN SI
        
        SI Mr <= 0 ENTONCES
            Mr <- 1;
        FIN SI
        
        DEFINIR lista_izquierda COMO ENTERO;
        DIMENSION lista_izquierda[Ml];
        
        DEFINIR lista_derecha COMO ENTERO;
        DIMENSION lista_derecha[Mr];
        
        DEFINIR i COMO ENTERO;
        DEFINIR j COMO ENTERO;
        
        PARA i <- 0 HASTA Nl - 1 CON PASO 1 HACER
            lista_izquierda[i] <- lista_entrada[l + i];
        FIN PARA
        
        PARA j <- 0 HASTA Nr - 1 CON PASO 1 HACER
            lista_derecha[j] <- lista_entrada[m + j];
        FIN PARA
        
        DEFINIR k COMO ENTERO;
        
        i <- 0;
        j <- 0;
        k <- l;
        
        MIENTRAS i < Nl Y j < Nr Y k <= r HACER
            SI lista_izquierda[i] <= lista_derecha[j] ENTONCES
                lista_entrada[k] = lista_izquierda[i];
                i <- i + 1;
            SINO
                lista_entrada[k] = lista_derecha[j];
                j <- j + 1;
            FIN SI
            k <- k + 1;
        FIN MIENTRAS
        
        MIENTRAS i < Nl Y k <= r HACER
            lista_entrada[k] = lista_izquierda[i];
            i <- i + 1;
            k <- k + 1;
        FIN MIENTRAS
        
        MIENTRAS j < Nr Y k <= r HACER
            lista_entrada[k] = lista_derecha[j];
            j <- j + 1;
            k <- k + 1;
        FIN MIENTRAS
        
    FIN SUBPROCESO

    SUBPROCESO Ordenar ( lista_entrada, l, r )
        
        SI l < r ENTONCES
            
            // Buscamos el índice central m
            DEFINIR m COMO ENTERO;
            
            m <- Redon( (l + r + 1) / 2 );
            
            Imprimir "L: " l " M: " m " R: " r; 
            
            Ordenar(lista_entrada, l, m - 1);
            
            Ordenar(lista_entrada, m, r);
            
            Mezclar(lista_entrada, l, m, r);
            
        FIN SI
        
    FIN SUBPROCESO

    DEFINIR N COMO ENTERO;
    
    IMPRIMIR "Dame el tamaño de la lista a ordenar:";
    LEER N;
	
    DEFINIR lista COMO ENTERO;
    DIMENSION lista[N];
	
    DEFINIR i COMO ENTERO;
	
    // Capturamos el valor de cada posición en la lista
    PARA i <- 0 HASTA N - 1 CON PASO 1 HACER
		
        IMPRIMIR "Dame el valor de la lista en la posición " i ":";
        LEER lista[i];
		
    FIN PARA
	
    // COMIENZA ORDENAMIENTO POR MEZCLA

    Ordenar(lista, 0, N - 1);
	
	// Imprimimos la lista, ahora ordenada
    PARA i <- 0 HASTA N - 1 CON PASO 1 HACER
        IMPRIMIR lista[i];
    FIN PARA

### Ejercicio 2.13

* Resuelve la [Práctica 1](../practicas/pactica1.md)

## Ordenamiento Rápido (*Quicksort*)

El método de ordenamiento rápido es uno de los más populares, debido a que en algunos casos se llega a comportar con orden menor que los otros.

El ordenamiento consiste en ubicar un pivote (por ejemplo, el último valor de la sublista a ordenar). Luego se intercambiarán todos los elementos respecto a ese pivote. Para al final tener una lista ordenada.

Al igual que el algoritmo de la mezcla, este funciona recursivamente.

    # ORDENAMIENTO RÁPIDO

    SUBPROCESO Intercambiar (lista_entrada, i, j)
        
        DEFINIR temporal COMO ENTERO;
        
        temporal <- lista_entrada[i];
        lista_entrada[i] <- lista_entrada[j];
        lista_entrada[j] <- temporal;
        
    FIN SUBPROCESO

    SUBPROCESO indice_menor <- Particion (lista_entrada, l, r)
        
        DEFINIR pivote COMO ENTERO;
        
        pivote <- lista_entrada[r];
        
        IMPRIMIR "Particion (" l " " pivote " " r ")";
        
        DEFINIR k COMO ENTERO;
        
        DEFINIR indice_menor COMO ENTERO;
        
        indice_menor <- l - 1;
        
        PARA k <- l HASTA r - 1 CON PASO 1 HACER
            SI lista_entrada[k] < pivote ENTONCES
                indice_menor <- indice_menor + 1;
                Intercambiar(lista_entrada, indice_menor, k);
            FIN SI
        FIN PARA
        
        indice_menor <- indice_menor + 1;
        
        Intercambiar(lista_entrada, indice_menor, r);
        
    FIN SUBPROCESO

    SUBPROCESO Ordenar (lista_entrada, l, r)
        
        SI l < r ENTONCES
            
            IMPRIMIR "ORDENAR (" l " " r ")"; 
            
            DEFINIR indice_particion COMO ENTERO;
            
            indice_particion <- Particion(lista_entrada, l, r);
            
            IMPRIMIR l " " indice_particion " " r; 
            
            Ordenar(lista_entrada, l, indice_particion - 1);
            Ordenar(lista_entrada, indice_particion + 1, r);
            
        FIN SI
        
    FIN SUBPROCESO
        
    DEFINIR N COMO ENTERO;
    
    IMPRIMIR "Dame el tamaño de la lista a ordenar:";
    LEER N;
    
    DEFINIR lista COMO ENTERO;
    DIMENSION lista[N];
    
    DEFINIR i COMO ENTERO;
    
    // Capturamos el valor de cada posición en la lista
    PARA i <- 0 HASTA N - 1 CON PASO 1 HACER
        
        IMPRIMIR "Dame el valor de la lista en la posición " i ":";
        LEER lista[i];
        
    FIN PARA
    
    Ordenar(lista, 0, N - 1);
    
    // Imprimimos la lista, ahora ordenada
    PARA i <- 0 HASTA N - 1 CON PASO 1 HACER
        IMPRIMIR lista[i];
    FIN PARA

### Ejercicio 2.14

* Resuelve la [Práctica 2](../practicas/pactica2.md)