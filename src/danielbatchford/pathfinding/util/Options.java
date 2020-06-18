package danielbatchford.pathfinding.util;

import danielbatchford.pathfinding.exceptions.PathFindingException;

public class Options {

    public char distanceMetric = 'm';
    public boolean allowDiagonal = false;
    public boolean attachStateLogger = false;

    public Options(char distanceMetric, boolean allowDiagonal, boolean attachStateLogger) throws PathFindingException {
        this.distanceMetric = distanceMetric;
        this.allowDiagonal = allowDiagonal;
        this.attachStateLogger = attachStateLogger;

        validateDistanceMetric();
    }

    public Options(char distanceMetric, boolean allowDiagonal) throws PathFindingException {
        this.distanceMetric = distanceMetric;
        this.allowDiagonal = allowDiagonal;

        validateDistanceMetric();
    }

    public Options(char distanceMetric) {
        this.distanceMetric = distanceMetric;
    }

    private void validateDistanceMetric() throws PathFindingException {
        if (!(distanceMetric == 'm' || distanceMetric == 'e')) {
            throw new PathFindingException("Distance mode \"" + distanceMetric + "\" was not valid");
        }
    }

}
