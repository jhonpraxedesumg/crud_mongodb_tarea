package org.example.crud;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.List;

public class ClsTelefonos {
    public void agregarTelefono(){
        TelefonoDTO telefono= new TelefonoDTO();
        telefono.setNombre("Monica");
        telefono.setCorreo("Monica@example.com");
        telefono.setIdTelegram(123456789);
        telefono.

        Document document = new Document("Nombre",usuario.getCorreo())
                .append("correo",usuario.getCorreo())
                .append("IdTelegram",usuario.getIdTelegram());
        collection.insertOne(document);
        System.out.println("Usuario Creado");
    }
    public void leerUsuario(){
        List<mdUsuario> usuarios=new ArrayList<>();
        for (Document doc: collection.find()){
            mdUsuario u = new mdUsuario();
            u.setIdTelegram(doc.getLong("idTelegram"));
            u.setNombre(doc.getString("nombre"));
            u.setCorreo(doc.getString("correo"));
            usuarios.add(u);
        }
        for (mdUsuario u: usuarios){
            System.out.println("usuario:"+u.getNombre()+"correo:"= u.getCorreo());
        }
    }
    private  void actualizarUsuario() {
        collection.updateOne(Filters.eq("idTelegram", 88745587),
                Updates.set("correo", "Nuevo@example.com"));
        System.out.println("Usuario actualizado");
    }

    private  void eliminarUsuario() {
        collection.deleteOne(Filters.eq("idTelegram", 9995587));
        System.out.println("Usuario eliminado");
    }

    private  void desconectarMongoDB() {
        // Cerrar la conexión
        mongoClient.close();
        System.out.println("Desconectado de MongoDB");
    }
}
