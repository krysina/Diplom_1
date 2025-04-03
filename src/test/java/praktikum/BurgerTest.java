package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1, mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(1,0);
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        // Настройки моков
        Mockito.when(mockBun.getPrice()).thenReturn(100F);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(200F);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(100F);

        // Устанавливаем булочку и ингредиенты
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Проверяем правильность результата getPrice()
        assertEquals(500F,burger.getPrice(),0);
    }

    @Test
    public void getReceiptTest() {
        // Настройки моков
        Mockito.when(mockBun.getName()).thenReturn("black bun");
        Mockito.when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(mockIngredient1.getName()).thenReturn("hot sauce");
        Mockito.when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mockIngredient2.getName()).thenReturn("cutlet");
        Mockito.when(mockBun.getPrice()).thenReturn(100F);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(200F);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(100F);

        // Устанавливаем булочку и ингредиенты
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Выполняем действие
        String receipt = burger.getReceipt();

        // Проверяем, что метод getPrice() был вызван один раз
        verify(mockBun, times(1)).getPrice();

        // Проверяем правильность результата getReceipt()
        assertEquals(String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n","black bun","sauce","hot sauce","filling","cutlet","black bun",500F), receipt);
    }
}