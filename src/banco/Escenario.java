/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author eliezer
 */
public class Escenario {
    int cont =1;
    int contColor =0;
    int contSalir= 0;
    int n;
    Color ocupado  = Color.ORANGE;
    Color libre  = Color.WHITE;
    public synchronized void entrar(Rectangle p1, Rectangle p2, Rectangle p3, Rectangle p4, Rectangle p5) throws InterruptedException{
        while(cont>5){
            wait();
        }
        contColor++;
        pintar(contColor, ocupado, p1,p2,p3,p4,p5);
        cont++;
        if(contColor==5){
            contColor=0;
        }
    }
    
    public synchronized void salir(Rectangle p1, Rectangle p2, Rectangle p3, Rectangle p4, Rectangle p5) throws InterruptedException{
        if(contSalir==5){
            contSalir=0;
        }
        contSalir++;
        pintar(contSalir, libre, p1,p2,p3,p4,p5);
        cont--;
        notifyAll();
    }  
    
    
    public void pintar(int cont, Color color, Rectangle p1, Rectangle p2, Rectangle p3, Rectangle p4, Rectangle p5) throws InterruptedException{
        Thread.currentThread().sleep(150);
        switch(cont){
            case 1:{
                p1.setFill(color);
                break;
            }
            case 2:{
                p2.setFill(color);
                break;
            }
            case 3:{
                p3.setFill(color);
                break;
            }
            case 4:{
                p4.setFill(color);
                break;
            }
            case 5:{
                p5.setFill(color);
                break;
            }
            
            
            
        }
    }

    
    
}
