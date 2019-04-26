package core.data.exceptions;

public class EmptyFieldException extends Exception {
    public EmptyFieldException(String name) {
        super(String.format("Error : %s need to dont be empty",name));
    }
}
