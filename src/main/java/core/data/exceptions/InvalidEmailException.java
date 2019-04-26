package core.data.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmailException extends Exception {
    public InvalidEmailException() {
        super("Error : Invalid email input");
    }
}
