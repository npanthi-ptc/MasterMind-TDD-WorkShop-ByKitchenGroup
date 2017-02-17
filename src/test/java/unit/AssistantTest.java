package unit;

import com.mastermind.*;
import com.mastermind.rule.ChangingCorrectColorPermuatationRule;
import com.mastermind.rule.RepeatedRule;
import junit.framework.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by npanthi on 17-02-2017.
 */
@Test
public class AssistantTest {

    private Game game;

    @BeforeMethod
    public void initGiven() {
        game = new Game("RED GREEN BLUE PINK");
    }

    @Test
    public void shouldGiveGoAheadMessageIfAllRulesPass() {
        Attempt attempt1 = new Attempt();
        attempt1.setColorSequence(new ColorSequence(Arrays.asList(InputColor.GREEN, InputColor.BLUE, InputColor.RED, InputColor.PINK)));
        attempt1.calculateScore(game.getSecretCode());

        Attempt attempt2 = new Attempt();
        attempt2.setColorSequence(new ColorSequence(Arrays.asList(InputColor.GREEN, InputColor.BLUE, InputColor.RED, InputColor.BROWN)));

        Assistant assistant = new Assistant();
        assistant.getRules().add(new RepeatedRule());
        assistant.getRules().add(new ChangingCorrectColorPermuatationRule());

        Assert.assertTrue(assistant.validate(game, attempt2));
        Assert.assertEquals("Go Ahead!", assistant.getAdvice());
    }

}
