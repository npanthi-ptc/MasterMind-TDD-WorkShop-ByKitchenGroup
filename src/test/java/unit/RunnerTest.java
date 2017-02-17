package unit;

import com.mastermind.GameRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * Created by npanthi on 17-02-2017.
 */
@Test
public class RunnerTest {
    @Test
    public void estGetNextInput(){
        GameRunner runner = new GameRunner();
        runner.initScanner(new Scanner("RED BROWN BLUE YELLOW"));
        Assert.assertEquals(runner.getNextInput(),"RED BROWN BLUE YELLOW");

    }
}
