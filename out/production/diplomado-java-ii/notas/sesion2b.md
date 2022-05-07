# Sesión 2.B - Java JDK: Instalación, Compilación y Ejecución

![Logo CIC](./figuras/logo.png)

    Diplomado de Java - Módulo I
    Departamento de Diplomados y Extensión Profesional
    Centro de Investigación en Cómputo
    Instituto Politécnico Nacional

---

[![Alan Badillo Salas](https://avatars.githubusercontent.com/u/79223578?s=40&v=4 "Alan Badillo Salas")](https://github.com/dragonnomada) Por [Alan Badillo Salas](https://github.com/dragonnomada)

---

## Introducción

En esta sesión aprenderemos a instalar, compilar y ejecutar archivos de Java. También veremos el `Classpath`, las variables y estructuras de control del lenguaje.

## Instalación de Java JDK

> Figura 4.1 - Página de descarga de Java

![Figura 4.1](./figuras/4.1.png)

[https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)

> Figura 4.2 - Instalación

    NOTA: Copiar la ruta donde será instalado el JDK

    >>> C:\Program Files\Java\jdk-17.0.2

![Figura 4.2](./figuras/4.2.png)

### Configuración de Java JDK

> Figura 4.3 - Ubicamos la carpeta del JDK

![Figura 4.3](./figuras/4.3.png)

> Figura 4.4 - Abrir la `Configuración Avanzada del Sistema`

![Figura 4.4](./figuras/4.4.png)

> Figura 4.5 - Abrir las `Variables de Entorno`

![Figura 4.5](./figuras/4.5.png)

> Figura 4.6 - Ajustar las `Variables del Sistema`

![Figura 4.6](./figuras/4.6.png)

> Figura 4.7 - Crear la variable `JAVA_HOME` con la ruta al JDK

![Figura 4.7](./figuras/4.7.png)

> Figura 4.8 - Eliminar de `Path` los `javapath`

    NOTA: Esto suprime la versión jre 1.8.X

    >>> Dejamos sólo el JDK

![Figura 4.8](./figuras/4.8.png)

> Figura 4.9 - Agregamos a `Path` el `%JAVA_HOME\bin%`

    NOTA: Esto activa el JDK

![Figura 4.9](./figuras/4.9.png)

### Verificación de Java JDK

> Figura 4.10 - Abrimos la configuración de Java

![Figura 4.10](./figuras/4.10.png)

> Figura 4.11 - Se muestra el Panel de Control de Java

![Figura 4.11](./figuras/4.11.png)

> Figura 4.12 - Opcionalmente podemos actualizar

    NOTA: Se puede desactivar la actualización

![Figura 4.12](./figuras/4.12.png)

> Figura 4.12b - Agregamos el JDK al Java Runtime Environment

![Figura 4.12b](./figuras/4.12b.png)

> Figura 4.13 - Verificamos `java -version`, `javac -version`, `jconsole`

![Figura 4.13](./figuras/4.13.png)

> Figura 4.14 - Revisamos la consola de monitoreo de la JVM

![Figura 4.14](./figuras/4.14.png)

## Compilación y Ejecución de Clases

Todas las clases de Java se pueden compilar, sin embargo sólo algunas serán ejecutables.

La siguiente lista numera algunas restricciones de Java.

* Las clases, interfaces o enumeraciones se tienen que llamar igual que el archivo.
* Por convención se utiliza la notación PascalCase, donde las clases, interfaces y enumeraciones se nombran con una Mayúscula inicial, seguido de minúsculas, y en cada cambio de palabra se alterna de minúsculas a Mayúsculas.
* Las clases tienen la posibilidad de ser ejecutables, es decir, que las ejecutemos como programas, si definimos un punto de entrada, dicho punto de entrada es un método de ejecución llamado `main` el cual debe ser público, estático, que no devuelva nada (`void`) y que reciba los argumentos pasados mediante un arreglo de textos (`String`). Es decir, `public static void main(String[] args) { ... }`.

### 1. Definir una clase que sea ejecutable (con punto de entrada/ejecución)

> Hola.java

```java
class Hola {
  
  public static void main(String[] args) {
    System.out.println("Hola Java :D");
  }

}
```

### 2. Compilar la clase `Hola.java` en el archivo `bytecode` `Hola.class`

    $ javac Hola.java

    --> Hola.class

### 3. Ejecutar el archivo `Hola.class` (sin la extensión)

    $ java Hola

    >>> Hola Java :D

### Notas

    TODO: Colocar cualquier expresión válida de Java
    - Definir variables
    - Instanciar objetos
    - Llamar a métodos estáticos
    - Llamar a métodos de los objetos
    - Leer datos de la entrada estándar (teclado)
    - Escribir datos a la salida estándar (consola)
    - Crear ventanas con Swing, Iniciar un Servidor, ...

    Podemos imprimir hacía la salida estándar
    mediante la clase `System`, el subpaquete `out`
    y los métodos `println`, `printf`, ...

## Tipos de Datos en Java

Existen dos tipos de datos principales en Java, los `datos primitivos` que se refiere a tipos básicos que no son objetos, y los `objetos` los cuáles provienen de clases estándar o generadas por el usuario.

> Tabla de Tipos de Datos Primitivos principales en Java

Tipo | Naturaleza | Ejemplo | Descripción
--- | --- | --- | ---
`int` | Entero | `123` | Retiene un número entero de `16/32 bits`
`float` | Decimal Corto | `123.456f` | Retiene un número con decimales cortos en `32 bits` (signo `1 bit`, exponente `8 bits` y `23 bits`).
`double` | Decimal Largo | `123.456...` | Retiene un número con decimales largos en `64bits`
`char` | Caracter | `'A', '\n', '\t'` | Retiene un caracter ascii (o utf-8) entrecomillado con comillas simples (`'`)
`byte` | Byte | `0x00`, `0xFF`, `0-255` | Retiene `8-bits` de información y es usado para transmisión de archivos, cifrado, manejo de imágnes, vídeos, audio, etc.
`boolean` | Booleano/Lógico | `true`, `false` | Retiene un dato verdadero o falso, se usa para crear banderas lógicas, determinar condiciones o estructurar predicados lógicos.

### Variables

Una variable es un almacén de datos, el cuál está asociado a un *tipo de dato* y Java reservará el espacio necesario para guardar y acceder los datos desde la memoria y hacía la memoria mediante un nombre especificado como *el nombre de la variable*. Es decir, podemos nombrar espacios de memoria para utilizarlos como valores dentro de nuestro programa.

Podemos construir variables bajo la siguiente sintaxis.

    SINTAXIS: <tipo de dato> <nombre de la variable>;

    ALTERNATIVA: <tipo de dato> <nombre de la variable> = <valor>;

    EJEMPLO:

        int a;

        char tabulado = '\t';

El `<tipo de dato>` puede ser primitivo o un objeto, y el nombre sigue la convención de nombrado `camelCase`, la cuál nos indica comenzar el nombre de la variable en minúsculas, y alternar a mayúsculas en cada cambio de palabra (ejemplo `edad`, `peso`, `nombrePersona`, `estaEnCirculo`).

Cuándo la variable no es asignada, se considera una `declaración`, es decir, el tener `int a;` significa `declara la variabla a de tipo entero`, sin embargo, tener `int a = 123;` significa `declara la variable a de tipo entero y asigna su valor a 123`. Las variables por defecto pueden reasignar su valor (`<nombre> = <valor>`) a menos que sean marcadas como inmutables mediante `const`.

> Ejemplo 2b.1 - Calcular el área de un círculo dado un radio

```java
double radio = 1.0;

double pi = 3.141592653;

double area = pi * radio * radio;

System.out.printf("El área del círculo de radio %.2f es %.2f\n", radio, area);
```

### Impresión con formato

El método `System.out.printf(...)` nos permite imprimir una plantilla (un texto llamado el formato), usando parámetros de reemplazo. Según el tipo de dato podremos imprimir los parámetros adecuados.

> Formatos para los tipos de datos principales

Formato | Tipo | Ejemplo | Descripción
--- | --- | --- | ---
`%d` | Entero | `"La edad es %d años", edad` | Reemplaza un entero en la posición del `%d`
`%f` | Decimales | `"El peso es %f kilogramos", pesos` | Reemplaza un decimal en la posición del `%f`
`%c` | Caracter | `"La tecla pulsada es: %c", tecla` | Reemplaza un caracter en la posición del `%c`
`%b` | Booleano | `"Activo: %b", activo` | Reemplaza un booleano en la posición del `%b` (en minúsculas `true`/`false`) 
`%B` | Booleano | `"Activo: %b", activo` | Reemplaza un booleano en la posición del `%B` (en minúsculas `TRUE`/`FALSE`) 
`%x` | Hexadecimal | `"Hexadecimal: %x", valor` | Imprime el valor en hexadecimal, ya sea entero o byte (minúsculas `0xff`)
`%X` | Hexadecimal | `"Hexadecimal: %X", valor` | Imprime el valor en hexadecimal, ya sea entero o byte (mayúsculas `0xFF`)
`%o` | Octal | `"Octal: %o", valor` | Imprime el valor en octal, ya sea entero o byte
`%s` | Texto | `"Tu nombre es %s", nombre` | Reemplaza un texto (`String` o `toString()`) en la posición del `%s`

Algunas variantes es definir la longitud máxima, por ejemplo `%5d` muestra sólo hasta 5 dígitos, `%10s` muestra sólo hasta 10 caracteres, `%.4f` muestra 4 decimales después del punto, `%5.3f` muestra hasta 5 dígitos y 3 decimales.

[REFERENCIAS]

* [https://www.javatpoint.com/java-string-format](https://www.javatpoint.com/java-string-format)

## Arreglos de Variables

Un arreglo de datos es similar a una variable que reserva la memoria necesaria para guardar tantos datos finitos como se necesites. Por ejemplo, si queremos almacenar `100` números, `50` textos, `200` caracteres, `2 millones` de bytes, etc. Los arreglos poseen un índice el cuál nos permitirá asignar y obtener los datos de una posición en particular, partiendo de cero. Por ejemplo, obtener del arreglo el valor en la `5ta` posición (índice 4), cambiar el valor del arreglo en la `12va` posición (índice 11), u obtener el valor de la `1ra` (índice 0).

Cualquier tipo de dato se puede volver un arreglo, es decir, un conjunto ordenado y finito de valores del mismo tipo de datos, mediante la sintaxis de los `[]`. Las posiciones para los valores dentro del arreglo comenzarán en 0.

    SINTAXIS: <tipo>[] <nombre> = new <tipo>[<tamaño>];

    EJEMPLO:

    double[] calificaciones = new double[30];

> Ejemplo 2b.2 - Generar una tabla con los valores de una parábola

```java
double[] x = new double[100];
double[] y = new double[100];

for (int i = 0; i < 100; i++) {
    x[i] = -10 + i * 0.2;
}

for (int j = 0; j < 100; j++) {
    y[j] = x[j] * x[j];
}

for (int k = 0; k < 100; k++) {
    System.out.printf("| %04.2f | %04.2f |\n", x[k], y[k]);
}
```

## Estructuras de Control

### Condicionales

Las condicionales `if` nos permiten evaluar un código, si la condición se cumple.

    SINTAXIS:

    # Forma Canónica

    if ( <condición> ) {
        <<código si se cumple la condición>>
    }

    # Forma Dual

    if ( <condición> ) {
        <<código si se cumple la condición>>
    } else {
        <<código si no se cumple la condición>>
    }

    # Forma Anidada

    if ( <condición 1> ) {
        <<código si se cumple la condición 1>>
    } else if ( <condición 2> ) {
        <<código si no se cumple la condición, 
            pero si se cumple la condición 2>>
    } if ( <condición N> ) {
        <<código si no se cumplen las condiciones anteriores,
            pero si se cumple la condición N>>
    } else {
        <<código si no se cumple ninguna condición anterior>>
    }

### Iteradores

Hay dos formas de crear iteradores, de la forma tradicional (`PARA <iterando> <- <valor inicial> HASTA <valor final> CON PASO <incremento> HACER`) o recorriendo cada elemento de una secuencia (lista, arreglo, iterable, etc).

    SINTAXIS:

    # Forma Canónica

    for (<tipo> <iterando> = <inicial>; <condición>; <incremento>) {
        <<código para cada iteración>>
    } 

    # Forma Para-Cada

    for (<tipo> <valor> : <iterable>) {
        <<código para cada elemento del iterable>>
    }

La diferencia entre los dos tipos de iteradores consiste en incrementar manualmente cada iteración (`<incremento>`) y determinar la condición de paro (`<condición>`) o recorrer cada elemento (`<valor>`) de un iterable (`<iterable>`). Si no deseamos saber el índice del elemento, la segunda forma podría ser más cómoda.

### Ciclos

Los ciclos nos permitirán repetir un bloque de código, mientras la condición se cumpla. En Java tenemos la variante `MIENTRAS` y `HACER-MIENTRAS`.

    SINTAXIS:

    # Forma Canónica

    while ( <condición> ) {
        <<código mientras se cumpla la condición>>
    }

    # Forma Hacer-Mientras

    do {
        <<código ejecutado la primera vez y mientras se cumpla la condición>>
    } while ( <condición> );

### Ejercicios

> Ejercicio 2b.E1 - Sumar dos números enteros

    DEFINIR a COMO entero;
    DEFINIR b COMO entero;
    DEFINIR c COMO entero;

    IMPRIMIR "Dame A:";
    LEER a;

    IMPRIMIR "Dame B:";
    LEER b;

    c <- a + b;

    IMPRIMIR "C = " c;

```java
// import java.util.Scanner;

int a;
int b;
int c;

Scanner sc = new Scanner(System.in);

System.out.printf("Dame A: ");
a = sc.nextInt();

System.out.printf("Dame B: ");
b = sc.nextInt();

c = a + b;

System.out.printf("C = %d\n", c);

sc.close();
```

> Ejercicio 2b.E2 - Sumar los números de una lista de enteros

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

> Ejercicio 2b.E3 - Determinar si `x` está en el intervalo de `[1, 5) o de (10, 15]`

    DEFINIR x COMO real;

    IMPRIMIR "Dame un número:";
    LEER x;

    SI (x >= 1 Y x < 5) O (x > 10 Y x <= 15) ENTONCES
        IMPRIMIR "Está en el intervalo";
    SINO
        IMPRIMIR "No está en el intervalo";
    FIN SI

> Ejercicio 2b.E4 - Calcular primeros `N` números de Fibonacci

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

> Ejercicio 2b.E5 - Sumar los múltiplos de `3` mientras su suma sea menor a `500`

    DEFINIR n COMO entero;

    n <- 3;

    DEFINIR suma COMO entero;

    suma <- 0

    MIENTRAS suma < 500 HACER
        suma <- suma + n;
        n <- n + 3
    FINMIENTRAS

    IMPRIMIR "Último múltiplo: " n;
    IMPRIMIR "La suma es: " suma;

## Listas Dinámicas (`List` y `ArrayList`)

Una limitación de los arreglos, es que al crearlos reservarán la memoria necesaria para el número de elementos que necesitamos almacenar. Sin embargo, si no estamos seguros cuántos elementos necesitamos, o no queremos reservar tanta memoria de golpe, podemos utilizar las listas dinámicas en lugar de los arreglos.

Una lista dinámica se puede generar mediante la clase `java.util.ArrayList`, la cual es una clase genérica, es decir, una clase asociada a un tipo de objeto genérico, lo cual nos pondrá algunas restricciones.

    SINTAXIS:

    // import java.util.ArrayList;

    ...
    
    ArrayList<T> <nombre> = new ArrayList<T>();

Como podemos observar el tipo `<T>` puede ser cualquier tipo de objeto, por lo que no podremos crear listas sobre tipos de datos primitivos. Es decir, tenemos la restricción de solo poder almacenar objetos de un tipo no primitivo (alguna clase estándar o definida por el usuario). Afortunadamente tenemos unas clases llamadas las clase de envoltura de los primitivos, que serán equivalentes con los primitivos, de hecho podremos hacer conversiones automáticas.

> Tabla de Clases Envolutura de Primitivos

Clase | Tipo Primitivo | Ejemplo
--- | --- | ---
`Integer` | `int` | `Integer edad = 123;`
`Float` | `float` |  `Float altura = 17.45f;`
`Double` | `double` | `Double peso = 123.456;`
`Boolean` | `boolean` | `Boolean activo = false;`
`String` | - | `String nombre = "Ana Ming";`

Entonces podemos generar listas que almacenen objetos en las posiciones correspondientes. Dada una lista dinámica, podemos acceder a los siguientes métodos de la lista.

> Tabla de Métodos Principales de `ArrayList`

    SUPONER LA LISTA: ArrayList<Persona> personas = new ArrayList<Persona>();

Método | Ejemplo | Descripción
--- | --- | ---
`<lista>.add(<elemento>)` | `personas.add(persona)` | Agrega un elemento al final de la lista.
`<lista>.set(<índice>, <elemento>)` | `personas.set(3, ana)` | Sustituye el `<elemento>` en un `<índice>` dado. (Cuidado con salirse del índice mínimo y máximo)
`<lista>.get(<índice>)` | `Persona ana = personas.get(3)` | Recupera un `<elemento>` del `<índice>` específicado. (Cuidado con salirse del índice mínimo y máximo)
`<lista>.size()` | `if (personas.size() < 10) { ... }` | Devuelve un entero con el número de elementos en la lista
`<lista>.remove(<índice>)` | `personas.remove(0)` | Quita el `<elemento>` en el `<índice>` dado y recorre los elementos. Por ejemplo, si se quita el primer elemento, ahora el segundo elemento sería el primero, el tercero el segundo y así sucesivamente.
`<lista>.clear()` | Borra todos los elementos al mismo tiempo (vacía la lista).
`<lista>.remove(<elemento>)` | `personas.remove(ana)` | Si el `<elemento>` se encuentra en la lista quita la primer coincidencia al objeto exacto.
`<índice>` dado y recorre los elementos. Por ejemplo, si se quita el primer elemento, ahora el segundo elemento sería el primero, el tercero el segundo y así sucesivamente.

> Ejercicio 2b.L1 - Llenar una lista con los primeros `N` números de Fibonacci

```java
// import java.util.Scanner;
// import java.util.ArrayList;

Scanner sc = new Scanner(System.in);

int n;

System.out.printf("Dame el límite de números de Fibonacci: ");
n = sc.nextInt();

ArrayList<Integer> fibonacci = new ArrayList<Integer>();

int a = 1;
int b = 1;
int c;

fibonacci.add(a);
fibonacci.add(b);

while (fibonacci.size() < n) {
    c = a + b; // actual
    fibonacci.add(c);
    a = b;  // penúltimo
    b = c;  // último
}

// for (int i = 0; i < fibonacci.size(); i = i + 1) {
//     int f = fibonacci.get(i);
//     System.out.printf("%d ", f);
// }

for (int f : fibonacci) {
    System.out.printf("%d ", f);
}

System.out.println();

sc.close();
```

---

## Entornos de Desarrollo para Java (Java IDE)

### Eclipse

Eclipse es uno de los IDEs más populares para el desarrollo en Java, cuenta con herramientas avanzadas de depuración, predicción de código e inspección de clases y objetos. También es muy flexible hacía los plugins de la comunidad y es el más utilizado para adaptarlo a diferentes tipos de frameworks.

![Figura 4.A1](./figuras/4.A1.png)

[https://www.eclipse.org/downloads/](https://www.eclipse.org/downloads/)

### Netbeans

Netbeans se volvió muy popular por sus capacidades de diseñar interfaces gráficas al estlo de Visual Basic y Visual C#, sin embargo, en las versiones posteriores a la 8 perdió esta capacidad y actualmente ya no posee ningua característica que lo posicione arriba de algún otro framework.

![Figura 4.A2](./figuras/4.A2.png)

[https://netbeans.apache.org/download/index.html](https://netbeans.apache.org/download/index.html)

### IntelliJ IDEA

IntelliJ es un framework muy popular por su gran capacidad de predicción de código, la cuál quizás sea de las mejores, y también por su livianez. Este es uno de los frameworks más ligeros para trabajar con Java, y en las últimas versiones el estilo se asemeja a usar [Visual Code](https://code.visualstudio.com).

Existen dos versiones, una de paga y otra `community`, la cual es gratuita y mantenida por la comunidad.

![Figura 4.A3](./figuras/4.A3.png)

[https://www.jetbrains.com/es-es/idea/](https://www.jetbrains.com/es-es/idea/)

### Spring Tools

Spring Tools es una adaptación de Eclipse, para integrar proyectos de Spring. Es muy útil para compilar rápidamente proyectos de Spring Boot para ofrecer servicios web principalmente.

![Figura 4.A4](./figuras/4.A4.png)

[https://spring.io/tools](https://spring.io/tools)

> Tabla comparativa de Frameworks

Framework | Tamaño | Memoria | Tiempo de Carga
--- | --- | --- | ---
Eclipse | ~117mb | - | -
Netbeans | ~438mb | - | -
IntelliJ | ~575mb | - | -
Spring Tools | ~545mb | - | -

---

**RESUELVE LA [PRÁCTICA 3](../practicas/pactica3.md)**