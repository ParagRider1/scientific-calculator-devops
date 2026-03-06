import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testSqrt() {
        assertEquals(4.0, calc.squareRoot(16), 0.001);
    }

    @Test
    public void testFactorial() {
        assertEquals(120, calc.factorial(5));
    }

    @Test
    public void testPower() {
        assertEquals(8.0, calc.power(2,3), 0.001);
    }
}
