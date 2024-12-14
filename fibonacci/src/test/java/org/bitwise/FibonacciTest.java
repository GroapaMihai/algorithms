package org.bitwise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciTest {
    private final Fibonacci fibonacci = new Fibonacci();

    @Test
    void testFibonacci_1() {
        int result = fibonacci.generate(1);

        Assertions.assertEquals(0, result);
    }

    @Test
    void testFibonacci_2() {
        int result = fibonacci.generate(2);

        Assertions.assertEquals(1, result);
    }

    @Test
    void testFibonacci_5() {
        int result = fibonacci.generate(5);

        Assertions.assertEquals(3, result);
    }

    @Test
    void testFibonacci_10() {
        int result = fibonacci.generate(10);

        Assertions.assertEquals(34, result);
    }

    @Test
    void testFibonacci_30() {
        int result = fibonacci.generate(30);

        Assertions.assertEquals(514229, result);
    }
}
