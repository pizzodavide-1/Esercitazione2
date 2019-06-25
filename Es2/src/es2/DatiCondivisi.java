/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pizzd
 */
public class DatiCondivisi {
     private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;
    private Semaphore sem4;
    private int num;
    private int numPariLetti;
    private int numDispariLetti;
    private int numPariInseriti;
    private int numDispariInseriti;
    private int buffer;

    public DatiCondivisi( int num) {
        this.sem1 = new Semaphore(0);
        this.sem2 = new Semaphore(0);
        this.sem3= new Semaphore(0);
        this.sem4=new Semaphore(1);
        this.num = num;
    }
    
     public void setSem1(Semaphore sem1) {
        this.sem1 = sem1;
    }

    public void setSem2(Semaphore sem2) {
        this.sem2 = sem2;
    }
    
    public Semaphore getSem1() {
        return sem1;
    }

    public Semaphore getSem2() {
        return sem2;
    }
      public void setNum(int num) {
        this.num = num;
    }
       public int getNum() {
        return num;
    }
    public int getBuffer() {
        return buffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }
     public int getNumPariLetti() {
        return numPariLetti;
    }

    public void setNumPariLetti(int numPariLetti) {
        this.numPariLetti = numPariLetti;
    }

    public int getNumDispariLetti() {
        return numDispariLetti;
    }

    public void setNumDispariLetti(int numDispariLetti) {
        this.numDispariLetti = numDispariLetti;
    }

    public int getNumPariInseriti() {
        return numPariInseriti;
    }

    public void setNumPariInseriti(int numPariInseriti) {
        this.numPariInseriti = numPariInseriti;
    }

    public int  getNumDispariInseriti() {
        return numDispariInseriti;
    }

    public synchronized void setNumDispariInseriti(int numDispariInseriti) {
        this.numDispariInseriti = numDispariInseriti;
    }
    public synchronized void incNumPariIns()
   {
   
   this.numPariInseriti++;
   }
   public void incNumDispariIns()
   {
   this.numDispariInseriti++;
   
   }
   public synchronized void incNumPariLetti()
   {
   this.numPariLetti++;
   }
   public synchronized void incNumDispariLetti()
   {
   this.numDispariLetti++;
   }
     public void waitSem1()
    {
        try {
            sem1.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void waitSem2()
    {
        try {
            sem2.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void waitSem3()
    {
        try {
            sem3.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void waitSem4()
    {
        try {
            sem4.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void signalSem1()
    {
    
    sem1.release();
    
    }
    public void signalSem2()
    {
    
    sem2.release();
    }
    public void signalSem3()
    {
    
    sem3.release();
    }
    public void signalSem4()
    {
    
    sem4.release();
    }
    
}
