package it.unibo.mvc;

import java.util.List;

/**
 * This interface represents a controller in the MVC pattern,
 * responsible for managing the flow of data between the model and the view.
 */
public interface Controller {
    /**
     * Method for setting the next string to print.
     * @param input the string we want to print next
     * @throws NullPointerException if the argument is not valid (input string is null)
     */
    void setNextString(String input);

    /**
     * Method for getting the next string to print
     * @return the next string
     */
    String getNextString();

    /**
     * Method that return all the printed lists
     * @return the list of printed strings
     */
    List<String> getHistory();

    /**
     * Method that prints the current string. 
     * @throws IllegalStateException
     */
    void printString();
}
