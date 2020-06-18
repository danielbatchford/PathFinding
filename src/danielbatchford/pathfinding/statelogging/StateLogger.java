package danielbatchford.pathfinding.statelogging;

import java.util.LinkedList;
import java.util.List;

public class StateLogger {

    private final List<State> states;

    public StateLogger() {
        states = new LinkedList<>();
    }

    public void add(State state) {
        states.add(state);
    }

    @Override
    public String toString() { //fix this

        StringBuilder sb = new StringBuilder();


        for (int i = 0, max = states.size(); i < max; i++) {
            State state = states.get(i);

            sb.append("\n\nState ").append(i).append(state.toString());
        }
        return sb.toString();
    }

    public List<State> getStates() {
        return states;
    }

}
