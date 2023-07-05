# Projecto jUnit GameStore App

### Descripción
GameStore App es una software hecho en Java el cual simula un tienda de videojuegos a través de la interacción del usuario con la consola, el sistema está diseñado para 2 usuarios con las siguientes funcionalidades.

* Cliente
  * Ver el inventario actual de la tienda
  * Comprar juegos de la tienda por nombre y cantidad
* Administrador (**admin123**)
    * Ver el inventario actual de la tienda
    * Comprar juegos
    * Vender juegos
    * Ver un resumen de la cantida de juegos vendidos, comprados y la ganancia total

Para el caso del cliente este puede comprar juegos con el nombre respectivo y la cantidad que desea, esta cantidad en caso de poder ser comprada será descontada del stock total actual, para el caso del administrador este puede vender juegos, similar a la compra del cliente y además este puede comprar juegos, lo cual aumenta el stock de los correspondientes juegos comprados descontando del total de ganacias de la tienda, además este puede generar un breve resumen de la cantidad de juegos comprados, vendidos y las ganancias totales.

### Instalación

No es necesario instalar el software ya que este se ejecuta y se utiliza por consola, sin embargo es necesario tener alguna versión actual de Java instalada en el sistema Java 17.0+, jUnit4.13 para la ejecución de las pruebas unitarias y una forma de compilar y ejecutar el proyecto como apache Maven o (mi recomendación) un IDLE como eclipse.

Utilizando Eclipse basta con ejecutar el proyecto como una aplicación de java y testear las pruebas unitarias por archivos con jUnit hacer build a maven con goal = package.
Alternativamente podemos desde el root folder ejecutar:

>mvn test

en caso de tener maven instalado para ejectuar y hacer build a las pruebas.

### Como usar

Una vez ejecutado el projecto de Java, basta con seguir las instrucciones del menú, siendo claro y preciso en el nombre de los juegos y las cantidades, la tienda inicializa una lista de juegos por defecto una vez se ejecuta por lo que no es necesario llenar manualmente de juegos para testear, en caso de querer agregar nuevos basta con que el administrador compre juegos que no existen en el inventario despues de confirmar que esa es su intención. La clave del administrador para entrar al sistema es **admin123**

### Como contribuir

En caso de querer contribuir al código basta con realizar un fork a este proyecto y levantar una solicitud de incorporación de cambios.

### Supuestos

* La tienda puede tener saldo negativo, esto implica quedar en deuda.
* Los inputs necesarios, como nombres de juegos, serán entregados correctamente
* El sistema es Case sensitive, debido a la gran cantidad de juegos existentes

