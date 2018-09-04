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
        fila.enqueue("elemento7");
        fila.enqueue("elemento8");
        fila.enqueue("elemento9");
        fila.enqueue("elemento10");
        fila.enqueue("elemento11");
        fila.enqueue("elemento12");
        fila.enqueue("elemento13");
        fila.enqueue("elemento14");
        fila.enqueue("elemento15");
        fila.enqueue("elemento16");
        fila.enqueue("elemento17");
        fila.enqueue("elemento18");
        
        while (!fila.isEmpty()) {
            System.out.println("Elemento removido: " + fila.first());
            fila.dequeue();
                       
        }
    }
    
}
