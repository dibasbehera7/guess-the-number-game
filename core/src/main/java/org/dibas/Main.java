package org.dibas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        //Create Context (Container)
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // Create a Bean
        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        //call method next() to get random number
        int number = numberGenerator.next();

        //log generated number
        log.info("number = {}",number);

        //close Context (Container)
        context.close();

    }
}
