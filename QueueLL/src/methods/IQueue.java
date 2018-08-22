/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import Exception.EEmptyQueue;

/**
 *
 * @author Luis
 */
public interface IQueue {
    
    public int size();
    public boolean isEmpty() throws EEmptyQueue;
    public Object first() throws EEmptyQueue;
    public void enqueue(Object o);
    public Object dequeue() throws EEmptyQueue; 
    
}
