package Computer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComputerTest {

    @Test
    public void testStatus() throws Exception {
        Computer computer = new Computer("MacBook Air", "Intel core-i7", "DDR4" ,16 , "SSD" , 256, "SomeName");
        computer.SwitchOn();
        Assert.assertTrue(computer.Status(), String.valueOf(true));
    }

    @Test
    public void testCheckViruses() throws Exception {
        Computer computer = new Computer("MacBook Air", "Intel core-i7", "DDR4" ,16 , "SSD" , 256, "SomeName");
        computer.setViruses();
        Assert.assertEquals(computer.checkViruses(), false);
    }

    @Test
    public void testSizeOfWinchester() throws Exception {
        Computer computer = new Computer("MacBook Air", "Intel core-i7", "DDR4" ,16 , "SSD" , 256, "SomeName");
        Assert.assertEquals(computer.sizeOfWinchester(), 256);
    }

    @Test
    public void testTestToString() throws Exception {
        Computer computer = new Computer("MacBook Air", "Intel core-i7", "DDR4" ,16 , "SSD" , 256, "SomeName");
        Assert.assertEquals(computer.toString(), "Some String");
    }

    @Test
    public void testTestEquals() throws Exception {
        Computer computer1 = new Computer("MacBook Air", "Intel core-i7", "DDR4" ,16 , "SSD" , 256, "SomeName");
        Computer computer2 = new Computer("MacBook Air", "Intel core-i7", "DDR4" ,16 , "SSD" , 256, "SomeName");
        Assert.assertEquals(computer1.equals(computer2), true);
    }
}