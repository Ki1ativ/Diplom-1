import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    private String nameIngredient = "Цезарь";
    private float priceIngredient = 25.5f;

    @Mock
    IngredientType filling;


    @Test

    public void getNameIngredientTest () {
        Ingredient ingredient = new Ingredient(filling, nameIngredient, priceIngredient);
        Assert.assertEquals (nameIngredient, ingredient.getName());
    }

    @Test

    public void getPriceIngredientTest () {
        Ingredient ingredient = new Ingredient(filling, nameIngredient, priceIngredient);
        Assert.assertEquals (priceIngredient, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getTypeIngredientTest () {
        Ingredient ingredient = new Ingredient(filling, nameIngredient, priceIngredient);
        Assert.assertEquals (filling, ingredient.getType());
    }

}
