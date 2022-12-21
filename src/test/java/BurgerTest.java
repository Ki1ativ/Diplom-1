import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    private Ingredient sauce1;
    @Mock
    private Ingredient filling1;
    @Mock
    private Bun bunMock;

    @Before
    public void setUp() {
        burger = new Burger();
    }


    @Test
    public void setBunsBurgerTest() {
        burger.setBuns(bunMock);

        Assert.assertEquals(bunMock, burger.bun);
    }

    @Test
    public void addIngredientBurgerTest() {
        burger.addIngredient(sauce1);

        Assert.assertEquals( 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientBurgerTest() {
        burger.addIngredient(sauce1);
        burger.removeIngredient(0);

        Assert.assertTrue( burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientBurgerTest() {
        burger.addIngredient(sauce1);
        burger.addIngredient(filling1);
        burger.moveIngredient(1, 0);

        Assert.assertEquals( filling1, burger.ingredients.get(0));
    }

    @Test
    public void getPriceBurgerTest() {
        burger.addIngredient(sauce1);
        burger.addIngredient(filling1);
        burger.setBuns(bunMock);
        float expected = 600F;
        Mockito.when(bunMock.getPrice()).thenReturn(100F);
        Mockito.when(sauce1.getPrice()).thenReturn(100F);
        Mockito.when(filling1.getPrice()).thenReturn(300F);

        Assert.assertEquals(expected, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptBurgerTest() {
        burger.addIngredient(sauce1);
        burger.setBuns(bunMock);
        Mockito.when(bunMock.getName()).thenReturn("Булка");
        Mockito.when(bunMock.getPrice()).thenReturn(100F);
        Mockito.when(sauce1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce1.getName()).thenReturn("sour cream");
        Mockito.when(sauce1.getPrice()).thenReturn(200F);
        String expectedResult = "(==== Булка ====)\r\n= sauce sour cream =\r\n(==== Булка ====)\r\n\r\nPrice: 400,000000\r\n";

        Assert.assertEquals(expectedResult, burger.getReceipt());

    }

}
