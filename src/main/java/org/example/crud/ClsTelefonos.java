package org.example.crud;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import org.bson.Document;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static jdk.internal.org.jline.utils.AttributedStringBuilder.append;

public class ClsTelefonos {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    Nodo head;

    public void add(Document data) {
        Nodo newNode = new Nodo(data);
        if (head == null) {
            head = newNode;
        } else {
            Nodo last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    public void printList() {
        Nodo currNode = head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data.toJson() + " ");
            currNode = currNode.next;
        }
    }

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

    public void agregarTelefono() {
        TelefonoDTO telefono = new TelefonoDTO();

        telefono.setMarca(JOptionPane.showInputDialog("ingrese marca ="));
        telefono.setModelo(JOptionPane.showInputDialog("ingrese modelo ="));
        telefono.setSisOperativo(JOptionPane.showInputDialog("ingrese SO ="));
        telefono.setSizePantalla(Double.parseDouble(JOptionPane.showInputDialog("ingrese tamano de pantalla =")));
        telefono.setMemoriaRAM(Double.parseDouble(JOptionPane.showInputDialog("ingrese memoriaRAM=")));

        telefono.setAlmacenamiento(Double.parseDouble(JOptionPane.showInputDialog("ingrese Almacenamiento =")));
        telefono.setCamara(Boolean.parseBoolean(JOptionPane.showInputDialog("tiene camara ")));
        telefono.setResolucionCamara(Double.parseDouble(JOptionPane.showInputDialog("resolucion")));
        telefono.setSmartphone(Boolean.parseBoolean(JOptionPane.showInputDialog("es smartphone")));
        telefono.setImei(JOptionPane.showInputDialog("IMEI"));


//        Document documento = new Document("marca",telefono.getMarca())
//                .append("modelo",telefono.setModelo())
//                .append("sisOperativo",telefono.getSisOperativo());
        Document documento = new Document("marca", telefono.getMarca())
                .append("modelo", telefono.getModelo())
                .append("sisOperativo", telefono.getSisOperativo())
                .append("sizePantalla", telefono.getSizePantalla())
                .append("memoriaRAM", telefono.getMemoriaRAM())
                .append("Almacenamiento", telefono.getAlmacenamiento())
                .append("camara ", telefono.isCamara())
                .append("Resolucion ", telefono.getResolucionCamara())
                .append("es smartphone", telefono.isSmartphone())
                .append("imei", telefono.getImei());

        collection.insertOne(documento);
        System.out.println("Registro creado");
    }

    public void MostrarTelefonos(){
//        List<TelefonoDTO>documento=new ArrayList<>();
//        for (Document doc: collection.find()){
//            TelefonoDTO u = new TelefonoDTO();
//
//            u.setMarca(doc.getString("marca"));
//            u.setModelo(doc.getString("modelo"));
//            u.setSisOperativo(doc.getString("sisOperativo"));
//            u.setSizePantalla(doc.getDouble("sizePantalla"));
////            u.setMarca(doc.getDouble("memoriaRAM"));
////            u.setMarca(doc.getDouble("almacenamiento"));
////            u.setMarca(doc.getBoolean("camara"));
////            u.setMarca(doc.getDouble("resolucionCamara"));
////            u.setMarca(doc.getBoolean("smartphone"));
////            u.setMarca(doc.getString("imei"));
//            documento.add(u);
//        }
//        for (TelefonoDTO u: documento){
//            System.out.println("marca ="+u.getMarca()+"modelo"+u.getModelo());
//        }

        MongoCursor<Document> cursor = collection.find().iterator();

        try {
            while (cursor.hasNext()) {
                // Imprimimos cada documento
                System.out.println(cursor.next().toJson());
            }
        } finally {
            // Cerramos el cursor
            cursor.close();
        }
    }


}



