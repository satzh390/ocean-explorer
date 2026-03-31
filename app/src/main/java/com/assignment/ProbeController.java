package com.assignment;

import com.assignment.command.Command;
import com.assignment.command.CommandFactory;

public class ProbeController {

    private final Probe probe;
    private final OceanGrid grid;

    public ProbeController(OceanGrid grid, Probe probe) {
        this.grid = grid;
        this.probe = probe;
    }

    private void execute(Command command) {
        command.execute(probe, grid);
    }

    public void execute(String commands) {
        for (char c : commands.toCharArray()) {
            Command command = CommandFactory.get(c);
            execute(command);
        }
    }

    public void printSummary() {
        System.out.println("Current Position: " + probe.getPosition());
        System.out.println("Current Direction: " + probe.getDirection());
        System.out.println("Path Taken: " + probe.getPath().stream()
            .map(Position::toString).reduce((a, b) -> a + " -> " + b).orElse(""));
    }
}