/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es2;

import java.util.Random;
/**
 *
 * @author pizzd
 */
public class ThGenera extends Thread{
    DatiCondivisi ptrDati;
    int num;
    int buffer;
    
      public ThGenera(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
        this.num = ptrDati.getNum();
        this.buffer=ptrDati.getBuffer();
    }

  
    public void run(){
    Random rand = new Random();
        for(int i = 0; i < num; i++)
        {
        ptrDati.waitSem4();
        buffer=rand.nextInt(10);
        if(buffer %2 == 0)
        {
        ptrDati.incNumPariIns();
        
        }
        else
        {
        ptrDati.incNumDispariIns();
        
        }
        ptrDati.setBuffer(buffer);
        ptrDati.signalSem1();
        }
    }
}
