package com.assignment;

import java.util.List;

import org.junit.Test;

public class OceanGridTest {
    
    @Test
    public void testCanMoveTo() {
        OceanGrid grid = new OceanGrid(5, 5, List.of(new Position(1, 1), new Position(2, 2)));

        // Test valid move
        assert grid.canMoveTo(new Position(0, 0));
        assert grid.canMoveTo(new Position(4, 4));

        // Test out of bounds
        assert !grid.canMoveTo(new Position(-1, 0));
        assert !grid.canMoveTo(new Position(0, -1));
        assert !grid.canMoveTo(new Position(5, 0));
        assert !grid.canMoveTo(new Position(0, 5));

        // Test obstacles
        assert !grid.canMoveTo(new Position(1, 1));
        assert !grid.canMoveTo(new Position(2, 2));
    }

}
