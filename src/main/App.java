package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tss
 */

import banksystem.servises.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    
    public static void main(String[] args) throws InvalidCodeExeption{
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Bank b1 = new Bank("Mia");
        try {

            
            b1.createAccount(LocalDate.parse("13/11/2011",format), "John", 1000);
            b1.createAccount(LocalDate.parse("16/12/2011",format), "Paul", 23000);
            b1.createAccount(LocalDate.parse("21/11/2011",format), "Ringo", 500);
            b1.createAccount(LocalDate.parse("19/08/2011",format), "George", 120000);
            
            //    for(int i=0; i<b1.elencoAccount.size(); i++)
            
            b1.createAccount(LocalDate.parse("19/02/2011",format), "Sam", 0);
        } catch (InvalidValueExeption ex) {
            System.out.println(ex);
        }
        b1.stampaElencoAcc();
        System.out.println("------------------------------------------------------------");
        
        b1.deposit(LocalDate.parse("23/02/2011",format), 2, 453);
        b1.deposit(LocalDate.parse("15/07/2011",format), 1, 1743);
        b1.deposit(LocalDate.parse("05/03/2011",format), 4, 700);
        b1.deposit(LocalDate.parse("19/10/2011",format), 3, 3050);
        
        System.out.println("----------------------------dopo depositi--------------------------------");
        b1.stampaElencoAcc();
        System.out.println("Eliminiamo: "+b1.deleteAccount(LocalDate.parse("12/11/2011", format), 3));
        System.out.println("------------------------------------------------------------");
        b1.stampaElencoAcc();
        
    }
    

}
