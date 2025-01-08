package dev.amit.ProductService.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ProductControllerTest {
    @Test
    @DisplayName("1+ 1 equals 2")
    void testOnePlusOneTrue(){

     //   System.out.println("It is True");

        assertEquals (2, 1+1, " one plus is not comming to be");



    }
    @Test
    @DisplayName("testAdditionShouldBeCorrect")
    void testAdditionShouldBeCorrect(){

        assertTrue(-1 + -1 == -2, " adding 2 -ve is not correct");



        assertTrue(-1 + 0 == -1, " adding 1 + 0 is not correct " );

        assertTrue(0+ 0 == 0, " adding 1 + 0 is not");

        assertTrue(0 +-1 == -1,
                " adding 0 -ve is not correct"

        );

        assertFalse(-1 + 1 == 0, " adding 1 + 0 is not correct");
        assertEquals(
                -1 + 1 == 2,
                " adding 1 + 1 is not correct"
        );
    }

    // Assertion Framework
    //--> allows you to make assertion
    // --> allows you to make check






}
