package com.practice.techcheck.app.model;

public class Field {
    private final int width;
    private final int depth;

    public Field(int width, int depth) {
        this.width = width;
        this.depth = depth;
    }

    public boolean isOutOfTheField(RobotPosition robotPosition) {
        return robotPosition.xPosition() < 0 || robotPosition.xPosition() >= width ||
               robotPosition.yPosition() < 0 || robotPosition.yPosition() >= depth;
    }
}
