package Clases;

public class Usuario {
	private String nombre;
	private String apellido;
	private String mail;
	
	public Usuario(String nombre, String apellido, String mail) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
	}
	
	public String getMail() {
		return this.mail;
	}
}
