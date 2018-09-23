/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gentree.business;

import exception.InvalidNoException;

/**
 *
 * @author rodrigo
 */
public interface GeneralTree  extends Tree{

    public void addChild(Node v, Object o);

    /**
     * @param v
     * @return Objeto que estava na poso que foi removida
     * @throws InvalidNoException
     */
    
    public Object remove(Node v) throws InvalidNoException;

}
