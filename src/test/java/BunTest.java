import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun = new Bun ("MegaBulka", 66.6f);

    @Test
    public void getNameTest () {
        Assert.assertEquals ("MegaBulka", bun.getName());
    }

    @Test
    public void getPriceTest () {
        Assert.assertEquals (66.6f, bun.getPrice(), 0.0);
    }

}
