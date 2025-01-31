package com.practice.techcheck.app;

import com.practice.techcheck.app.model.Field;
import com.practice.techcheck.app.model.RobotPosition;
import com.practice.techcheck.app.processor.RobotProgrammer;

import java.util.Scanner;

public class RobotController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = scanner.nextInt();
        int depth = scanner.nextInt();

        int xPosition = scanner.nextInt();
        int yPosition = scanner.nextInt();
        char initialOrientation = scanner.next().charAt(0);
        scanner.nextLine();

        System.out.println("xPosition " + xPosition + " yPosition: " + yPosition + " initialOrientation: " + initialOrientation);
        String navigationCommands = scanner.nextLine();
        System.out.println(navigationCommands);

        RobotPosition initialPosition = new RobotPosition(xPosition, yPosition);
        Field field = new Field(width, depth);
        RobotProgrammer robotProgrammer = new RobotProgrammer(field);

        robotProgrammer.printReport(initialPosition, initialOrientation, navigationCommands);

        scanner.close();
    }
}