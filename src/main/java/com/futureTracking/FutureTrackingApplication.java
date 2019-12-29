package com.futureTracking;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FutureTrackingApplication {

    static Logger logger = Logger.getLogger(FutureTrackingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FutureTrackingApplication.class, args);
    }

}
