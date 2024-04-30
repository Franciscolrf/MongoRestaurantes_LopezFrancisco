/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.Date;

import org.bson.types.ObjectId;

/**
 *
 * @author ID145
 */
public class Restaurante {
    private ObjectId id;
    private String nombre;
    private int rating;
    private Date fecha;
    private String categorias[];

    public Restaurante() {
    }

    public Restaurante(ObjectId id, String nombre, int rating, Date fecha, String categorias[]) {
        this.id = id;
        this.nombre = nombre;
        this.rating = rating;
        this.fecha = fecha;
        this.categorias = categorias;

    }

    public Restaurante(String nombre, int rating, Date fecha, String categorias[]) {
        this.nombre = nombre;
        this.rating = rating;
        this.fecha = fecha;
        this.categorias = categorias;

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String[] getCategorias() {
        return categorias;
    }

    public void setCategorias(String[] categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return "Restaurantes{" + "id=" + id + ", nombre=" + nombre + ", rating=" + rating + ", fecha=" + fecha + ", categorias=" + categorias + '}';
    }

}
