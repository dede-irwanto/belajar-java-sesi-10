package programmer.zaman.now.test;

import org.junit.jupiter.api.*;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {
    @BeforeAll
    void beforAll() {
    }
    @AfterAll
    void afterAll() {
    }
    private int counter = 0;
    @Test
    @Order(1)
    void test3() {
        counter++;
        System.out.println(counter);
    }
    @Test
    @Order(2)
    void test2() {
        counter++;
        System.out.println(counter);
    }
    @Test
    @Order(3)
    void test1() {
        counter++;
        System.out.println(counter);
    }
}