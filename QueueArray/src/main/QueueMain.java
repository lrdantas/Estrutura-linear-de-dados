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
     */
    public static void main(String[] args) throws EEmptyQueue {
        // TODO code application logic here
        
        Queue fila = new Queue();
        
        fila.enqueue("elemento1");
        fila.enqueue("elemento2");
        fila.enqueue("elemento3");
        fila.enqueue("elemento4");
        fila.enqueue("elemento5");
        fila.enqueue("elemento6");
              fila.enqueue("elemento1");
        fila.enqueue("elemento2");
        fila.enqueue("elemento3");
        fila.enqueue("elemento4");
        fila.enqueue("elemento5");
        fila.enqueue("elemento6");
              fila.enqueue("elemento1");
        fila.enqueue("elemento2");
        fila.enqueue("elemento3");
        fila.enqueue("elemento4");
        fila.enqueue("elemento5");
        fila.enqueue("elemento6");
        
        while (!fila.isEmpty()) {
            System.out.println("Elemento removido: " + fila.first());
            fila.dequeue();
            
            
        }
    }
    
}
