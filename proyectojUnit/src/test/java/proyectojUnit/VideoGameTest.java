package proyectojUnit;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VideoGameTest {
	
	private VideoGame game;
	
	@Before
	public void setUp() throws Exception{
		game = new VideoGame("Majotori","puzzle","PC",15,5000);
	}
	/*
	 * Pruebas estandar de verificacion para comprobar que los metodos
	 * de la clase videogame funcionan.
	 */
	@Test
	public void testGetTitle() throws Exception{
		Assert.assertTrue(game.getTitle().equals("Majotori"));
	}

	@Test
	public void testGetGenre() throws Exception {
		Assert.assertTrue(game.getGenre().equals("puzzle"));
	}

	@Test
	public void testGetPlatform() throws Exception {
		Assert.assertTrue(game.getPlatform().equals("PC"));
	}

	@Test
	public void testGetQuantity() throws Exception {
		Assert.assertTrue(game.getQuantity() == 15);
	}
	@Test
	public void testGetPrice() throws Exception {
		Assert.assertTrue(game.getPrice() == 5000);
	}

}
