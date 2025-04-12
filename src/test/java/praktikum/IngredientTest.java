package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final static RandomStringUtils randomStringUtils = new RandomStringUtils();
    private final static Random random = new Random();
    private Ingredient ingredient;

    @Parameterized.Parameter(0)
    public IngredientType ingredientType;
    @Parameterized.Parameter(1)
    public String name;
    @Parameterized.Parameter(2)
    public float price;

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] dataIngredients() {
        return new Object[][]{
                {IngredientType.FILLING, randomStringUtils.randomAlphabetic(11), random.nextFloat()},
                {IngredientType.SAUCE, randomStringUtils.randomAlphabetic(11), random.nextFloat()}
        };
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(ingredientType, ingredient.getType());
    }
}