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
        if(tree == null){
            tree = root;
        }
        if(n.getKey() < tree.getKey()){
            tree = tree.getLeft();
            insert(tree);
        }
        else if(n.getKey() > tree.getKey()){
            insert(tree.getRight());
        }
        
        
    }
    
}
