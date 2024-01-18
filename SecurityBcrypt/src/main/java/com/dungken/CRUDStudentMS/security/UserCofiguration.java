package com.dungken.CRUDStudentMS.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.net.http.HttpRequest;

@Configuration
public class UserCofiguration {


//    @Bean
//    @Autowired
//    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("SELECT id, pw, active FROM accounts WHERE id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT id, role FROM roles WHERE id=?");
        return userDetailsManager;
    }
    
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        UserDetails tung = User.withUsername("tung").password("{noop}tung123").roles("TEACHER").build();
//        UserDetails dung = User.withUsername("dung").password("{noop}dung123").roles("Manager").build();
//        UserDetails hung = User.withUsername("hung").password("{noop}hung123").roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(tung, dung, hung);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                configurer->configurer
                    .requestMatchers(HttpMethod.GET, "/api/students")
                        .hasAnyRole("ADMIN", "TEACHER", "MANAGER")
                    .requestMatchers(HttpMethod.GET, "/api/students/**")
                        .hasAnyRole("ADMIN", "TEACHER", "MANAGER")
                    .requestMatchers(HttpMethod.POST, "/api/students")
                        .hasAnyRole("ADMIN", "MANAGER")
                    .requestMatchers(HttpMethod.PUT, "/api/students")
                        .hasAnyRole("ADMIN", "MANAGER")
                    .requestMatchers(HttpMethod.DELETE, "/api/students/**")
                        .hasRole("ADMIN")

        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());

        return http.build();
    }
}
