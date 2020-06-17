package danielbatchford.pathfinding.finders;


import danielbatchford.pathfinding.Box;
import danielbatchford.pathfinding.Grid;
import danielbatchford.pathfinding.Options;
import danielbatchford.pathfinding.exceptions.PathFindingException;

import java.util.*;

class PathFinder {

    Options options;
    Box start;
    Box end;
    Set<Box> visited;

    protected List<int[]> findPath(int[] startCord, int[] endCord, Grid grid, Options options) throws PathFindingException {

        if (startCord == null) throw new PathFindingException("Start co-ordinate was null");
        if (endCord == null) throw new PathFindingException("End co-ordinate was null");
        if (grid == null) throw new PathFindingException("Grid provided was null");
        if (options == null) throw new PathFindingException("Options object provided was null");

        this.options = options;


        if (startCord.length != 2) throw new PathFindingException("Start co-ordinate specified is not of size 2");
        if (endCord.length != 2) throw new PathFindingException("End co-ordinate specified is not of size 2");

        int[] dim = grid.getDimensions();

        if (startCord[0] < 0 || startCord[0] >= dim[0] || startCord[1] < 0 || startCord[1] >= dim[1]) {
            throw new PathFindingException("Start coordinate (" + startCord[0] + "," + startCord[1] + ") was outside the grid range.");
        }

        if (endCord[0] < 0 || endCord[0] >= dim[0] || endCord[1] < 0 || endCord[1] >= dim[1]) {
            throw new PathFindingException("End coordinate (" + endCord[0] + "," + endCord[1] + ") was outside the grid range.");
        }

        start = grid.getBoxes()[startCord[0]][startCord[1]];
        end = grid.getBoxes()[endCord[0]][endCord[1]];

        if (!start.isWalkable()) {
            throw new PathFindingException("Start Square (" + start.getCord()[0] + "," + start.getCord()[1] + ") was not walkable.");
        }
        if (!end.isWalkable()) {
            throw new PathFindingException("End Square (" + end.getCord()[0] + "," + end.getCord()[1] + ") was not walkable.");
        }

        start.setParent(null);

        visited = new HashSet<>();
        visited.add(start);

        return null;
    }

    protected float getDistance(Box a, Box b) throws PathFindingException {
        int[] aC = a.getCord();
        int[] bC = b.getCord();
        switch (options.getDistanceMetric()) {
            case 'm':
                return Math.abs(aC[0] - bC[0]) + Math.abs(aC[1] - bC[1]);
            case 'e':
                return (float) Math.sqrt(Math.pow(aC[0] - bC[0], 2) + Math.pow(aC[1] - bC[1], 2));
            default:
                throw new PathFindingException("Bad distance Metric used");
        }
    }

    protected List<int[]> backTrace(Box box) {

        if (box == null) return null;

        List<int[]> route = new ArrayList<>();

        route.add(box.getCord());
        while (box.getParent() != null) {
            box = box.getParent();
            route.add(box.getCord());
        }
        Collections.reverse(route);
        return route;
    }


}
