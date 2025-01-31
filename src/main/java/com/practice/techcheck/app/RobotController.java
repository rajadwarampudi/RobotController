package com.practice.techcheck.app;

import com.practice.techcheck.app.input.InputValidator;
import com.practice.techcheck.app.model.Field;
import com.practice.techcheck.app.model.RobotPosition;
import com.practice.techcheck.app.processor.RobotProgrammer;

import java.util.Scanner;

public class RobotController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = 0, depth = 0;
        int xPosition = 0, yPosition = 0;
        char initialOrientation = 0;
        String navigationCommands = "";
        try {
            width = InputValidator.readValidInt(scanner, "field width");
            depth = InputValidator.readValidInt(scanner, "field depth");
            xPosition = InputValidator.readValidInt(scanner, "Robot's initial xPosition");
            yPosition = InputValidator.readValidInt(scanner, "Robot's initial yPosition");
            initialOrientation = InputValidator.readValidOrientation(scanner);
            scanner.nextLine();
            navigationCommands = InputValidator.readValidNavigationCommand(scanner);
        } catch (Exception e) {
            scanner.close();
            System.out.println(e.getMessage());
            System.exit(1);
        } finally {
            scanner.close();
        }

        

        RobotPosition initialPosition = new RobotPosition(xPosition, yPosition);
        Field field = new Field(width, depth);
        RobotProgrammer robotProgrammer = new RobotProgrammer(field);

        robotProgrammer.printReport(initialPosition, initialOrientation, navigationCommands);
    }
}