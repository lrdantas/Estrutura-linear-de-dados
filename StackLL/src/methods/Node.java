/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import entity.Element;

/**
 *
 * @author rodrigo
 */
public class Node {
    Object o;
    Node before;

    public Node(Object o, Node before) {
        this.o = o;
        this.before = before;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public Node getBefore() {
        return before;
    }

    public void setBefore(Node before) {
        this.before = before;
    }
    
    
    

    
    
    

    
    
    

    
    
    

    
    
    
     
    
}
