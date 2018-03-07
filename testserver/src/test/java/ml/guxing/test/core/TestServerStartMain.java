package ml.guxing.test.core;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@EnableEurekaClient
@SpringBootApplication
@RestController
public class TestServerStartMain {

//    @Bean
//    @LoadBalanced
//    public RestTemplate loadBalancedRestTemplate() {
//        return new RestTemplate();
//    }

    @RequestMapping("")
    public String test() {
        return "11111";
    }

    public static void main(String[] args) {
//        args = new String[]{"--spring.config.location=D:\\source\\testa\\testserver\\src\\test\\resources\\server-a.properties"};
        // 启动方式一

        new SpringApplicationBuilder()
                .web(true)
                .main(TestServerStartMain.class)
                .run(args);
    }

}
