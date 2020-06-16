package danielbatchford.pathfinding;

import danielbatchford.pathfinding.exceptions.PathFindingException;

public class Options {

    char distanceMetric;
    boolean allowDiagonal;

    public Options(char distanceMetric, boolean allowDiagonal) throws PathFindingException {
        this.allowDiagonal = allowDiagonal;
        this.distanceMetric = distanceMetric;


        if (!(distanceMetric == 'm' || distanceMetric == 'e')) {
            throw new PathFindingException("Distance mode \"" + distanceMetric + "\" was not valid");
        }

    }

}
