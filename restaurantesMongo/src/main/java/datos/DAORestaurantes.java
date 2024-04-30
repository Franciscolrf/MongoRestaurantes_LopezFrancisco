package datos;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import java.util.Arrays;
import java.util.Date;

import modelos.Restaurante;

public class DAORestaurantes {

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    public DAORestaurantes() {
        mongoClient = new MongoClient();
        database = mongoClient.getDatabase("asigrest");
        collection = database.getCollection("restaurantes");
    }

    public void insertarRestaurante(Restaurante restaurante) {
        Document docRestaurante = new Document("nombre", restaurante.getNombre())
                .append("rating", restaurante.getRating())
                .append("fecha", restaurante.getFecha())
                .append("categorias", Arrays.asList(restaurante.getCategorias()));

        collection.insertOne(docRestaurante);
    }

    public void insertarRestaurantes(ArrayList<Restaurante> restaurantes) {
        for (Restaurante restaurante : restaurantes) {
            insertarRestaurante(restaurante);
        }
    }

    public ArrayList<Restaurante> obtenerRestaurantes() {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Restaurante restaurante = new Restaurante();
                restaurante.setNombre(doc.getString("nombre"));
                restaurante.setRating(doc.getInteger("rating"));
                restaurante.setFecha(doc.getDate("fecha"));
                ArrayList<String> categorias = (ArrayList<String>) doc.get("categorias");
                restaurante.setCategorias(categorias.toArray(new String[categorias.size()]));
                restaurantes.add(restaurante);
            }
        } finally {
            cursor.close();
        }
        return restaurantes;
    }

    public void eliminarRestaurante(String nombre) {
        Document doc = new Document();
        doc.append("nombre", nombre);
        collection.deleteOne(doc);
    }

    public ArrayList<Restaurante> consultarRestaurantesRating(int rating) {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Document doc = new Document();
        doc.append("rating", rating);
        MongoCursor<Document> cursor = collection.find(doc).iterator();
        try {
            while (cursor.hasNext()) {
                Document doc2 = cursor.next();
                Restaurante restaurante = new Restaurante();
                restaurante.setNombre(doc2.getString("nombre"));
                restaurante.setRating(doc2.getInteger("rating"));
                restaurante.setFecha(doc2.getDate("fecha"));
                ArrayList<String> categorias = (ArrayList<String>) doc2.get("categorias");
                restaurante.setCategorias(categorias.toArray(new String[categorias.size()]));
                restaurantes.add(restaurante);
            }
        } finally {
            cursor.close();
        }
        return restaurantes;

    }

    public ArrayList<Restaurante> consultarRestauranteMenorQueRating(int rating) {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Document doc = new Document();
        doc.append("rating", new Document("$lt", rating));
        MongoCursor<Document> cursor = collection.find(doc).iterator();
        try {
            while (cursor.hasNext()) {
                Document doc2 = cursor.next();
                Restaurante restaurante = new Restaurante();
                restaurante.setNombre(doc2.getString("nombre"));
                restaurante.setRating(doc2.getInteger("rating"));
                restaurante.setFecha(doc2.getDate("fecha"));
                ArrayList<String> categorias = (ArrayList<String>) doc2.get("categorias");
                restaurante.setCategorias(categorias.toArray(new String[categorias.size()]));
                restaurantes.add(restaurante);
            }
        } finally {
            cursor.close();
        }
        return restaurantes;

    }

    public ArrayList<Restaurante> consultarRestauranteMayorQueRating(int rating) {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Document doc = new Document();
        doc.append("rating", new Document("$gt", rating));
        MongoCursor<Document> cursor = collection.find(doc).iterator();
        try {
            while (cursor.hasNext()) {
                Document doc2 = cursor.next();
                Restaurante restaurante = new Restaurante();
                restaurante.setNombre(doc2.getString("nombre"));
                restaurante.setRating(doc2.getInteger("rating"));
                restaurante.setFecha(doc2.getDate("fecha"));
                ArrayList<String> categorias = (ArrayList<String>) doc2.get("categorias");
                restaurante.setCategorias(categorias.toArray(new String[categorias.size()]));
                restaurantes.add(restaurante);
            }
        } finally {
            cursor.close();
        }
        return restaurantes;

    }

    public ArrayList<Restaurante> consultarRestauranteMenorIgualQueRating(int rating) {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Document doc = new Document();
        doc.append("rating", new Document("$lte", rating));
        MongoCursor<Document> cursor = collection.find(doc).iterator();
        try {
            while (cursor.hasNext()) {
                Document doc2 = cursor.next();
                Restaurante restaurante = new Restaurante();
                restaurante.setNombre(doc2.getString("nombre"));
                restaurante.setRating(doc2.getInteger("rating"));
                restaurante.setFecha(doc2.getDate("fecha"));
                ArrayList<String> categorias = (ArrayList<String>) doc2.get("categorias");
                restaurante.setCategorias(categorias.toArray(new String[categorias.size()]));
                restaurantes.add(restaurante);
            }
        } finally {
            cursor.close();
        }
        return restaurantes;

    }

    public ArrayList<Restaurante> consultarRestauranteMayorIgualQueRating(int rating) {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Document doc = new Document();
        doc.append("rating", new Document("$gte", rating));
        MongoCursor<Document> cursor = collection.find(doc).iterator();
        try {
            while (cursor.hasNext()) {
                Document doc2 = cursor.next();
                Restaurante restaurante = new Restaurante();
                restaurante.setNombre(doc2.getString("nombre"));
                restaurante.setRating(doc2.getInteger("rating"));
                restaurante.setFecha(doc2.getDate("fecha"));
                ArrayList<String> categorias = (ArrayList<String>) doc2.get("categorias");
                restaurante.setCategorias(categorias.toArray(new String[categorias.size()]));
                restaurantes.add(restaurante);
            }
        } finally {
            cursor.close();
        }
        return restaurantes;

    }

    public void editarRestaurante(String nombre, Restaurante restaurante) {
        Document doc = new Document();
        doc.append("nombre", nombre);
        Document doc2 = new Document();
        doc2.append("nombre", restaurante.getNombre());
        doc2.append("rating", restaurante.getRating());
        doc2.append("fecha", restaurante.getFecha());
        doc2.append("categorias", restaurante.getCategorias());
        collection.updateOne(doc, new Document("$set", doc2));
    }

    public void agregarCategoriaExtra(String nombreRestaurante, String nuevaCategoria) {
        Document filtro = new Document("nombre", nombreRestaurante);

        Document actualizacion = new Document("$push", new Document("categorias", nuevaCategoria));

        collection.updateOne(filtro, actualizacion);
    }

    public ArrayList<Restaurante> consultarRestauranteCategoria(String categoria) {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Document doc = new Document();
        doc.append("categorias", categoria);
        MongoCursor<Document> cursor = collection.find(doc).iterator();
        try {
            while (cursor.hasNext()) {
                Document doc2 = cursor.next();
                Restaurante restaurante = new Restaurante();
                restaurante.setNombre(doc2.getString("nombre"));
                restaurante.setRating(doc2.getInteger("rating"));
                restaurante.setFecha(doc2.getDate("fecha"));
                ArrayList<String> categorias = (ArrayList<String>) doc2.get("categorias");
                restaurante.setCategorias(categorias.toArray(new String[categorias.size()]));
                restaurantes.add(restaurante);
            }
        } finally {
            cursor.close();
        }
        return restaurantes;
    }

    public ArrayList<Restaurante> consultarRestauranteNombre(String nombre) {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Document query = new Document("nombre", new Document("$regex", nombre).append("$options", "i"));

        MongoCursor<Document> cursor = collection.find(query).iterator();

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Restaurante restaurante = new Restaurante();
                restaurante.setNombre(doc.getString("nombre"));
                restaurante.setRating(doc.getInteger("rating"));
                restaurante.setFecha(doc.getDate("fecha"));
                ArrayList<String> categorias = (ArrayList<String>) doc.get("categorias");
                restaurante.setCategorias(categorias.toArray(new String[categorias.size()]));
                restaurantes.add(restaurante);
            }
        } finally {
            cursor.close();
        }

        return restaurantes;
    }

    public void eliminarRestauranteId(ObjectId id) {
        Bson filtro = Filters.eq("_id", id);

        collection.deleteOne(filtro);
    }

    public void eliminarRestaurantes(ArrayList<Restaurante> restaurantes) {
        for (Restaurante restaurante : restaurantes) {
            eliminarRestaurante(restaurante.getNombre());
        }
    }
}
