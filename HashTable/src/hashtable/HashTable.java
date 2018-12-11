/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.util.Iterator;

/**
 *
 * @author rodrigo
 */
public class HashTable implements IHashTable{ 
    
    private int[] keys;
    private Object[] values;
    private int capacity;
    private int count = 0;
    private HashEntry[] hashs;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.keys = new int[capacity];
        this.values = new Object[capacity];
        this.hashs = new HashEntry[capacity];
    }
    
    public int hash(int key){
        return (2*key + 5)%11;
    }
    
    
    //Colisão tratada por linear probing
    
    public int getValue(int key){
        
        int i = hash(key);
        while(hashs[i]!= null){
            if(hashs[i].getKey()== key){
                return (int) hashs[i].getValue();
            }
            i = (i + 1)%capacity;
        }
        return -1;          
    }
    
     public void insert(int key, int value) 
    {                
        int tmp = hash(key);
        int i = tmp;
        do
        {
            if (hashs[i] == null)
            {
                hashs[i] = new HashEntry(key, value);             
                count++;
                return;
            }
            if (hashs[i].getKey() == key) 
            { 
                hashs[i] = new HashEntry(key, value);         
                return; 
            }            
            i = (i + 1) % capacity;            
        } while (i != tmp);     
        
    }
 

    @Override
    public Object findElement(int k) {
        
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Colisão tratada por encadeamento

    @Override
    public void insertItem(int k, Object o) {
        
        int i = hash(k);
        HashEntry temp = hashs[i];
        do{
       
            if(temp == null){
                temp = new HashEntry(k, o);
                temp.setNext(null);
                hashs[i] = temp;
                break;
            }
            else if(temp.getNext() == null){
                temp = temp.getNext();
                temp.setKey(k);
                temp.setValue(o);
                temp.setNext(null);
                break;
            }
            else{
                temp = temp.getNext();
            }
            
        }while(temp!=null);
    }

    @Override
    public Object removeElement(int k) {
        int i = hash(k);
        
        HashEntry temp = hashs[i];
        do{
     
            if(temp.getNext() == null){
                hashs[i] = null;
                return temp;
            }
            else if(temp.getNext().getKey() == k){
                temp.setNext(temp.getNext().getNext());
                return temp.getNext();
            }
            temp = temp.getNext();
            
        }while(temp!=null);
        
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public Iterator keys() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator Elements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void listar(){
        
        for(int i = 0; i < hashs.length-1; i++){
            HashEntry temp = hashs[i];
            if(hashs[i] != null){
                System.out.println("Key: " + temp.getKey() + " | Value: " + temp.getValue());
                if(temp.getNext() != null){
                    while(temp!=null){
                        temp = temp.getNext();
                        System.out.println("Key: " + temp.getKey() + " || Value: " + temp.getValue());
                    }
                }
            }
        }
    }
    
}
