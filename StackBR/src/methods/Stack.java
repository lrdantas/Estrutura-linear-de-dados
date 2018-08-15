/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import exception.IsStackEmpty;

/**
 *
 * @author Luis
 */
public class Stack implements IStack{
    
    private int t = -1;
    private int capacity = 3;
    
    private Object[] list = new Object[capacity];

    public int getT() {
        return t;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public Object[] getList() {
        return list;
    }


    @Override
    public int size() {
        return t + 1;
      }

    @Override
    public void push(Object o) {
        int as = list.length-1;
        t++;
        if(t > as){
            Object[] newList = new Object[as*2];
            for(int i = 0; as > i; i++){
                newList[i] = list[i];
            }
            list = newList;
        }
        
        list[t] = o;
        
        
    }

    @Override
    public Object pop() throws IsStackEmpty {
        
        if(isEmpty()){
            throw new IsStackEmpty("A Pilha está vazia");
        }
        else{
            Object temp = list[t];
            list[t] = null;
            t--;
            return temp;
        }
    }

    @Override
    public Object top() throws IsStackEmpty {
        if(isEmpty()){
            throw new IsStackEmpty("A Pilha está vazia");
        }
        else
            return list[t];
    }

    @Override
    public boolean isEmpty() {
        return t == -1; 
    }
    
}
