package com.practice.techcheck.app.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FieldTest {

    @Test
    public void testFieldBoundaries() {
        Field field = new Field(20, 30);
        assertTrue(field.isOutOfTheField(new RobotPosition(20, 10)), "Given position should be out of the field");
        assertTrue(field.isOutOfTheField(new RobotPosition(13, 30)), "Given position should be out of the field");
        assertFalse(field.isOutOfTheField(new RobotPosition(0, 10)), "Given position should be within the field");
        assertFalse(field.isOutOfTheField(new RobotPosition(0, 0)), "Given position should be within the field");
        assertFalse(field.isOutOfTheField(new RobotPosition(19, 0)), "Given position should be within the field");
    }

}
