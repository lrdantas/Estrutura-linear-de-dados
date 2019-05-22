/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

/**Class for entity Node
* @author Luis Rodrigo Dantas da Silva
* @version 1.0
* @since Release 01
*/

public class Node {
    Object o;
    Node before;

    public Node(Object o, Node before) {
        this.o = o;
        this.before = before;
    }
    
    
    /** Method to return Object.
    *   @return Object - reference of object*/

    public Object getO() {
        return o;
    }
    
    
    /** Method to set object.
    *   @param o Object - set object*/
    
    public void setO(Object o) {
        this.o = o;
    }
    
    
    /** Method to return previous node.
    *   @return Object - reference of previous node*/

    public Node getBefore() {
        return before;
    }
    
    
    /** Method to set previous node.
    *   @param before Node - set previous node*/

    public void setBefore(Node before) {
        this.before = before;
    }
    
    
    

    
    
    

    
    
    

    
    
    

    
    
    
     
    
}
