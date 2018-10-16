/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.util.Iterator;

/**
 *
 * @author rodrigo
 */
public interface IHashTable {
    
    public Object findElement(int k); 
    public void insertItem(int k, Object o); 
    public Object removeElement(int k); 
    public int size();
    public boolean isEmpty();
    public Iterator keys();
    public Iterator Elements();
    
}
