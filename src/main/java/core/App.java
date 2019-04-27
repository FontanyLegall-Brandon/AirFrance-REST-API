package core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Hashtable;
import java.util.Map;

/**
 * The main class, is here to launch and define the environment variables of the app
 */
@SpringBootApplication
@EnableAsync
public class App {
        public static void main(String[] args) {

                String APP_PORT = "8080";

                if (args.length > 0){
                        APP_PORT = args[0];
                }

                SpringApplication app = new SpringApplication(App.class);

                Map<String, Object> properties = new Hashtable<>();

                properties.put("server.port", APP_PORT);

                app.setDefaultProperties(properties);
                app.run(args);
        }

}
