package com.practice.techcheck.app.input;

import com.practice.techcheck.app.exception.InvalidInputException;

import java.util.Scanner;

public class InputValidator {
    public static int readValidInt(Scanner scanner, String inputName) throws Exception{
        try {
            return scanner.nextInt();
        } catch (Exception ex) {
            throw new InvalidInputException("Wrong format for the input: " + inputName);
        }
    }

    public static char readValidOrientation(Scanner scanner) throws InvalidInputException {
        try {
            char initialOrientation = scanner.next().charAt(0);
            if (isNotValid(initialOrientation)) {
                throw new InvalidInputException("Initial orientation: " + initialOrientation + " is invalid");
            }
            return initialOrientation;
        } catch (Exception ex) {
            throw new InvalidInputException("Wrong format for the initial orientation: " + ex.getMessage());
        }
    }

    private static boolean isNotValid(char initialOrientation) {
        return initialOrientation != 'N' && initialOrientation != 'E' && initialOrientation != 'S' && initialOrientation != 'W';
    }

    public static String readValidNavigationCommand(Scanner scanner) throws InvalidInputException {
        try {
            String navigationCommands = scanner.nextLine();
            if (isNotValid(navigationCommands)) {
                throw new InvalidInputException("Navigation commands contains invalid letters: " + navigationCommands);
            }
            return navigationCommands;
        } catch (Exception ex) {
            throw new InvalidInputException("Navigation command is invalid: " +ex.getMessage());
        }
    }

    private static boolean isNotValid(String navigationCommands) {
        if (navigationCommands == null || navigationCommands.isBlank())
        {
            return true;
        }

        for (char ch : navigationCommands.toCharArray()) {
            if (ch != 'R' && ch != 'L' && ch != 'F') {
                return true;
            }
        }

        return false;
    }
}
