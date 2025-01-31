package com.practice.techcheck.app.processor;

import com.practice.techcheck.app.model.Field;
import com.practice.techcheck.app.model.Report;
import com.practice.techcheck.app.model.RobotPosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RobotProgrammerTest {

    @Test
    public void testGenerateReport() throws Exception {
        RobotProgrammer robotProgrammer = new RobotProgrammer(new Field(5, 5));
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
    public void TestGenerateReportThrowsException() {
        RobotProgrammer robotProgrammer = new RobotProgrammer(new Field(1, 1));
        Throwable exception = assertThrows(Exception.class, () -> robotProgrammer.generateReport(
                new RobotPosition(0, 0 ), 'N', "FFFFFFF"));
        assertEquals("Exception", exception.getMessage());
    }
}
