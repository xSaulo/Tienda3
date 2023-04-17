package com.tecno.tecno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

 /*@Bean
    public  UserDetailsService users(){
       UserDetails admin = User.builder()
               .username("juan")
                .password("{noop}123")
                .roles("USER", "VENDEDOR", "ADMIN")
                .build();
        UserDetails sales = User.builder()
               .username("rebeca")
                .password("{noop}456")
                .roles("VENDEDOR", "ADMIN")
                .build();
         UserDetails user = User.builder()
               .username("pedro")
                .password("{noop}789")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user, sales, admin);
    }   */


    
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        
    }

    
    
    
    
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
 //.requestMatchers("/facturar/carrito")
               // .hasRole("USER")
