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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Node root = new Node(10);
        root.setLeft(null);
        root.setRight(null);
        Node no = new Node(5);
        tree.insert(root);
        no = new Node(3);
        tree.insert(no);
        no = new Node(1);
        tree.insert(no);
        no = new Node(4);
        tree.insert(no);
        no = new Node(12);
        
        tree.inorder(root);
    
     
    }
    
}
