package danielbatchford.pathfinding;

import danielbatchford.pathfinding.exceptions.NoPathFoundException;
import danielbatchford.pathfinding.exceptions.PathFindingException;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import static danielbatchford.pathfinding.AStarHeuristic.calculate;

public class AStar extends PathFinder implements PathFindingIF {


    public AStar() {
    }

    public List<int[]> findPath(int[] startCord, int[] endCord, Grid grid) throws PathFindingException {
        super.findPath(startCord, endCord, grid);
        return findPath(startCord, endCord, grid, options);
    }

    @Override
    public List<int[]> findPath(int[] startCord, int[] endCord, Grid grid, Options options) throws PathFindingException {
        super.findPath(startCord, endCord, grid, options);

        PriorityQueue<Box> queue = new PriorityQueue<Box>((o1, o2) -> {
            if (o1.getF() == o2.getF()) return 0;
            return (o1.getF() > o2.getF()) ? 1 : -1;
        });

        Set<Box> explored = new HashSet<Box>();


        start.setG(0);

        queue.add(start);

        while (!(queue.isEmpty())) {

            Box workingBox = queue.poll();
            explored.add(workingBox);

            if (workingBox.equals(end)) {
                return backTrace(workingBox);
            }

            List<Box> neighbors = grid.getNeighbors(workingBox, options.allowDiagonal);

            for (Box neighbor : neighbors) {

                if (explored.contains(neighbor) || !neighbor.isWalkable()) {
                    continue;
                }
                if ((workingBox.getG() + getDistance(workingBox, neighbor)) < neighbor.getG() || !queue.contains(neighbor)) {

                    neighbor.setG(workingBox.getG() + getDistance(workingBox, neighbor));
                    neighbor.setF(neighbor.getG() + calculate(workingBox, neighbor)); //heuristic here

                    neighbor.setParent(workingBox);

                    if (!queue.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        throw new NoPathFoundException("No path was found from (" + startCord[0] + "," + startCord[1] + ") to (" + endCord[0] + "," + endCord[1] + ")");
    }


}
