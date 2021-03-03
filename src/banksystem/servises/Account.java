/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem.servises;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author tss
 */
public class Account implements Cloneable{


    private final int nCC;
    private final String nome;
    private float saldo;
    private LocalDate dataUltimaOp;
    
    private List<Deposit> elencoDepositi;
    private List<Withdrawal> elencoPrelievi;

    public Account(String nome, float versamentoIniz, LocalDate data) {
        this.nCC = Bank.numCC;
        this.nome = nome;
        this.saldo = versamentoIniz;
        this.dataUltimaOp = data;   
        elencoDepositi = new ArrayList<>();
        elencoPrelievi = new ArrayList<>();
        Deposit firstVers = new Deposit(data, versamentoIniz);
        elencoDepositi.add(firstVers);
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public void setDataUltimaOp(LocalDate dataUltimaOp) {
        this.dataUltimaOp = dataUltimaOp;
    }
    public int getnCC() {
        return nCC;
    }

    public String getNome() {
        return nome;
    }

    public float getSaldo() {
        return saldo;
    }

    public LocalDate getDataUltimaOp() {
        return dataUltimaOp;
    }

    public List<Deposit> getElencoDepositi() {
        return elencoDepositi;
    }

    public List<Withdrawal> getElencoPrelievi() {
        return elencoPrelievi;
    }
    
    public void addDeposito(LocalDate data, Deposit mov) {
        elencoDepositi.add(mov);
        float nuovoSaldo = getSaldo()+mov.getImporto();
        setSaldo(nuovoSaldo); 
        setDataUltimaOp(data);
        System.out.println("Deposito: "+mov.toString());
    }
    
    public void addPrelievo(LocalDate data, Withdrawal mov) {
        elencoPrelievi.add(mov);
        setSaldo(getSaldo()+mov.getImporto()); 
        setDataUltimaOp(data);
    }


    
    public ArrayList<Operation> getMovements() {
        ArrayList<Operation> ris = new ArrayList<>();
        ris.addAll(elencoDepositi);
        ris.addAll(elencoPrelievi);
        //ris.sort();-----------------------------------------------verificare
        return ris;
    }
    
    public List<Deposit> getDeposits() {
        return getElencoDepositi();
    }
    
            
    public List<Withdrawal> getWithdrawals(){
        return getElencoPrelievi();
    }
        
    @Override
    public String toString() {
        return "Account:\n" + "conto corrente: " + nCC + "\n nome: " + nome + "\n saldo= " + saldo 
                + "\n data ultimo movimento: " + dataUltimaOp + "\n";
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); 
    }
    
}
