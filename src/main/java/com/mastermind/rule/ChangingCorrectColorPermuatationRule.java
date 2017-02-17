package com.mastermind.rule;

import com.mastermind.Attempt;
import com.mastermind.Game;
import com.mastermind.InputColor;

/**
 * Created by npanthi on 17-02-2017.
 */
public class ChangingCorrectColorPermuatationRule implements Rule {
    private static String message = "All colors were correct in your previous attempt. Changing colors is a waste of move.";

    public boolean validate(Game game, Attempt currentAttempt) {
        if (game.getInputAttempts().size() == 0) return true;
        Attempt lastAttempt = game.getInputAttempts().get(game.getInputAttempts().size() - 1);

        if(lastAttempt.getScore().getNumberOfWhites() + lastAttempt.getScore().getNumberOfBlacks() == 4) {
            for(InputColor color: currentAttempt.getColorSequence().getSequence()) {
                if(!lastAttempt.getColorSequence().getSequence().contains(color)){
                    return false;
                }
            }
        }

        return true;
    }

    public String getMessage() {
        return message;
    }
}
