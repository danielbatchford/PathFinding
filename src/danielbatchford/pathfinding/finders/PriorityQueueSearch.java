package danielbatchford.pathfinding.finders;

import danielbatchford.pathfinding.Box;
import danielbatchford.pathfinding.Grid;
import danielbatchford.pathfinding.Options;
import danielbatchford.pathfinding.exceptions.PathFindingException;
import danielbatchford.pathfinding.statelogging.State;

import java.util.List;
import java.util.PriorityQueue;

import static danielbatchford.pathfinding.heuristics.AStarHeuristic.calculate;

class PriorityQueueSearch extends PathFinder {

    ;

    public List<int[]> findPath(int[] startCord, int[] endCord, Grid grid, Options options, boolean useHeuristic) throws PathFindingException {
        super.findPath(startCord, endCord, grid, options);

        PriorityQueue<Box> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getF() == o2.getF()) return 0;
            return (o1.getF() > o2.getF()) ? 1 : -1;
        });

        start.setG(0);
        start.setF(0);
        queue.add(start);

        if(options.attachStateLogger()){
            stateLogger.add(new State(visited,queue));
        }

        List<Box> neighbors;

        while (!(queue.isEmpty())) {

            Box workingBox = queue.poll();
            visited.add(workingBox);

            if (workingBox.equals(end)) {
                return backTrace(workingBox);
            }

            neighbors = grid.getNeighbors(workingBox, options.allowDiagonal());

            for (Box n : neighbors) {

                if (visited.contains(n) || !n.isWalkable()) {
                    continue;
                }
                if ((workingBox.getG() + getDistance(workingBox, n)) < n.getG() || !queue.contains(n)) {

                    n.setG(workingBox.getG() + getDistance(workingBox, n));
                    n.setF(n.getG() + ((useHeuristic) ? calculate(workingBox, n) : 0));

                    n.setParent(workingBox);

                    if (!queue.contains(n)) {
                        queue.add(n);
                    }
                }
            }

            if(options.attachStateLogger()){
                stateLogger.add(new State(visited,queue));
            }
        }
        throwNoPathFoundError();
        return null;
    }

}
