/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import Exception.EEmptyQueue;
import model.Node;

/**
 *
 * @author Luis
 */
public class Queue implements IQueue{
    
    private Node root = null;
    private Node node = null;
    private int count = 0;

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() throws EEmptyQueue {
        return count == 0;
    }

    @Override
    public Object first() throws EEmptyQueue {
        return this.root.getO();
    }

    @Override
    public void enqueue(Object o) {
        Node temp = new Node(null, o);       
        
        if(root == null){
            this.node = temp;
            this.root = this.node;
        }
        else{
            node.setNext(temp);
            node = temp;
            
        }
        
        count++;
    }

    @Override
    public Object dequeue() throws EEmptyQueue {
        Object temp = this.root.getO();
        this.root = this.root.getNext();
        
        count--;
        return temp;
    }
    
    
}
