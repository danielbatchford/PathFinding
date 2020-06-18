package danielbatchford.pathfinding.heuristics;

import danielbatchford.pathfinding.Box;

public class AStarHeuristic {

    public static float calculate(Box from, Box to) { //check that this is working!

        int[] cordFrom = from.getCord();
        int[] cordTo = to.getCord();

        return Math.abs(cordFrom[0] - cordTo[0]) + Math.abs(cordFrom[1] - cordTo[1]);
    }
}
