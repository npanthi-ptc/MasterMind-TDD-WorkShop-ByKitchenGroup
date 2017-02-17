package unit;

import com.mastermind.Game;
import com.mastermind.InputColor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by npanthi on 16-02-2017.
 */
@Test
public class SecretCodeTest {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void throwErrorIfInputDoesNotContainExactlyFourColors() {
        String inputCode = "RED GREEN YELLOW BLUE BROWN";
        Game game = new Game(inputCode);
    }


    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Repeated Color Code!")
    public void throwErrorIfColorsAreRepeatedInInput() {
        String inputCode = "RED RED GREEN YELLOW";
        Game game = new Game(inputCode);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void throwErrorIfInputColorsHaveBlackOrWhite() {
        String inputCode = "RED GREEN YELLOW WHITE";
        Game game = new Game(inputCode);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void throwErrorIfInputIsInvalid() {
        String inputCode = "RED GREEN ELEPHANT YELLOW";
        Game game = new Game(inputCode);
    }

    @Test
    public void storeColorCodeIfInputIsValid() {
        String inputCode = "RED GREEN YELLOW BLUE";
        Game game = new Game(inputCode);
        List<InputColor> actualInputColors = Arrays.asList(InputColor.RED, InputColor.GREEN, InputColor.YELLOW, InputColor.BLUE);
        Assert.assertEquals(actualInputColors, game.getSecretCode().getSequence());
    }

    @Test
    public void ignoreSpacesInInput() {
        String inputCode = "      RED    GREEN YELLOW BLUE    ";
        Game game = new Game(inputCode);
        List<InputColor> actualInputColors = Arrays.asList(InputColor.RED, InputColor.GREEN, InputColor.YELLOW, InputColor.BLUE);
        Assert.assertEquals(actualInputColors, game.getSecretCode().getSequence());
    }

    @Test
    public void ingoreCaseAndStoreColorCodeIfInputIsValid() {
        String inputCode = "Red gREEN yellow BLUE";
        Game game = new Game(inputCode);
        List<InputColor> actualInputColors = Arrays.asList(InputColor.RED, InputColor.GREEN, InputColor.YELLOW, InputColor.BLUE);
        Assert.assertEquals(actualInputColors, game.getSecretCode().getSequence());
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Wrong number of colors!")
    public void throwErrorIfInputIsEmptyString() {
        String inputCode = "";
        Game game = new Game(inputCode);
    }
}
