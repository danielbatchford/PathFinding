package danielbatchford.pathfinding;


import danielbatchford.pathfinding.exceptions.PathFindingException;

import java.util.List;

public class PathFinder implements PathFindingIF {


    Options options;

    PathFinder() {
    }

    public List<int[]> findPath(int[] startCord, int[] endCord, Grid grid) throws PathFindingException {
        return findPath(startCord, endCord, grid, new Options('m', false));
    }


    public List<int[]> findPath(int[] startCord, int[] endCord, Grid grid, Options options) throws PathFindingException {

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

        Box start = grid.getBoxes()[startCord[0]][startCord[1]];
        Box end = grid.getBoxes()[endCord[0]][endCord[1]];

        if (!start.isWalkable()) {
            throw new PathFindingException("Start Square (" + start.getCord()[0] + "," + start.getCord()[1] + ") was not walkable.");
        }
        if (!end.isWalkable()) {
            throw new PathFindingException("End Square (" + end.getCord()[0] + "," + end.getCord()[1] + ") was not walkable.");
        }

        grid.setParentsToNull();

        return null;
    }

    public float getDistance(Box a, Box b) throws PathFindingException {
        int[] aC = a.getCord();
        int[] bC = b.getCord();
        switch (options.distanceMetric) {
            case 'm':
                return Math.abs(aC[0] - bC[0]) + Math.abs(aC[1] - bC[1]);
            case 'e':
                return (float) Math.sqrt(Math.pow(aC[0] - bC[0], 2) + Math.pow(aC[1] - bC[1], 2));
            default:
                throw new PathFindingException("Bad distance Metric used");
        }
    }


}
