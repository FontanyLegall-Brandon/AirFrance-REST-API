package core.data;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;


public class ValidDataTest {
    private User user = new User();

    @Test
    public void validDate(){
        assertTrue(user.converteToDate("01/01/2000").toString().equals("2000-01-01"));
        assertTrue(user.valideAge(user.converteToDate("01/01/2000")));

        for(int i = 0;i < 18;i++){
            LocalDate from = LocalDate.of(LocalDate.now().getYear() - i,LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth());
            assertFalse(user.valideAge(from));
        }
    }

    @Test
    public void validEmail(){
        assertTrue(user.valideEmail("a@a.fr"));
        assertFalse(user.valideEmail("a"));
    }

    @Test
    public void validLocation(){
        assertTrue(user.valideLocation("france"));
        assertTrue(user.valideLocation("France"));
        assertFalse(user.valideLocation(""));
        assertFalse(user.valideLocation("Germany"));
    }

    @Test
    public void validPhone(){
        assertTrue(user.validePhone("0612345678"));
        assertTrue(user.validePhone("+33612345678"));

        assertFalse(user.validePhone("+3361234567"));
    }


}
