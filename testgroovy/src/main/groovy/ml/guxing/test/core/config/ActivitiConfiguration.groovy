package ml.guxing.test.core.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(["ml.guxing.activiti"])
//@ComponentScan(["org.activiti.rest.editor", "org.activiti.rest.diagram", "ml.guxing.activiti"])
class ActivitiConfiguration {

    @Bean
    def ObjectMapper loadObjectMapper() {
        return new ObjectMapper()
    }

}
