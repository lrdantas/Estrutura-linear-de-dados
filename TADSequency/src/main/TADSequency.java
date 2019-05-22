/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import business.Node;
import business.Sequency;

/**
 *
 * @author Luis
 */
public class TADSequency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Sequency lista=new Sequency();
        
        lista.insertAtRank(0, 1);
        lista.insertAtRank(0, 2);
        lista.insertAtRank(0, 3);
        
        System.out.println(lista.elemAtRank(0));
        
        
    }
    
}
