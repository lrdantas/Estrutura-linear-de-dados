/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import exception.ExceptionEmptyList;
import exception.ExceptionViolatedLimits;

/**
 *
 * @author Luis
 */
public class Sequency implements ISequency{
    
    private Node header = null;
    private Node trailer = null;
    
    private int count = 0;

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    
    //TAD Vector

    @Override
    public Object elemAtRank(int r) {
        return atRank(r).getO();
    }

    @Override
    public void replaceAtRank(int r, Object o) {
        atRank(r).setO(o);
    }

    @Override
    public void insertAtRank(int r, Object o) {
        Node temp = atRank(r);
        Node no = new Node(temp,temp.getNext(),o);
        temp.setNext(no);
        
        count++;
    }

    @Override
    public void removeAtRank(int r) {
        Node temp = atRank(r);
        Node prev = temp.getPrev();
        Node next = temp.getNext();
        
        prev.setNext(next);
        next.setPrev(prev);
        
        count--;
    }
    
    //TAD List

    @Override
    public Object first() throws ExceptionEmptyList{
        return this.header.getO();
    }

    @Override
    public Object last() throws ExceptionEmptyList{
        return this.trailer.getO();
    }

    @Override
    public Object prev(Node n) throws ExceptionViolatedLimits{
        Node prev = n.getPrev();
        
        if (prev == header)     
            throw new ExceptionViolatedLimits("Início da lista alcançado!");
        
        return prev.getO();
    }

    @Override
    public Object next(Node n) throws ExceptionViolatedLimits{
        Node next = n.getNext();
        
        if(next==trailer) 
            throw new ExceptionViolatedLimits("Início da lista alcançado!");
        
        return next.getO();
    }

    @Override
    public void replaceElement(Node n, Object o) {
        n.setO(o);
    }

    @Override
    public void swapElements(Node n, Node q) {
        Node prevA = n.getPrev();
        Node prevB = q.getPrev();
        Node nextA = n.getNext();
        Node nextB = q.getNext();
        
        n.setNext(nextB);
        n.setPrev(prevB);
        q.setNext(nextA);
        q.setPrev(prevA);
        
        //OR
        /* 
        temp = n;
        n = q;
        q = temp;
        */
    }

    @Override
    public void insertBefore(Node n, Object o) {
        count ++;
        Node temp = new Node(n.getPrev(), n, o);
       
        n.getPrev().setNext(temp);
        n.setPrev(temp);
    }

    @Override
    public void insertAfter(Node n, Object o) {
        count ++;
        Node temp = new Node(n, n.getNext(), o);
       
        n.getNext().setPrev(temp);
        n.setNext(temp);
    }

    @Override
    public void insertFirst(Object o) {
        this.count++;
        this.header = new Node(null,this.header, o);

    }

    @Override
    public void insertLast(Object o) {
        Node temp = new Node(trailer,null, o);       
        
        if(trailer == null){
            this.trailer = temp;
            this.header = this.trailer;
        }
        else{
            trailer.setNext(temp);
            trailer = temp;    
        }
        
        count++;
    }

    @Override
    public void remove(Node n) throws ExceptionEmptyList{
        Node prev = n.getPrev();
        Node next = n.getNext();
        //Object ele = n.getO();
        
        prev.setNext(next);
        next.setPrev(prev);
        
        //clear object
        n.setNext(null);
        n.setPrev(null);
        n.setO(null);
        
        count--;
       
    }
    
    //--------------//

    @Override
    public Node atRank(int r) {

        Node no;
        if(r <= size()/2){
            no = header.getNext();
            for(int i = 0; i< r; i++){
                no = no.getNext();
            }
        }
        else{
            no = trailer.getPrev();
            for(int j = 0; j < r ; j++){
                no = no.getPrev();
            }
        }
        
        return no;   
    }

    @Override
    public int rankOf(Node n) {
        Node no = header.getNext();
        int r = 0;
        
        while(no!=n && no!=this.trailer){
            no = no.getNext();
            r++;
        }
        
        return r;
        
    }
    
}
