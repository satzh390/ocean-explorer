package com.assignment;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Position moveForward(Direction direction) {
        switch (direction) {
            case NORTH: return new Position(x, y + 1);
            case EAST: return new Position(x + 1, y);
            case SOUTH: return new Position(x, y - 1);
            case WEST: return new Position(x - 1, y);
            default: throw new IllegalArgumentException("Invalid direction");
        }
    }

    public Position moveBackward(Direction direction) {
        switch (direction) {
            case NORTH: return new Position(x, y - 1);
            case EAST: return new Position(x - 1, y);
            case SOUTH: return new Position(x, y + 1);
            case WEST: return new Position(x + 1, y);
            default: throw new IllegalArgumentException("Invalid direction");
        }
    }
}
