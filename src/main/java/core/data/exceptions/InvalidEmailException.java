package core.data.exceptions;

public class InvalidEmailException extends Exception {
    public InvalidEmailException() {
        super("Error : Invalid email input");
    }
}
