package danielbatchford.pathfinding.finders;

import danielbatchford.pathfinding.Box;
import danielbatchford.pathfinding.Grid;
import danielbatchford.pathfinding.Options;
import danielbatchford.pathfinding.exceptions.NoPathFoundException;
import danielbatchford.pathfinding.exceptions.PathFindingException;

import java.util.List;

public class BreadthFirstSearch extends TreeSearch {

    @Override
    public List<int[]> findPath(int[] startCord, int[] endCord, Grid grid, Options options) throws PathFindingException {
        super.findPath(startCord, endCord, grid, options);

        while (!queue.isEmpty()) {

            Box workingBox = queue.pollFirst();

            if (workingBox.equals(end)) {
                return backTrace(workingBox);
            }

            List<Box> neighbors = grid.getNeighbors(workingBox, options.isAllowDiagonal());

            neighbors.removeAll(visited);

            for (Box n : neighbors) {

                if (!n.isWalkable()) {
                    continue;
                }
                visited.add(n);
                n.setParent(workingBox);
                queue.addLast(n);
            }
        }

        throw new NoPathFoundException("No path was found from (" + startCord[0] + "," + startCord[1] + ") to (" + endCord[0] + "," + endCord[1] + ")");

    }


}
