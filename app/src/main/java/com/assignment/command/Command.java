package com.assignment.command;

import com.assignment.OceanGrid;
import com.assignment.Probe;

public interface Command {
    void execute(Probe probe, OceanGrid grid);
}