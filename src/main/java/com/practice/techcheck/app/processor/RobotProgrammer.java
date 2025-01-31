package com.practice.techcheck.app.processor;

import com.practice.techcheck.app.exception.RobotOutOfBoundsException;
import com.practice.techcheck.app.model.Field;
import com.practice.techcheck.app.model.Report;
import com.practice.techcheck.app.model.RobotPosition;

public class RobotProgrammer {

    private final Field field;

    public RobotProgrammer(Field field) {
        this.field = field;
    }

    /**
     * This method prints the generated report in the format "Report: xPosition, yPosition, orientation"
     * It exits the application with an error status if the input is invalid or the robot has moved out of the field
     * @param initialPosition
     * @param initialOrientation
     * @param navigationCommands
     */
    public void printReport(RobotPosition initialPosition, char initialOrientation, String navigationCommands) {
        try {
            Report report = generateReport(initialPosition, initialOrientation, navigationCommands);
            System.out.println("Report: " + report.position().xPosition() + " " + report.position().yPosition() + " " + report.orientation());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    /**
     * This method navigates through the Field from the current position and orientation using the given navigation commands,
     * creates the report with final position and orientation and returns it.
     * It throws exception in case of invalid input or if the robot has moved out of the field
     * @param currentPosition
     * @param currentOrientation
     * @param navigationCommands
     * @return
     * @throws Exception
     */
    Report generateReport(RobotPosition currentPosition, char currentOrientation, String navigationCommands) throws Exception {
        for (char command : navigationCommands.toCharArray()) {
            if (isCurrentCommandTurnRight(command)) {
                currentOrientation = getNextOrientationAfterRightTurn(currentOrientation);
            } else if (isCurrentCommandTurnLeft(command)) {
                currentOrientation = getNextOrientationAfterLeftTurn(currentOrientation);
            } else {
                currentPosition = getNextPosition(currentPosition, currentOrientation);
            }
        }

        return new Report(currentPosition, currentOrientation);
    }

    private RobotPosition getNextPosition(RobotPosition currentPosition, char currentOrientation) throws RobotOutOfBoundsException {
        int currentXPosition = currentPosition.xPosition();
        int currentYPosition = currentPosition.yPosition();

        int nextXPosition = currentXPosition;
        int nextYPosition = currentYPosition;

        switch (currentOrientation) {
            case 'N' -> nextYPosition -= 1;
            case 'W' -> nextXPosition -= 1;
            case 'S' -> nextYPosition += 1;
            case 'E' -> nextXPosition += 1;
            default -> throw new RobotOutOfBoundsException("Invalid orientation");
        }



        RobotPosition nextPosition = new RobotPosition(nextXPosition, nextYPosition);

        if (!field.isOutOfTheField(nextPosition)) {
            return  nextPosition;
        } else {
            throw new RobotOutOfBoundsException("Robot moved out of the field");
        }
    }

    private boolean isCurrentCommandTurnLeft(char command) {
        return command == 'L';
    }

    private boolean isCurrentCommandTurnRight(char command) {
        return command == 'R';
    }

    private char getNextOrientationAfterRightTurn(char currentOrientation) throws Exception {
        return switch (currentOrientation)  {
            case 'N' -> 'E';
            case 'E' -> 'S';
            case 'S' -> 'W';
            case 'W' -> 'N';
            default -> throw new Exception("Invalid orientation");
        };
    }

    private char getNextOrientationAfterLeftTurn(char currentOrientation) throws Exception {
        return switch (currentOrientation)  {
            case 'N' -> 'W';
            case 'W' -> 'S';
            case 'S' -> 'E';
            case 'E' -> 'N';
            default -> throw new Exception("Invalid orientation");
        };
    }
}
