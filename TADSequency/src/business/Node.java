/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Luis
 */
public class Node {
    
    private Node prev;
    private Node next;
    
    private Object o;

    public Node(Node prev, Node next, Object o) {
        this.prev = prev;
        this.next = next;
        this.o = o;
    }

    public Node() {
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }
    
}
