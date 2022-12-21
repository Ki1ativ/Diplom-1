import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    @Parameterized.Parameters(name = "{0}, {1}")
    public static Object[][] ingredientTypeData() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"},
        };
    }

    private final IngredientType actualType;
    private final String expectedType;

    public IngredientTypeTest(IngredientType actualType, String expectedType) {
        this.actualType = actualType;
        this.expectedType = expectedType;
    }

    @Test
    public void ingredientTypeTest() {
        assertEquals(IngredientType.valueOf(expectedType), actualType);
    }


}
