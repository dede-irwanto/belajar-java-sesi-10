package programmer.zaman.now.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Test untuk Calculator class")
public class CalculatorTest {
    private final Calculator calculator = new Calculator();
    @Test
    @DisplayName("Test skenario sukses untuk method add(Integer, Integer)")
    public void testAddSuccess() {
        var result = calculator.add(10,10);
        assertEquals(20, result);
    }
    @Test
    public void testDevideSuccess() {
        var result = calculator.devide(10,10);
        assertEquals(1, result);
    }
    @Test
    public void testDevideFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.devide(10,0);
        });
    }
}
