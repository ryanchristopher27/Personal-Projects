/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.hello.min;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author rdash
 */
public class HelloWorldController implements Initializable {

    // FXML Variables
    @FXML
    private Button hwButton;
    @FXML
    private Rectangle hwSquare;
    @FXML
    private ListView<String> hwList;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hwButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ArrayList<String> listContents = new ArrayList<>();
                if (hwSquare.getFill() == Color.WHITE) {
                    hwSquare.setFill(Color.BLACK);
                    listContents.add("One");
                    listContents.add("Two");
                    listContents.add("Three");
                    
                }
                else {
                    hwSquare.setFill(Color.WHITE);
                    listContents.add("1");
                    listContents.add("2");
                    listContents.add("3");
                }
                hwList.getItems().clear();
                for (int i = 0; i < listContents.size(); i++) {
                    hwList.getItems().add(listContents.get(i));
                }
            }
            
        });
    }    
    
}
