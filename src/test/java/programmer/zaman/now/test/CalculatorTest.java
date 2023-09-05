package programmer.zaman.now.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.opentest4j.TestAbortedException;

import java.util.Properties;

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
    public void testSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + ": " + value));
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
    @Test
    public void testAssumption() {
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
    }
    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyOnWindows() {
    }
    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisabledOnWindows() {
    }
    @Test
    @EnabledOnJre({JRE.JAVA_8})
    public void testEnableOnJava8() {
    }
    @Test
    @DisabledOnJre({JRE.JAVA_8})
    public void testDisabledOnJava8() {
    }
    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
    public void testEnabledOnJava11To15() {
    }
    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
    public void testDisabledOnJava11To15() {
    }
    @Test
    @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void testEnabledIfJavaVendorOracle() {
    }
    @Test
    @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void testDisabledIfJavaVendorOracle() {
    }
    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE",matches = "DEV")
    public void testEnabledIfProfileDev() {
    }
    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE",matches = "DEV")
    public void testDisabledIfProfileDev() {
    }
}
