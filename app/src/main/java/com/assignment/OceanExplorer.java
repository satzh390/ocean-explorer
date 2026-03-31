package com.assignment;
import java.util.List;

public class OceanExplorer {
    public static void main(String[] args) {
        // Example usage
        OceanGrid grid = new OceanGrid(5, 5, List.of(new Position(1, 1), new Position(2, 2)));
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH);
        ProbeController controller = new ProbeController(grid, probe);

        String commands = "FFRFFLBB";
        controller.execute(commands);
       
        controller.printSummary();
    }
}
