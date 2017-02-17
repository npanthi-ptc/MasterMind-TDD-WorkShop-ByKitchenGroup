package com.mastermind;

/**
 * Created by npanthi on 17-02-2017.
 */
public class Attempt {
    private ColorSequence colorSequence;
    private Score score;

    public void setColorSequence(ColorSequence colorSequence) {
        this.colorSequence = colorSequence;
    }

    public ColorSequence getColorSequence() {
        return colorSequence;
    }

    public void calculateScore(ColorSequence secretCode) {
        int numberOfBlacks = 0;
        int numberOfWhites = 0;

        for(int i=0; i<colorSequence.getSequence().size(); i++) {
            if(isBothPositionAndColorCorrect(secretCode, i)) {
                numberOfBlacks++;
            }
            else if(isColorCorrect(secretCode, i)) {
                numberOfWhites++;
            }
        }

        score = new Score(numberOfBlacks, numberOfWhites);
    }

    private boolean isColorCorrect(ColorSequence secretCode, int i) {
        return secretCode.getSequence().contains(colorSequence.getSequence().get(i));
    }

    private boolean isBothPositionAndColorCorrect(ColorSequence secretCode, int i) {
        return colorSequence.getSequence().get(i).equals(secretCode.getSequence().get(i));
    }

    public Score getScore() {
        return score;
    }


    public void showScore() {
        System.out.print(score.getNumberOfBlacks() + " black " + score.getNumberOfWhites() + " white");
    }
}
