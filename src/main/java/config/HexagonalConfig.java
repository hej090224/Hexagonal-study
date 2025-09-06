package config;

import adapter.out.persistence.JpaPostRepositoryAdapter;
import adapter.out.persistence.JpaUserRepositoryAdapter;
import domain.port.in.AuthUseCase;
import domain.port.in.PostUseCase;
import domain.port.out.PostRepository;
import domain.port.out.UserRepository;
import domain.service.AuthService;
import domain.service.PostService;
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
