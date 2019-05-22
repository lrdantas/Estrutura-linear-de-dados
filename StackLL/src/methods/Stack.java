/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import exception.IsStackEmpty;

/**Class for entity Node
* @author Luis Rodrigo Dantas da Silva
* @version 1.0
* @since Release 01
*/


public class Stack implements IStack{
    
    private int count = 0;
    
    private Node no = null;
    
    
    /** Method to return size of stack.
    *   @return int - size of stack*/

    @Override
    public int size() {
        return count;
    }
    
    
    /** Method to push node in the stack.
    *   @param o Object - set object*/

    @Override
    public void push(Object o) {
        this.count++;
        this.no = new Node(o, this.no); // new node -> object + reference of previous node.
        
    }
    
    
    /** Method to pop node in the stack.
    *   @return Object - Object removed*/

    @Override
    public Object pop() throws IsStackEmpty {
        if(isEmpty()){
            throw new IsStackEmpty("A Pilha está vazia");        
        }
        count--;
        Object temp = this.no.getO();
        Node tempc = this.no.getBefore();
        this.no.setBefore(null);
        this.no = tempc;
        return temp;
   
    }
    
    
    /** Method to show top node in the stack.
    *   @return Object - Object of top node*/

    @Override
    public Object top() throws IsStackEmpty {
        if(isEmpty()){
            throw new IsStackEmpty("A Pilha está vazia");        
        }
        return this.no.getO();
    }
    
    
    /** Method to show if stack is empty.
    *   @return boolean - condicional on stack size*/

    @Override
    public boolean isEmpty() {
        return this.no == null;
    }
    
}
