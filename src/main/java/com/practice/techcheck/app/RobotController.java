package com.practice.techcheck.app;

import com.practice.techcheck.app.input.InputValidator;
import com.practice.techcheck.app.model.Field;
import com.practice.techcheck.app.model.RobotPosition;
import com.practice.techcheck.app.processor.RobotProgrammer;

import java.util.Scanner;

public class RobotController {
    public static void main(String[] args) {
        int width = 0, depth = 0;
        int xPosition = 0, yPosition = 0;
        char initialOrientation = 0;
        String navigationCommands = "";
        try {
            InputValidator inputValidator = new InputValidator();
            width = inputValidator.readValidInt("field width");
            depth = inputValidator.readValidInt("field depth");
            xPosition = inputValidator.readValidInt("Robot's initial xPosition");
            yPosition = inputValidator.readValidInt("Robot's initial yPosition");
            initialOrientation = inputValidator.readValidOrientation();
            navigationCommands = inputValidator.readValidNavigationCommand();
            inputValidator.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        

        RobotPosition initialPosition = new RobotPosition(xPosition, yPosition);
        Field field = new Field(width, depth);
        RobotProgrammer robotProgrammer = new RobotProgrammer(field);

        robotProgrammer.printReport(initialPosition, initialOrientation, navigationCommands);
    }
}