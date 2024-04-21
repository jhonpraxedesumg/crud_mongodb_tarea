package org.example.crud;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import org.bson.Document;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ClsTelefonos {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public void conexion() {
        //cadena de conexion, contiene la información de la insalacion del mongodb
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

        //se crean las configuraciones especificas para conexion y manejo de la base de datos
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("miBasedatos");
        collection = database.getCollection("telefono");
        System.out.println("conexion realizada");

    }

    public void agregarTelefono(){
        TelefonoDTO telefono= new TelefonoDTO();

        telefono.setMarca(JOptionPane.showInputDialog("ingrese marca ="));
        telefono.setModelo(JOptionPane.showInputDialog("ingrese modelo ="));
        telefono.setSisOperativo(JOptionPane.showInputDialog("ingrese SO ="));

//        Document documento = new Document("marca",telefono.getMarca())
//                .append("modelo",telefono.setModelo())
//                .append("sisOperativo",telefono.getSisOperativo());
        Document documento = new Document("marca",telefono.getMarca())
                .append("modelo",telefono.getModelo())
                .append("sisOperativo",telefono.getSisOperativo());

        collection.insertOne(documento);
        System.out.println("usuario creado");
        }


    }


