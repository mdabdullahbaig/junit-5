package com.abdullah.junit;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @Nested
    class NestedTest {
        @Test
        void positive() {
            assertEquals(2, mathUtils.add(1, 1));
        }

        @Test

        void negative() {
            assertEquals(-2, mathUtils.add(-1, -1));
        }
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up...");
    }

    @Test
    @DisplayName("Add Method")
    void add() {
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual, "The add method should add two numbers.");
    }

    @Test
    void computeSquareArea() {
        double expected = 16;
        double actual = mathUtils.computeSquareArea(4);
        assertEquals(expected, actual, "The computeSquareArea method should give area of the square.");
    }

    @Test
    void divide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(4, 0), "Divide by zero should throw.");
    }

    @Test
    @Disabled
    void testDisabled() {
        fail("This test should be disabled.");
    }

    @Test
    void testAssertAll() {
        assertAll(
                () -> mathUtils.add(3, 7),
                () -> mathUtils.divide(6, 2),
                () -> mathUtils.divide(6, 3)
        );
    }

    @RepeatedTest(3)
    void repeatedTestAdd(RepetitionInfo repetitionInfo) {
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        System.out.println(totalRepetitions );
        assertEquals(5, mathUtils.add(2,3));
    }


}