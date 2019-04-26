package core.data.exceptions;

public class BadGeographicLocationException extends Exception{
    public BadGeographicLocationException() {
        super("Error : Only French peoples are allowed to register");
    }
}
