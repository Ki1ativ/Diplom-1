import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "{0}, {1}")
    public static Object[][] bunData() {
        return new Object[][]{
                {"",13.1},
                {null,111.1},
                {" ",77.9},
                {"MegaKrutayaСОченьНевероятноДлиннымНазваниемСостоящихИзБуквLatinicaИКириллицаИ666Цифр",0.1f},
                {"Булка=из-Spec_simv!ov^:", 333.9f},
                {"Проверка цены равной ноль", 0},
                {"Проверка отрицательной цены", -10},
                {"Проверка минимальной цены", 0.0f},
                {"Проверка максимальной цены", 9999999999999999999999999999999999999.9f}
                };
            }
    @Test
    public void getNameTest () {
        Bun bun = new Bun (name,price);
        Assert.assertEquals (name, bun.getName());
    }

    @Test
    public void getPriceTest () {
        Bun bun = new Bun (name,price);
        Assert.assertEquals (price, bun.getPrice(), 0.0);
    }

}
