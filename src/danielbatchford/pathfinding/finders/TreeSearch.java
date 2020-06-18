package danielbatchford.pathfinding.finders;

import danielbatchford.pathfinding.Box;
import danielbatchford.pathfinding.Grid;
import danielbatchford.pathfinding.exceptions.PathFindingException;
import danielbatchford.pathfinding.statelogging.State;
import danielbatchford.pathfinding.util.Options;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class TreeSearch extends PathFinder {

    protected Deque<Box> openList;

    protected List<int[]> findPath(int[] startCord, int[] endCord, Grid grid, Options options, boolean pollFirstOrLast) throws PathFindingException {
        super.findPath(startCord, endCord, grid, options);

        openList = new ArrayDeque<>();
        openList.add(start);

        if (options.attachStateLogger()) {
            stateLogger.add(new State(closedList, openList));
        }

        while (!openList.isEmpty()) {

            Box workingBox = (pollFirstOrLast) ? openList.pollFirst() : openList.pollLast();

            if (workingBox.equals(end)) {
                return backTrace(workingBox);
            }

            neighbors = grid.getNeighbors(workingBox, options.allowDiagonal());

            neighbors.removeAll(closedList);

            for (Box n : neighbors) {

                if (!n.isWalkable()) {
                    continue;
                }
                closedList.add(n);
                n.setParent(workingBox);
                openList.addLast(n);
            }

            if (options.attachStateLogger()) {
                stateLogger.add(new State(closedList, openList));
            }
        }

        throwNoPathFoundError();
        return null;
    }


}
