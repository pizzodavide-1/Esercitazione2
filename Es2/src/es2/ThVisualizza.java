/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es2;

/**
 *
 * @author pizzd
 */
public class ThVisualizza extends Thread{
    DatiCondivisi ptrDati;
    int num;
    int buffer;
    int numPariIns;
    int numDispariIns;
    int numPariLetti;
    int numDispariLetti;
    public ThVisualizza(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
        this.num = ptrDati.getNum();
        this.buffer = ptrDati.getBuffer();
    }
    public void run(){
        for(int i = 0; i < num; i++)
        {
         ptrDati.waitSem3();
         buffer=ptrDati.getBuffer();
         numPariIns=ptrDati.getNumPariInseriti();
         numDispariIns=ptrDati.getNumDispariInseriti();
         numPariLetti=ptrDati.getNumPariLetti();
         numDispariLetti=ptrDati.getNumDispariLetti();
        
         System.out.println("Numero generato: " + buffer);
         System.out.println("Numeri pari inseriti: " +  numPariIns);
         System.out.println("Numeri dispari inseriti: " + numDispariIns);
         System.out.println("Numeri pari letti: " + numPariLetti);
         System.out.println("Numeri dispari letti: " + numDispariLetti);
         ptrDati.signalSem4();
    
        }
    }
}
