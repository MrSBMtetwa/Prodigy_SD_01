/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperatureconvertapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author sthandisobrighton
 */
public class TemperatureConvertApp extends Application {
   

    @Override
    public void start(Stage primaryStage) {
     
        Label celsiusLabel = new Label("Celsius:");
        TextField celsiusInput = new TextField();
        
        Label fahrenheitLabel = new Label("Fahrenheit:");
        TextField fahrenheitOutput = new TextField();
        fahrenheitOutput.setEditable(false); 
        
        Label kelvinLabel = new Label("Kelvin:");
        TextField kelvinOutput = new TextField();
        kelvinOutput.setEditable(false);  

        
        Button convertButton = new Button("Convert");

        
        convertButton.setOnAction(e -> {
            try {
             
                double celsius = Double.parseDouble(celsiusInput.getText());

             
                double fahrenheit = (celsius * 9/5) + 32;
                double kelvin = celsius + 273.15;

                
                fahrenheitOutput.setText(String.format("%.2f", fahrenheit));
                kelvinOutput.setText(String.format("%.2f", kelvin));
            } catch (NumberFormatException ex) {
                
                showError("Invalid input. Please enter a valid number.");
            }
        });

      
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20));


        grid.add(celsiusLabel, 0, 0);
        grid.add(celsiusInput, 1, 0);
        grid.add(convertButton, 1, 1);
        grid.add(fahrenheitLabel, 0, 2);
        grid.add(fahrenheitOutput, 1, 2);
        grid.add(kelvinLabel, 0, 3);
        grid.add(kelvinOutput, 1, 3);

        
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Input");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

    

