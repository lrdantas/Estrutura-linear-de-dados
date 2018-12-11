/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

/**
 *
 * @author rodrigo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HashTable hash = new HashTable(15);
        
        
        hash.insert(12, 6);
        hash.insert(6, 8);
        hash.insert(13, 2423);
        hash.insert(88, 23);
        hash.insert(23, 12333);
        hash.insert(94, 1);
        hash.insert(3, 23);
        hash.insert(39, 34534);
        
        hash.removeElement(44);
        
        hash.listar();
        
    }
    
}
