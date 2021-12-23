package com.example.snakesandladders;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public int randnum;
    public boolean start_game;
    static player p1 = new player1(new HelloController());
    static player p2 = new player2(new HelloController());

    @FXML
    public GridPane grid;

    @FXML
    private Button backtostart;

    @FXML
    private Button gotogame;

    @FXML
    public Label gameon;

    @FXML
    public Button player1;

    @FXML
    public Button player2;

    @FXML
    public ImageView rightsnl;

    @FXML
    public ImageView dimage;

    @FXML
    public ImageView leftsnl;


    @FXML
    public Button dice;

    public void startgame(MouseEvent event) {
        start_game = true;
        gameon.setVisible(false);
        p1.pturn = true;
        //p1.setside();
        p2.pturn = false;
    }
    public void startmove(int id){
        if(id==1){
            grid.add(player1, 0,9);
        }
        else if(id==2){
            grid.add(player2, 0,9);
        }
    }
    public void switchTostart1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("start.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToquestion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("question.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchTogame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToexit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("exit.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void move(int inc, int id){
        if(id==1){

            p1.findNewPosition(inc);
            grid.getChildren().remove(player1);
            grid.add(player1,p1.ycurr,p1.xcurr);
            if(p1.xcurr==0 && p1.ycurr==0){
                dice.setDisable(true);
            }

        }
        else if(id==2){
            p2.findNewPosition(inc);
            grid.getChildren().remove(player2);
            grid.add(player2, p2.ycurr, p2.xcurr);
            if(p2.xcurr==0 && p2.ycurr==0){
                dice.setDisable(true);
            }
        }
    }
    @FXML
    void rollingdice(ActionEvent event){
        if(start_game==false){
            return;
        }
        dice.setDisable(true);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int num=1;
                for(int i=0;i<13;i++){
                    Random random = new Random();
                    num = random.nextInt(6)+1;
                    File file = new File("src/main/resources/com/example/dice images/d"+ num +".jpeg");
                    dimage.setImage(new Image(file.toURI().toString()));
                    //dimage.setTranslateZ(20);
                    //diceAnimate();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                randnum = num;
                Runnable update_gui = () -> {
                    if(p1.pturn == true){
                        if(p1.playercanstart==false && randnum == 1){
                            p1.playercanstart = true;
                            startmove(1);

                        }
                        else if(p1.playercanstart==true){
                            move(randnum,1);
                        }
                        rightsnl.setOpacity(1);
                        p2.pturn = true;
                        p1.pturn = false;
                    }
                    else if(p2.pturn==true){
                        if(p2.playercanstart==false && randnum == 1){
                            p2.playercanstart = true;
                            startmove(2);
                        }
                        else if(p2.playercanstart==true){
                            move(randnum,2);
                        }
                        rightsnl.setOpacity(0);
                        p1.pturn = true;
                        p2.pturn = false;
                    }
                    dice.setDisable(false);
                };
                try{
                    Thread.sleep(200);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                Platform.runLater(update_gui);
            }
        });
        t1.start();


    }
}
