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

    @Override
    protected List<int[]> findPath(int[] startCord, int[] endCord, Grid grid, Options options) throws PathFindingException {
        super.findPath(startCord, endCord, grid, options);

        queue = new ArrayDeque<>();
        queue.add(start);

        return null;
    }



}
