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
    private Node findNode;
    private Node parent;
    private Node parentMinNode;
    private final String NULL_SUCH_KEY = "Não existe esta chave na arvore.";
    private int altura = 0;

    public BinarySearchTree(Node root) {
        this.root = root;
    }
    
    public boolean isLeaf(Node no){
        return no.getLeft() == null && no.getRight() ==null;
    }
    
    
    public void insert(Node n){
        
       if(this.root == null){
            root = n;
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
        this.parent = null;
        
        sentinel = getNode(root, key);
        
        //primeiro caso:
        
        if(isLeaf(sentinel)){
            if(parent.getKey() > key){
                parent.setLeft(null);
            }
            else{
                parent.setRight(null);
            }
        }
        
        //segundo caso:
        else if(sentinel.getLeft() != null && sentinel.getRight() !=null){
            Node sucess;
            sucess = minNode(sentinel.getRight());
            sentinel = sucess;
            
            //if(parent.getKey()> sucess.getKey()){
                //parent.setLeft(sucess);
                //sucess.setLeft(sentinel.getLeft());
                //sucess.setRight(sentinel.getRight());
               
            //}
            //else{
            //    parent.setRight(sucess);
            //    sucess.setLeft(sentinel.getLeft());
            //    sucess.setRight(sentinel.getRight());
            //}
        }
        
        //Terceiro caso:
       
        else if(sentinel.getLeft()!=null){
            if(sentinel.getKey() > sentinel.getLeft().getKey()){
                parent.setLeft(sentinel.getLeft());
            }
            else{
                parent.setRight(sentinel.getLeft());
            }         
        }
        
       
        else if(sentinel.getRight()!=null){
            if(sentinel.getKey() > sentinel.getLeft().getKey()){
                parent.setLeft(sentinel.getRight());
            }
            else{
                parent.setRight(sentinel.getRight());
            }                
        }
        
    
        return "Deu certo coleguinha";
            
        
    }
    
    public Node minNode(Node noM){
           
        while(noM.getLeft() != null){
            this.parentMinNode = noM;
            this.parentMinNode.setRight(noM.getLeft().getRight());
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
    
    //Acha um decendente através de um dado ancestral. ex: passado um nó raiz, acha a posição de um nó em uma determinada chave. 
    public Node getNode(Node no, int key){
        this.altura++; // A cada recursão um incremento de altura.
        if(no.getKey() != key && no !=null){
            if(no.getKey() > key && no.getLeft() !=null){
                this.parent = no;
                getNode(no.getLeft(), key);
            }
            else if(no.getRight()!= null){
                this.parent = no;
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
