package core.communication.controlers;

import core.AppEngine;
import core.communication.container.ResponseContainer;
import core.communication.container.UserContainer;
import core.data.User;
import core.communication.exceptions.*;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class RestCommunicationControler{
    private final Logger log = LoggerFactory.getLogger(RestCommunicationControler.class);

    @Autowired
    AppEngine appEngine;

    /**
     * Function to register a new user
     * @param user User
     * @return ResponseContainer the response with his status and message status
     * @throws InvalidEmailException mail invalid
     * @throws EmptyFieldException empty field on requested fields forbidden
     * @throws BadGeographicLocationException need to be frensh
     * @throws InvalidPhoneNumberException need to have a valid phone number (frensh number)
     * @throws MinimumAgeRequiredException need to have more than 18
     *
     */
    @PostMapping(value = "/register")
    public ResponseContainer resgister(@RequestBody User user) throws InvalidEmailException, EmptyFieldException, BadGeographicLocationException, InvalidPhoneNumberException, MinimumAgeRequiredException {

        long start = System.currentTimeMillis(); //process time log
        User createdUser = new User(user);

        //If User created
        appEngine.addUser(createdUser);
        log.info("New User created "+createdUser.toString());
        long finish = System.currentTimeMillis(); //process time log
        long timeElapsed = finish - start; //process time log
        log.info("User creation processing time : "+timeElapsed+"ms"); //process time log
        return new ResponseContainer(true,"The user has been register");

    }

    /**
     * Get the list of the registered players
     * @return UserCountainer a countainer of players
     */
    @GetMapping(value = "/registered")
    public UserContainer registered(){
        return new UserContainer(appEngine.getUserList());
    }

    /**
     * Get the player form his id
     * @param id int
     * @return UserCountainer a countainer of players
     * @throws UserNotFoundException User not found exception
     */
    @GetMapping(value = "/registered/{id}")
    public UserContainer registeredId(@PathVariable int id) throws UserNotFoundException {
        long start = System.currentTimeMillis(); //process time log
        if(appEngine.getUserList().size() <= id){
            throw new UserNotFoundException();
        }
        User user = appEngine.getUserList().get(id);
        long finish = System.currentTimeMillis(); //process time log
        long timeElapsed = finish - start; //process time log
        log.info("User getter processing time : "+timeElapsed+"ms"); //process time log
        return new UserContainer(user);
    }


}