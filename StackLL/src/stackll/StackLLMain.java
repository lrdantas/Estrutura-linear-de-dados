/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackll;

import exception.IsStackEmpty;
import methods.Stack;

/**
 *
 * @author rodrigo
 */
public class StackLLMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IsStackEmpty {
        
        Stack pilha = new Stack();
        
        pilha.push("Elemento 1");
        pilha.push("Elemento 2");
        pilha.push("Elemento 3");
        pilha.push("Elemento 4");
        pilha.push("Elemento 5");
        
        while(!pilha.isEmpty()){
            System.out.println("Retirando elemento: " + pilha.pop());
        }
    }
    
}
