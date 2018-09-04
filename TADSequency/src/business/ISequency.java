/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import exception.ExceptionEmptyList;
import exception.ExceptionViolatedLimits;

/**
 *
 * @author Luis
 */
public interface ISequency {
    
//Métodos genéricos:
public int size();
public boolean isEmpty();
//Métodos de Vetor:
public Object elemAtRank(int r);
public void replaceAtRank(int r, Object o);
public void insertAtRank(int r, Object o);
public void removeAtRank(int r);
//Métodos de Lista:
public Object first() throws ExceptionEmptyList;
public Object last() throws ExceptionEmptyList;;
public Object prev(Node n) throws ExceptionViolatedLimits;
public Object next(Node n) throws ExceptionViolatedLimits;;
public void replaceElement(Node n, Object o);
public void swapElements(Node n, Node q);
public void insertBefore(Node n, Object o);
public void insertAfter(Node n, Object o);
public void insertFirst(Object o);
public void insertLast(Object o);
public void remove(Node n) throws ExceptionEmptyList;
//Métodos “ponte”:
public Node atRank(int r);
public int rankOf(Node n);
    
}
