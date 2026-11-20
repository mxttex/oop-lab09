package it.unibo.mvc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * A simple implementation of the {@link Controller} interface.
 */
public final class SimpleController implements Controller {

    private String nextString;
    private List<String> history = new LinkedList<String>();
    @Override
    public void setNextString(String input) {
        this.nextString =Objects.requireNonNull(input, "Input string must not be null");
    }

    @Override
    public String getNextString() {
        return this.nextString;
    }

    @Override
    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }

    @Override
    public void printString(){
        if(nextString == null){
            throw new IllegalStateException("Next String must be set");
        }
        IO.println(nextString);
        history.add(nextString);
    }

}
