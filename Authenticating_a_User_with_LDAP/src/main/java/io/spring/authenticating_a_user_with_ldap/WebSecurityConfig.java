package io.spring.authenticating_a_user_with_ldap;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * configures a security policy.
 */
@Configuration
@EnableWebMvcSecurity //turns on a variety of beans needed to use Spring Security.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and().formLogin();
    }

    /**
     * Spring Security’s LDAP module includes an embedded server written in pure
     * Java. The ldapAuthentication() method configures things where the
     * username at the login form is plugged into {0} such that it searches
     * uid={0},ou=people,dc=springframework,dc=org in the LDAP server.
     */
    @Configuration
    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.ldapAuthentication().userDnPatterns("uid={0},ou=people")
                    .groupSearchBase("ou=groups")
                    .contextSource().ldif("classpath:test-server.ldif");
        }

    }

}
