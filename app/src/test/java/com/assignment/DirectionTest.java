package com.assignment;

import org.junit.Test;

public class DirectionTest {
    
    @Test
    public void testTurnLeft() {
        assert Direction.NORTH.turnLeft() == Direction.WEST;
        assert Direction.EAST.turnLeft() == Direction.NORTH;
        assert Direction.SOUTH.turnLeft() == Direction.EAST;
        assert Direction.WEST.turnLeft() == Direction.SOUTH;
    }

    @Test
    public void testTurnRight() {
        assert Direction.NORTH.turnRight() == Direction.EAST;
        assert Direction.EAST.turnRight() == Direction.SOUTH;
        assert Direction.SOUTH.turnRight() == Direction.WEST;
        assert Direction.WEST.turnRight() == Direction.NORTH;
    }

}
