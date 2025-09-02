package domain.service;

import domain.model.Post;
import domain.port.in.PostUseCase;
import domain.port.out.PostRepository;

import java.util.List;
import java.util.Optional;

public class PostService implements PostUseCase {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post post) {
        post.setId(null);
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(Long id, Post post) {
        Post updated = new Post(id, post.getTitle(), post.getContent(), post.getAuthor());
        return postRepository.save(updated);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
