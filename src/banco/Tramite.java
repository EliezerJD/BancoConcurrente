/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author eliezer
 */
public class Tramite extends Thread{
    Semaphore semA;
    Escenario e;
    Rectangle p1;
    Rectangle p2;
    Rectangle p3;
    Rectangle p4;
    Rectangle p5;
    Circle cajero;

    Tramite(Semaphore semA, Escenario e, Rectangle p1, Rectangle p2, Rectangle p3, Rectangle p4, Rectangle p5, Circle cajero) {
        this.semA = semA;
        this.e = e;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.cajero = cajero;
    }
    @Override
    public void run(){
        try {
            semA.acquire();
            System.out.println("Haciendo tramite...");
            cajero.setFill(Color.RED);
            Thread.currentThread().sleep(3500);
            cajero.setFill(Color.GREEN);
            e.salir(p1, p2, p3, p4, p5, cajero);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Tramite.class.getName()).log(Level.SEVERE, null, ex);
        } 
        semA.release();
    }
    
}
