/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem.servises;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 *
 * @author tss
 */
public class Bank {
    
    private final String nomeBanca;
    
    public static int numCC=1;
    public Map<Integer,Account> elencoAccount; 

    public Bank(String nomeBanca) {
        this.nomeBanca = nomeBanca;
        elencoAccount = new HashMap<>();
    }

    public String getNomeBanca() {
        return nomeBanca;
    }
    
    public void createAccount(LocalDate data, String nome, float versamento) throws InvalidValueExeption {
        if(versamento<=0)
            throw new InvalidValueExeption("InvalidValue: versamento iniziale insufficiente");
        Account newAcc = new Account(nome, versamento, data);
        elencoAccount.put(numCC++, newAcc);
    }
    
    public Account getAccount(int num) throws InvalidCodeExeption {
        if(!elencoAccount.containsKey(num)) {
            throw new InvalidCodeExeption("InvalidCode: conto non esiste");
        } else {
            return elencoAccount.get(num);
        }
    }
    
    public void deposit(LocalDate data, int num, float versamento) throws InvalidCodeExeption {
        if(!elencoAccount.containsKey(num)) {
            throw new InvalidCodeExeption("InvalidCode: conto non esiste");
        } else {
            Deposit dep = new Deposit(data, versamento);
            getAccount(num).addDeposito(data, dep);
        }        
    }
    
    public void transfer(LocalDate data, int cc1, int cc2, float versamento) throws InvalidCodeExeption, InvalidValueExeption {
        if(!(elencoAccount.containsKey(cc1) || elencoAccount.containsKey(cc2))) 
            throw new InvalidCodeExeption("InvalidCode: conto non esiste");
        if(getAccount(cc1).getSaldo()<versamento)
            throw new InvalidValueExeption("InvalidValue: saldo insufficiente");
        getAccount(cc1).addPrelievo(data, new Withdrawal(data, versamento));
        getAccount(cc2).addDeposito(data, new Deposit(data, versamento));           
    }
    
    public void prelievo(LocalDate data, int cc, float versamento) throws InvalidCodeExeption, InvalidValueExeption {
        if(!(elencoAccount.containsKey(cc))) 
            throw new InvalidCodeExeption("InvalidCode: conto non esiste");
        if(getAccount(cc).getSaldo()<versamento)
            throw new InvalidValueExeption("InvalidValue: saldo insufficiente");
        getAccount(cc).addPrelievo(data, new Withdrawal(data, versamento));
    }
    
    public Account deleteAccount(LocalDate data, int num) throws InvalidCodeExeption {
        Account ris;
        if(!elencoAccount.containsKey(num)) 
            throw new InvalidCodeExeption("InvalidCode: conto non esiste");
        LocalDate dataCiusura;
        if(getAccount(num).getDataUltimaOp().isAfter(data))
            dataCiusura = getAccount(num).getDataUltimaOp();
        else
            dataCiusura = data;
        
        getAccount(num).addPrelievo(dataCiusura, new Withdrawal(data, getAccount(num).getSaldo()));
        try {
            ris = (Account)getAccount(num).clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
        elencoAccount.remove(num);
        return ris;
    }
    
    public void stampaElencoAcc() {
        String ris = "Banca: "+nomeBanca+"\n";
        Stream st = elencoAccount.values().stream();
        st.forEach(System.out::println);
    }
        
    /*--metodi da completare------*/
    public float getTotalDeposit() {
        float ris=0;
        return ris;
    }
    
    public List<Account> getAccounts() {
        List<Account> ris = new ArrayList<>();
        return ris;
    }
    
    public List<Account> getAccountsByBalance(){
        List<Account> ris = new ArrayList<>();
        return ris;
    }
            
    public float getPerCentHigher() {
        float ris=0;
        return ris;
    }
    /*--------------------fine metodi da completare-----------*/


}


