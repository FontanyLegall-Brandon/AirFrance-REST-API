package core.communication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for non Unique emails
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NonUniqueEmailException  extends Exception{
    public NonUniqueEmailException() {
        super("Error : The email adress need to be Unique");
    }
}
