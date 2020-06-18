package danielbatchford.pathfinding;

import danielbatchford.pathfinding.exceptions.PathFindingException;

public class Options {

    private final char distanceMetric;
    private final boolean allowDiagonal;
    private final boolean attachStateLogger;

    public Options(char distanceMetric, boolean allowDiagonal, boolean attachStateLogger) throws PathFindingException {
        this.allowDiagonal = allowDiagonal;
        this.distanceMetric = distanceMetric;
        this.attachStateLogger = attachStateLogger;


        if (!(distanceMetric == 'm' || distanceMetric == 'e')) {
            throw new PathFindingException("Distance mode \"" + distanceMetric + "\" was not valid");
        }

    }

    public boolean attachStateLogger() {
        return attachStateLogger;
    }

    public char getDistanceMetric() {
        return distanceMetric;
    }

    public boolean allowDiagonal() {
        return allowDiagonal;
    }

}
