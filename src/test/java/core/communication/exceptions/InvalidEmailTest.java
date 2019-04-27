package core.communication.exceptions;

import core.data.User;
import org.junit.Test;

public class InvalidEmailTest {

    @Test(expected = InvalidEmailException.class)
    public void exceptionTest1() throws InvalidEmailException, InvalidPhoneNumberException, EmptyFieldException, MinimumAgeRequiredException, BadGeographicLocationException {
        new User("hey","test","abcd","01/01/2000","france",null,"1234");
    }

    @Test(expected = InvalidEmailException.class)
    public void exceptionTest2() throws InvalidEmailException, InvalidPhoneNumberException, EmptyFieldException, MinimumAgeRequiredException, BadGeographicLocationException {
        new User("hey","test@test","abcd","01/01/2000","france",null,"1234");
    }

    @Test(expected = InvalidEmailException.class)
    public void exceptionTest3() throws InvalidEmailException, InvalidPhoneNumberException, EmptyFieldException, MinimumAgeRequiredException, BadGeographicLocationException {
        new User("hey","test.fr","abcd","01/01/2000","france",null,"1234");
    }
}
