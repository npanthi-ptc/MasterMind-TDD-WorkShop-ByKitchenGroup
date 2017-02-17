package com.mastermind;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by npanthi on 17-02-2017.
 */
public class GameRunner {

    Scanner in;

    public void initScanner(Scanner in) {
        this.in = in;
    }

    public String getNextInput(){
        return in.nextLine();
    }


    public void run() {
        Game game = new Game("yellow pink blue red");
        initScanner(new Scanner(System.in));

        int i =0;

        do{
            System.out.println("\n Attempt " +  (i+1));
            String input = getNextInput();
            if(game.verifyAttempt(input) == false) {
                continue;
            };

            if(game.getInputAttempts().size() != 0 && isAllInputCorrect(game)) {
                System.out.print("\nGood Game. You Win!");
                break;
            }


            i++;
        }while(i<6);
    }

    private boolean isAllInputCorrect(Game game) {
        return game.getInputAttempts().get(game.getInputAttempts().size()-1).getScore().getNumberOfBlacks() == 4;
    }
}
