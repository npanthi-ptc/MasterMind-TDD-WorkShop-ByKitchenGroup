package com.mastermind.rule;

import com.mastermind.Attempt;
import com.mastermind.Game;
import com.mastermind.rule.Rule;

/**
 * Created by npanthi on 17-02-2017.
 */
public class RepeatedRule implements Rule {

    public static String message = "This attempt is already made before.";

    public boolean validate(Game game, Attempt currentAttempt) {
        for(Attempt attempt: game.getInputAttempts()) {
            if(attempt.getColorSequence().equals(currentAttempt.getColorSequence())) {
                return false;
            }
        }

        return true;
    }

    public String getMessage() {
        return message;
    }
}
