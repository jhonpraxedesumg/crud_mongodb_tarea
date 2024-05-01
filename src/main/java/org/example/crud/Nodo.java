package org.example.crud;

import org.bson.Document;

public class Nodo {
    Document data;
    Nodo next;

    public Nodo(Document data) {
        this.data = data;
        this.next = null;
    }
}

