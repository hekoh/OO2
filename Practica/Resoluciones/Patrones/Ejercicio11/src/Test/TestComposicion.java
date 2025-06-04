package Test;

import Clases.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;



public class TestComposicion {
	private Topografia topografia;
	
	@BeforeEach
	public void setup() {
		topografia = new Topografia();
	}
	
	
	@Test
	public void testUnaPorcion() {					//juntar agua y tierra en una?
		topografia.añadirComposicion(new Celda(1));
		assertEquals(topografia.proporcionAgua(),1);
		topografia.añadirComposicion(new Celda(0));
		assertEquals(topografia.proporcionAgua(),0);
	}
	
	@Test
	public void testMixtas() {
		Mixta mixta1 = new Mixta();
		Mixta mixta2 = new Mixta();
		mixta1.añadirCelda(new Celda(1));
		mixta1.añadirCelda(new Celda(1));
		
		mixta2.añadirCelda(new Celda(1));
		mixta2.añadirCelda(new Celda(0));
		mixta2.añadirCelda(new Celda(0));
		mixta2.añadirCelda(new Celda(0));
		
		mixta1.añadirCelda(mixta2);
		mixta1.añadirCelda(new Celda(0));
		topografia.añadirComposicion(mixta1);
		assertEquals(topografia.proporcionAgua(),0.5625);
	}
	
	@Test
	public void testIgualdadMixta() {
		Mixta mixta1 = new Mixta();
		Mixta mixta2 = new Mixta();
		mixta1.añadirCelda(new Celda(1));
		mixta1.añadirCelda(new Celda(0));
		mixta1.añadirCelda(new Celda(0));
		mixta1.añadirCelda(new Celda(1));
		
		mixta2.añadirCelda(new Celda(1));
		mixta2.añadirCelda(new Celda(0));
		mixta2.añadirCelda(new Celda(0));
		mixta2.añadirCelda(new Celda(1));
		
		assertTrue(mixta1.equals(mixta2));
	}

	@Test
	public void testIgualdadSingular() {
		topografia.añadirComposicion(new Celda(0.7));
		Topografia topografia2 = new Topografia();
		topografia2.añadirComposicion(new Celda(0.7));
		assertEquals(topografia,topografia2);
		topografia2.añadirComposicion(new Celda(1));
		assertNotEquals(topografia,topografia2);
	}
		
		
}
