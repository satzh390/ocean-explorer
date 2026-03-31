package com.assignment.command;

import com.assignment.OceanGrid;
import com.assignment.Position;
import com.assignment.Probe;

public class BackwardCommand implements Command {
    @Override
    public void execute(Probe probe, OceanGrid grid) {
        Position next = probe.getPosition().moveBackward(probe.getDirection());
        if (!grid.canMoveTo(next)) {
            return;
        }

        probe.setPosition(next);
    }
}