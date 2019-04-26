package core.communication.controlers;

import core.AppEngine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


}