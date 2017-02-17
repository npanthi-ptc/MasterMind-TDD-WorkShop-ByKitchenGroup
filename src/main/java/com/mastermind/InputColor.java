package com.mastermind;

/**
 * Created by npanthi on 16-02-2017.
 */
public enum InputColor {

    RED("RED"),
    GREEN("GREEN"),
    BLUE("BLUE"),
    BROWN("BROwN"),
    YELLOW("YELLOW"),
    PINK("PINK");

    private String value;
    InputColor(String stringValue) {
        this.value = stringValue;
    }
}
