package TestConsoleApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends Logger{
    @Override
    public void log(String aMessage)  {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
            writer.write(aMessage);
        } catch (IOException aE) {
            System.out.println(aE.getMessage());
            throw new RuntimeException(aE);
        }
    }

    @Override
    public void changeOutputColour(Colour aColour) {

    }
}
