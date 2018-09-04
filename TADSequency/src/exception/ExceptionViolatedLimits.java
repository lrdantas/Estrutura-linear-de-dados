/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Luis
 */
public class ExceptionViolatedLimits extends RuntimeException{
    
    public ExceptionViolatedLimits(String err){
        
        super(err);
        
    }
    
}
