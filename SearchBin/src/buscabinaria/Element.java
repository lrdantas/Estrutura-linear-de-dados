/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscabinaria;

/**
 *
 * @author Luis
 */
public class Element {
    
    private Object o;
    private int key;

    public Element(Object o, int key) {
        this.o = o;
        this.key = key;
    }

    public Element() {
    }
    
    

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
    
    
    
}
