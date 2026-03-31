package com.assignment.command;

import com.assignment.OceanGrid;
import com.assignment.Position;
import com.assignment.Probe;

public class ForwardCommand implements Command {
    @Override
    public void execute(Probe probe, OceanGrid grid) {
        Position next = probe.getPosition().moveForward(probe.getDirection());
        if (!grid.canMoveTo(next)) {
            return;
        }
        
        probe.setPosition(next);
    }
}