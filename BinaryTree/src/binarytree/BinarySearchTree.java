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
public class BinarySearchTree {
    
    private Node left;
    private Node right;
    private Node root;
    private Node tree;
    
    public void insert(Node n){
        
       if(this.root == null){
            n = root;
        }
        
        Node current = root;
        Node parent = null;
        
        while(true){
            parent = current;
            if(n.getKey()<current.getKey()){				
                current = current.getLeft();
                if(current==null){
                    parent.setLeft(n);
                    return;
                }
            }
            else{
                current = current.getRight();
                if(current==null){
                    parent.setRight(n);
                    return;
                }
            }
        }   
    }
}
