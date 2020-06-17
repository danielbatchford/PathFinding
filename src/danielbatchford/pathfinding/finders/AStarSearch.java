package danielbatchford.pathfinding.finders;

import danielbatchford.pathfinding.Box;
import danielbatchford.pathfinding.Grid;
import danielbatchford.pathfinding.Options;
import danielbatchford.pathfinding.exceptions.NoPathFoundException;
import danielbatchford.pathfinding.exceptions.PathFindingException;

import java.util.List;
import java.util.PriorityQueue;

import static danielbatchford.pathfinding.heuristics.AStarHeuristic.calculate;

public class AStarSearch extends PathFinder {


    @Override
    public List<int[]> findPath(int[] startCord, int[] endCord, Grid grid, Options options) throws PathFindingException {
        super.findPath(startCord, endCord, grid, options);

        PriorityQueue<Box> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getF() == o2.getF()) return 0;
            return (o1.getF() > o2.getF()) ? 1 : -1;
        });

        start.setG(0);

        queue.add(start);

        while (!(queue.isEmpty())) {

            Box workingBox = queue.poll();
            visited.add(workingBox);

            if (workingBox.equals(end)) {
                return backTrace(workingBox);
            }

            List<Box> neighbors = grid.getNeighbors(workingBox, options.isAllowDiagonal());

            for (Box n : neighbors) {

                if (visited.contains(n) || !n.isWalkable()) {
                    continue;
                }
                if ((workingBox.getG() + getDistance(workingBox, n)) < n.getG() || !queue.contains(n)) {

                    n.setG(workingBox.getG() + getDistance(workingBox, n));
                    n.setF(n.getG() + calculate(workingBox, n)); //heuristic here

                    n.setParent(workingBox);

                    if (!queue.contains(n)) {
                        queue.add(n);
                    }
                }
            }
        }
        throw new NoPathFoundException("No path was found from (" + startCord[0] + "," + startCord[1] + ") to (" + endCord[0] + "," + endCord[1] + ")");
    }


}
