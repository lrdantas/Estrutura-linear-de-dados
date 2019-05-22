/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author rodrigo
 */
public class AVLNode extends Node{
    
    
    private int fb;
    
    
    public AVLNode(int key) {
        super(key);
        fb =0;
        
    }
    
    public int getFb() {
        return fb;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }

    
}
