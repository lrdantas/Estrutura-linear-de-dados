/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

/**
 *
 * @author rodrigo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Heap heap = new Heap(16);
        
        heap.insert(1);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(7);
        heap.insert(10);
        heap.insert(2);
        heap.insert(18);
        heap.insert(-1);
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        
        int[] lista = heap.getList();
        
        for(int i = 0; i < lista.length -1; i++){
            System.out.println("Lista:  :" + lista[i]);
        }
        
    }
    
}
