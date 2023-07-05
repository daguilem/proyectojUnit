package proyectojUnit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GameStoreTest {
	
	private VideoGame game;
	
	/*
	 * Verifico que el metodo funciona comparando el inventario al cual 
	 * agregue un nuevo juego con uno el cual se que tiene el juego a 
	 * verificar.
	 */
	@Test
	public void testAddGame()throws Exception {
		game = new VideoGame("Majotori","puzzle","PC",15,5000);
		GameStore gameStore = new GameStore();
		ArrayList<VideoGame> juegos = new ArrayList<VideoGame>();
		juegos.add(game);
		gameStore.addGame(game);
		Assert.assertEquals(gameStore.inventory, juegos);
	}
	/*
	 * Agrego un juego a la tienda y vendo 10 unidades a través del 
	 * método, luego comparo el valor de ingresos totales con el valor 
	 * manual de vender 10 juegos.
	 */
	@Test
	public void testSellGame() throws Exception {
		game = new VideoGame("Majotori","puzzle","PC",15,5000);
		GameStore gameStore = new GameStore();
		gameStore.addGame(game);
		gameStore.sellGame("Majotori", 10);
		Assert.assertTrue(gameStore.totalEarnings == 10*5000);
	}
	/*
	 * Similar al anterior, pero esta vez estoy quitando ganacias a la 
	 * tienda al comprar juegos, dado que la tienda no tiene dinero al 
	 * iniciar, el saldo final es negativo.
	 * "Successfully sold " + quantity + " copies of " + title
	 */
	@Test
	public void testPurchaseGame() throws Exception {
		game = new VideoGame("Majotori","puzzle","PC",15,5000);
		GameStore gameStore = new GameStore();
		gameStore.addGame(game);
		gameStore.purchaseGame("Majotori", 5);
		Assert.assertTrue(gameStore.totalEarnings == -5*5000);
	}
	/*
	 * Agregamos un juego a la tienda y luego utilizamos el método para 
	 * buscarlo por su nombre, si lo encontramos nos deberia retornar el
	 * juego, por lo que lo comparo con el juego creado originalmente.
	 * Tambien comparamos que si el juego no existe devuelve null.
	 */
	@Test
	public void testFindGame() throws Exception {
		game = new VideoGame("Majotori","puzzle","PC",15,5000);
		GameStore gameStore = new GameStore();
		gameStore.addGame(game);
		Assert.assertTrue(gameStore.findGame("Majotori").equals(game));
		Assert.assertNull(gameStore.findGame("God of War"));
	}

}
