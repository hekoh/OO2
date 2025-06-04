# Ejercicio 3

```java 
public class Document {
    List<String> words;
    public long characterCount() {
        long count = this.words
        .stream()
        .mapToLong(w -> w.length())
        .sum();
        return count;
    }
    public long calculateAvg() {
        long avgLength = this.words
        .stream()
        .mapToLong(w -> w.length())
        .sum() / this.words.size();
        return avgLength;
    }
    // Resto del código que no importa
}
```
### Primer Olor: en ambos metodos se crea una variable temporal solo para devolver el resultado. 
¿long method? consultar
Solucion: Inline temp

```java 
public class Document {
    List<String> words;
    public long characterCount() {
        return this.words
        .stream()
        .mapToLong(w -> w.length())
        .sum();
    }
    public long calculateAvg() {
        return this.words
        .stream()
        .mapToLong(w -> w.length())
        .sum() / this.words.size();
    }
    // Resto del código que no importa
}
```

### Segundo Olor: Se repite codigo que ya esta en otro metodo. Duplicate Code
Solucion: Extract Method

```java 
public class Document {
    List<String> words;
    public long characterCount() {
        return this.words
        .stream()
        .mapToLong(w -> w.length())
        .sum();
    }
    public long calculateAvg() {
        return this.characterCount() / this.words.size();
    }
    // Resto del código que no importa
}
```

### Tercer Olor: La variable `words` no es privada. Rompe el encapsulamiento
Solucion: Encapsulate Field
```java 
public class Document {
    private List<String> words;
    public long characterCount() {
        return this.words
        .stream()
        .mapToLong(w -> w.length())
        .sum();
    }
    public long calculateAvg() {
        return this.characterCount() / this.words.size();
    }
    // Resto del código que no importa
}
```

## 3. Errores

Primer Error: Si el documento esta vacio el metodo `calculateAvg` divide por 0.

Segundo Error: El metodo `calculateAvg` deberia devolver double, el resultado de la division no se puede transformar a long

Ninguno de los dos errores es corregido por el refactoring, ya que este proceso no cambia la funcionalidad del codigo.