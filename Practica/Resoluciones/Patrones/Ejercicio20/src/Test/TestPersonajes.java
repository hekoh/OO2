package Test;

import Clases.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class TestPersonajes {
	Juego director;
	Personaje pj1;
	Personaje pj2;
	
	
	@BeforeEach
	public void setup() {
		director = new Juego(new BuilderGuerrero());
		pj1 = director.buildPersonaje("Varian");
		director.setBuilder(new BuilderArquero());
		pj2 = director.buildPersonaje("Sylvanas");
	}
	
	
	@Test
	public void testBuilders() {
		assertEquals(pj1.getArma().getClass(), Espada.class);
		assertEquals(pj2.getArma().getClass(), Arco.class);
		director.setBuilder(new BuilderMago());
		assertEquals(director.buildPersonaje("Medivh").getArma().getClass(),Baston.class);
		director.setBuilder(new BuilderThor());
		assertEquals(director.buildPersonaje("Thrall").getArma().getClass(),Martillo.class);
	}
	
	@Test
	public void testCombate() {
		pj1.Combatir(pj2);
		assertEquals(pj1.getVida(), 98);
		assertEquals(pj2.getVida(), 92);
		assertTrue(pj1.isAlive());
		assertTrue(pj2.isAlive());
	}
}
