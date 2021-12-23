package com.example.snakesandladders;

public class player2 extends player {
    static HelloController controller;

    public player2(HelloController H) {
        this.controller = H;
    }

    @Override
    public void findNewPosition(int inc) {
        posValue = posValue + inc;

        if (temp % 2 == 0) {
            if (ycurr + inc > 9) {
                xcurr = xcurr - 1;
                int rem = Math.abs(9 - ycurr - inc);
                ycurr = 10 - rem;
                temp = 1;
            } else {
                ycurr = ycurr + inc;
            }
        } else if (temp % 2 == 1) {
            if (xcurr == 0 && ycurr - inc < 0) {
                return;
            }
            if (ycurr - inc < 0) {
                xcurr = xcurr - 1;
                int rem = Math.abs(ycurr - inc);
                ycurr = rem - 1;
                temp = 0;
            } else {
                ycurr = ycurr - inc;
            }
        }

        checkForLadder();
        checkForSnake();
    }
}
