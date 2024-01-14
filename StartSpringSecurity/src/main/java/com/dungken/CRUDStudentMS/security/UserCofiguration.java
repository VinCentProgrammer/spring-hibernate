package com.dungken.CRUDStudentMS.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserCofiguration {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails tung = User.withUsername("tung").password("{noop}tung123").roles("Teacher").build();
        UserDetails dung = User.withUsername("dung").password("{noop}dung123").roles("Manager").build();
        UserDetails hung = User.withUsername("hung").password("{noop}hung123").roles("Admin").build();

        return new InMemoryUserDetailsManager(tung, dung, hung);
    }
}
