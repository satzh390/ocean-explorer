package com.assignment;

import java.util.List;

import org.junit.Test;

public class ProbeControllerTest {
    
    @Test
    public void testProbeCommands() {
        OceanGrid grid = new OceanGrid(5, 5, List.of(new Position(1, 1)));
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH);
        ProbeController controller = new ProbeController(grid, probe);
        String commands = "FFRFFLBB";

        controller.execute(commands);
        Position expectedPosition = new Position(2, 0);
        Direction expectedDirection = Direction.NORTH;  
        List<Position> expectedPath = List.of(
            new Position(0, 0),
            new Position(0, 1),
            new Position(0, 2),
            new Position(1, 2),
            new Position(2, 2),
            new Position(2, 1),
            new Position(2, 0)
        );

        assert probe.getPosition().equals(expectedPosition);
        assert probe.getDirection() == expectedDirection;   
        assert probe.getPath().equals(expectedPath);
    }

    @Test
    public void testProbeCommandsWithObstacles() {  
        OceanGrid grid = new OceanGrid(5, 5, List.of(new Position(1, 1)));
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH);
        ProbeController controller = new ProbeController(grid, probe);
        String commands = "FRFF";

        controller.execute(commands);
        Position expectedPosition = new Position(0, 1); 
        Direction expectedDirection = Direction.EAST;
        List<Position> expectedPath = List.of(
            new Position(0, 0),
            new Position(0, 1) // blocked by obstacle at (1, 1)
        );  

        assert probe.getPosition().equals(expectedPosition);
        assert probe.getDirection() == expectedDirection;
        assert probe.getPath().equals(expectedPath);
    }

    @Test
    public void testProbeCommandsOutOfBounds() {
        OceanGrid grid = new OceanGrid(5, 5, List.of());
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH);
        ProbeController controller = new ProbeController(grid, probe);
        String commands = "FFFFF"; // Attempt to move out of bounds

        controller.execute(commands);
        Position expectedPosition = new Position(0, 4); // Should stop at the edge
        Direction expectedDirection = Direction.NORTH;
        List<Position> expectedPath = List.of(
            new Position(0, 0),
            new Position(0, 1),
            new Position(0, 2),
            new Position(0, 3),
            new Position(0, 4) // stops here
        );

        assert probe.getPosition().equals(expectedPosition);
        assert probe.getDirection() == expectedDirection;
        assert probe.getPath().equals(expectedPath);
    }

    @Test
    public void testProbeSummary() {
        OceanGrid grid = new OceanGrid(5, 5, List.of(new Position(1, 1)));
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH);
        ProbeController controller = new ProbeController(grid, probe);
        String commands = "FFRFFLBB";

        controller.execute(commands);
        String expectedSummary = """
        Current Position: (2, 0)
        Current Direction: NORTH
        Path Taken: (0, 0) -> (0, 1) -> (0, 2) -> (1, 2) -> (2, 2) -> (2, 1) -> (2, 0)
        """.replaceAll("\\r\\n", "\n").trim();

        // Capture the output of printSummary
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        controller.printSummary();
        String actualSummary = outContent.toString().replaceAll("\\r\\n", "\n").trim();

        assert actualSummary.equals(expectedSummary);
    }
}
