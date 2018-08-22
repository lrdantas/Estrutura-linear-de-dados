/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import Exception.EEmptyQueue;
import java.awt.List;

/**
 *
 * @author Luis
 */
public class Queue implements IQueue{
    
    private int capacity = 5;
    private int s = 3;
    private int f = s;
    private Object[] list = new Object[capacity];
    
    

    @Override
    public int size() {
        return (list.length - s + f) % list.length;
    }

    @Override
    public boolean isEmpty() throws EEmptyQueue {
        return size() == 0;
    }

    @Override
    public Object first() throws EEmptyQueue {
        return list[s];
    }

    @Override
    public void enqueue(Object o) {       
        if(size() == list.length - 1){            
            Object[] temp = new Object[list.length*2];
            int ss = s;
            for(int ff=0 ; ff<list.length-1; ff++){
                temp[ff] = list[ss];
                ss = (ss+1)%list.length;
            }
            list = temp;
            f = size();
            s=0;
        }
        list[f%list.length] = o;
        f++;
    }

    @Override
    public Object dequeue() throws EEmptyQueue {
        Object temp = list[s];
        s = (s + 1)%list.length;
        return temp;
    }
    
}
