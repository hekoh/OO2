package Clases;

import java.time.LocalDate;
import java.util.List;

public class FileSystem {
	private Directorio root;
	
	
	public FileSystem(LocalDate fecha) {
		root = new Directorio("root", fecha);
	}
	
	public void añadirElemento(Elemento elem) {
		this.root.añadirElemento(elem);
	}
	
	public int tamañoTotalOcupado() {
		return this.root.tamaño();
	}
	
	public Directorio getRoot() {
		return root;
	}
	
	public Archivo archivoMasGrande() {
		return this.root.archivoMasGrande();
	}
	
	public Archivo archivoMasNuevo() {
		return this.root.archivoMasNuevo();
	}
	
	public Elemento buscar(String nombre) {
		return this.root.Buscar(nombre);
	}
	
	public List<Elemento> buscarTodos(String nombre){
		return this.root.BuscarTodos(nombre);
	}
	
	public String ListadoDeContenido() {
		return this.root.listadoDeContenido("");
	}
}
