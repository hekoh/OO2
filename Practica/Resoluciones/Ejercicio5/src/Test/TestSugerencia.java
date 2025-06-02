package Test;

import Clases.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


public class TestSugerencia {
	private Decodificador deco;
	private Sugerencia algoritmo;
	private Pelicula p1;
	private Pelicula p2;
	private Pelicula p3;
	private Pelicula p4;
	private Pelicula p5;
	private Pelicula p6;
	private Pelicula p7;

	
	
	
	@BeforeEach
	public void setup() {
		this.deco = new Decodificador();
		this.p1 = new Pelicula("El pianista",LocalDate.of(2002, 3, 6),10);
		this.p2 = new Pelicula("La tumba de las luciernagas",LocalDate.of(1988, 4, 16),9);
		p2.añadirSimilar(p1);
		this.p3 = new Pelicula("La vida es bella",LocalDate.of(1997, 2, 18),9);
		p3.añadirSimilar(p1);
		p3.añadirSimilar(p2);
		this.p4 = new Pelicula("El señor de los anillos: la comunidad del anillo",LocalDate.of(2002, 1, 31),10);
		this.p5 = new Pelicula("El señor de los anillos: las dos torres",LocalDate.of(2002, 12, 16),8);
		this.p6 = new Pelicula("El señor de los anillos: el retorno del rey",LocalDate.of(2003, 12, 17),9);
		p5.añadirSimilar(p4);
		p5.añadirSimilar(p6);
		p4.añadirSimilar(p6);
		this.p7 = new Pelicula("Forrest Gump",LocalDate.of(1994, 10, 6),10);
		deco.añadirPelicula(p1);
		deco.añadirPelicula(p2);
		deco.añadirPelicula(p3);
		deco.añadirPelicula(p4);
		deco.añadirPelicula(p5);
		deco.añadirPelicula(p6);
		deco.añadirPelicula(p7);
	}
	
	@Test
	public void testSimilares() {
		assertTrue(p1.getSimilares().contains(p3));
		assertTrue(p4.getSimilares().contains(p5));
		assertTrue(p2.getSimilares().contains(p1));
	}
	
	@Test
	public void testSugerencia() {
		this.algoritmo = new Similaridad();
		deco.setSugerencia(algoritmo);
		deco.verPelicula(p4);
		deco.verPelicula(p2);
		deco.verPelicula(p7);
		List<Pelicula> aux = deco.sugerir();
		System.out.println(aux.toString());
		assertEquals(aux.size(),3);
	}
	
	@Test
	public void testNovedad() {
		this.algoritmo = new Novedad();
		deco.setSugerencia(algoritmo);
		deco.verPelicula(p1);
		deco.verPelicula(p6);
		List<Pelicula> aux = deco.sugerir();
		System.out.println(aux.toString());
		assertEquals(aux.size(),3);
	}
	
	@Test
	public void testPuntaje() {
		this.algoritmo = new Puntaje();
		deco.setSugerencia(algoritmo);
		deco.verPelicula(p1);
		deco.verPelicula(p4);
		List<Pelicula> aux = deco.sugerir();
		System.out.println(aux.toString());
		assertEquals(aux.size(),3);
		assertTrue(aux.contains(p7));
		assertTrue(aux.contains(p6));
		assertTrue(aux.contains(p3));
	}
}
