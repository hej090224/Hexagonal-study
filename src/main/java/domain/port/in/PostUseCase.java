package domain.port.in;

import domain.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostUseCase {
    Post createPost(Post post);
    Optional<Post> getPost(Long id);
    List<Post> getAllPosts();
    Post updatePost(Long id, Post post);
    void deletePost(Long id);



}
