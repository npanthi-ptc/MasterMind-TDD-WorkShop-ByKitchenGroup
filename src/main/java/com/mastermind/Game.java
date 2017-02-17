package com.mastermind;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by npanthi on 16-02-2017.
 */
public class Game {

    private ColorSequence secretCode;
    private List<Attempt> inputAttempts = new ArrayList<Attempt>();

    public Game(String inputCode) {
        ColorSequence inputColorCodes = validateColorCode(inputCode);
        this.secretCode = inputColorCodes;
    }

    private ColorSequence validateColorCode(String inputCode) {
        StringTokenizer tk = new StringTokenizer(inputCode.toUpperCase(), " ");
        List<InputColor> inputColorCodes = new ArrayList<InputColor>();
        while(tk.hasMoreTokens()) {
            InputColor current = InputColor.valueOf(tk.nextToken());
            if(inputColorCodes.contains(current))
                throw new IllegalArgumentException("Repeated Color Code!");
            inputColorCodes.add(current);
        }
        if(inputColorCodes.size() != 4) {
            throw new IllegalArgumentException("Wrong number of colors!");
        }

        return new ColorSequence(inputColorCodes);
    }

    public boolean verifyAttempt(String inputCode) {
        Assistant assistant = new Assistant();
        assistant.addRules();
        Attempt attempt = new Attempt();
        ColorSequence attemptedColorSequence = validateColorCode(inputCode);
        attempt.setColorSequence(attemptedColorSequence);
        if(!assistant.validate(this, attempt)) {
            System.out.println(assistant.getAdvice());
            return false;
        }
        attempt.calculateScore(secretCode);
        inputAttempts.add(attempt);
        attempt.showScore();
        return true;
    }

    public ColorSequence getSecretCode() {
        return secretCode;
    }

    public List<Attempt> getInputAttempts() {
        return inputAttempts;
    }
}
