package ml.guxing.test.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class TestServerStartMain {

    public static void main(String[] args) {
        SpringApplication.run(TestServerStartMain.class);
    }

}
