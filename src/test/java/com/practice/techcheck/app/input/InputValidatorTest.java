package com.practice.techcheck.app.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputValidatorTest {

    @Test
    public void testInputValidatorForIntegers() {
        InputValidator inputValidator = new InputValidator();
        assertTrue(inputValidator.isNotValid(-2));
        assertTrue(inputValidator.isNotValid(-237));
        assertFalse(inputValidator.isNotValid(0));
        assertFalse(inputValidator.isNotValid(20));
        assertFalse(inputValidator.isNotValid(34535747));
    }

    @Test
    public void testInputValidatorForOrientation() {
        InputValidator inputValidator = new InputValidator();
        assertFalse(inputValidator.isNotValid('N'));
        assertFalse(inputValidator.isNotValid('E'));
        assertFalse(inputValidator.isNotValid('S'));
        assertFalse(inputValidator.isNotValid('W'));

        assertTrue(inputValidator.isNotValid('A'));
        assertTrue(inputValidator.isNotValid('w'));
    }

    @Test
    public void testInputValidatorForNavigationCommands() {
        InputValidator inputValidator = new InputValidator();
        assertFalse(inputValidator.isNotValid("FFFFFFFFFFFFFFFFF"));
        assertFalse(inputValidator.isNotValid("RRRRRRRRRRRRRRRRRRR"));
        assertFalse(inputValidator.isNotValid("LLLLLLLLLLLLLLLLLLLLLL"));
        assertFalse(inputValidator.isNotValid("RFLLFRRFLFLFFLRRRRLFFLFLFFLRLFFFFFFLR"));

        assertTrue(inputValidator.isNotValid("RFLLFRRFLFLFFLRRRRALFFLFLFFLRLFFFFFFLR"));
        assertTrue(inputValidator.isNotValid("RRRLR23345345nn"));
        assertTrue(inputValidator.isNotValid(""));
        assertTrue(inputValidator.isNotValid("  "));
        assertTrue(inputValidator.isNotValid(null));

    }
}
