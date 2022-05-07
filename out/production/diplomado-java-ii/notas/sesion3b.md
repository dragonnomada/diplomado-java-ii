# Sesión 3.B - Encapsulamiento, Polimorfismo y Herencia

![Logo CIC](./figuras/logo.png)

    Diplomado de Java - Módulo I
    Departamento de Diplomados y Extensión Profesional
    Centro de Investigación en Cómputo
    Instituto Politécnico Nacional

---

[![Alan Badillo Salas](https://avatars.githubusercontent.com/u/79223578?s=40&v=4 "Alan Badillo Salas")](https://github.com/dragonnomada) Por [Alan Badillo Salas](https://github.com/dragonnomada)

---

## Introducción

En esta sesión revisaremos los conceptos de *encapsulamiento*, *polimorfismo*, 
*composición de objetos* y *herencia*.

* Encapsulamiento de Atributos y Métodos
* Encapsulamiento de Objetos, Getters y Setters
* Sobrecarga de Métodos
* Herencia (Superclase y Subclase)
* Polimorfismo de Clases (Sobrecarga de Constructores)
* Polimorfismo de Métodos (Sobrecarga de Métodos)
* Agregación de Objetos
* Composición de Objetos
* Métodos Estáticos
* Patrón de Diseño *Factory Method*

## Encapsulamiento de Atributos y Métodos

Para poder lograr un correcto uso de los atributos y métodos, debemos pensar
en establecer los niveles de acceso que tendrá cada uno.

En la siguiente tabla se resumen los niveles de acceso de atributos y métodos.

| Nivel de Acceso | Palabra Reservada | Descripción                                                                                                                                            |
|-----------------|-------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|
| Público         | `public`          | Se refiere a permitir el control a nivel objeto. Ejemplo `objeto.x = 123` o `objeto.foo()`.                                                            |
| Protegido       | `protected`       | Se refiere a permitir el control desde la clase y las subclases que posea. Ejemplo `super.x = 123` o `super.foo()`.                                    |
| Privado         | `private`         | Se refiere a permitir el control sólo desde la clase. Ejemplo `this.x = 123` o `this.foo()`.                                                           |
| Paquete         | -                 | Cuándo no se establece ningún nivel de acceso, se otorgará un nivel de acceso público, sólo a nivel paquete (todos los que estén en el mismo paquete). |

* **Nota:** No es una buena práctica el no definir ningún nivel de acceso (por defecto a nivel Paquete). Ya que se podrían crear inconsistencias lógicas.

La siguiente tabla resumen los niveles de acceso.

| Nivel de Acceso | Otro paquete | Mismo Paquete | Objeto | Clase | Subclase |
|-----------------|--------------|---------------|--------|-------|----------|
| `public`        | SI           | SI            | SI     | SI    | SI       |
| `protected`     | NO           | NO            | NO     | SI    | SI       |
| `private`       | NO           | NO            | NO     | SI    | NO       |
| -               | NO           | SI            | SI     | SI    | SI       |

El encapsulamiento garantizará que los atributos y métodos sean accedidos correctamente
al nivel otorgado. Esto evitará modificar accidentalmente el valor de los atributos
o ejecutar métodos desde lugares inadmisibles.

## Encapsulamiento de Objetos, Getters y Setters

Cuándo manejamos objetos es común acceder a sus métodos públicos y solicitarle la
ejecución de métodos. Sin embargo, muchas veces estos métodos no son muy explicativos
sobre los cambios directos o la adquisición directa sobre los valores de los atributos.
Para solventar esto, en Java existe la convención de anteponer el prefijo `get`, `is` o
`has` antes del nombre del método, para indicar explícitamente en la nomenclatura que
recibiremo el valor de algún atributo. Así, si tenemos un atributo llamado `nombre`,
podremos crear un método llamado `getNombre()` que nos devuelva el valor del atributo.
A estos métodos les llamaremos *Getters*. Por el contrario, si queremos que alguien
pueda modificar manualmente el valor de un atributo, usaremos el prefijo `set` para
recibir el nuevo valor y actualizar el atributo. Por ejemplo, si tenemos el atributo
`edad`, podremos definir un método llamado `setEdad(edad)` que reciba el nuevo
que será definido para el atributo. A estos métodos les llamaremos `Setters`.

A los atributos que tienen un *Getter* y un *Setter* les llamaremos *Propiedades*,
y si no tienen un *Setter* definido, les llamaremos *Propiedades de Solo Lectura*.

Cuándo los atributos son booleanos, dependiendo si es plural o singular, sustituiremos
el prefijo `get` por `has` o `is` respectivamente. Por ejemplo, si tenemos el atributo
`encendido` podemos tener un *getter* llamado `isEncendido()` o si tenemos el atributo
`items` y queremos determinar si tiene elementos, podemos tener el *getter* llamado
`hasItems()`.

## Sobrecarga de Métodos

La *firma/signatura/huella/nomenclatura* (*signature*) de un método consiste en
la combinación de los tipos de parámetros que posee y el tipo de retorno. 
Por ejemplo, si definimos un método `void foo(int a, int b)` su *firma* será 
`(int, int) -> void`.

En Java podemos sobrecargar métodos, es decir, repetir la definición de un método
que tenga distinta *firma*, por ejemplo, definir dos métodos llamados `int suma(...)`
cuya diferencia serán los parámetros recibidos. Sin embargo, debemos respetar siempre
el mismo tipo de retorno.

En el siguiente ejemplo se muestra una tabla de métodos sobrecargados

| Número | Método                    | Firma               | Descripción                               |
|--------|---------------------------|---------------------|-------------------------------------------|
| 1      | `int suma()`              | `() -> int`         | Devuelve cero                             |
| 2      | `int suma(int a)`         | `(int) -> int`      | Devuelve el mismo valor `a`               |
| 3      | `int suma(int a, int b)`  | `(int, int) -> int` | Devuelve la suma de `a` y `b`             |
| 4      | `int suma(int[] valores)` | `(int[]) -> int`    | Devuelve la suma del arreglo de `valores` |

Como podemos observar tenemos `4` sobrecargas del método `suma` que acepta
distintos parámetros para realizar una misma lógica. A esto le llamaremos
*polimorfismo de métodos*.

