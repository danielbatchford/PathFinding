package danielbatchford.pathfinding;

import danielbatchford.pathfinding.exceptions.PathFindingException;

public class Options {

    private final char distanceMetric;
    private final boolean allowDiagonal;

    public Options(char distanceMetric, boolean allowDiagonal) throws PathFindingException {
        this.allowDiagonal = allowDiagonal;
        this.distanceMetric = distanceMetric;


        if (!(distanceMetric == 'm' || distanceMetric == 'e')) {
            throw new PathFindingException("Distance mode \"" + distanceMetric + "\" was not valid");
        }

    }

    public char getDistanceMetric() {
        return distanceMetric;
    }

    public boolean isAllowDiagonal() {
        return allowDiagonal;
    }

}
