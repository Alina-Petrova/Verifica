/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem.servises;

import java.time.LocalDate;

/**
 *
 * @author tss
 */
public class Deposit extends Operation {


    public Deposit(LocalDate data, float importo) {
        super(data, importo);
    }


    @Override
    public String toString() {
        return "Deposito{" + "data=" + getData() + ", importo=" + getImporto() + '\n';
    }  
}
