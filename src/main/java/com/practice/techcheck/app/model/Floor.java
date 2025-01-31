package com.practice.techcheck.app.model;

public class Floor {
    private final int width;
    private final int depth;

    public Floor(int width, int depth) {
        this.width = width;
        this.depth = depth;
    }

    public boolean isOutOfTheFloor(RobotPosition robotPosition) {
        return robotPosition.xPosition() < 0 || robotPosition.xPosition() >= width ||
               robotPosition.yPosition() < 0 || robotPosition.yPosition() >= depth;
    }
}
