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
        
        AVLNode no;
        AVLNode root = new AVLNode(40);
        root.setLeft(null);
        root.setRight(null);
        root.setFb(0);
        AVLTree tree = new AVLTree(root);
        
        
//Example 1 -> left rotation
       
//        no = new AVLNode(2);
//        tree.insertAVL(no);
//        no = new AVLNode(3);
//        tree.insertAVL(no);
//        no = new AVLNode(4);
//        tree.insertAVL(no);
//        no = new AVLNode(5);
//        tree.insertAVL(no);
//        no = new AVLNode(6);
//        tree.insertAVL(no);
//        no = new AVLNode(7);
//        tree.insertAVL(no);
        
//Example 2 -> right rotation

//        no = new AVLNode(6);
//        tree.insertAVL(no);
//        no = new AVLNode(5);
//        tree.insertAVL(no);
//        no = new AVLNode(4);
//        tree.insertAVL(no);
//        no = new AVLNode(3);
//        tree.insertAVL(no);
//        no = new AVLNode(2);
//        tree.insertAVL(no);
//        no = new AVLNode(1);
//        tree.insertAVL(no);

//Example 3 -> test AVL
        
        no = new AVLNode(30);
        tree.insertAVL(no);
        no = new AVLNode(60);
        tree.insertAVL(no);
        no = new AVLNode(70);
        tree.insertAVL(no);
        no = new AVLNode(35);
        tree.insertAVL(no);
        no = new AVLNode(10);
        tree.insertAVL(no);
        no = new AVLNode(5);
        tree.insertAVL(no);
        no = new AVLNode(12);
        tree.insertAVL(no);
        no = new AVLNode(3);
        tree.insertAVL(no);
        no = new AVLNode(33);
        tree.insertAVL(no);
        no = new AVLNode(11);
        tree.insertAVL(no);
        no = new AVLNode(9);
        tree.insertAVL(no);
        
        
        tree.removeAVL(10);
        tree.removeAVL(11);
        tree.removeAVL(60);

       
        
        
        //tree.remove(3);
    //    tree.remove(5);
  //      tree.remove(10);
//        tree.remove(1);
//        
        
        //System.out.println("find node: " + tree.getNode(root, 12).getKey());
        
        tree.inorder(tree.getRoot());
        tree.show();
        //tree.print2D(root);
    
     
    }
    
}
