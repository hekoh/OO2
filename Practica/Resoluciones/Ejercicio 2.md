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

<a> <img src ="https://lh3.googleusercontent.com/fife/ALs6j_FaveUCnWwGOTnHcNVkHcrERIv2auPY3yYQChPsOgfCbKC-496u8r-50wzY1jHX47oA4DFgrrbqz3GZBVqTYMw-NFHkEy5UmN3xvGL5xjJj6-N0LtO58iPJ4oPaaaJkNb5RS2259OhAqFKW4tP8JUfDkXA9RM_I2Ps-YCez__DpgLGjnoRZtfcnv_mumxiZVwBw30qbsI6rwFY-HcdiV_B3pBZNI_fE5IqWgsXLtN7vR2yCGBK3Nxu8h2BKBa7kdJMI872AsBq_j_kIJY6rbAfKbQV1qxu9wg8WqYJqvKwxyibtGNijBEZTtOTXNszT_T3biJ2CdjdACPcX6kjz2VeuIYqVgrdMZnYsDWAnaQ80x6dzbGWvsbZIVuGOpAKb8WMMRllZB-XemSWO_OAYs36V-K_3kcoA9tpd6D1QSTHLKYpmQ1_LhhVMgk_AxzEwDqErG35TUvCbLafStfJufWc3M-ZjRTMRbTv5nPObsHqoumBRfHBgExXEzX9uTkfZcd0DPGzxfvpx_kHRumjW7YYCCNd_YZ-NRhlQVGUmUf9cS3ovxsn4GUbBN_VA6z7bpCI8dFeXGENeza9lLq_Jl0GQoUy39ArSIg4Dc3KAvqh2NOA7hlwOnvZ074ZpRsZdKhD0W3opmqbyUZQc57tyIdyNpXBuum-6HwRrJ56NZ-KaIBeWqprJX8yQZFe1UYuVXVU7iTGDSP2mPLZLqjD_LTwTlMDrcBqhDu0yrBdpAv_qG5gHSF8MP4hIQyXwsrCQ5oW0gUf4P8vxVwY4ipkoRLQlvkwQh87-II3gOgC86dZe7FPB-eAUCd8zHlEYCtbCuYYh9IF4KOU-GjFkDbfdwOh8wEHJ9qNeQL9l5j2_AprgjCcOwPyMqKphpa3O-ftozs825RoO3RJKOuFWKndhZJzgzsBIwJFr59YcJvvB5zKpI8vwbzMFGj2w0lTB7tkJw2TU_0NVmoqPuW_2AgZGU9I5FLWhORm_P8Yk01ejuY2Z1aW_Acv5s7o7pdCCbIRCQbY_AbJYlShfYFfiNVWP0WNpDFU6uzSSaSJxq4AbkSRdul-Yr0_VkI1nlnxbjulxR2DSljG2uuxR9DSiQCBGl4bXaTKG5NfBFtBHAvi6cKo1sAfjDcb7lwTbLV6VPyqxm78y2RCtGTr_jyracOcaGC1Mjaxp3TpeDKZCu8R4zcqSk7XLFyTRi2oMTDwjwo6LDRSHOrGbspBBOm1HXyUcWxNLlhrlLFZuWvRU6koaYeavvSePYyKLIXx_52fWDdeXZevXowCCdSjfSucZ2SWOG0qv1bwZPltFenU9jLE5LPV_Fu7YykbExintQxLbk3_xvNoq3OaAcQaec99mf4jEZxro0MoqpoE95nE24P6FkyqjnYC-sVpaTTMbxgC0befP10pLViXuFXricyo7p8sAiCcqelbUeNZm7JGlDo5EGnfe3ufDwg7J7IXGSbO02x_ytVLdr73XAjlr_PV9ZpunjhWV2nshYrDu1bsSgYCIIRo7LSjeTDzfqIZESHfLRkqoKl-2GUXAQvb2iqt9RkzVgshKlTQBv9kbD0-rz0qyuUsXcw19rlevnZinaCVQWy6UAQ3cZsxXMlNTtWeJqyQ1LLTePBOraVV0VexD-_zn7emzyDkd_XRKTtfsj8f8UHJRoyHe8BkRcK3yhWBmcdLwQkUW=w1240-h919" alt = "uml"> </a>	

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

<a> <img src ="https://lh3.googleusercontent.com/fife/ALs6j_H6XHjcs7bz7gWCAfUS6F_9LVRRm7XRH6tymD7u8y35w1Qa-ib7ka1whKvo1KavmQQ-YnpGbFvCkqpBcw9xyto-ptQTsgRWTt5x_eSEjZMviSe-PcgbB4zHLUAM0oEZqATI283FSxxd7KKz7l1AyhSet2AqMAIftKtPYMKJSpgQCYF9aX9AGVxp10sthnBeX6Fgtoyt4V4KtI8hSan3Lb0kasHAUon1im1D00AZo2dxtssyfYozOJN9Q8uj1f1bOKPaZ0QI5gQVhTbvxjLiCwAbL8fL8SFHisFUd-JBDpEBQ6YF8d7GOaPxAcz70gnga09qgZ_GnnHnKxAabuQ7KpWlfyOEFehv_lU1q3TU6lBFI3gYy1-dZlx0V3_WcEcOXBUd_PFzR-nEqFTjYKIGFJmyxO27fQ-o2dJt6huwTZL_Fj5VrbAEkXDTQam3bWFtcsmX-h-n2LnVjo2GsNVj4uqI0zlhVbYK5su5wCX4nytGAyOKR2fLV3jgv5hYWILk6arUSxnBVk7aH_KU2fuSRS2LaVzbJoXvQVf7QW0LMnXpF1QQtuDZciZToOBeq7kyGqqJJBC8Y9hLa2rSCxreOetrImbPxPnlialLYgLoi8QUGksOuc6t5j2h2Qv7mUIaljcIAXjVGGXCTgGBcVPpYc1PNuSU5si8GIBSy60d34VXJekLYUZC8m0L8cGny_rqPETKQzTQ1UeBnynOBzJ_XxeI811mJXe9Vm3VcPYQjZgf5PS8O-9pVnqXopZq9-bpAFiLItbMVtcB4Y_mbRui1CTfvIPh4hY8Byrxh-N36OPGzjK_5fEuUxYRWaCpVUZVNl4QACsR1q1CRGyRou3iIHTm0FjirH_AB9g_Q4MfWQeALxE0z8dO1KzLpMekxRWgOAvs35ii4KOgaN-dP20BGZ9w8Omp7XgJD07GxoRTF8RD7SlhUHDRNQX0vF0m1jHA44XIuE3YVcECEXchZyjuR4ju5YYTdO6izPSglcCY3JsfrDPuESFMwTx4vxPyXNz8_csrYhhfvDSEr4_j6TP971wa9VnCYRvtLnmPU1v0fDQjHEvKNI7kCMk2NC3IgG9Oo63qwQk8kYABMHEfNrRAxAwYCT3qrWhDInflzeSEN2L0CLhx1Lh4_y5VZsoUSRw_jQRcTdrtjJ3-VKbQbigNYf-fcolfhbb_qrprdBblnHSAAG642YYGW0cnJY5FzpPFYzq7_-nReZGtPyCXLxT66_hANVxvbv2n0qsm5T3fZ0laUyOhSGioxWbu3pvkfZu7jNbM2oGLCk7S8hOZw2ZRXe5vNbB7e-qXUAWASClOqgO_qNLVgGD2RfM4XeQ7tvrsUFJhhFc3QrDURj24PFy4tYpP18C-8Ho2Xc68NytokHQu4ug-VT8CKbJTqK7HKHIXr9A4uw_zjkPmuDlEZxqaHuqxQZNpVSte9KpI2ZD-MXxeRQgTTKfeW43IScCrO-PuqtQrVr4pyhFB6VjsoQBJDm0t2cXqnT-oFuAs6B8iNXLvfmhd9Gw8EKvgxTvkOhb-BMfb7W-9Oq_rhx5UoPD79pPFhYRQWBCWSBNn8cmCNeCvWpBMchpWL9PoL_di4pN6NWbWxIgVNCRL8lmrVGuso8cB2vGY7A0l91mxkuP2eKQB0cgdeGuD5kjMl0myZwEJuOFh_fdyfp69ISmgxhck1aVX4A=w1240-h919" alt = "uml"> </a>

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

<a ><img src= "https://lh3.googleusercontent.com/fife/ALs6j_EGYwchWFjEjJ3J9UbwK5XwLnms2DqpnX9ozyr4GnsoFJ3qzbc4Oq41ngzYrBFAbrTRd_99IbYYysHPEBdFZYHza1eNbz5jvc9GaZ32QLohHD2Cwh1IFgl0pGs8Xemt0evUJtsyDmR0IXJl8TZhgiOmuj8nxO2bdKsV2z-XUPedJ1wxEAO_Gwd-Qqgl7mw0_ob3qjuk0kc2wRmxZEst_o3LkTN_Vp-nDl7CT_8pUvt6FNy1S-dEUbI354llwlHc4lwo7-Q_rbvoCX1QEZ0toff3PzVnQRCxeR3-wC9nYoV1cw7UniynBW_k7AU2Yytbn9Re58QmkA4Yp61g9M6yNMKajGjjUsYMe4w4EL3GbXB26OgvpAa0CkyB2jmmu4Vb2y71H6C3ZYETUqOm971VPZHSFx3rQDItqSYwUYuVSzieI6wuXJMW2tYnWS50vbf3Ex4lrYEIAES6_7zUgwdnB5EoSNgHcYXiROD9o6g7ah3275d9fbj-xdw7ZhpIVvP_Rgb04RzIZqrcjdICK37eZLhbYPSYM5HpPEBBDOKSCxaMriSMjFSc6S9paR2cSQBTTlNgKejWHfsfSoZqr6OwMDhwHsPz2wOgIWYmIZUxPgGFOZ3gFQN5vi6reN2c0VcByUavm9_H45jjuG_iW9i_95wwq_8qJgsfrz4ig2smskWGPImhaWaZaA3nBZXv42511He_DBsg1EX_eJaj65mhkhyTNUvsXi1lWyFohzfQWeH9f-EXKhbhQpUb5kDLU_ahiT0eAbbrLc4PR1G59gjfLy9xtLfFdnihSSBgri0UsowJr5zzCslB2cIzGeNEL3nOYaB3BLpNERBST7srIPKMiD2YzxkvOc3eHJRPeZRHOn_Hk_PkXz8xfwrP9tH_h9NnZNjHK1_VbPqgiXO-TMyiSypOqBv7i5M8oOTGmlKFR1D2lYQuoIm57zprGx-JH88ilye6nZqRQOCe7jU18ugXAxdbEasRonXTjK0b1ZJdT7IxapHP2ISPMHf8Z2D9wu7WvV5_gH_d3SiHhSEOt4NSYR_zAI0Q3RdxI2McjFvUoO5jNgyU_z5u1TfVFnYuTMT7-137wBkKUVZbk1a8UJPfDuq8ebE6unWDukmuNOKCRKF7rX__ors_0SkLmqhDcpbAoebe-QeUAQv2k3hZTwwfxWq9wE4jtIlpmR3Ku9Hb-6oLrCco7gaFXar3nbKBi9dxAZU8_XwYOJlznfoghze2bStaqIzSCvG_Natb4WFsCGWqLev8Ds9zWwXn2suOhHfFQWU9eR5Dm-U2q5E8fO3nrupC5hfhqWE64-hTwHrXt0Vhrrfpe06wDjos8ac9gKweJtt4nDAtlxZsE99TyhF3caQxmm7_zkOHyKbxgpqOL-g3sz2nfCCjv4KgVMW6brbCCUkgCBVf4_K6gKDk_XJU1Kpgw3Km3tu5YBUBoCs8gRakn7kWvA9qKeoms-oSL8H9cBd-S-AC1KTsjOJFFIIVpHphotfsKi2pYctHvSlXRvd5qJQZSSOTL5L3CwLY_nB8njXwNst2EVBJDWuyOVJX8x0zLIsmdDU6bVonPeQwhsAh4CtKvXyF5ZILydGvjP-_RL0jTobqFN3eUxHg1AwtqJQ-dm-Q_49tgFUUMR5MBiiZnFXLnqWgGaHMEzpI2QTbLlFEthH7GAr1xAS4g3B3Gg4TWw=w1240-h919" alt ="uml"></a>