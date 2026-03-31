package com.assignment;

import java.util.List;
import org.junit.Test;

public class ProbeTest {
    
    @Test
    public void testProbePath() {
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH);

        probe.setPosition(new Position(0, 1));
        probe.setPosition(new Position(0, 2));
        probe.setPosition(new Position(1, 2));

        List<Position> expectedPath = List.of(
            new Position(0, 0),
            new Position(0, 1),
            new Position(0, 2),
            new Position(1, 2)
        );

        assert probe.getPath().equals(expectedPath);
    }

    @Test
    public void testPathImmutability() {
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH);
        List<Position> path = probe.getPath();

        try {
            path.add(new Position(1, 1));
            assert false; // Should not reach here
        } catch (UnsupportedOperationException e) {
            assert true; // Expected exception
        }
    }
}
