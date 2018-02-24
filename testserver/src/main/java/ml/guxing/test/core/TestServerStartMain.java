package ml.guxing.test.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
//@EnableConfigServer
@SpringBootApplication
public class TestServerStartMain {

    public static void main(String[] args) {
        // 启动方式一
        SpringApplication.run(TestServerStartMain.class, args);
        // 启动方式二
//        new SpringApplicationBuilder(TestServerStartMain.class).web(true).run(args);
    }

}
