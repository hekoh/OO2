package Clases;

import java.util.Collection;
import java.util.List;

public class DatabaseAccessProxy implements DatabaseAccess{
	private DatabaseAccess db;
	private boolean logedIn;
	private String password;
	
	
	public DatabaseAccessProxy(DatabaseAccess db, String pass) {
		this.db = db;
		this.logedIn = false;
		this.password = pass;
	}
	
	
	public Collection<String> getSearchResults(String queryString){
		if(this.logedIn)
			return this.db.getSearchResults(queryString);
		else
			throw new IllegalArgumentException("El usuario no se encuentra registrado");
	}
	
	public int insertNewRow(List<String> rowData) {
		if(this.logedIn)
			return this.db.insertNewRow(rowData);
		else
			throw new IllegalArgumentException("El usuario no se encuentra registrado");
		}
	
	
	public void iniciarSesion(String password) {
		if(!logedIn) {
			if(password == this.password) {
				this.logedIn = true;
				System.out.println("Se ha logeado correctamente!");
			}
			else
				throw new RuntimeException("Contraseña incorrecta	");
		}
		else
			throw new RuntimeException("Sesíon ya iniciada");
	}
	
	public void cerrarSesion() {
		if(logedIn) {
			this.logedIn = false;
			System.out.println("Se ha cerrado la sesison");
		}
		else
			throw new RuntimeException("No se inicio la sesion");
	}
	
}

