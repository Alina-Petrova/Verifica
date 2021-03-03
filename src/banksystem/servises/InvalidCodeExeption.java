/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem.servises;

/**
 *
 * @author tss
 */
public class InvalidCodeExeption extends Exception{

    public InvalidCodeExeption(String mess) {
        super(mess);
    }  
}
