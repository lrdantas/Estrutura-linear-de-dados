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
public class StackBkRd implements IStackRB{
    
    
    private int capacity = 5; //Capacidade
    
    private Object[] listbr = new Object[capacity]; 
    
    private int k = -1;  //Tamanho
    private int x = listbr.length;
    private int cb = 0;

    public StackBkRd() {
    }
    
    public Object[] getListbr() {
        return listbr;
    }
    
    public boolean isFull(){
        return x - k < 3;
    }
    
    public Object[] dupArray(Object[] lista){
        int ti = lista.length;
        Object[] temp = new Object[ti*2];
        int tf = ti*2;
        int ii = tf;
        
        //copia a pilha vermelha
        for(int i = 0; i < k+1; i++){
            temp[i] = lista[i];
        }
        
        //copia a pílha preta
        for(int j=ti-1; j >= x ; j--){
            temp[--tf] = lista[j];
        }
        
        x = temp.length - cb;
 
        return temp;
        
    }
    

    @Override
    public int size() {
        return sizeBlack() + sizeRed() ;
    }

    @Override
    public void pushRed(Object o) {
        if(isFull()){
            listbr = dupArray(listbr);
        }
        k++;
        listbr[k] = o;
    }

    @Override
    public void pushBlack(Object o) {
        
        if(isFull()){
            listbr = dupArray(listbr);
        }
        cb++;
        x--;
        listbr[x] = o;
    }

    @Override
    public Object popRed() throws IsStackEmpty {
        if(isEmpty()){
            throw new IsStackEmpty("A Pilha está vazia");
        }
        else if(isEmptyRed()){
            throw new IsStackEmpty("A Pilha vermelha está vazia");
        }
        else{
            Object temp = listbr[k];
            k--;
            return temp;
        }    
    }

    @Override
    public Object popBlack() throws IsStackEmpty {
        if(isEmpty()){
            throw new IsStackEmpty("A Pilha está vazia");
        }
        else if(isEmptyRed()){
            throw new IsStackEmpty("A Pilha preta está vazia");
        }
        else{
            Object temp = listbr[x];
            cb++;
            x++;
            return temp;
        }   
    }

    @Override
    public Object topRed() throws IsStackEmpty {
        if(isEmpty()){
            throw new IsStackEmpty("A Pilha está vazia");
        }
        else if(isEmptyRed()){
            throw new IsStackEmpty("A Pilha vermelha está vazia");
        }
        else{
            Object temp = listbr[k];
            return temp;
        }    
    }

    @Override
    public Object topBlack() throws IsStackEmpty {
       if(isEmpty()){
            throw new IsStackEmpty("A Pilha está vazia");
        }
        else if(isEmptyRed()){
            throw new IsStackEmpty("A Pilha preta está vazia");
        }
        else{
            Object temp = listbr[x];
            return temp;
        }   
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean isEmptyRed() {
        return k == -1;
    }

    @Override
    public boolean isEmptyBlack() {
        return cb == 0;
    }

    @Override
    public int sizeRed() {
        return k+1;
    }

    @Override
    public int sizeBlack() {
        return cb;
    }
    
}
