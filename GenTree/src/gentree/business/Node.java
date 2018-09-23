/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gentree.business;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author rodrigo
 */
public class Node implements Position {

    @Override
    public Object element() {
        return o; //To change body of generated methods, choose Tools | Templates.
    }

    private Object o;
    private Node pai;
    private Vector filhos = new Vector();

    public Node(Node pai, Object o) {
        this.pai = pai;
        this.o = o;
    }

    public Node parent() {
        return pai;
    }

    public void setElement(Object o) {
        this.o = o;
    }

    public void addChild(Node o) {
        filhos.add(o);
    }

    public void removeChild(Node o) {
        filhos.remove(o);
    }

    public int childrenNumber() {
        return filhos.size();
    }

    public Iterator children() {
        return filhos.iterator();
    }

    public void setFilhos(Vector filhos) {
        this.filhos = filhos;
    }

    public Vector getFilhos() {
        return filhos;
    }
    
    
}

