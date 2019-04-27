package core.communication.exceptions;

import core.data.User;
import org.junit.Test;


public class EmptyFieldTest {

    @Test(expected = EmptyFieldException.class)
    public void exceptionTest1() throws InvalidEmailException, InvalidPhoneNumberException, EmptyFieldException, MinimumAgeRequiredException, BadGeographicLocationException {
        new User("","test@test.fr","abcd","01/01/2000","france",null,"1234");
    }

    @Test(expected = EmptyFieldException.class)
    public void exceptionTest2() throws InvalidEmailException, InvalidPhoneNumberException, EmptyFieldException, MinimumAgeRequiredException, BadGeographicLocationException {
        new User("test","test@test.fr","","01/01/2000","france",null,"1234");
    }
}
