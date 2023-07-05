# Projecto jUnit GameStore App

### Descripción
GameStore App es una software hecho en Java el cual simula un tienda de videojuegos a través de la interacción del usuario con la consola, el sistema está diseñado para 2 usuarios.

* Cliente
  * Ver el inventario actual de la tienda
  * Comprar juegos de la tienda por nombre y cantidad
* Administrador
    * Ver el inventario actual de la tienda
    * Comprar juegos
    * Vender juegos
    * Ver un resumen de la cantida de juegos vendidos, comprados y la ganancia total

### Instalación

No es necesario instalar el software ya que este se ejecuta y se utiliza por consola, sin embargo es necesario tener alguna versión actual de Java instalada en el sistema Java 17.0+, jUnit4.13 para la ejecución de las pruebas unitarias y una forma de compilar y ejecutar el proyecto como apache Maven o (mi recomendación) un IDLE como eclipse.

### Como usar

Utilizando Eclipse basta con ejecutar el proyecto como una aplicación de java y testear las pruebas unitarias por archivos con jUnit hacer build a maven con goal = package.
Alternativamente podemos desde el root folder ejecutar:

>mvn test

en caso de tener maven instalado para ejectuar y hacer build a las pruebas.
