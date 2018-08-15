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
public interface IStack {
    
    public int size();
    
    public void push(Object o);
    
    public Object pop() throws IsStackEmpty;
    
    public Object top() throws IsStackEmpty;
    
    public boolean isEmpty();
    
}
