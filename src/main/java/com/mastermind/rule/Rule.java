package com.mastermind.rule;

import com.mastermind.Attempt;
import com.mastermind.Game;

/**
 * Created by npanthi on 17-02-2017.
 */
public interface Rule {
    boolean validate(Game game, Attempt attempt);
    String getMessage();
}
