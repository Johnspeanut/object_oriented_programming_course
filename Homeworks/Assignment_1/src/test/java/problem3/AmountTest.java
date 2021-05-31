package problem3;

import org.junit.Before;
import org.junit.Test;
import problem2.Time;

import static org.junit.Assert.*;

public class AmountTest {
    Amount amount1;
    Amount amount2;

    public static boolean amountEquals(Amount amountA, Amount amountB){
        if (amountA == amountB) return true;
        return amountA.getDollar() == amountB.getDollar() && amountA.getCent() == amountB.getCent();
    }

    @Before
    public void setUp() throws Exception {
        amount1 = new Amount(100,55);
        amount2 = new Amount(20,70);
    }

    @Test
    public void getDollar() {
        assertEquals(100,amount1.getDollar());
    }

    @Test
    public void getCent() {
        assertEquals(55,amount1.getCent());
    }

    @Test
    public void add() {
        Amount amountUpdated = Amount.add(amount1, amount2);
        amountEquals(new Amount(121,25),amountUpdated);
    }

    @Test
    public void minus() {
        Amount amountUpdated = Amount.minus(amount1, amount2);
        amountEquals(new Amount(79,85), amountUpdated);
        Amount amountNull = Amount.minus(amount2, amount1);
        amountEquals(null,amountNull);
    }
}