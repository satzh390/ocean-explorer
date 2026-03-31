package com.assignment.command;

import com.assignment.OceanGrid;
import com.assignment.Probe;

public class LeftCommand implements Command {
    @Override
    public void execute(Probe probe, OceanGrid grid) {
        probe.setDirection(probe.getDirection().turnLeft());
    }
}