/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Exception.EEmptyQueue;
import methods.Queue;

/**
 *
 * @author Luis
 */
public class QueueMain {

    /**
     * @param args the command line arguments
     * @throws Exception.EEmptyQueue
     */
    public static void main(String[] args) throws EEmptyQueue {
        Queue fila = new Queue();
        
        fila.enqueue("Objeto 1");
        fila.enqueue("Objeto 2");
        fila.enqueue("Objeto 3");
        fila.enqueue("Objeto 4");
        fila.enqueue("Objeto 5");
        fila.enqueue("Objeto 6");
        
        while (!fila.isEmpty()) {
            System.out.println("Fila: " + fila.first());
            fila.dequeue();
            
        }
            
    }
 }
    

