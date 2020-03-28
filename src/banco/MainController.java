/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author eliezer
 */
public class MainController implements Initializable{
    @FXML
    public Circle cajero;
    @FXML
    public Rectangle p5;
    @FXML
    public Rectangle p4;
    @FXML
    public Rectangle p3;
    @FXML
    public Rectangle p2;
    @FXML
    public Rectangle p1;
    @FXML
    private Polygon gerente;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Run run = new Run(p1,p2,p3,p4,p5,cajero,gerente);
        run.start();
        
    }
    
}
