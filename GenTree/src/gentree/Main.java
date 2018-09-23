/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gentree;

import gentree.business.Node;
import gentree.business.SimpleTree;
import java.util.Iterator;

/**
 *
 * @author rodrigo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int r = 1;
        SimpleTree tree = new SimpleTree(r);
        Node root = tree.root();
        
        tree.addChild(root, 3);
        tree.addChild(root, 5);
        tree.addChild(root, 9);
        
        Node n1 = (Node) tree.children(root).next();
        tree.addChild(n1, 10);
        tree.addChild(n1, 11);
        
        Node n2 = (Node) tree.children(n1).next();
        tree.addChild(n2, 15);
        tree.addChild(n2, 18);
        
        int profn2 = tree.depth(n2);
        int altura = tree.height();
        System.out.println("profundidade pai 2: " + profn2);
        System.out.println("Altura da arvore: " + altura);
        
        Iterator nos =  tree.nos();
        
        while (nos.hasNext()) {
            Node n = (Node) nos.next();
            System.out.println(n.element());
            
        }
        
    }
    
}