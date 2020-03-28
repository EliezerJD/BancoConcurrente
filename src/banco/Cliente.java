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
public class Cliente extends Thread{
    Escenario e;
    Rectangle p1;
    Rectangle p2;
    Rectangle p3;
    Rectangle p4;
    Rectangle p5;
    Circle cajero;
    Semaphore semA;
    Semaphore semB;
    TramiteCajero t;
    TramiteGerente g;
    int servicio;
    Polygon gerente;

    Cliente(Escenario e, Rectangle p1, Rectangle p2, Rectangle p3, Rectangle p4, Rectangle p5, Circle cajero, Semaphore semA, Semaphore semB, int servicio, Polygon gerente) {
        this.e = e;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.cajero = cajero;
        this.semA= semA;
        this.semB= semB;
        this.servicio = servicio;
        this.gerente = gerente;
        
    }

    
    @Override
    public void run() {
        try {
            e.entrar(p1,p2,p3,p4,p5);
            switch(servicio){
                case 0:{
                    t = new TramiteCajero(semA, e, p1,p2,p3,p4,p5,cajero);
                    t.start();
                    break;
                }
                case 1:{
                    g = new TramiteGerente(semB, e, p1,p2,p3,p4,p5,gerente);
                    g.start();
                    break;
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
