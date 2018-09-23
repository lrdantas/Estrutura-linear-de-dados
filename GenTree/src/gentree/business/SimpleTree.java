/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gentree.business;

import exception.InvalidNoException;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author rodrigo
 */
public class SimpleTree {

    //Atributos da �rvore
    Node raiz;
    int tamanho;
    private Vector<Node> listaNos = new Vector<Node>();
    private Vector<Object> listaObjects = new Vector<Object>();
    //Construtor

    public SimpleTree(Object o) {
        raiz = new Node(null, o);
        tamanho = 1;
    }

    /**
     * Retorna a raiz da rvore
     */
    public Node root() {
        return raiz;
    }

    /**
     * Retorna o n� pai de um n�
     */
    public Node parent(Node v) {
        return (v.parent());
    }

    /**
     * retorna os filhos de um n�
     */
    public Iterator children(Node v) {
        return v.children();

    }

    /**
     * Testa se um n� � interno
     */
    public boolean isInternal(Node v) {
        return (v.childrenNumber() > 0);
    }

    /**
     * Testa se um n� � externo
     */
    public boolean isExternal(Node v) {
        return (v.childrenNumber() == 0);
    }

    /**
     * Testa se um n� � a raiz
     */
    public boolean isRoot(Node v) {
        return v == raiz;
    }

    /**
     * Adiciona um filho a um n�
     */
    public void addChild(Node v, Object o) {
        Node novo = new Node(v, o);
        v.addChild(novo);
        tamanho++;
    }

    /**
     * Remove um n� S� pode remover n�s externos e que tenham um pai (n�o seja
     * raiz)
     */
    public Object remove(Node v) throws InvalidNoException {
        Node pai = v.parent();
        if (pai != null || isExternal(v)) {
            pai.removeChild(v);
        } else {
            throw new InvalidNoException();
        }

        Object o = v.element();
        tamanho--;
        return o;
    }

    /**
     * Troca dois elementos de posi��o
     */
    public void swapElements(Node v, Node w) {
        
        Node temp = w;
        w = v;
        v = temp;

    }

    /**
     * Retorna a profundidade de um n�
     */
    public int depth(Node v) {
        int profundidade = profundidade(v);
        return profundidade;
    }

    private int profundidade(Node v) {
        if (v == raiz) {
            return 0;
        } else {
            return 1 + profundidade(v.parent());
        }
    }

    /**
     * Retorna a altura da �rvore
     */
    public int height() {
        Iterator lista = nos();
        int temp;
        int max = 0;
        while(lista.hasNext()){
            temp = profundidade((Node) lista.next());
            if(temp > max){
                max = temp;           
            }
            
        }
        // M�todo que serve de exerc�cio
        
        int altura = max;
        return altura;
    }

    /**
     * Retorna um iterator com os elementos armazenados na �rvore
     */
    public Iterator elements() {
         Vector<Object> elements = new Vector<Object>();
         
        // M�todo n�o implementados --- Coleguinha fique a vontade para faz�-los
        Vector<Object> lista = preOrdemO(raiz);
        return lista.iterator();
        
    }

    /**
     * Retorna u m iterator com as posi��es (n�s) da �rvore
     */
    
    public Vector<Node> preOrdem(Node no){
        
        //Vector<Object> listaObjects = new Vector<Object>();
        //if(no.children().hasNext()){
            //listaObjects.add(no.element());
            listaNos.add(no);
            Iterator filhos=no.children();
            while (filhos.hasNext()) { 
                Node x=(Node) filhos.next();
                preOrdem(x);
             
            }
            
        return listaNos;
    }
    
        public Vector<Object> preOrdemO(Node no){
        
        //Vector<Object> listaObjects = new Vector<Object>();
        //if(no.children().hasNext()){
            
            //listaObjects.add(no.element());
            listaObjects.add(no.element());
            Iterator filhos=no.children();
            while (filhos.hasNext()) { 
                Node x=(Node) filhos.next();
                preOrdemO(x);
            }
        return listaObjects;
    }
    
    public Iterator nos() {
        
        Vector<Node> lista = preOrdem(raiz);
        return lista.iterator();
    }

    /**
     * Retorna o n�mero de n�s da �rvore
     */
    public int size() {
        return preOrdem(raiz).size();
    }

    /**
     * Retorna se a �vore est� vazia. Sempre vai ser falso, pois n�o permitimos
     * remover a raiz
     */
    public boolean isEmpty() {
        return false;
    }

    public Object replace(Node v, Object o) {
        Object temp = v.element();
        v.setElement(o);
        return temp;
    }



}
