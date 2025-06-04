# Ejercicio 4

```java
public class Pedido {
    private Cliente cliente;
    private List<Producto> productos;
    private String formaPago;

    public Pedido(Cliente cliente, List<Producto> productos, String formaPago) {
        if (!"efectivo".equals(formaPago)
                && !"6 cuotas".equals(formaPago)
                && !"12 cuotas".equals(formaPago)) {
            throw new Error("Forma de pago incorrecta");
        }
        this.cliente = cliente;
        this.productos = productos;
        this.formaPago = formaPago;
    }

    public double getCostoTotal() {
        double costoProductos = 0;
        for (Producto producto : this.productos) {
            costoProductos += producto.getPrecio();
        }
        double extraFormaPago = 0;
        if ("efectivo".equals(this.formaPago)) {
            extraFormaPago = 0;
        } else if ("6 cuotas".equals(this.formaPago)) {
            extraFormaPago = costoProductos * 0.2;
        } else if ("12 cuotas".equals(this.formaPago)) {
            extraFormaPago = costoProductos * 0.5;
        }
        int añosDesdeFechaAlta = Period.between(this.cliente.getFechaAlta(), LocalDate.now()).getYears();
        // Aplicar descuento del 10% si el cliente tiene más de 5 años de antigüedad
        if (añosDesdeFechaAlta > 5) {
            return (costoProductos + extraFormaPago) * 0.9;
        }
        return costoProductos + extraFormaPago;
    }
}

public class Cliente {
    private LocalDate fechaAlta;

    public LocalDate getFechaAlta() {
        return this.fechaAlta;
    }
}

public class Producto {
    private double precio;

    public double getPrecio() {
        return this.precio;
    }
}
```

### Replace Loop with Pipeline

```java
public class Pedido {
    private Cliente cliente;
    private List<Producto> productos;
    private String formaPago;

    public Pedido(Cliente cliente, List<Producto> productos, String formaPago) {
        if (!"efectivo".equals(formaPago)
                && !"6 cuotas".equals(formaPago)
                && !"12 cuotas".equals(formaPago)) {
            throw new Error("Forma de pago incorrecta");
        }
        this.cliente = cliente;
        this.productos = productos;
        this.formaPago = formaPago;
    }

    public double getCostoTotal() {
        double costoProductos = productos.stream().mapToDouble(producto -> producto.getPrecio()).ssum();
        double extraFormaPago = 0;
        if ("efectivo".equals(this.formaPago)) {
            extraFormaPago = 0;
        } else if ("6 cuotas".equals(this.formaPago)) {
            extraFormaPago = costoProductos * 0.2;
        } else if ("12 cuotas".equals(this.formaPago)) {
            extraFormaPago = costoProductos * 0.5;
        }
        int añosDesdeFechaAlta = Period.between(this.cliente.getFechaAlta(), LocalDate.now()).getYears();
        // Aplicar descuento del 10% si el cliente tiene más de 5 años de antigüedad
        if (añosDesdeFechaAlta > 5) {
            return (costoProductos + extraFormaPago) * 0.9;
        }
        return costoProductos + extraFormaPago;
    }
}

public class Cliente {
    private LocalDate fechaAlta;

    public LocalDate getFechaAlta() {
        return this.fechaAlta;
    }
}

public class Producto {
    private double precio;

    public double getPrecio() {
        return this.precio;
    }
}
```
### Replace Conditional with Polymorphism 

```java
public class Pedido {
    private Cliente cliente;
    private List<Producto> productos;
    private FormaDePago formaPago;

    public Pedido(Cliente cliente, List<Producto> productos, String formaPago) {
        if (!"efectivo".equals(formaPago)
                && !"6 cuotas".equals(formaPago)
                && !"12 cuotas".equals(formaPago)) {
            throw new Error("Forma de pago incorrecta");
        }
        this.cliente = cliente;
        this.productos = productos;
        this.formaPago = formaPago;
    }

    public double getCostoTotal() {
        double costoProductos = productos.stream().mapToDouble(producto -> producto.getPrecio()).ssum();
        double extraFormaPago = this.formaPago.Recargo();
        int añosDesdeFechaAlta = Period.between(this.cliente.getFechaAlta(), LocalDate.now()).getYears();
        // Aplicar descuento del 10% si el cliente tiene más de 5 años de antigüedad
        if (añosDesdeFechaAlta > 5) {
            return (costoProductos + extraFormaPago) * 0.9;
        }
        return costoProductos + extraFormaPago;
    }
}

public class Cliente {
    private LocalDate fechaAlta;

    public LocalDate getFechaAlta() {
        return this.fechaAlta;
    }
}

public class Producto {
    private double precio;

    public double getPrecio() {
        return this.precio;
    }
}

public interface FormaDePago {

    public double Recargo();
}

public class efectivo implements FormaDePago {
    
    public double Recargo(){
        return 0;
    }
}

public class cuotas_6 implements FormaDePago {
    
    public double Recargo(){
        return 0.2;
    }
}

public class cuotas_12 implements FormaDePago {
    
    public double Recargo(){
        return 0.5;
    }
}
```

### Extract method y Move Method

```java
public class Pedido {
    private Cliente cliente;
    private List<Producto> productos;
    private FormaDePago formaPago;

    public Pedido(Cliente cliente, List<Producto> productos, String formaPago) {
        if (!"efectivo".equals(formaPago)
                && !"6 cuotas".equals(formaPago)
                && !"12 cuotas".equals(formaPago)) {
            throw new Error("Forma de pago incorrecta");
        }
        this.cliente = cliente;
        this.productos = productos;
        this.formaPago = formaPago;
    }

    public double getCostoTotal() {
        double costoProductos = productos.stream().mapToDouble(producto -> producto.getPrecio()).ssum();
        double extraFormaPago = this.formaPago.Recargo();
        // Aplicar descuento del 10% si el cliente tiene más de 5 años de antigüedad
        if (this.cliente.añosDesdeFechaAlta() > 5) {
            return (costoProductos + extraFormaPago) * 0.9;
        }
        return costoProductos + extraFormaPago;
    }
}

public class Cliente {
    private LocalDate fechaAlta;

    public LocalDate getFechaAlta() {
        return this.fechaAlta;
    }
    public int añosDesdeFechaAlta(){
        return Period.between(this.cliente.getFechaAlta(), LocalDate.now()).getYears();
    }
}

public class Producto {
    private double precio;

    public double getPrecio() {
        return this.precio;
    }
}

public interface FormaDePago {

    public double Recargo();
}

public class efectivo implements FormaDePago {
    
    public double Recargo(){
        return 0;
    }
}

public class cuotas_6 implements FormaDePago {
    
    public double Recargo(){
        return 0.2;
    }
}

public class cuotas_12 implements FormaDePago {
    
    public double Recargo(){
        return 0.5;
    }
}
```

### Extract Method y Replace Temp with Queary

```java
public class Pedido {
    private Cliente cliente;
    private List<Producto> productos;
    private FormaDePago formaPago;

    public Pedido(Cliente cliente, List<Producto> productos, String formaPago) {
        if (!"efectivo".equals(formaPago)
                && !"6 cuotas".equals(formaPago)
                && !"12 cuotas".equals(formaPago)) {
            throw new Error("Forma de pago incorrecta");
        }
        this.cliente = cliente;
        this.productos = productos;
        this.formaPago = formaPago;
    }

    public double getCostoTotal() {
        double costoProductos = productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
        double extraFormaPago = this.formaPago.Recargo();
        // Aplicar descuento del 10% si el cliente tiene más de 5 años de antigüedad
        return this.calcularDescuento(costoProductos,extraFormaPago);
    }
    
    public double calcularDescuento(double costoProductos, double extraFormaPago){
        if (this.cliente.añosDesdeFechaAlta() > 5) {
            return (costoProductos + extraFormaPago) * 0.9;
        }
        return costoProductos + extraFormaPago;
    }
}

public class Cliente {
    private LocalDate fechaAlta;

    public LocalDate getFechaAlta() {
        return this.fechaAlta;
    }
    public int añosDesdeFechaAlta(){
        return Period.between(this.cliente.getFechaAlta(), LocalDate.now()).getYears();
    }
}

public class Producto {
    private double precio;

    public double getPrecio() {
        return this.precio;
    }
}

public interface FormaDePago {

    public double Recargo();
}

public class efectivo implements FormaDePago {
    
    public double Recargo(){
        return 0;
    }
}

public class cuotas_6 implements FormaDePago {
    
    public double Recargo(){
        return 0.2;
    }
}

public class cuotas_12 implements FormaDePago {
    
    public double Recargo(){
        return 0.5;
    }
}
```