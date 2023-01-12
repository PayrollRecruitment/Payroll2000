package TestConsoleApp;

import java.io.IOException;

public abstract class Logger {
    public abstract void log(String aMessage);
    public abstract void changeOutputColour(Colour aColour);
}
