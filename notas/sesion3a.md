# Sesión 3.A - Clases, Objetos y Constructores

![Logo CIC](./figuras/logo.png)

    Diplomado de Java - Módulo I
    Departamento de Diplomados y Extensión Profesional
    Centro de Investigación en Cómputo
    Instituto Politécnico Nacional

---

[![Alan Badillo Salas](https://avatars.githubusercontent.com/u/79223578?s=40&v=4 "Alan Badillo Salas")](https://github.com/dragonnomada) Por [Alan Badillo Salas](https://github.com/dragonnomada)

---

## Introducción

En esta sesión aprenderemos sobre la construcción de clases.

* Establecer atributos y métodos
* Creación de Objetos
* Establecer nivel de acceso de atributos y métodos
* Sobrecargar métodos
* Definir Constructores
* Sobrecargar Constructores
* Objetos y Referencias
* Valores Copiados y Valores Referenciados

## Clase

Representan el diseño que tendrán objetos comunes.

    > Las clases abstraen la naturaleza de un sistema
      para modelarlo mediante atributos y métodos.

    SINTAXIS

    <nivel de acceso> class <Nombre> {
        
        ... atributos y métodos

    }

> Ejemplo de una clase que representa un Ticket

```java
public class Ticket {
    
    private int id;
    private double total;
    private String fecha;
    private PuntoVenta puntoVenta;
    
    public void imprimir() {
        System.out.printf("[Ticket #%d / %s] $%.2f %s \n",
                this.id, this.puntoVenta, this.total, this.fecha);
    }
    
}
```

    NOTA: Las clases se tienen que llamar igual que su archivo `.java`
          y seguir las convenciones de nombrado PascalCase.

## Atributo

Representa un dato que podrán ser retenidos por un objeto y su nivel de acceso.

    > Los atributos estructuran la información de los objetos 
      modelados por la clase.

    SINTAXIS

    <nivel de acceso> class <Nombre> {

        // ATRIBUTOS
        <nivel de acceso1> <tipo1> <nombre1>;
        ...
        <nivel de accesoN> <tipoN> <nombreN>;

    }

> Ejemplo de una clase que retiene el dato de si un Aparato está prendido

```java
public class Aparato {
    
    protected boolean encendido;
    
    public void encender() {
        this.encendido = true;
    }
    
    public void apagar() {
        this.encendido = false;
    }
    
}
```

## Método

Representa una funcionalidad que se puede aplicar el objeto y su nivel de acceso.

    > Los métodos estructuran las acciones que se le pueden aplicar
      a un objeto, aceptando información extenerna en forma de parámetros.

    SINTAXIS

    <nivel de acceso> class <Nombre> {

        // ATRIBUTOS
        ...

        // MÉTODOS
        <nivel de acceso> <tipo de retorno1> <nombre1>([<... paramétros>]) {
            // CUERPO DEL MÉTODO ...
            return <valor devuelto>;
        }

        ...

        <nivel de acceso> <tipo de retornoM> <nombreM>([<... paramétros>]) {
            // CUERPO DEL MÉTODO ...
            return <valor devuelto>;
        }

    }

    <parámetros> ~ <tipo de dato1> <nombre1>, ..., <tipo de dato k> <nombrek>

> Ejemplo de una clase Cafetera con la acción de prepar café

```java
public class Cafetera {
    
    private boolean preparando;
    
    public void prepararCafe(String tipo) {
        if (this.preparando) {
            System.out.println("La cafetera está ocupada");
            return;
        }
        
        switch (tipo) {
            case "Americano":
                System.out.println("Preparando café americano");
                this.preparando = true;
                break;
            case "Expreso":
                System.out.println("Preparando café expreso");
                this.preparando = true;
                break;
            default:
                System.out.println("No se puede preparar este tipo de café");
                this.preparando = false;
                break;
        }
    }
    
}
```

## Creación de Objetos

Cada clase permite construir objetos diseñados con los mismos atributos
y métodos. La diferencia entre un objeto y otro será el valor contenido
en cada atributo. Estos serán independientes de otros objetos.
Por los que cada objeto será como una caja independiente, diseñada
según la clase.

    > Los objetos permiten retener valores específicos en los atributos
      diseñados por la clase y mandar a aplicarles los métodos definidos.

    SINTAXIS

    <Clase> <nombre> = new <Clase>([<parámetros>]);

> Ejemplo de una batalla de Robots

```java
public class TestRobots {
    
    public static void main(String[] args) {
        Robot r1 = new Robot();
        Robot r2 = new Robot();
        
        while (!r1.estaAniquilado() || !r2.estaAniquilado()) {
            r1.mover();
            r2.mover();
            r1.atacar();
            r2.atacar();
        }
    }
    
}
```

> Ejemplo hacer una venta e imprimir el ticket

```java
public class SistemaOperando {
    
    public static void main(String[] args) {
        
            Venta venta = new Venta();
            
            venta.abrir();
            
            Articulo a1 = Articulo.buscar("Coca Cola").primero();
            
            if (!a1.estaBloqueado() && a1.obtenerExistencias() > 0) {
                String nombre1 = a1.obtenerNombre();
                a1.reservar();
                venta.agregarArticulo(a1);
                a1.bloquear();
            }

            Articulo a2 = Articulo.buscar("Gansito").primero();
    
            if (!a2.estaBloqueado() && a2.obtenerExistencias() > 0) {
                a2.reservar();
                venta.agregarArticulo(a2);
                a2.bloquear();
            }
            
            double total = venta.calcularTotal();
            
            double cambio = venta.realizarPago(total + 50);
            
            Ticket ticket = venta.obtenerTicket();
            
            ticket.imprimir();
            
            if (!ticket.sePudoImprimir()) {
                venta.cerrar("REIMPRIMIR");
            } else {
                venta.cerrar("EXITOSA");
            }
        
    }
    
} 
```

## Constructores

Los constructores son métodos especiales que nos permitirán inicializar nuestro atributos, recibiendo los parámetros
de construcción.

    > Los constructores se llaman igual que la clase y a diferencia de los métodos no marcan un tipo de retorno.

    SINTAXIS

    <nivel de acceso> class <Nombre> {

        // ATRIBUTOS ...

        <nivel de acceso> <Nombre>([<... parámetros>]) {
            ... TODO: Inicializar todos los atributos en sus valores por iniciales
        }

        // MÉTODOS ...

    }

    OBSERVACIÓN

    > Cuando usamos la palabra `new` el constructor es el primer método en ser llamado
    > Podemos tener más de un constructor sobrecargado
    
    EJEMPLO

    <Clase> <nombre> = new <Clase>(<... parámetros>);

    <nombre> -> sería el objeto ya inicializado