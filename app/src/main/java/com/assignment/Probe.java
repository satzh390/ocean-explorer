package com.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Probe {
    private Position position;
    private Direction direction;
    private final List<Position> path = new ArrayList<>();

    public Probe(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
        path.add(position);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Position> getPath() {
        return Collections.unmodifiableList(path);
    }

    public void setPosition(Position position) {
        this.position = position;
        path.add(position);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}