/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rodrigo
 */
public class BinarySearchTree {
    
    private Node left;
    private Node right;
    private Node root;
    private Node findNode;
    private Node parent;
    private Node parentMinNode;
    private final String NULL_SUCH_KEY = "Não existe esta chave na arvore.";
    private Integer altura;
    private List largura;
    private final Map<Integer, List> mapTree = new HashMap<Integer, List>();
    private final Map<Integer, Integer> mapKeys = new HashMap<Integer, Integer>();
    private int count=1;
    
    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    
    
    public boolean isLeaf(Node no){
        return no.getLeft() == null && no.getRight() ==null;
    }
    
    public boolean isLeft(Node no){
        
        return no.getKey() < no.getFather().getKey();
    }
    public boolean isRight(Node no){
        return no.getKey() > no.getFather().getKey();
    }
   
    private int getNodeHeight(Node n){
        Node temp = n;
        altura=0;
        while(temp!=null){
            temp=temp.getFather();
            altura++;
        }
        return altura;
    }
    
    public Node insert(Node n){
        
       if(this.root == null){
            root = n;
            return n;
        }
        
        Node sentinel = root;
        
        while(true){
            
            if(n.getKey()<sentinel.getKey()){	
                parent =sentinel;
                sentinel = sentinel.getLeft();
                if(sentinel==null){
                    parent.setLeft(n);
                    n.setFather(parent);
                    return n;
                }
            }
            else{
                parent =sentinel;
                sentinel = sentinel.getRight();
                if(sentinel==null){
                    parent.setRight(n);
                    n.setFather(parent);
                    return n;
                }
            }
        }   
    }
    
    public Object remove(int key){
        
        Node sentinel;
        
        sentinel = getNode(root, key);
        
        //primeiro caso:
        
        if(sentinel == root){
            this.root = null;
            return "remove root";
            
        }
        
        if(isLeaf(sentinel)){
            parent = sentinel.getFather();
            if(parent.getKey() > key){
                parent.setLeft(null);
            }
            else{
                parent.setRight(null);
            }
        }
        
        //segundo caso
        else if(sentinel.getLeft() == null ^ sentinel.getRight() == null){
            
            if(sentinel.getRight()!=null){
                sentinel.setKey(sentinel.getRight().getKey());
                sentinel.setLeft(sentinel.getRight().getLeft());
                sentinel.setRight(sentinel.getRight().getRight());            
            }
            else{
                sentinel.setKey(sentinel.getLeft().getKey());
                sentinel.setLeft(sentinel.getLeft().getLeft());
                sentinel.setRight(sentinel.getLeft().getRight());   
            }
            
            
        }
        
        //terceiro caso
        
        else if(sentinel.getLeft() != null && sentinel.getRight() != null){
            Node min;
            min = minNode(sentinel.getRight());
            
            //sentinel.setKey(min.getKey());
            if(isRight(min)){
                if(sentinel.getFather()!=null){
                    if(isLeft(sentinel))
                        sentinel.getFather().setLeft(min);
                    else if(isRight(sentinel))
                        sentinel.getFather().setRight(min);
                
                }
               min.setLeft(sentinel.getLeft());
               
               sentinel.getLeft().setFather(min);
               // min.getFather().setRight(min.getRight());
               min.setFather(sentinel.getFather());
               
//               if(min.getRight()!=null){
//                    min.getRight().setFather(min.getFather());
//                }
            }
            else if(isLeft(min)){
                if(sentinel.getFather()!=null){
                    if(isLeft(sentinel))
                        sentinel.getFather().setLeft(min);
                    else if(isRight(sentinel))
                        sentinel.getFather().setRight(min);
                }
                min.getFather().setLeft(min.getRight());
                if(min.getRight()!=null){
                    min.getRight().setFather(min.getFather());               
                }
                
               min.setLeft(sentinel.getLeft());
               min.setRight(sentinel.getRight());
               sentinel.getLeft().setFather(min);
               sentinel.getRight().setFather(min);
               min.setFather(sentinel.getFather());
                
            }
        }
        
         return "Deu certo coleguinha";
            
        
    }
    
    public Node minNode(Node noM){
        int step = 0;   
        while(noM.getLeft() != null){
            noM = noM.getLeft();
            step++;
        }
//        if(step <2){
//            noM.getFather().setRight(noM.getRight());
//            if(noM.getRight()!=null){
//                noM.getRight().setFather(noM.getFather());
//            }
//        }
        return noM;
    }
    
    public void inorder(Node no) { 
        if (no != null) 
        {   
            inorder(no.getLeft()); 
            System.out.print(no.getKey() + "   "); 
//            this.altura = getNodeHeight(no)-1;
//            if(!mapTree.containsKey(altura)){
//                largura = new ArrayList();
//                largura.add(count);
//            }
//            else{
//                largura = mapTree.get(altura);
//                largura.add(count);
//            }
//            this.mapTree.put(altura, largura);
//            this.mapKeys.put(count, no.getKey());
//            count++;
            inorder(no.getRight()); 
            
        } 
        
    }
    
    public void show(){
        for(int i=0; mapTree.size() > i; i++){
            System.out.println("\n \n");
            for(Object j : mapTree.get(i)){
                int t = (Integer) j;
                for(int k = 0; t > k; k++){
                    System.out.print("   ");
                    if(t==k+1){
                        System.out.print("<-|" + mapKeys.get(t) + "|->");
                    }
                }
 
            }
                      
        }
        System.out.println("\n\n");
        //System.out.println(mapTree);
        //System.out.println(mapKeys);
        
    }

    
    
    //Acha um decendente através de um dado ancestral. ex: passado um nó raiz, acha a posição de um nó em uma determinada chave. 
    public Node getNode(Node no, int key){
//        this.altura++; // A cada recursão um incremento de altura.
        if(no.getKey() != key && no !=null){
            if(no.getKey() > key && no.getLeft() !=null){
                getNode(no.getLeft(), key);
            }
            else if(no.getRight()!= null){
                getNode(no.getRight(), key);
            }
        }
        else if(no.getKey() == key){
            this.findNode = no;
        }
        
        return this.findNode;
        
    }
    
    public int NodeHeight(Node no){
        this.altura = 0;
        getNode(this.root, no.getKey());
        return altura;
    }
    
   
}
