package ml.guxing.test.core.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http)
        http.authorizeRequests().antMatchers("/login.html").permitAll().anyRequest().authenticated()
        .and().formLogin().loginPage("/login.html") .permitAll()
    }

    @Override
    void configure(WebSecurity web) throws Exception {
        super.configure(web)
    }
}
