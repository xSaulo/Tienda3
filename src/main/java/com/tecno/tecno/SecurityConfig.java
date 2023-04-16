package com.tecno.tecno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // @Bean
    // public InMemoryUserDetailsManager userDetailsService() {
    // UserDetails user = User.builder()
    // .username("Juan")
    // .password("{noop}andresEsGay")
    // .roles("USER", "VENDEDOR")
    // .build();
    //
    // UserDetails admin = User.builder()
    // .username("Luis")
    // .password("{noop}12345")
    // .roles("ADMIN", "USER", "VENDEDOR")
    // .build();
    //
    // return new InMemoryUserDetailsManager(user, admin);
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/", "/index", "/errores/**", "/webjars/**")
                        .permitAll()
                        .requestMatchers("/articulo/nuevo", "/articulo/guardar", "/articulo/modificar/**",
                                "/articulo/eliminar/**",
                                "/cliente/listar", "/cliente/nuevo", "/cliente/guardar", "/cliente/modificar/**",
                                "/cliente/eliminar/**",
                                "/categoria/nuevo", "/categoria/guardar", "/categoria/modificar/**",
                                "/categoria/eliminar/**")
                        .hasRole("ADMIN")
                        .requestMatchers("/articulo/listar", "/categoria/listar", "/cliente/listar")
                        .hasRole("VENDEDOR"))
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll())
                .logout((logout) -> logout.permitAll())
                .exceptionHandling()
                .accessDeniedPage("/errores/403");

        return httpSecurity.build();

    }

}
