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
public class ThNumPariLetti extends Thread{
    DatiCondivisi ptrDati;
    int num;
    int buffer;
    public ThNumPariLetti(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
        this.num = ptrDati.getNum();
        this.buffer = ptrDati.getBuffer();
    }
    public void run(){
    for(int i = 0; i < num; i++)
        {
        ptrDati.waitSem1();
        buffer=ptrDati.getBuffer();
        if(buffer%2==0)
        {
        ptrDati.incNumPariLetti();
        
        }
        ptrDati.signalSem2();
        
        
        }
    }
}
