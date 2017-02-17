package unit;

import com.mastermind.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by npanthi on 17-02-2017.
 */
public class AttemptTest {

    Game game;

    @BeforeMethod
    public void givenGame() {
        String inputCode = "RED GREEN YELLOW BROWN";
        game = new Game(inputCode);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void throwErrorIfInputDoesNotContainExactlyFourColors() {
        String inputCode = "RED GREEN YELLOW BLUE BROWN";
        game.verifyAttempt(inputCode);
    }


    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Repeated Color Code!")
    public void throwErrorIfColorsAreRepeatedInInput() {
        String inputCode = "RED RED GREEN YELLOW";
        game.verifyAttempt(inputCode);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void throwErrorIfInputColorsHaveBlackOrWhite() {
        String inputCode = "RED GREEN YELLOW WHITE";
        game.verifyAttempt(inputCode);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void throwErrorIfInputIsInvalid() {
        String inputCode = "RED GREEN ELEPHANT YELLOW";
        game.verifyAttempt(inputCode);
    }

    @Test
    public void storeAttemptIfInputIsValid() {
        String inputCode = "RED GREEN YELLOW BLUE";
        game.verifyAttempt(inputCode);
        List<InputColor> actualInputColors = Arrays.asList(InputColor.RED, InputColor.GREEN, InputColor.YELLOW, InputColor.BLUE);
        ColorSequence actualColorSequence = new ColorSequence(actualInputColors);
        Assert.assertTrue(game.getInputAttempts().get(0).getColorSequence().equals(actualColorSequence));
    }

    @Test
    public void calculateScoreIfInputIsValid() {
        String inputCode = "GREEN RED YELLOW BLUE"; //1B 2W
        game.verifyAttempt(inputCode);
        Assert.assertEquals(game.getInputAttempts().get(0).getScore(), new Score(1, 2));
    }

    @Test
    public void ignoreSpacesInInput() {
        String inputCode = "RED    GREEN YELLOW BLUE    ";
        game.verifyAttempt(inputCode);
    }

    @Test
    public void ingoreCaseAndStoreColorCodeIfInputIsValid() {
        String inputCode = "Red gREEN yellow BLUE";
        game.verifyAttempt(inputCode);
    }
}
