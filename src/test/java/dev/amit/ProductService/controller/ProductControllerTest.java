package dev.amit.ProductService.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductControllerTest {
    @Test
    @DisplayName("1+ 1 equals 2")
    void testOnePlusOneTrue(){

     //   System.out.println("It is True");

        assertEquals (11, 1+1, " one plus is not comming to be");

    }
    @Test
    @DisplayName("testAdditionShouldBeCorrect")
    void testAdditionShouldBeCorrect(){

        assert -1 + -1 == -2;

        assert -1 + 0 == -1;

        assert 0+ 0 == 0;

        assert 0 +-1 == -1;

        assert -1 + 1 == 0;
        assert 1+1 == 2;
    }

    // Assertion Framework
    //--> allows you to make assertion
    // --> allows you to make check






}
