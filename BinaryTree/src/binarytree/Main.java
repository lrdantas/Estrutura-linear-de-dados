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
        
        Node no;
        Node root = new Node(10);
        root.setLeft(null);
        root.setRight(null);
        BinarySearchTree tree = new BinarySearchTree(root);
       
        no = new Node(3);
        tree.insert(no);
        no = new Node(1);
        tree.insert(no);
        no = new Node(4);
        tree.insert(no);
        no = new Node(12);
        tree.insert(no);
        no = new Node(2);
        tree.insert(no);
        no = new Node(19);
        tree.insert(no);
        
        tree.remove(19);
        tree.remove(12);
        
        System.out.println("fing node: " + tree.getNode(root, 12).getKey());
        
        tree.inorder(root);
    
     
    }
    
}
