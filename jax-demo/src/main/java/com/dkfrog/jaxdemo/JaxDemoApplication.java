package com.dkfrog.jaxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author ramos.bh.wu@mail.foxconn.com
 * @date 2020-01-15 16:57
 * @since 1.0.1
 */
@SpringBootApplication(scanBasePackages = {"com.dkfrog.jaxcommon", "com.dkfrog.jaxdemo"})
public class JaxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JaxDemoApplication.class, args);
    }

}
