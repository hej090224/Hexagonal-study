package com.example.HexagonalStudy.security;

import com.example.HexagonalStudy.domain.port.in.AuthUseCase;
import com.example.HexagonalStudy.domain.model.UserAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final AuthUseCase authUseCase;

    public SecurityConfig(AuthUseCase authUseCase){
        this.authUseCase = authUseCase;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            UserAccount ua = authUseCase.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            return User.withUsername(ua.getUsername())
                    .password(ua.getPassword())
                    .roles(ua.getRoles().stream().map(r -> r.replace("ROLE_", "")).toArray(String[]::new))
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/css/**").permitAll()
                        .requestMatchers("/posts/**").authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/posts", true)
                        .permitAll()
                )
                .logout(logout -> logout.logoutSuccessUrl("/login?logout"))
                .csrf(csrf -> csrf.disable()); // 개발 편의: 반드시 프로덕션에서는 적절히 설정

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService uds) {
        DaoAuthenticationProvider p = new DaoAuthenticationProvider();
        p.setUserDetailsService(uds);
        p.setPasswordEncoder(passwordEncoder());
        return p;
    }
}
