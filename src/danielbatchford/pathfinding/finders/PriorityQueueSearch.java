package danielbatchford.pathfinding.finders;

import danielbatchford.pathfinding.Box;
import danielbatchford.pathfinding.Grid;
import danielbatchford.pathfinding.exceptions.PathFindingException;
import danielbatchford.pathfinding.statelogging.State;
import danielbatchford.pathfinding.util.Options;

import java.util.List;
import java.util.PriorityQueue;

import static danielbatchford.pathfinding.heuristics.AStarHeuristic.calculate;

class PriorityQueueSearch extends PathFinder {

    PriorityQueue<Box> openList;

    protected List<int[]> findPath(int[] startCord, int[] endCord, Grid grid, Options options, boolean useHeuristic) throws PathFindingException {
        super.findPath(startCord, endCord, grid, options);

        openList = new PriorityQueue<>((o1, o2) -> {
            if (o1.getF() == o2.getF()) return 0;
            return (o1.getF() > o2.getF()) ? 1 : -1;
        });

        start.setG(0);
        start.setF(0);
        openList.add(start);

        if (options.attachStateLogger) {
            stateLogger.add(new State(closedList, openList));
        }


        while (!(openList.isEmpty())) {

            Box workingBox = openList.poll();
            closedList.add(workingBox);

            if (workingBox.equals(end)) {
                return backTrace(workingBox);
            }

            neighbors = grid.getNeighbors(workingBox, options.allowDiagonal);

            for (Box n : neighbors) {

                if (closedList.contains(n) || !n.isWalkable()) {
                    continue;
                }
                if ((workingBox.getG() + getDistance(workingBox, n)) < n.getG() || !openList.contains(n)) {

                    n.setG(workingBox.getG() + getDistance(workingBox, n));
                    n.setF(n.getG() + ((useHeuristic) ? calculate(workingBox, n) : 0));

                    n.setParent(workingBox);

                    if (!openList.contains(n)) {
                        openList.add(n);
                    }
                }
            }

            if (options.attachStateLogger) {
                stateLogger.add(new State(closedList, openList));
            }
        }
        throwNoPathFoundError();
        return null;
    }

}
