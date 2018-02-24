package ml.guxing.test.core.components

import com.alibaba.druid.pool.DruidDataSource
import com.alibaba.druid.support.http.StatViewServlet
import com.alibaba.druid.support.http.WebStatFilter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
@ConditionalOnClass(DruidDataSource::class)
open class DruidLoadConfig {


    @Bean
    open fun druidServlet(): ServletRegistrationBean {
        val servletRegistrationBean = ServletRegistrationBean(StatViewServlet(), "/druid/*");
        // IP白名单
        servletRegistrationBean.addInitParameter("allow", "192.168.2.25,127.0.0.1")
        // IP黑名单(共同存在时，deny优先于allow)
        servletRegistrationBean.addInitParameter("deny", "192.168.1.100")
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "123");
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean
    }

    @Bean
    open fun initfilterRegistrationBean(): FilterRegistrationBean {
        val registrationBean = FilterRegistrationBean(WebStatFilter())
        registrationBean.addUrlPatterns("/*")
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*")
        return registrationBean
    }

    @Bean
    @ConfigurationProperties(value = "spring.datasource")
    open fun configDataSource(): DataSource {
        return DruidDataSource()
    }

}