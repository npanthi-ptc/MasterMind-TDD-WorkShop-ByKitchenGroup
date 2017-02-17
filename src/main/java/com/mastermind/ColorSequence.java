package com.mastermind;

import java.util.List;

/**
 * Created by npanthi on 17-02-2017.
 */
public class ColorSequence {
    List<InputColor> sequence;

    public ColorSequence(List<InputColor> combination) {
        this.sequence = combination;
    }

    public List<InputColor> getSequence() {
        return sequence;
    }

    @Override
    public boolean equals(Object o) {
        return this.sequence.equals(((ColorSequence)o).getSequence());
    }

    @Override
    public int hashCode() {
        return sequence != null ? sequence.hashCode() : 0;
    }
}
