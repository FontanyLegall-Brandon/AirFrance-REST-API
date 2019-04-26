package core;

import core.data.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppEngine {
    @Autowired
    private Environment env;
    private static final Logger log = LoggerFactory.getLogger(AppEngine.class);


    private List<User> userList;

    public AppEngine() {
        this.userList = new ArrayList<>();
    }


    @Primary
    @Bean(name = "UserEngine")
    @Scope("singleton")
    public AppEngine userEngine() {
        return new AppEngine();
    }



    // GETTERS
    public List<User> getUserList() {
        return userList;
    }

    public Environment getEnv() {
        return env;
    }


    // SETTERS
    public void addUser(User user) {
        this.userList.add(user);
    }

    @Override
    public String toString() {
        return "UserEngine{" +
                "userList=" + userList +
                '}';
    }
}
