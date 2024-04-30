/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package bda.itson.restaurantesmongo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

import datos.DAORestaurantes;
import modelos.Restaurante;

/**
 *
 * @author ID145
 */
public class RestaurantesMongo {

    public static void main(String[] args) {
        // Insertar 3 documentos (restaurantes) más con al menos 2 categorías cada uno.
        DAORestaurantes dao = new DAORestaurantes();
        /* 
        Restaurante r1 = new Restaurante("Sushilito", 5, new Date(), new String[]{"Sushi", "Japonesa"});
        Restaurante r2 = new Restaurante("Pizza Hut", 4, new Date(), new String[]{"Pizza", "Italiana"});
        Restaurante r3 = new Restaurante("McDonald's", 3, new Date(), new String[]{"Hamburguesas", "Rápida"});
        
        dao.insertarRestaurante(r1);
        dao.insertarRestaurante(r2);
        dao.insertarRestaurante(r3);
        */

        // Consultar los restaurantes con más de 4 estrellas de rating.
        
        /*
        for (Restaurante restaurante : dao.consultarRestauranteMayorQueRating(4)) {
            System.out.println(restaurante);
        }
        */


        // Consultar los restaurantes que incluyan la categoría pizza.
        /* 
        for (Restaurante restaurante : dao.consultarRestauranteCategoria("Pizza")) {
            System.out.println(restaurante);
        }
        */

        // Consultar los restaurantes que incluyan sushi en su nombre.
        /* 
        for (Restaurante restaurante : dao.consultarRestauranteNombre("Sushi")) {
            System.out.println(restaurante);
        }
        */

        // Agregar una categoría extra al restaurant sushilito.

        /* 
        dao.agregarCategoriaExtra("Sushilito", "Rapida");
        */

        // Eliminar un restaurante por su identificador.
        /*
        dao.eliminarRestauranteId(new ObjectId("6630a53895061f8424c63080"));
        */

        //  Eliminar los restaurantes con 3 estrellas o menos.

        ArrayList<Restaurante> restaurantes = dao.consultarRestauranteMenorIgualQueRating(3);
        dao.eliminarRestaurantes(restaurantes);

    }
}
