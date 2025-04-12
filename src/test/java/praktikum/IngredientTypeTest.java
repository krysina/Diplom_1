package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameter()
    public String ingredientType;

    @Parameterized.Parameters
    public static Object[][] dataType() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void valueOfTest() {
        assertTrue(IngredientType.valueOf(ingredientType) == SAUCE || IngredientType.valueOf(ingredientType)==FILLING);
    }
}