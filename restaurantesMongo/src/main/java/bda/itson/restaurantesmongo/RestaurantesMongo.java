/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package bda.itson.restaurantesmongo;

import java.util.Date;

import datos.DAORestaurantes;
import modelos.Restaurante;

/**
 *
 * @author ID145
 */
public class RestaurantesMongo {

    public static void main(String[] args) {
        // Insertar 3 documentos (restaurantes) más con al menos 2 categorías cada uno.
        Restaurante r1 = new Restaurante("Sushilito", 5, new Date(), new String[]{"Sushi", "Japonesa"});
        Restaurante r2 = new Restaurante("Pizza Hut", 4, new Date(), new String[]{"Pizza", "Italiana"});
        Restaurante r3 = new Restaurante("McDonald's", 3, new Date(), new String[]{"Hamburguesas", "Rápida"});


        // Consultar los restaurantes con más de 4 estrellas de rating.
        //DAORestaurantes dao = new DAORestaurantes();
        //dao.consultarRestauranteMayorIgualQueRating(4);


        // Consultar los restaurantes que incluyan la categoría pizza.
        // Consultar los restaurantes que incluyan sushi en su nombre.
        // Agregar una categoría extra al restaurant sushilito.
        // Eliminar un restaurante por su identificador.
        // Eliminar los restaurantes con 3 estrellas o menos.
    }
}
