package danielbatchford.pathfinding;

public class AStarHeuristic {

    public static float calculate(Box from, Box to) {

        int[] cordFrom = from.getCord();
        int[] cordTo = to.getCord();

        return Math.abs(cordFrom[0] - cordTo[0]) + Math.abs(cordFrom[1] - cordTo[1]);
    }
}
