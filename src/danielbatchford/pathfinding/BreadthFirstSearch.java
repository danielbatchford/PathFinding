package danielbatchford.pathfinding;

import danielbatchford.pathfinding.exceptions.NoPathFoundException;
import danielbatchford.pathfinding.exceptions.PathFindingException;

import java.util.*;

public class BreadthFirstSearch extends PathFinder implements PathFindingIF {

    @Override
    public List<int[]> findPath(int[] startCord, int[] endCord, Grid grid) throws PathFindingException {
        super.findPath(startCord, endCord, grid);
        return findPath(startCord, endCord, grid, options);
    }

    @Override
    public List<int[]> findPath(int[] startCord, int[] endCord, Grid grid, Options options) throws PathFindingException {
        super.findPath(startCord, endCord, grid, options);

        Queue<Box> queue = new LinkedList<Box>();
        Set<Box> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            Box workingBox = queue.poll();

            if (workingBox.equals(end)) {
                return backTrace(workingBox);
            }

            List<Box> neighbors = grid.getNeighbors(workingBox, options.allowDiagonal);
            neighbors.removeAll(visited);

            for (Box n : neighbors) {
                visited.add(n);
                n.setParent(workingBox);
                queue.add(n);
            }

        }

        throw new NoPathFoundException("No path was found from (" + startCord[0] + "," + startCord[1] + ") to (" + endCord[0] + "," + endCord[1] + ")");

    }


}
