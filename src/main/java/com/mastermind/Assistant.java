package com.mastermind;

import com.mastermind.rule.ChangingCorrectColorPermuatationRule;
import com.mastermind.rule.RepeatedRule;
import com.mastermind.rule.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by npanthi on 17-02-2017.
 */
public class Assistant {

    private String advice;
    private List<Rule> rules = new ArrayList<Rule>();

    public Assistant() {

    }

    public void addRules() {
        rules.add(new RepeatedRule());
        rules.add(new ChangingCorrectColorPermuatationRule());
    }

    public boolean validate(Game game, Attempt attempt) {
        for(Rule rule: this.rules) {
            if(!rule.validate(game, attempt)) {
                this.advice = rule.getMessage();
                return false;
            }
            this.advice = "Go Ahead!";
        }
        return true;
    }

    public String getAdvice() {
        return advice;
    }

    public List<Rule> getRules() {
        return rules;
    }
}
