package ml.guxing.test.scala.core.conf

import org.springframework.context.annotation.{Bean, Configuration}
import tk.mybatis.spring.mapper.MapperScannerConfigurer

@Configuration
class MyBaitsMapperConfig {

  @Bean
  def confMapperScannerConfigurer(): MapperScannerConfigurer = {
    val scannerConfigurer = new MapperScannerConfigurer()
    scannerConfigurer.setBasePackage("ml.guxing.test.scala.core.mapper")
    scannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory")
    scannerConfigurer
  }

}
