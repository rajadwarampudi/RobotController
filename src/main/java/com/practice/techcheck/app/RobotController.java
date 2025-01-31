package com.practice.techcheck.app;

import com.practice.techcheck.app.input.InputValidator;
import com.practice.techcheck.app.model.Floor;
import com.practice.techcheck.app.model.RobotPosition;
import com.practice.techcheck.app.processor.RobotProgrammer;


public class RobotController {
    public static void main(String[] args) {
        int width = 0, depth = 0;
        int xPosition = 0, yPosition = 0;
        char initialOrientation = 0;
        String navigationCommands = "";
        try {
            InputValidator inputValidator = new InputValidator();
            width = inputValidator.readValidInt("floor width");
            depth = inputValidator.readValidInt("floor depth");
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
        Floor floor = new Floor(width, depth);
        RobotProgrammer robotProgrammer = new RobotProgrammer(floor);

        robotProgrammer.printReport(initialPosition, initialOrientation, navigationCommands);
    }
}