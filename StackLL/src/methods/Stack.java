/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import exception.IsStackEmpty;

/**
 *
 * @author rodrigo
 */
public class Stack implements IStack{
    
    private int count = 0;
    
    private Node no = null;

    @Override
    public int size() {
        return count;
    }

    @Override
    public void push(Object o) {
        this.count++;
        this.no = new Node(o, this.no);
        
    }

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

    @Override
    public Object top() throws IsStackEmpty {
        if(isEmpty()){
            throw new IsStackEmpty("A Pilha está vazia");        
        }
        return this.no.getO();
    }

    @Override
    public boolean isEmpty() {
        return this.no == null;
    }
    
}
