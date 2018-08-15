/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackbr;

import entity.Element;
import exception.IsStackEmpty;
import methods.Stack;
import methods.StackBkRd;

/**
 *
 * @author Luis
 */
public class StackMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IsStackEmpty {
        
        Element bandeira = new Element("Vermelho");
        Stack pilha = new Stack();
        
        pilha.push(bandeira);
        bandeira = (Element) pilha.top();
        System.out.println("Top: " + bandeira.getNome());
        pilha.pop();
        pilha.push(bandeira);
        bandeira = (Element) pilha.top();
        System.out.println("Top: " + bandeira.getNome());
        pilha.push(bandeira);
        bandeira = (Element) pilha.top();
        System.out.println("Top: " + bandeira.getNome());
        pilha.push(bandeira);
        bandeira = (Element) pilha.top();
        System.out.println("Top: " + bandeira.getNome());
        pilha.push(bandeira);
        pilha.push(bandeira);
        pilha.push(bandeira);
   
        
       StackBkRd listabr = new StackBkRd();
       
       listabr.pushBlack("Preto1");
       listabr.pushBlack("Preto2");
       listabr.pushBlack("Preto3");
       listabr.pushRed("vermelho1");
       listabr.pushRed("vermelho2");
       listabr.pushRed("vermelho3");
   
       
       
       
        Object[] lista = listabr.getListbr();
        
        int i = 0;
        while (i < lista.length) {
            System.out.println(lista[i]);
            i++;
        }
        
        while(!listabr.isEmpty()){
            System.out.println("Elemento petro removido: " + listabr.popBlack());
            System.out.println("Elemento Vermelho removido: " + listabr.popRed());
        }
    }
    
}
