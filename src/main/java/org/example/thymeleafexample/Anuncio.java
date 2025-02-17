package org.example.thymeleafexample;

public class Anuncio {
    private String nombre;
    private String asunto;
    private String descripcion;
    private String tipo; // Misión, Evento, Mercado, Noticia
    private boolean completado; // Estado del anuncio

    // Constructor, getters y setters
    public Anuncio(String nombre, String asunto, String descripcion, String tipo) {
        this.nombre = nombre;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.completado = false; // Por defecto, el anuncio no está completado
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}
