package danielbatchford.pathfinding.statelogging;

import danielbatchford.pathfinding.Box;

import java.util.Collection;
import java.util.Set;

public class State {

    private final Set<Box> visited;
    private final Collection<Box> queue;

    public State(Set<Box> visited, Collection<Box> queue) {
        this.visited = visited;
        this.queue = queue;
    }

    public Set<Box> getVisited() {
        return visited;
    }

    public Collection<Box> getQueue() {
        return queue;
    }
}
