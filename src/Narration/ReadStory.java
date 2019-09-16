package Narration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadStory {

    private BufferedReader inFile;
    private String line;
    private int numLine = 0;
    private String story [] = new String [80];

    public ReadStory(String file) throws IOException {

        inFile = new BufferedReader (new FileReader(file));

        line = inFile.readLine();

        while (line != null)
        {
            story [numLine] = line;
            ++numLine;
            line = inFile.readLine();
        }

        inFile.close();
    }

//    ****************************************************************************************

    public int getSize ()
    {
        return numLine;

    }

    public String [] getStory ()
    {
        return story;
    }
}
