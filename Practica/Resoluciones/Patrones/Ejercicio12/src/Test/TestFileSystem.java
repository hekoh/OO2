package Test;

import Clases.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;



public class TestFileSystem {
	private FileSystem fs;
	
	
	
	@BeforeEach
	public void setup() {
		fs = new FileSystem(LocalDate.now().minusDays(30));
		Archivo a1 = new Archivo("a1",LocalDate.now().minusDays(1),4);
		Archivo a2 = new Archivo("a2",LocalDate.now().minusDays(3),12);
		Archivo a3 = new Archivo("a2",LocalDate.now().minusDays(5),5);
		Directorio d1 = new Directorio("d1",LocalDate.now().minusDays(5));
		fs.añadirElemento(a1);
		fs.añadirElemento(a2);
		d1.añadirElemento(a3);
		fs.añadirElemento(d1);
	}
	
	
	@Test
	public void testTamaño() {
		assertEquals(fs.tamañoTotalOcupado(),85);
	}
	
	@Test
	public void testMasGrande() {
		Archivo aux = new Archivo("aux",LocalDate.now().minusDays(3),50);
		fs.añadirElemento(aux);
		assertEquals(fs.archivoMasGrande(), aux);
	}
	
	@Test
	public void testMasNuevo() {
		Archivo aux = new Archivo("aux",LocalDate.now(),50);
		fs.añadirElemento(aux);
		assertEquals(fs.archivoMasNuevo(),aux);
	}
	
	@Test
	public void testBuscar() {
		Archivo aux = new Archivo("aux",LocalDate.now(),5);
		fs.añadirElemento(aux);
		assertEquals(fs.buscar("aux"),aux);
		Directorio aux2 = new Directorio("aux",LocalDate.now());
		fs.añadirElemento(aux2);
		assertEquals(fs.buscar("aux"),aux);	//se llaman igual, encuentra primero el archivo
		assertTrue(fs.buscarTodos("aux").contains(aux2));
		assertTrue(fs.buscarTodos("aux").contains(aux));
		assertEquals(fs.buscarTodos("aux").size(),2);
	}
	
	@Test
	public void testListar() {
		Directorio d2 = new Directorio("d2",LocalDate.now().minusDays(2));
		Directorio d3 = new Directorio("d3",LocalDate.now().minusDays(2));
		Archivo aux = new Archivo("aux",LocalDate.now(),5);
		d3.añadirElemento(aux);
		d2.añadirElemento(aux);
		d2.añadirElemento(d3);
		fs.añadirElemento(d2);
		System.out.println(fs.ListadoDeContenido());
	}
	
}
