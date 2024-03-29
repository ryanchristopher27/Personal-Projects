/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hello.min;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rdash
 */
public class HelloWorld extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        Button btn1 = new Button("Hello World!");
        //StackPane root = new StackPane();
        //root.getChildren().add(btn1);
        
        Parent root = FXMLLoader.load(getClass().getResource("HelloWorld.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hello World JavaFX!");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
