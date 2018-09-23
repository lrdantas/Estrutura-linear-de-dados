/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gentree.business;

import java.util.Iterator;

/**
 *
 * @author rodrigo
 */

public interface Tree {

    /* M�todos gen�ricos */
    /**
     * Retorna o n�mero de n�s da �rvore
     */
    public int size();

    /**
     * retorna se a �rvore est� vazia
     */
    public boolean isEmpty();

    /**
     * Retorna a altura da �rvore
     */
    public int height();

    /**
     * Retorna um iterator com os elementos armazenados na �rvore
     */
    public Iterator elements();

    /**
     * Retorna um iterator com as posi��es (n�s) da �rvore
     */
    public Iterator nos();

    /* M�todos de acesso*/
    /**
     * Retorna a raiz da �rvore
     */
    public Node root();

    /**
     * Retorna o n� pai de um n�
     */
    public Node parent(Node v);

    /**
     * Retorna os filhos de um n�
     */
    public Iterator children(Node v);

    /* M�todos de consulta */
    /**
     * Testa se um n� � interno
     */
    public boolean isInternal(Node v);

    /**
     * Testa se um n� � externo
     */
    public boolean isExternal(Node v);

    /**
     * Testa se um n� � a raiz
     */
    public boolean isRoot(Node v);

    /**
     * Retorna a profundidade de um n�
     */
    public int depth(Node v);

    /* M�todos de atualiza��o */
    /**
     * Substitui o objeto de um um n�
     */
    public Object replace(Node v, Object o);
    /**
     * Retorna a profundidade de um n�
     */
}

