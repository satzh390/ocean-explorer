package com.assignment;

import org.junit.Test;

public class PositionTest {
    
    @Test
    public void testEquals() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(1, 2);
        Position p3 = new Position(2, 3);

        assert p1.equals(p2);
        assert !p1.equals(p3);
    }

    @Test
    public void testMoveForward() {
        Position p = new Position(0, 0);
        assert p.moveForward(Direction.NORTH).equals(new Position(0, 1));
        assert p.moveForward(Direction.EAST).equals(new Position(1, 0));
        assert p.moveForward(Direction.SOUTH).equals(new Position(0, -1));
        assert p.moveForward(Direction.WEST).equals(new Position(-1, 0));
    }

    @Test
    public void testMoveBackward() {
        Position p = new Position(0, 0);
        assert p.moveBackward(Direction.NORTH).equals(new Position(0, -1));
        assert p.moveBackward(Direction.EAST).equals(new Position(-1, 0));
        assert p.moveBackward(Direction.SOUTH).equals(new Position(0, 1));
        assert p.moveBackward(Direction.WEST).equals(new Position(1, 0));
    }

    @Test
    public void testToString() {
        Position p = new Position(3, 4);
        assert p.toString().equals("(3, 4)");
    }

    
}
