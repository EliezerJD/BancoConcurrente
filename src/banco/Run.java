/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author eliezer
 */
public class Run extends Thread{
   Escenario e = new Escenario();
   Semaphore semA = new Semaphore(1);
   Semaphore semB = new Semaphore(1);
   Rectangle p1;
   Rectangle p2;
   Rectangle p3;
   Rectangle p4;
   Rectangle p5;
   Circle cajero;
   TramiteCajero t;
   Polygon gerente;
    Run(Rectangle p1, Rectangle p2, Rectangle p3, Rectangle p4, Rectangle p5, Circle cajero, Polygon gerente) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.cajero = cajero;
        this.gerente = gerente;
    }

    
    @Override
    public void run(){
       try {
           Thread.currentThread().sleep(700);
       } catch (InterruptedException ex) {
           Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
       }
        for(int x=1; x<=15; x++){
           int servicio = (int) (Math.random()*2);
           Cliente cl = new Cliente(e,p1,p2,p3,p4,p5,cajero,semA, semB, servicio,gerente);
           cl.start();
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
    }
    
}
