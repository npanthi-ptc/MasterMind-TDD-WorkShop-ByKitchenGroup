package unit;

import com.mastermind.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by npanthi on 17-02-2017.
 */
@Test
public class ScoreTest {
    Game game;

    @BeforeMethod
    public void init() {
        String inputCode = "RED GREEN YELLOW BROWN";
        game = new Game(inputCode);
    }

    @Test
    public void showCorrectScore() {
        String inputCode = "RED YELLOW GREEN BLUE";
        Score expectedScore = new Score(1, 2);
        Attempt attempt = new Attempt();
        attempt.setColorSequence(new ColorSequence(Arrays.asList(InputColor.RED, InputColor.YELLOW, InputColor.GREEN, InputColor.BLUE)));
        attempt.calculateScore(game.getSecretCode());
        Assert.assertEquals(attempt.getScore(), expectedScore);
    }
}
