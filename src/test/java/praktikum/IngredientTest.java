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
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] createIngredient() {
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