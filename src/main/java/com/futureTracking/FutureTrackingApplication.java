package com.futureTracking;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class FutureTrackingApplication {

    static Logger logger = Logger.getLogger(FutureTrackingApplication.class);

    public static void main(String[] args) {
        logger.info("Démarrage de l'application Future Tracking BackEnd");
        SpringApplication.run(FutureTrackingApplication.class, args);
    }

}
