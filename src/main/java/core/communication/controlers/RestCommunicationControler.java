package core.communication.controlers;

import core.AppEngine;
import core.communication.container.UserCountainer;
import core.data.User;
import core.data.exceptions.*;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class RestCommunicationControler{
    private final Logger log = LoggerFactory.getLogger(RestCommunicationControler.class);

    @Autowired
    AppEngine appEngine;

    @GetMapping("/test/")
    public String getPlateau(){
        return new String("test");
    }

    @PostMapping(value = "/register")
    @ExceptionHandler({ InvalidEmailException.class,EmptyFieldException.class,NonUniqueEmailException.class,BadGeographicLocationException.class,InvalidEmailException.class,MinimumAgeRequiredException.class })
    public User resgister(@RequestBody User user) throws InvalidEmailException, EmptyFieldException, NonUniqueEmailException, BadGeographicLocationException, InvalidPhoneNumberException, MinimumAgeRequiredException {

        long start = System.currentTimeMillis();
        User createdUser = new User(user);

        //If User created
        appEngine.addUser(createdUser);
        log.info("New User created "+createdUser.toString());
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        log.info("Processing time : "+timeElapsed+"ms");
        return createdUser;

    }



}