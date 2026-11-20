package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String HOME = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private File dest = new File(HOME + SEPARATOR + "output.txt");

    /**
     * Set the given file to the working one
     * @param newFile -> the file we want to set
     * @throws IllegalArgumentException if the folder doesnt exists
     */
    public void setFile(final File newFile) throws IllegalArgumentException{
        final File parentFile = newFile.getParentFile();
        if(parentFile.exists()){
            dest = newFile;
        }
        else{
            throw new IllegalArgumentException("cannot save in a non-existing folder");
        }
    }

    /**
     * 
     * @param newFile the path of the new file
     */
    public void setFile(final String newFile){
        setFile(new File(newFile));
    }

    /**
     * 
     * @return the file we are working on
     */
    public File getFile(){
        return this.dest;
    }

    /**
     * @return the file path as a String
     */
    public String getFilePath(){
        return this.dest.getPath();
    }

    /**
     * Write the phrase we give in input on our file
     * @param phrase, what we want to Write on out file
     * @throws IOException if the writing fails
     */
    public void saveOnFile(final String phrase) throws IOException{
        try(PrintStream ps = new PrintStream(dest, StandardCharsets.UTF_8)){
            ps.println(phrase);
        }
    }
}

