package danielbatchford.pathfinding;

public class Options {

    static char distanceMetric = 'm';
    static boolean allowDiagonal = false;


    public static void setOptions(char distMetric, boolean allowDiag) throws PathFindingException {
        allowDiagonal = allowDiag;
        distanceMetric = distMetric;

        if (!(distanceMetric == 'm' || distanceMetric == 'e')) {
            throw new PathFindingException("Distance mode \"" + distanceMetric + "\" was not valid");
        }

    }


}
