package com.project.ecobike;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class TestCases {

    private Validation validation = new Validation();

    @Test
    @ParameterizedTest(name = "For example, input {0} is not supported.")
    public void testIfInteger() {
        String str = validation.validatorIfInteger("66");
        if (!str.equals("1")) {
            System.out.println("Test faled");
        }
    }

    @Test
    public void testMenu() {
        String str = validation.validatorIfInteger("1");
        if (!str.equals("1")) {
            System.out.println("Test faled");
        }
    }

    @Test
    public void testAvailable() {
        String str = validation.validatorAvailable("1");
        if (!str.equals("true")) {
            System.out.println("Test faled");
        }
    }

}
