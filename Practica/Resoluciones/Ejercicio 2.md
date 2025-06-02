# Ejercicio 2.2 Juego


``` java
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
```

### Primer olor: La clase Juego Utiliza datos de la clase `jugador`, rompe el encapsulamiento.
Solucion: Se aplica "Move Method" y se mueven los metodos a la clase `Jugador`.

```java
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
```
 
### Segundo olor: La clase `juego` no tiene funcionalidad ni proposito.
Solucion: Inline Class. Se mueven las caracteristicas (si quedo alguna) de la clase `Juego` a la clase `Jugador` y se elimina la primera

consultar

 ```java	
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
```

### Tercer Olor: Las variables de instancia de la clase `Jugador` son publicas. Rompe el encapsulamiento
Solucion: Encapsulate Field. Cambiar las variables publicas a privadas

```java
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
```

# Ejercicio 2.3 Publicaciones

<a> <img src ="https://i.ibb.co/KzFmRGYJ/Whats-App-Image-2025-04-08-at-09-32-50.jpg" alt = "uml"> </a>	

```java
public List<Post> ultimosPosts(Usuario user, int cantidad) {
	List<Post> postsOtrosUsuarios = new ArrayList<Post>();
	for (Post post : this.posts) {
		if (!post.getUsuario().equals(user)) {
			postsOtrosUsuarios.add(post);
		}
	}

	// ordena los posts por fecha
	for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
		int masNuevo = i;
		for(int j= i +1; j < postsOtrosUsuarios.size(); j++) {
			if (postsOtrosUsuarios.get(j).getFecha().isAfter(
				postsOtrosUsuarios.get(masNuevo).getFecha())) {
				masNuevo = j;
			}
		}
		Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo));
		postsOtrosUsuarios.set(masNuevo, unPost);
		}

	List<Post> ultimosPosts = new ArrayList<Post>();
	int index = 0;
	Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
	while (postIterator.hasNext() && index < cantidad) {
		ultimosPosts.add(postIterator.next());
	}
	return ultimosPosts;
}
```

### Primer Olor: Se reinventa la rueda en 3 ocasiones.
Solucion: Reemplazar loops por stream

```java
public List<Post> ultimosPosts(Usuario user, int cantidad) {
	List<Post> postsOtrosUsuarios = new ArrayList<Post>();
	postOtrosUsuarios = this.post.stream().filter(p -> !p.getUsuario().equals(user)).collect(Collectors.toList());

	// ordena los posts por fecha
	postOtrosUsuarios = postOtrosUsuarios.stream().sorted(p1, p2) -> p1.getFecha().compareTo(p2.getFecha()).collect(Collectors.toList());


	List<Post> ultimosPosts = new ArrayList<Post>();
	ultimosPost = postOtrosUsuarios.stream().limit(cantidad).collect(Collectors.toList());

	return ultimosPosts;
}
```

### Segundo Olor: el metodo `ultimosPost` realiza demasiadas tareas. Long Method
solucion: Extract Method

```java
public List<Post> ultimosPosts(Usuario user, int cantidad) {
	List<Post> ultimosPosts = ordenarPostPorFecha(postOtrosUsuarios(user));
	return ultimosPost.stream().limit(cantidad).collect(Collectors.toList());
}

private List<Post> postOtrosUsuarios(Usuario user){
	return this.post.stream()
			.filter(p -> !p.getUsuario().equals(user))
			.collect(Collectors.toList());
}

private List<Post> ordenarPostPorFecha(List<Post> listaPost){
	return listaPost.stream().sorted(p1, p2) -> p1.getFecha().compareTo(p2.getFecha()).collect(Collectors.toList());
}

```

### Tercer Olor: El nombre del metodo no representa el funcionamiento
Solucion: Rename Method

```java
public List<Post> ultimosPostsDeOtrosUsuarios(Usuario user, int cantidad) {
	List<Post> ultimosPosts = ordenarPostPorFecha(postOtrosUsuarios(user));
	return ultimosPost.stream().limit(cantidad).collect(Collectors.toList());
}

private List<Post> postOtrosUsuarios(Usuario user){
	return this.post.stream()
			.filter(p -> !p.getUsuario().equals(user))
			.collect(Collectors.toList());
}

private List<Post> ordenarPostPorFecha(List<Post> listaPost){
	return listaPost.stream().sorted(p1, p2) -> p1.getFecha().compareTo(p2.getFecha()).collect(Collectors.toList());
}

```


# Ejercicio 2.4 Carrito de compras

<a> <img src ="https://i.ibb.co/RkGrWGsC/Whats-App-Image-2025-04-08-at-11-28-17.jpg" alt = "uml"> </a>

```java 
public class Producto {
	private String nombre;
	private double precio;

	public double getPrecio() {
		return this.precio;
	}
}

public class ItemCarrito {
	private Producto producto;
	private int cantidad;

	public Producto getProducto() {
		return this.producto;
	}

	public int getCantidad() {
		return this.cantidad;
	}
}

public class Carrito {
	private List<ItemCarrito> items;

	public double total() {
		return this.items.stream()
			.mapToDouble(item ->
			item.getProducto().getPrecio() * item.getCantidad())
			.sum();
	}
}

```

### Primer Olor: La clase `producto` no hace nada. Data Class
Solucion: Inline Class

```java

public class ItemCarrito {
	private String nombre;
	private double precio;
	private int cantidad;

	public String getProducto(){
		return this.nombre;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public double getPrecio() {
		return this.precio;
	}
}

public class Carrito {
	private List<ItemCarrito> items;

	public double total() {
		return this.items.stream()
			.mapToDouble(item ->
			item.getPrecio() * item.getCantidad())
			.sum();
	}
}
```
### Segundo Olor: La clase `Carrito` realiza tareas que podria realizar `ItemCarrito`. Feature Envy
Solucion: Move Method

```java
public class ItemCarrito {
	private String nombre;
	private double precio;
	private int cantidad;

	public String getProducto(){
		return this.nombre;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public double getPrecio() {
		return this.precio;
	}
	
	public double getTotal(){
		return this.precio * this.cantidad;
	}
}

public class Carrito {
	private List<ItemCarrito> items;

	public double total() {
		return this.items.stream()
			.mapToDouble(item ->
				item.getTotal())
			.sum();
	}
}
```

# Ejercicio 2.5 Envio de pedidos

<a ><img src= "https://i.ibb.co/4ZbtVMPj/Whats-App-Image-2025-04-08-at-11-28-17-1.jpg" alt ="uml"></a>

```java

public class Supermercado {

	public void notificarPedido(long nroPedido, Cliente cliente) {
		String notificacion = MessageFormat.format(“Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { 
			nroPedido, cliente.getDireccionFormateada() });
		// lo imprimimos en pantalla, podría ser un mail, SMS, etc..
		System.out.println(notificacion);
	}
}

public class Cliente {

	public String getDireccionFormateada() {
		return
		this.direccion.getLocalidad() + “, ” +
		this.direccion.getCalle() + “, ” +
		this.direccion.getNumero() + “, ” +
		this.direccion.getDepartamento()
	}
}
``` 

### Primer Olor: El metodo "getDireccionFormateada" usa datos de la clase `direccion`. Feature Envy
Solucion: Move Method

data class?? inline class? preguntar

```java

public class Supermercado {

	public void notificarPedido(long nroPedido, Cliente cliente) {
		String notificacion = MessageFormat.format(“Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { 
			nroPedido, cliente.getDireccionFormateada() });
		// lo imprimimos en pantalla, podría ser un mail, SMS, etc..
		System.out.println(notificacion);
	}
}

public class Cliente {
	private Direccion direccion;

	public String getDireccionFormateada(){
		return Direccion.getDireccionFormateada();
	}

}

public class Direccion{
	public String localidad;
	public String calle;
	public String numero;
	public String departamento;

	public String getDireccionFormateada() {
		return
		this.localidad() + “, ” +
		this.calle() + “, ” +
		this.numero() + “, ” +
		this.departamento()
	}
}
``` 
### Segundo Olor: Las variables de la clase `Direccion` son publicas.
Solucion: Encasulate Field
```java

public class Supermercado {

	public void notificarPedido(long nroPedido, Cliente cliente) {
		String notificacion = MessageFormat.format(“Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { 
			nroPedido, cliente.getDireccionFormateada() });
		// lo imprimimos en pantalla, podría ser un mail, SMS, etc..
		System.out.println(notificacion);
	}
}

public class Cliente {
	private Direccion direccion;

	public String getDireccionFormateada(){
		return Direccion.getDireccionFormateada();
	}

}

public class Direccion{
	private String localidad;
	private String calle;
	private String numero;
	private String departamento;

	public String getDireccionFormateada() {
		return
		this.direccion.getLocalidad() + “, ” +
		this.direccion.getCalle() + “, ” +
		this.direccion.getNumero() + “, ” +
		this.direccion.getDepartamento()
	}
}
``` 
### Tercer Olor: El metodo `notificarPedido` usa una variable temporal solo para imprimirla mas adelante.
Solucion: Inline Temp
```java

public class Supermercado {

	public void notificarPedido(long nroPedido, Cliente cliente) {
		// lo imprimimos en pantalla, podría ser un mail, SMS, etc..
		System.out.println( MessageFormat.format(“Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { 
			nroPedido, cliente.getDireccionFormateada() }););
	}
}

public class Cliente {
	private Direccion direccion;

	public String getDireccionFormateada(){
		return Direccion.getDireccionFormateada();
	}

}

public class Direccion{
	private String localidad;
	private String calle;
	private String numero;
	private String departamento;

	public String getDireccionFormateada() {
		return
		this.direccion.getLocalidad() + “, ” +
		this.direccion.getCalle() + “, ” +
		this.direccion.getNumero() + “, ” +
		this.direccion.getDepartamento()
	}
}
``` 
### Cuarto Olor: La clase Cliente actua como intermediario entre Supermercado y Direccion. Middle Man
Solucion: Remove Middle man
```java

public class Supermercado {

	public void notificarPedido(long nroPedido, Direccion direccion) {
		// lo imprimimos en pantalla, podría ser un mail, SMS, etc..
		System.out.println( MessageFormat.format(“Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { 
			nroPedido, cliente.getDireccionFormateada() }););
	}
}

public class Direccion{
	private String localidad;
	private String calle;
	private String numero;
	private String departamento;

	public String getDireccionFormateada() {
		return(
		this.direccion.getLocalidad() + “, ” +
		this.direccion.getCalle() + “, ” +
		this.direccion.getNumero() + “, ” +
		this.direccion.getDepartamento())
	}
}
```

# Ejercicio 2.6 Peliculas
<a><img src= "https://i.ibb.co/b5HLPvj6/Screenshot-2.jpg" alt="uml"></a>

```java

public class Usuario {
	private String tipoSubscripcion;
	// ...
	public void setTipoSubscripcion(String unTipo) {
		this.tipoSubscripcion = unTipo;
	}
	public double calcularCostoPelicula(Pelicula pelicula) {
		double costo = 0;
		if (tipoSubscripcion=="Basico") {
			costo = pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();
		}
		else if (tipoSubscripcion== "Familia") {
			costo = (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;
		}
		else if (tipoSubscripcion=="Plus") {
			costo = pelicula.getCosto();
		}
		else if (tipoSubscripcion=="Premium") {
			costo = pelicula.getCosto() * 0.75;
		}
		return costo;
	}
}
public class Pelicula {
	private LocalDate fechaEstreno;
	// ...
	public double getCosto() {
		return this.costo;
	}
	public double calcularCargoExtraPorEstreno(){
		// Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
		return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30 ? 0 : 300;
	}
}
```

### Primer Olor: La clase `Usuario` usa muchos if-else. Switch Statement
Solucion: Replace Conditional with Polymorphism

```java

public class Usuario {
	private Subscripcion tipoSubscripcion;
	// ...
	public void setTipoSubscripcion(Subscripcion unTipo) {
		this.tipoSubscripcion = unTipo;
	}
	public double calcularCostoPelicula(Pelicula pelicula) {
		return this.tipoSubscripcion.calcularCostoPelicula(pelicula); //sacar este metodo?? consultar
	}
}
public interface Subscripcion{ 
	public double calcularCostoPelicula(Pelicula pelicula);
}

public class Basico implements Subscripcion{
	public double calcularCostoPelicula(Pelicula pelicula) {
		return pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();
	}
}
public class Familia implements Subscripcion{
	public double calcularCostoPelicula(Pelicula pelicula) {
		return (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;
	}
}
public class Plus implements Subscripcion{
	public double calcularCostoPelicula(Pelicula pelicula) {
		return pelicula.getCosto()
	}
}
public class Premium implements Subscripcion{
	public double calcularCostoPelicula(Pelicula pelicula) {
		return pelicula.getCosto() * 0.75;
	}
}

public class Pelicula {
	private LocalDate fechaEstreno;
	// ...
	public double getCosto() {
		return this.costo;
	}
	public double calcularCargoExtraPorEstreno(){
		// Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
		return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30 ? 0 : 300;
	}
}

```

### Segundo Olor: Las clases `Familia` y `Basico` implementan funcionalidad que deberia realizar `Pelicula`. Feature Envy
Solucion: Extract Method

```java

public class Usuario {
	private Subscripcion tipoSubscripcion;
	// ...
	public void setTipoSubscripcion(Subscripcion unTipo) {
		this.tipoSubscripcion = unTipo;
	}
	public double calcularCostoPelicula(Pelicula pelicula) {
		return this.tipoSubscripcion.calcularCostoPelicula(pelicula); //sacar este metodo?? consultar
	}
}
public interface Subscripcion{ 
	public double calcularCostoPelicula(Pelicula pelicula);
}

public class Basico implements Subscripcion{
	public double calcularCostoPelicula(Pelicula pelicula) {
		return pelicula.costoConEstreno();
	}
}
public class Familia implements Subscripcion{
	public double calcularCostoPelicula(Pelicula pelicula) {
		return pelicula.costoConEstreno() * 0.90;
	}
}
public class Plus implements Subscripcion{
	public double calcularCostoPelicula(Pelicula pelicula) {
		return pelicula.getCosto()
	}
}
public class Premium implements Subscripcion{
	public double calcularCostoPelicula(Pelicula pelicula) {
		return pelicula.getCosto() * 0.75;
	}
}

public class Pelicula {
	private LocalDate fechaEstreno;
	// ...
	public double getCosto() {
		return this.costo;
	}
	private double calcularCargoExtraPorEstreno(){
		// Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
		return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30 ? 0 : 300;
	}
	public double costoConEstreno(){
		return this.getCosto() + this..calcularCargoExtraPorEstreno();
	}
}

```