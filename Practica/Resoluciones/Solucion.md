#Ejercicio 2.2 Juego


'''java
public class Juego {
// ......

	public void incrementar(Jugador j) {
		j.puntuacion = j.puntuacion + 100;
	}

	public void decrementar(Jugador j) {
		j.puntuacion = j.puntuacion - 50;
	}
}

public class Jugador {
	public String nombre;
	public String apellido;
	public int puntuacion = 0;
}
'''
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
###Primer olor: La clase Juego Utiliza datos de la clase jugador, rompe el encapsulamiento.
	##Solucion: Se aplica "Move Method" y se mueven los metodos a la clase Jugador.

'''java
public class Juego {
// ......
}

public class Jugador {
	public String nombre;
	public String apellido;
	public int puntuacion = 0;
	
	public void incrementar(Jugador j) {
		j.puntuacion = j.puntuacion + 100;
	}

	public void decrementar(Jugador j) {
		j.puntuacion = j.puntuacion - 50;
	}
}
'''
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
###Segundo olor: La clase 'juego' no tiene funcionalidad ni proposito.
	##Solucion: Inline Class. Se mueven las caracteristicas (si quedo alguna) de la clase Juego a la clase Jugador y se elimina la primera

 '''java	
 public class Jugador {
	public String nombre;
	public String apellido;
	public int puntuacion = 0;
	
	public void incrementar(Jugador j) {
		j.puntuacion = j.puntuacion + 100;
	}

	public void decrementar(Jugador j) {
		j.puntuacion = j.puntuacion - 50;
	}
}
'''
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
###Tercer Olor: Las variables de instancia de la clase Jugador son publicas. Rompe el encapsulamiento
	##Solucion: Encapsulate Field. Cambiar las variables publicas a privadas
'''java
 public class Jugador {
	private String nombre;
	private String apellido;
	private int puntuacion = 0;
	
	public void incrementar(Jugador j) {
		j.puntuacion = j.puntuacion + 100;
	}

	public void decrementar(Jugador j) {
		j.puntuacion = j.puntuacion - 50;
	}
}
'''

