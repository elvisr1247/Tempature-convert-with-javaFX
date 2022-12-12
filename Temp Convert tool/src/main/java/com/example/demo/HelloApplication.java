package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    String violet = "#F3A2FF";
    String grey = "#D3D3D3";
    String currentColor = violet;
    @Override
    public void start(Stage stage) throws IOException {



        // create a stack pane
        StackPane r = new StackPane();
        r.setStyle("-fx-background-color:#fff;"+
                "-fx-border-color:"+currentColor+";"
                +"-fx-border-radius: 0 10 0 0;"+
                "-fx-border-width: 3;");
        //background
        Rectangle rectangle = new Rectangle(100, 100, 300,400);
        rectangle.setTranslateX(180);
        rectangle.setFill(Color.web(currentColor));



        //labels
        Label degrees = new Label("Degrees");
        Label convert = new Label("Convert");
        Label result = new Label("-1");
        Label resultType = new Label("\u00B0C");

        result.setTranslateX(150);
        result.setFont(new Font("Ariel",70));
        result.setTextFill(Color.web("#fff"));

        resultType.setTranslateX(180);
        resultType.setTranslateY(-40);
        resultType.setFont(new Font("Ariel",15));
        resultType.setTextFill(Color.web("#fff"));

        degrees.setTranslateX(-270);
        degrees.setTranslateY(-150);
        degrees.setTextFill(Color.web(currentColor));

        convert.setTranslateX(-270);
        convert.setTranslateY(-50);
        convert.setTextFill(Color.web(currentColor));



        // create a textfield
        TextField b = new TextField("0");
        b.setPrefWidth(240);
        b.setMaxWidth(240);


        b.setTranslateX(-170);
        b.setTranslateY(-120);

        b.setStyle("-fx-border-color:"+grey+";"
                +"-fx-border-radius: 0 0 0 0;"+
                "-fx-background-radius: 0 0 0 0;");
        //combo box
        ComboBox convertComboBox = new ComboBox();
        convertComboBox.getItems().add("Fahrenheit(\u00B0F)");
        convertComboBox.getItems().add("Celsius(\u00B0C)");
        convertComboBox.getItems().add("Kelvin(K)");
        convertComboBox.getSelectionModel().select(1);//default item


        convertComboBox.setPrefWidth(300);
        convertComboBox.setMaxWidth(300);

        convertComboBox.setTranslateX(-140);
        convertComboBox.setTranslateY(-20);

        convertComboBox.setStyle("-fx-border-color:"+grey+";"
                +"-fx-border-radius: 0 0 0 0;"+
                "-fx-background-radius: 0 0 0 0;"+
                "-fx-background-color:#fff");
        //input type combo
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().add("\u00B0F");
        comboBox.getItems().add("\u00B0C");
        comboBox.getItems().add("K");
        comboBox.getSelectionModel().selectFirst();//default item

        comboBox.setTranslateX(-20);
        comboBox.setTranslateY(-120);

        comboBox.setStyle("-fx-border-color:"+grey+";"
                +"-fx-border-radius: 0 0 0 0;"+
                "-fx-background-radius: 0 0 0 0;"+
                "-fx-background-color:#fff"
        );
        //button
        Button convertButton = new Button("Convert");
        //button actions when pressed
        convertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {


                if(comboBox.getValue().equals("\u00B0F")&&
                convertComboBox.getValue().equals("Celsius(\u00B0C)")){

                    int input = Integer.parseInt(b.getText());
                    int fahtoCel = (int) ((input-32)*5/9);
                    result.setText(String.valueOf(fahtoCel));
                }
                if(comboBox.getValue().equals("\u00B0C")&&
                        convertComboBox.getValue().equals("Fahrenheit(\u00B0F)")){

                    int input = Integer.parseInt(b.getText());
                    int celtoFah = (int)((input*9/5)+32);
                    result.setText(String.valueOf(celtoFah));
                }

                if(comboBox.getValue().equals("\u00B0C")&&
                        convertComboBox.getValue().equals("Kelvin(K)")){

                    int input = Integer.parseInt(b.getText());
                    int celtoKel = (int)((input+273.15));
                    result.setText(String.valueOf(celtoKel));
                }
                if(comboBox.getValue().equals("\u00B0F")&&
                        convertComboBox.getValue().equals("Kelvin(K)")){

                    int input = Integer.parseInt(b.getText());
                    int fahtoKel = (int) ((input-32)*5/9+273.15);
                    result.setText(String.valueOf(fahtoKel));
                }
                if(comboBox.getValue().equals("K")&&
                        convertComboBox.getValue().equals("Fahrenheit(\u00B0F)")){

                    int input = Integer.parseInt(b.getText());
                    int keltoFah = (int)((input - 273.15)*9/5+32);
                    result.setText(String.valueOf(keltoFah));
                    System.out.println(keltoFah);
                }
                if(comboBox.getValue().equals("K")&&
                        convertComboBox.getValue().equals("Celsius(\u00B0C)")){

                    int input = Integer.parseInt(b.getText());
                    int keltoCel = (int)((input-273.15));
                    result.setText(String.valueOf(keltoCel));
                    System.out.println(keltoCel);
                }
                if(comboBox.getValue().equals("\u00B0F")&&convertComboBox.getValue().equals("Fahrenheit(\u00B0F)")||
                   comboBox.getValue().equals("\u00B0C")&&convertComboBox.getValue().equals("Celsius(\u00B0C)")||
                   comboBox.getValue().equals("K")&&convertComboBox.getValue().equals("Kelvin(K)")){
                    result.setText(b.getText());
                }

                if(convertComboBox.getValue().equals("Celsius(\u00B0C)"))
                    resultType.setText("\u00B0C");
                if(convertComboBox.getValue().equals("Fahrenheit(\u00B0F)"))
                    resultType.setText("\u00B0F");
                if(convertComboBox.getValue().equals("Kelvin(K)"))
                    resultType.setText("K");
            }
        });
        //styles the button
        convertButton.setStyle(
                "-fx-background-radius: 5em;"+
                "-fx-background-color: "+currentColor+";"+
                "-fx-text-fill: #fff;"
        );

        convertButton.setTranslateX(-150);
        convertButton.setTranslateY(100);

        // adding items
        r.getChildren().add(b);
        r.getChildren().add(comboBox);
        r.getChildren().add(convertComboBox);
        r.getChildren().add(convertButton);

        //background
        r.getChildren().add(rectangle);
        //labels
        r.getChildren().add(degrees);
        r.getChildren().add(convert);
        r.getChildren().add(result);
        r.getChildren().add(resultType);




        // create a scene
        Scene sc = new Scene(r, 600, 400);
        // set the scene
        stage.setScene(sc);
        stage.setResizable(false);

        stage.setTitle("Temperature Converter");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}