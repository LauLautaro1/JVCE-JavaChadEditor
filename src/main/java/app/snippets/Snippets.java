package app.snippets;

import java.util.Objects;

public class Snippets {
    private String key;
    private String value;
    private String descripcion;
    private String paquete;

    // Constructor
    
    public Snippets() {}
    
    public Snippets(String key, String value, String descripcion, String paquete) {
        this.key = key;
        this.value = value;
        this.descripcion = descripcion;
        this.paquete = paquete;
    }

    // Getters y Setters
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snippets snippet = (Snippets) o;
        return Objects.equals(key, snippet.key) && 
               Objects.equals(paquete, snippet.paquete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, paquete);
    }

    // Método toString
    @Override
    public String toString() {
        return "Snippet{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", paquete='" + paquete + '\'' +
                '}';
    }
}
