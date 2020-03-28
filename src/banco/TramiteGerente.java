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
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author eliezer
 */
public class TramiteGerente extends Thread{
    Semaphore semB;
    Escenario e;
    Rectangle p1;
    Rectangle p2;
    Rectangle p3;
    Rectangle p4;
    Rectangle p5;
    Polygon gerente;
    TramiteGerente(Semaphore semB, Escenario e, Rectangle p1, Rectangle p2, Rectangle p3, Rectangle p4, Rectangle p5, Polygon gerente) {
        this.semB = semB;
        this.e = e;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.gerente = gerente;
    }
    @Override
    public void run(){
        try {
            semB.acquire();
            System.out.println("Haciendo tramite... con gerente");
            gerente.setFill(Color.RED);
            int random = (int) (Math.random()*6 + 1);
            Thread.currentThread().sleep((random*1000)-500);
            gerente.setFill(Color.GREEN);
            e.salir(p1, p2, p3, p4, p5);
            semB.release();      
        } catch (InterruptedException ex) {
            Logger.getLogger(TramiteGerente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}

