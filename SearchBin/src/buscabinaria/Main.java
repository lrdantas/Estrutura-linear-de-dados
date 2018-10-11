/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscabinaria;

/**
 *
 * @author Luis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Element[] lista = new Element[10];
        Element e = new Element("oi",0);
        lista[0] = e;
        e = new Element("mundo",1);
        lista[1] = e;
        e = new Element("aqui",2);
        lista[2] = e;
        e = new Element("e",3);
        lista[3] = e;
        e = new Element("um",4);
        lista[4] = e;
        e = new Element("teste",5);
        lista[5] = e;
        e = new Element("de busca",6);
        lista[6] = e;
        
        BinarySearch bin = new BinarySearch(lista);
        
        int min = 0;
        int max = lista.length - 1;
        
        Object texto = bin.search(lista, 4, min, max);
        
        System.out.println("Elemento no indice 1: " + texto);
        
        
    }
    
}
