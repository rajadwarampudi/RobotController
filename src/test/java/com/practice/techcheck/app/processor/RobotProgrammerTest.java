package com.practice.techcheck.app.processor;

import com.practice.techcheck.app.model.Floor;
import com.practice.techcheck.app.model.Report;
import com.practice.techcheck.app.model.RobotPosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RobotProgrammerTest {

    @Test
    public void testGenerateReport() throws Exception {
        RobotProgrammer robotProgrammer = new RobotProgrammer(new Floor(5, 5));
        Report report = robotProgrammer.generateReport(new RobotPosition(1, 2), 'N', "RFRFFRFRF");
        assertEquals(1, report.position().xPosition());
        assertEquals(3, report.position().yPosition());
        assertEquals('N', report.orientation());

        report = robotProgrammer.generateReport(new RobotPosition(0, 0), 'E', "RFLFFLRF");
        assertEquals(3, report.position().xPosition());
        assertEquals(1, report.position().yPosition());
        assertEquals('E', report.orientation());
    }

    @Test
    public void TestGenerateReportThrowsExceptionOnOuterBounds() {
        RobotProgrammer robotProgrammer = new RobotProgrammer(new Floor(10, 10));
        Throwable exception = assertThrows(Exception.class, () -> robotProgrammer.generateReport(
                new RobotPosition(0, 0), 'S', "FFFFFFFFFFFFFFFF"));
        assertEquals("Robot moved out of the floor", exception.getMessage());

        exception = assertThrows(Exception.class, () -> robotProgrammer.generateReport(
                new RobotPosition(0, 0), 'N', "FFFFFFFFFFFFFFFF"));
        assertEquals("Robot moved out of the floor", exception.getMessage());

        exception = assertThrows(Exception.class, () -> robotProgrammer.generateReport(
                new RobotPosition(5, 6), 'E', "FFFFFFFFFFFFFFFF"));
        assertEquals("Robot moved out of the floor", exception.getMessage());

        exception = assertThrows(Exception.class, () -> robotProgrammer.generateReport(
                new RobotPosition(4, 3), 'W', "FFFFFFFFFFFFFFFF"));
        assertEquals("Robot moved out of the floor", exception.getMessage());
    }
}
