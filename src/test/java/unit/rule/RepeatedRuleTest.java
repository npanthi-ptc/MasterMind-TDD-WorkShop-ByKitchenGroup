package unit.rule;

import com.mastermind.*;
import com.mastermind.rule.RepeatedRule;
import junit.framework.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by npanthi on 17-02-2017.
 */

@Test
public class RepeatedRuleTest {

    private Game game;

    @BeforeMethod
    public void initGiven() {
        game = new Game("RED GREEN BLUE PINK");
    }

    @Test
    public void showAdviceWhenAnAttemptIsRepeated() {
        Attempt attempt1 = new Attempt();
        attempt1.setColorSequence(new ColorSequence(Arrays.asList(InputColor.GREEN, InputColor.BLUE, InputColor.RED, InputColor.PINK)));
        attempt1.calculateScore(game.getSecretCode());
        game.getInputAttempts().add(attempt1);

        Attempt attempt2 = new Attempt();
        attempt2.setColorSequence(new ColorSequence(Arrays.asList(InputColor.GREEN, InputColor.BLUE, InputColor.RED, InputColor.PINK)));

        Assistant assistant = new Assistant();
        assistant.getRules().add(new RepeatedRule());
        Assert.assertFalse(assistant.validate(game, attempt2));
        Assert.assertEquals(assistant.getAdvice(), "This attempt is already made before.");
    }
}
