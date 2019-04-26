package core.data.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyFieldException extends Exception {
    public EmptyFieldException(String name) {
        super(String.format("Error : %s need to dont be empty",name));
    }
}
