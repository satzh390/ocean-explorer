package com.assignment;

import java.util.List;

public class OceanGrid {
    private final int width;
    private final int height;
    private final List<Position> obstacles;

    public OceanGrid(int width, int height, List<Position> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }
   
    private boolean hasObstacle(Position position) {
        return obstacles.contains(position);
    }

    private boolean isWithinBounds(Position position) {
        return position.getX() >= 0 && position.getX() < width &&
               position.getY() >= 0 && position.getY() < height;
    }

    public boolean canMoveTo(Position position) {
        return isWithinBounds(position) && !hasObstacle(position);
    }

}
