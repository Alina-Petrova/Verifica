package banksystem.servises;


import banksystem.servises.Operation;
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tss
 */
public class Withdrawal extends Operation {
    

    public Withdrawal(LocalDate data, float importo) {
        super(data, -importo);
    }


    @Override
    public String toString() {
        return "Prelievo{" + "data=" + getData() + ", importo=" + getImporto() + '\n';
    }
    
    
    
}
