package com.employees.managment.secureConfigration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
@EnableWebSecurity
public class securityConfiguration  {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=
                new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers(HttpMethod.POST,"/employ/save/**").hasAnyAuthority("empUser")
                        .requestMatchers(HttpMethod.GET,"/employ/get/**").hasAuthority("empUser")
                        .requestMatchers(HttpMethod.PUT,"/employ/update/{id}").hasAuthority("empUser")
                        .requestMatchers(HttpMethod.DELETE, "/employ/delete/{id}").hasAuthority("empUser")
                        .requestMatchers(HttpMethod.POST,"/depArtMen/saveDepartment").hasAnyAuthority("depUser")
                        .requestMatchers(HttpMethod.PUT,"/update/{id}").hasAuthority("depUser")
                        //.requestMatchers( "/depArtMen/getJobDepartment/{id}").hasAnyAuthority("depUser")
                        .requestMatchers(HttpMethod.POST, "/payroll/savePay").hasAnyAuthority("empUser")
                        .requestMatchers("/payroll/get/{id}").hasAuthority("payrollUser")
                        .requestMatchers(HttpMethod.PUT, "/payroll/updatePayroll/{Id}").hasAuthority("payrollUser")
                        .requestMatchers("/employ/csrf").permitAll()
                        .anyRequest().authenticated()
                )

                .httpBasic(Customizer.withDefaults());
//	            .exceptionHandling((exceptionHandling) -> exceptionHandling
//                .accessDeniedPage("/access-denied")
//        );
        return http.build();
    }
}
