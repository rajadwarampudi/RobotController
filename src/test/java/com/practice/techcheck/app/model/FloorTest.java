package com.practice.techcheck.app.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloorTest {

    @Test
    public void testFloorBoundaries() {
        Floor floor = new Floor(20, 30);
        assertTrue(floor.isOutOfTheFloor(new RobotPosition(20, 10)), "Given position should be out of the floor");
        assertTrue(floor.isOutOfTheFloor(new RobotPosition(13, 30)), "Given position should be out of the floor");
        assertFalse(floor.isOutOfTheFloor(new RobotPosition(0, 10)), "Given position should be within the floor");
        assertFalse(floor.isOutOfTheFloor(new RobotPosition(0, 0)), "Given position should be within the floor");
        assertFalse(floor.isOutOfTheFloor(new RobotPosition(19, 0)), "Given position should be within the floor");
    }

}
