package com.example.snakesandladders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 520, 780);
//        stage.setTitle("Snakes and ladder");
//        stage.setWidth(520);
//        stage.setHeight(780);
//        stage.setResizable(false);
//        stage.setScene(scene);
//        stage.show();
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("Snakes and ladder");
            stage.setWidth(370);
            stage.setHeight(780);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}