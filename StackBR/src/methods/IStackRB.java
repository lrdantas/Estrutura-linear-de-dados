/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import exception.IsStackEmpty;

/**
 *
 * @author Luis
 */
public interface IStackRB {
    
    public int size();
    
    public void pushRed(Object o);
    
    public void pushBlack(Object o);
    
    public Object popRed() throws IsStackEmpty;
    
    public Object popBlack() throws IsStackEmpty;
    
    public Object topRed() throws IsStackEmpty;
    
    public Object topBlack() throws IsStackEmpty;
    
    public boolean isEmpty();
    
    public boolean isEmptyRed();
    
    public boolean isEmptyBlack();
    
    public int sizeRed();
    
    public int sizeBlack();
    
    
}
