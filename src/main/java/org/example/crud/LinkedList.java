package org.example.crud;

import org.bson.Document;

public class LinkedList {
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
}
