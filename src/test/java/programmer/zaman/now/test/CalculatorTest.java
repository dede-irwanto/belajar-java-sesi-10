package programmer.zaman.now.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

@DisplayName("Test untuk Calculator class")
public class CalculatorTest {
    private final Calculator calculator = new Calculator();
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all");
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }
    @BeforeEach
    public void setUp() {
        System.out.println("Before each");
    }
    @AfterEach
    public void tearDown() {
        System.out.println("After each");
    }
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
    @Test
    @Disabled
    public void testComingSoon() {
    }
    @Test
    public void testAborted() {
        var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Test dibatalkan karena bukan DEV");
        }

        // Unit test untuk DEV
    }
}
