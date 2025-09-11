package com.example.HexagonalStudy.config;

import com.example.HexagonalStudy.domain.port.in.AuthUseCase;
import com.example.HexagonalStudy.domain.port.in.PostUseCase;
import com.example.HexagonalStudy.domain.port.out.PostRepository;
import com.example.HexagonalStudy.domain.port.out.UserRepository;
import com.example.HexagonalStudy.domain.service.AuthService;
import com.example.HexagonalStudy.domain.service.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HexagonalConfig {

    @Bean
    public PostUseCase postUseCase(PostRepository postRepository){
        return new PostService(postRepository);
    }

    @Bean
    public AuthUseCase authUseCase(UserRepository userRepository){
        return new AuthService(userRepository);
    }
}
