package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Random;

import static org.junit.Assert.*;

public class BunTest {

    private static RandomStringUtils randomStringUtils = new RandomStringUtils();
    private static Random random = new Random();

    @Parameterized.Parameter(0)
    public String name;

    @Parameterized.Parameter(1)
    public float price;

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Parameterized.Parameters
    public static Object[][] dataBuns() {
        return new Object[][]{
                {randomStringUtils.randomAlphabetic(11), random.nextFloat()},
                {randomStringUtils.randomAlphabetic(11), 19.99f}
        };
    }
    @Test
    public void getNameTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, bun.getPrice(), 0);
    }
}