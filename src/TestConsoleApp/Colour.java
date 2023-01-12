package TestConsoleApp;

public enum Colour {
    Reset("\u001B[0m"),
    Red("\u001B[31m");

    public final String  ANSI_CODE;

    Colour(String aANSI_code) {
        ANSI_CODE = aANSI_code;
    }
}
