package com.practice.techcheck.app.input;

import com.practice.techcheck.app.exception.InvalidInputException;

import java.util.Scanner;

public class InputValidator {
    Scanner scanner;

    public InputValidator() {
        scanner = new Scanner(System.in);

    }

    public int readValidInt(String inputName) throws Exception{
        try {
            int input = scanner.nextInt();
            if (isNotValid(input)) {
                throw new InvalidInputException(inputName + ": " + input + " is invalid");
            }
            return input;
        } catch (Exception ex) {
            scanner.close();
            throw new InvalidInputException("Wrong format for the input: " + inputName);
        }
    }

    boolean isNotValid(int input) {
        return input < 0;
    }

    public char readValidOrientation() throws InvalidInputException {
        try {
            char initialOrientation = scanner.next().charAt(0);
            if (isNotValid(initialOrientation)) {
                throw new InvalidInputException("Initial orientation: " + initialOrientation + " is invalid");
            }
            return initialOrientation;
        } catch (Exception ex) {
            scanner.close();
            throw new InvalidInputException("Wrong format for the initial orientation: " + ex.getMessage());
        }
    }

    boolean isNotValid(char initialOrientation) {
        return initialOrientation != 'N' && initialOrientation != 'E' && initialOrientation != 'S' && initialOrientation != 'W';
    }

    public String readValidNavigationCommand() throws InvalidInputException {
        try {
            scanner.nextLine();
            String navigationCommands = scanner.nextLine();
            if (isNotValid(navigationCommands)) {
                throw new InvalidInputException("Navigation commands contains invalid letters: " + navigationCommands);
            }
            return navigationCommands;
        } catch (Exception ex) {
            scanner.close();
            throw new InvalidInputException("Navigation command is invalid: " +ex.getMessage());
        }
    }

    public void close() {
        scanner.close();
    }

    boolean isNotValid(String navigationCommands) {
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
