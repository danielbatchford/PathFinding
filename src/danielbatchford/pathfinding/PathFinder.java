package danielbatchford.pathfinding;


import java.util.List;

public class PathFinder implements PathFindingIF {


    Grid grid;
    Options options;

    public PathFinder(Grid grid) throws PathFindingException { //check to see if this can be stopped from being initialised
        this.grid = grid;
    }

    public List<int[]> findPath(int[] startCord, int[] endCord) throws PathFindingException {

        Box start = grid.getBoxes()[startCord[0]][startCord[1]];
        Box end = grid.getBoxes()[endCord[0]][endCord[1]];

        if (!start.isWalkable()) {
            throw new PathFindingException("Start Square (" + start.getCord()[0] + "," + start.getCord()[1] + ") was not walkable.");
        }
        if (!end.isWalkable()) {
            throw new PathFindingException("End Square (" + end.getCord()[0] + "," + end.getCord()[1] + ") was not walkable.");
        }

        int[] dimensions = grid.getDimensions();
        int[] cordStart = start.getCord(), cordEnd = end.getCord();
        if (cordStart[0] < 0 || cordStart[0] >= dimensions[0] || cordStart[1] < 0 || cordStart[1] >= dimensions[1]) {
            throw new PathFindingException("Start square exceeds grid dimensions " + dimensions[0] + " x " + dimensions[1]);
        }

        if (cordEnd[0] < 0 || cordEnd[0] >= dimensions[0] || cordEnd[1] < 0 || cordEnd[1] >= dimensions[1])
            throw new PathFindingException("End square exceeds grid dimensions " + dimensions[0] + " x " + dimensions[1]);
        return null;
    }

    public float getDistance(Box a, Box b) throws PathFindingException {
        int[] aC = a.getCord();
        int[] bC = b.getCord();
        switch (Options.distanceMetric) {
            case 'm':
                return Math.abs(aC[0] - bC[0]) + Math.abs(aC[1] - bC[1]);
            case 'e':
                return (float) Math.sqrt(Math.pow(aC[0] - bC[0], 2) + Math.pow(aC[1] - bC[1], 2));
            default:
                throw new PathFindingException("Bad distance Metric used");
        }
    }


}
