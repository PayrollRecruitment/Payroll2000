package TestConsoleApp;

public class ConsoleLogger extends Logger{
    @Override
    public void log(String aMessage) {
        System.out.println(aMessage);
    }

    @Override
    public void changeOutputColour(Colour aColour) {
        System.out.println(aColour.ANSI_CODE);
    }
}
