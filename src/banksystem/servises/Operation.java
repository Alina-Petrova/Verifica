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
public abstract class Operation implements Comparable<Operation>{
    private LocalDate data;   
    private float importo;


    public Operation(LocalDate data, float importo) {
        this.importo = importo;
        this.data = data;
    }  

    @Override
    public int compareTo(Operation t) {
        return this.data.compareTo(t.data);
    }

    public LocalDate getData() {
        return data;
    }

    public float getImporto() {
        return importo;
    }

    
}