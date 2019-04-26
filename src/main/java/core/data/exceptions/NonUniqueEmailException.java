package core.data.exceptions;

public class NonUniqueEmailException  extends Exception{
    public NonUniqueEmailException() {
        super("Error : The email adress need to be Unique");
    }
}
