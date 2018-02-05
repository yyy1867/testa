package ml.guxing.test.scala.core.conf

import javax.sql.DataSource

import com.alibaba.druid.pool.DruidDataSource
import com.alibaba.druid.support.http.{StatViewServlet, WebStatFilter}
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.web.servlet.{FilterRegistrationBean, ServletRegistrationBean}
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
//@EnableConfigurationProperties(Array(classOf[DruidDataSource]))
class DruidConfiguration {

  private val logger: Logger = LoggerFactory.getLogger(classOf[DruidConfiguration])
  private val DB_PREFIX: String = "spring.datasource"

  @Bean
  def druidServlet(): ServletRegistrationBean = {
    logger.info("init Druid Servlet Configuration");
    val servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    // IP白名单
    servletRegistrationBean.addInitParameter("allow", "192.168.2.25,127.0.0.1")
    servletRegistrationBean
    // IP黑名单(共同存在时，deny优先于allow)
    servletRegistrationBean.addInitParameter("deny", "192.168.1.100")
    //控制台管理用户
    servletRegistrationBean.addInitParameter("loginUsername", "admin");
    servletRegistrationBean.addInitParameter("loginPassword", "123");
    //是否能够重置数据 禁用HTML页面上的“Reset All”功能
    servletRegistrationBean.addInitParameter("resetEnable", "false");
    servletRegistrationBean
  }

  @Bean
  def initfilterRegistrationBean(): FilterRegistrationBean = {
    val filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter())
    filterRegistrationBean.addUrlPatterns("/*")
    filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*")
    filterRegistrationBean
  }

  @Bean
  @ConfigurationProperties(value = "spring.datasource")
  def dataSource(): DataSource = {
    new DruidDataSource()
  }

}
