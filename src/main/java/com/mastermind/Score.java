package com.mastermind;

/**
 * Created by npanthi on 17-02-2017.
 */
public class Score {

    private int numberOfBlacks;
    private int numberOfWhites;

    public Score(int numberOfBlacks, int numberOfWhites) {
        this.numberOfBlacks = numberOfBlacks;
        this.numberOfWhites = numberOfWhites;
    }

    public int getNumberOfBlacks() {
        return numberOfBlacks;
    }

    public void setNumberOfBlacks(int numberOfBlacks) {
        this.numberOfBlacks = numberOfBlacks;
    }

    public int getNumberOfWhites() {
        return numberOfWhites;
    }

    public void setNumberOfWhites(int numberOfWhites) {
        this.numberOfWhites = numberOfWhites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        if (numberOfBlacks != score.numberOfBlacks) return false;
        return numberOfWhites == score.numberOfWhites;
    }

    @Override
    public int hashCode() {
        int result = numberOfBlacks;
        result = 31 * result + numberOfWhites;
        return result;
    }
}
