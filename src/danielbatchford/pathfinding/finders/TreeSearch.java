package danielbatchford.pathfinding.finders;

import danielbatchford.pathfinding.Box;
import danielbatchford.pathfinding.Grid;
import danielbatchford.pathfinding.Options;
import danielbatchford.pathfinding.exceptions.PathFindingException;
import danielbatchford.pathfinding.statelogging.State;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class TreeSearch extends PathFinder {

    protected Deque<Box> queue;

    public List<int[]> findPath(int[] startCord, int[] endCord, Grid grid, Options options, boolean pollFirstOrLast) throws PathFindingException {
        super.findPath(startCord, endCord, grid, options);

        queue = new ArrayDeque<>();
        queue.add(start);

        if(options.attachStateLogger()){
            stateLogger.add(new State(visited,queue));
        }

        List<Box> neighbors;

        while (!queue.isEmpty()) {

            Box workingBox = (pollFirstOrLast) ? queue.pollFirst() : queue.pollLast();

            if (workingBox.equals(end)) {
                return backTrace(workingBox);
            }

            neighbors = grid.getNeighbors(workingBox, options.allowDiagonal());

            neighbors.removeAll(visited);

            for (Box n : neighbors) {

                if (!n.isWalkable()) {
                    continue;
                }
                visited.add(n);
                n.setParent(workingBox);
                queue.addLast(n);
            }

            if(options.attachStateLogger()){
                stateLogger.add(new State(visited,queue));
            }
        }

        throwNoPathFoundError();
        return null;
    }


}
