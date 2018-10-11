/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscabinaria;

import java.util.List;

/**
 *
 * @author Luis
 */
public class BinarySearch {
    
    private Element[] lista;
    private int k = 0;
    private String NO_SUCH_KEY = "Chave invalida";

    public BinarySearch(Element[] lista) {
        this.lista = lista;
    }
    
    
    
    
    public Object search(Element[] list, int k, int min, int max){
        int m = (max+min)/2;
        Element c = list[m];
        
        if(min >max){
            
            return NO_SUCH_KEY;
            
        }
        else if(c.getKey() == k){
            
            return c.getO();
            
        }
        
        else if(k < c.getKey()){
            
            search(list, k, min, m-1);
        }
        
        else if(k > c.getKey()){
            
            search(list, k, m + 1, max);
        }
        
        return NO_SUCH_KEY;
    }
    
    
}
