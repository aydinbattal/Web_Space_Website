package ca.sheridancollege.battalay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    DataSource dataSource;

    @Autowired
    void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Autowired
    public void configureGlobal(
            @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService,
            AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {

        security.headers().frameOptions().sameOrigin();

        security.authorizeRequests()
                // remove "h2-console" from the program in production
                .antMatchers("/css/**", "/js/**", "/Index", "/", "/h2-console/**")
                .permitAll();

        // this line is for h2-console, it reduces security
        security.csrf().disable();

        security.authorizeRequests()
                .antMatchers("/users/**").hasRole("STUDENT")
                .antMatchers("/users/**").hasRole("TEACHER")
                .anyRequest()
                .authenticated();

        security.formLogin()
                .loginPage("/Login")
                .defaultSuccessUrl("/Home")
                .failureUrl("/Login?error")
                .permitAll();

        security.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/Logout"))
                .logoutSuccessUrl("/Index")
                .deleteCookies("my-remember-me-cookie")
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }
}
