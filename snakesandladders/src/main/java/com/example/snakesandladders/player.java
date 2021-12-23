package com.example.snakesandladders;

import javafx.scene.Node;

import java.util.ArrayList;

abstract class player {

    public boolean pturn;
    public boolean playercanstart;
    public int xcurr, ycurr;
    public int posValue, temp=0;
    static int i=0;
    static int arr[][];


    ArrayList<Ladders> allLadders = new ArrayList<>();
    ArrayList<Snakes> allSnakes = new ArrayList<>();
    {

        int arr1[][] = {{9,2,7,3},{9,6,6,6},{8,8,6,9},{8,0,5,0},{6,4,5,5},{4,0,1,0},{4,4,3,2},{2,2,0,3},{2,5,0,5},{3,8,0,7}};
        int arr2[][] = {{7,1,9,1},{5,3,7,2},{8,5,9,4},{6,7,9,7},{2,1,5,2},{1,4,3,4},{0,6,5,6},{3,7,5,9},{0,8,2,9},{0,2,1,1}};
        for(int i=0;i<10;i++){
            Ladders ladder = new Ladders();
            ladder.startx = arr1[i][0];
            ladder.starty = arr1[i][1];
            ladder.destx = arr1[i][2];
            ladder.desty = arr1[i][3];
            allLadders.add(ladder);
            Snakes snake = new Snakes();
            snake.startx = arr2[i][0];
            snake.starty = arr2[i][1];
            snake.destx = arr2[i][2];
            snake.desty = arr2[i][3];
            allSnakes.add(snake);
        }

    }
    public void findNewPosition(int inc){}

    public void checkForLadder(){
        for(int i=0;i<10;i++){
            if(allLadders.get(i).startx==xcurr && allLadders.get(i).starty==ycurr){
                if(Math.abs(xcurr-allLadders.get(i).destx)%2==1){
                    if(temp==0){
                        temp=1;
                    }
                    else{
                        temp=0;
                    }
                }
                xcurr = allLadders.get(i).destx;
                ycurr = allLadders.get(i).desty;
                break;
            }
        }
    }

    public void checkForSnake(){
        for(int i=0;i<10;i++){
            if(allSnakes.get(i).startx==xcurr && allSnakes.get(i).starty==ycurr){
                if(Math.abs(xcurr-allSnakes.get(i).destx)%2==1){
                    if(temp==0){
                        temp=1;
                    }
                    else{
                        temp=0;
                    }
                }
                xcurr = allSnakes.get(i).destx;
                ycurr = allSnakes.get(i).desty;
                break;
            }
        }
    }

}

//class player1 extends player{
//    static HelloController controller;
//    public player1(HelloController H){
//        this.controller = H;
//    }
//    @Override
//    public void findNewPosition(int inc){
//        posValue = posValue + inc;
//        if(temp%2==0){
//            if(ycurr+inc>9){
//                xcurr= xcurr-1;
//                int rem = Math.abs(9-ycurr-inc);
//                ycurr = 10-rem;
//                temp=1;
//            }
//            else{
//                ycurr = ycurr+inc;
//
//            }
//        }
//        else if(temp%2==1){
//            if(xcurr==0 && ycurr-inc<0){
//                return;
//            }
//            if(ycurr-inc<0){
//                xcurr = xcurr-1;
//                int rem = Math.abs(ycurr-inc);
//                ycurr = rem-1;
//                temp=0;
//            }
//            else{
//                ycurr = ycurr-inc;
//            }
//        }
//        checkForLadder();
//        checkForSnake();
//    }
//
//}

//class player2 extends player {
//    static HelloController controller;
//
//    public player2(HelloController H) {
//        this.controller = H;
//    }
//
//    @Override
//    public void findNewPosition(int inc) {
//        posValue = posValue + inc;
//
//        if (temp % 2 == 0) {
//            if (ycurr + inc > 9) {
//                xcurr = xcurr - 1;
//                int rem = Math.abs(9 - ycurr - inc);
//                ycurr = 10 - rem;
//                temp = 1;
//            } else {
//                ycurr = ycurr + inc;
//            }
//        } else if (temp % 2 == 1) {
//            if (xcurr == 0 && ycurr - inc < 0) {
//                return;
//            }
//            if (ycurr - inc < 0) {
//                xcurr = xcurr - 1;
//                int rem = Math.abs(ycurr - inc);
//                ycurr = rem - 1;
//                temp = 0;
//            } else {
//                ycurr = ycurr - inc;
//            }
//        }
//
//        checkForLadder();
//        checkForSnake();
//    }
//}
