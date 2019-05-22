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
public class AVLTree extends BinarySearchTree{
    
    private AVLNode left;
    private AVLNode right;
    private AVLNode root;
    private int bf;
    private boolean delLeftClidren = true;
    private boolean isRoot = false;
    
    
    public AVLTree(AVLNode root) { 
        super(root);
    }
    
    public void insertAVL(AVLNode n){
        insert(n);
        climbing(n, "insert");
        AVLNode navl = (AVLNode) n.getFather();
        System.out.println(navl.getFb());
    }
    
    public void removeAVL(int key){
        AVLNode node = (AVLNode) getNode(getRoot(), key);
        AVLNode sucess = node;
        AVLNode father = sucess;
        
        if(node.getFather()==null){
            System.out.println("permission denied, node is root.");
            return;
        }
  
        if(isLeaf(node)){
            father = (AVLNode) node.getFather();
            climbing(father, "remove");
        }
        else if(node.getLeft()==null || node.getRight() == null){
            if(node.getLeft()==null)
                sucess= (AVLNode) node.getRight();
            else if(node.getRight()==null)
                sucess= (AVLNode) node.getLeft();
            sucess.setFb(node.getFb());
            father = (AVLNode) node.getFather();
            climbing((AVLNode) father, "remove");
        }
        else
            sucess =  (AVLNode) minNode(node.getRight());
            father = (AVLNode) sucess.getFather();
            sucess.setFb(node.getFb());
            this.delLeftClidren = father.getLeft() == sucess.getFather();
            remove(key);
            climbing((AVLNode) father, "remove");
        //AVLNode pmin = (AVLNode) min.getFather();
        
 
    }
    
    private void balance(AVLNode nb){
        AVLNode ne = (AVLNode) nb.getLeft();
        AVLNode nd = (AVLNode) nb.getRight();
       
        if(nb.getFb() ==2 && ne!=null){
            if(ne.getFb() > -1){
                System.out.println("Right Rotation");
                //update(nb,"right");
                rightRotation(nb);
            }
            else{
                System.out.println("Double Right Rotation");
                //update(nb,"right");
                doubleRightRotation(nb);
            }
        }
        else if(nb.getFb() == -2 && nd!=null){
            if(nd.getFb() < 1){
                System.out.println("Left Rotation");
                //update(nb,"left");
                leftRotation(nb);
            }
            else{
                System.out.println("Double Left Rotation");
                //update(nb,"left");
                doubleLeftRotation(nb);
            }
        }
        
    }
    
    private AVLNode climbing(AVLNode node, String type){
        
        AVLNode sentinel = node;
        
        if("insert".equals(type)){
            while(sentinel.getFather()!=null){
                
                if(isLeft(sentinel)){
                    sentinel = (AVLNode) sentinel.getFather();
                    sentinel.setFb(sentinel.getFb()+1);
                }
                else if(isRight(sentinel)){
                    sentinel = (AVLNode) sentinel.getFather();
                    sentinel.setFb(sentinel.getFb()-1);
                }
                if(sentinel.getFb() >1 || sentinel.getFb() < -1){
            //        update(sentinel);
                    balance(sentinel);
                }
                if(sentinel.getFb()==0)
                    break;
            }
            
        }
        
        else if("remove".equals(type)){
            
            while(sentinel.getFather()!=null){

                if(isLeft(sentinel)){                   
                    sentinel.setFb(sentinel.getFb()-1);
                    
                }
                else if(isRight(sentinel)){                    
                    sentinel.setFb(sentinel.getFb()+1);
                    
                }
                
                if(sentinel.getFb() >1 || sentinel.getFb() < -1){
                    balance(sentinel);
                  
                }
                if(sentinel.getFb()!=0)
                    break;
                
                sentinel = (AVLNode) sentinel.getFather();
            }    
        }
        
        return node;
    }
    
    private void leftRotation(AVLNode nb){
        
        update(nb,"left");
        
        AVLNode ns = (AVLNode) nb.getRight();
        AVLNode nse =(AVLNode) ns.getLeft();
        AVLNode nsd = (AVLNode) ns.getRight();
        
        //set childrens
        
        nb.setRight(nse);
        ns.setLeft(nb);
        
        
        //set fathers
        
        if(nb.getKey() == getRoot().getKey()){
            setRoot(ns);
            ns.setFather(null);
        }
        else{
            ns.setFather(nb.getFather());
            if(ns.getKey() > ns.getFather().getKey())
                ns.getFather().setRight(ns);
            else
                ns.getFather().setLeft(ns);
        }
        nb.setFather(ns);
        if(nse != null)
            nse.setFather(nb);
        
    }
    
    private void rightRotation(AVLNode nb){
        
        update(nb,"right");
        
        AVLNode ns = (AVLNode) nb.getLeft();
        AVLNode nsd =(AVLNode) ns.getRight();
        
        //set childrens
        
        nb.setLeft(nsd);
        ns.setRight(nb);
        
        
        //set fathers
        
        if(nb.getKey() == getRoot().getKey()){
            setRoot(ns);
            ns.setFather(null);
        }
        else{
            ns.setFather(nb.getFather());
            if(ns.getKey() > ns.getFather().getKey())
                ns.getFather().setRight(ns);
            else
                ns.getFather().setLeft(ns);
        }
        nb.setFather(ns);
        if(nsd != null)
            nsd.setFather(nb);
        
            
    }
    
    private void doubleLeftRotation(AVLNode node){
        rightRotation((AVLNode) node.getRight());
        leftRotation(node);       
    }
    
    private void doubleRightRotation(AVLNode node){
        leftRotation((AVLNode) node.getLeft());
        rightRotation(node);
    }
    
    private void update(AVLNode n, String type){
        
        int bf_b_new=0;
        int bf_a_new=0;
        int bf_b = n.getFb();
        AVLNode node_a =new AVLNode(-1);
        
        if(type.equals("left")){
            node_a = (AVLNode) n.getRight();
            int bf_a = node_a.getFb();
            bf_b_new = bf_b + 1 - Integer.min(bf_a, 0);
            bf_a_new = bf_a + 1 + Integer.max(bf_b_new, 0);
        }
        else if(type.equals("right")){
            node_a = (AVLNode) n.getLeft();
            int bf_a = node_a.getFb();
            bf_b_new = bf_b - 1 - Integer.max(bf_a, 0);
            bf_a_new = bf_a - 1 + Integer.min(bf_b_new, 0);
        }
            
        n.setFb(bf_b_new);
        node_a.setFb(bf_a_new);
        
    }
    
    
}
