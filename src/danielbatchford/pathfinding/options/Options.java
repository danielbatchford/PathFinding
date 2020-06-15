package danielbatchford.pathfinding.options;

import danielbatchford.pathfinding.PathFindingException;

public class Options {

    public char distanceMetric = 'm';
    public boolean allowDiagonal = false;


    public Options(char distanceMetric, boolean allowDiagonal) throws PathFindingException {
        this.allowDiagonal = allowDiagonal;
        this.distanceMetric = distanceMetric;

        if (!(distanceMetric == 'm' || distanceMetric == 'e')) {
            throw new PathFindingException("Distance mode \"" + distanceMetric + "\" was not valid");
        }

    }
}
