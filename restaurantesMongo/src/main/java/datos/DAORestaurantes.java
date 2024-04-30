package datos;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import modelos.Restaurante;

public class DAORestaurantes {
    
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    public DAORestaurantes() {
        mongoClient = new MongoClient();
        database = mongoClient.getDatabase("as20");
        collection = database.getCollection("Restaruantes");
    }

    public void insertarRestaurante(Restaurante restaurante) {
        Document doc = new Document();
        doc.append("nombre", restaurante.getNombre());
        doc.append("rating", restaurante.getRating());
        doc.append("fecha", restaurante.getFecha());
        doc.append("categorias", restaurante.getCategorias());
        collection.insertOne(doc);
    }

    public void insertarRestaurantes(ArrayList<Restaurante> restaurantes) {
        for (Restaurante restaurante : restaurantes) {
            insertarRestaurante(restaurante);
        }
    }
    
    public ArrayList<Restaurante> obtenerRestaurantes() {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        MongoCursor <Document> cursor = collection.find().iterator();
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
    
    public ArrayList<Restaurante> consultarRestaurantesRating (int rating){
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Document doc = new Document();
        doc.append("rating", rating);
        MongoCursor <Document> cursor = collection.find(doc).iterator();
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

    public ArrayList<Restaurante> consultarRestauranteMenorQueRating (int rating){
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Document doc = new Document();
        doc.append("rating", new Document("$lt", rating));
        MongoCursor <Document> cursor = collection.find(doc).iterator();
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

    public ArrayList<Restaurante> consultarRestauranteMayorQueRating (int rating){
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Document doc = new Document();
        doc.append("rating", new Document("$gt", rating));
        MongoCursor <Document> cursor = collection.find(doc).iterator();
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

    public ArrayList<Restaurante> consultarRestauranteMenorIgualQueRating (int rating){
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Document doc = new Document();
        doc.append("rating", new Document("$lte", rating));
        MongoCursor <Document> cursor = collection.find(doc).iterator();
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

    public ArrayList<Restaurante> consultarRestauranteMayorIgualQueRating (int rating){
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Document doc = new Document();
        doc.append("rating", new Document("$gte", rating));
        MongoCursor <Document> cursor = collection.find(doc).iterator();
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
}
