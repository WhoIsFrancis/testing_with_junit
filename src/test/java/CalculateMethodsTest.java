import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculateMethodsTest {
    private CalculateMethods calculateMethods;

    // This will run before every test
    @BeforeEach
    public void initTest() {
        calculateMethods = new CalculateMethods();
    }

    @Test
    public void testDivide(){
        assertEquals(10, calculateMethods.divide(100, 10));
    }

    @Test
    public void testDivideByZero(){
        // First parameter is going to be the exception u want to throw
        // Second parameter is an executable in this case it will be the method divide
        assertThrows(ArithmeticException.class, () -> calculateMethods.divide(100, 0));
    }
}
