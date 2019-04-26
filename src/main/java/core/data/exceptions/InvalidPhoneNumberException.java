package core.data.exceptions;

public class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException() {
        super("Error : The input phone number is invalid");
    }
}
