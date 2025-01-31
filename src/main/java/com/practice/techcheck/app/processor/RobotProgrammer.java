package com.practice.techcheck.app.processor;

import com.practice.techcheck.app.model.Field;
import com.practice.techcheck.app.model.Report;
import com.practice.techcheck.app.model.RobotPosition;

public class RobotProgrammer {

    private final Field field;

    public RobotProgrammer(Field field) {
        this.field = field;
    }

    public void printReport(RobotPosition initialPosition, char initialOrientation, String navigationCommands) {
        try {
            Report report = generateReport(initialPosition, initialOrientation, navigationCommands);
            System.out.println("Report: " + report.position().xPosition() + " " + report.position().yPosition() + " " + report.position());
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    Report generateReport(RobotPosition currentPosition, char currentOrientation, String navigationCommands) throws Exception {
        for (char command : navigationCommands.toCharArray()) {
            if (isCurrentCommandTurnRight(command)) {
                currentOrientation = getNextDirectionAfterRightTurn(currentOrientation);
            } else if (isCurrentCommandTurnLeft(command)) {
                currentOrientation = getNextDirectionAfterLeftTurn(currentOrientation);
            } else {
                currentPosition = getNextPosition(currentPosition, currentOrientation);
            }
        }

        System.out.println("Report: " + currentPosition.xPosition() + " " + currentPosition.yPosition() + " " + currentOrientation);

        return new Report(currentPosition, currentOrientation);
    }

    private RobotPosition getNextPosition(RobotPosition currentPosition, char currentDirection) throws Exception {
        int currentXPosition = currentPosition.xPosition();
        int currentYPosition = currentPosition.yPosition();

        int nextXPosition = currentXPosition;
        int nextYPosition = currentYPosition;

        switch (currentDirection) {
            case 'N' -> nextYPosition -= 1;
            case 'W' -> nextXPosition -= 1;
            case 'S' -> nextYPosition += 1;
            case 'E' -> nextXPosition += 1;
            default -> System.out.println("Invalid Direction");
        }



        RobotPosition nextPosition = new RobotPosition(nextXPosition, nextYPosition);

        if (!field.isOutOfTheField(nextPosition)) {
            return  nextPosition;
        } else {
            throw new Exception("Exception");
        }
    }

    private boolean isCurrentCommandTurnLeft(char command) {
        return command == 'L';
    }

    private boolean isCurrentCommandTurnRight(char command) {
        return command == 'R';
    }

    private char getNextDirectionAfterRightTurn(char currentDirection) {
        return switch (currentDirection)  {
            case 'N' -> 'E';
            case 'E' -> 'S';
            case 'S' -> 'W';
            case 'W' -> 'N';
            default -> 'T';
        };
    }

    private char getNextDirectionAfterLeftTurn(char currentDirection) {
        return switch (currentDirection)  {
            case 'N' -> 'W';
            case 'W' -> 'S';
            case 'S' -> 'E';
            case 'E' -> 'N';
            default -> 'T';
        };
    }
}
