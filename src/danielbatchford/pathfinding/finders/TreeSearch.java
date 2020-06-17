package danielbatchford.pathfinding.finders;

import danielbatchford.pathfinding.Box;
import danielbatchford.pathfinding.Grid;
import danielbatchford.pathfinding.Options;
import danielbatchford.pathfinding.exceptions.PathFindingException;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class TreeSearch extends PathFinder {

    protected Deque<Box> queue;

    protected List<int[]> findPath(int[] startCord, int[] endCord, Grid grid, Options options, boolean pollFirstOrLast) throws PathFindingException {
        super.findPath(startCord, endCord, grid, options);

        queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {

            Box workingBox = (pollFirstOrLast) ? queue.pollFirst() : queue.pollLast();

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

        throwNoPathFoundError();
        return null;
    }


}
