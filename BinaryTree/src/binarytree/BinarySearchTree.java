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
    private final String NULL_SUCH_KEY = "Não existe esta chave na arvore.";
    
    
    public void insert(Node n){
        
       if(this.root == null){
            n = root;
            return;
        }
        
        Node sentinel = root;
        Node parent = null;
        
        while(true){
            parent = sentinel;
            if(n.getKey()<sentinel.getKey()){				
                sentinel = sentinel.getLeft();
                if(sentinel==null){
                    parent.setLeft(n);
                    return;
                }
            }
            else{
                sentinel = sentinel.getRight();
                if(sentinel==null){
                    parent.setRight(n);
                    return;
                }
            }
        }   
    }
    
    public Object remove(int key){
        
        Node sentinel = root;
        Node parent = null;
        
        while(sentinel.getKey()!=key){
            parent = sentinel;
            if(sentinel.getKey() < key){
                sentinel = sentinel.getLeft();
            }
            else{
                sentinel = sentinel.getRight();
            }
            
            if(sentinel == null){
                return NULL_SUCH_KEY;
            }        
        }
        
        if(sentinel.getLeft() == null && sentinel.getRight() ==null){
            if(parent.getKey() < key){
                parent.setLeft(null);
            }
            else{
                parent.setRight(null);
            }
        }
        
        //primeiro caso:
        else if(sentinel.getLeft()!=null){
            if(sentinel.getKey() > sentinel.getLeft().getKey()){
                parent.setLeft(sentinel.getLeft());
            }
            else{
                parent.setRight(sentinel.getLeft());
            }         
        }
        
        //Segundo caso:
        else if(sentinel.getRight()!=null){
            if(sentinel.getKey() > sentinel.getLeft().getKey()){
                parent.setLeft(sentinel.getRight());
            }
            else{
                parent.setRight(sentinel.getRight());
            }                
        }
        
        //terceiro caso:
        else if(sentinel.getLeft() != null && sentinel.getRight() !=null){
            Node sucess;
            sucess = minNode(sentinel.getRight());
            if(parent.getKey()< sucess.getKey()){
                parent.setLeft(sucess);
                sucess.setLeft(sentinel.getLeft());
                sucess.setRight(sentinel.getRight());
               
            }
            else{
                parent.setRight(sucess);
                sucess.setLeft(sentinel.getLeft());
                sucess.setRight(sentinel.getRight());
            }
        }
    
        
 
        
        
        return "Deu certo coleguinha";
            
        
    }
    
    public Node minNode(Node noM){
           
        while(noM.getLeft() != null){
            noM = noM.getLeft();
        }        
        return noM;
    }
    
    public void inorder(Node no) { 
        if (no != null) 
        { 
            inorder(no.getLeft()); 
            System.out.print(no.getKey() + " "); 
            inorder(no.getRight()); 
        } 
    } 
}
