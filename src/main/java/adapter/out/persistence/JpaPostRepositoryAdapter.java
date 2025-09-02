package adapter.out.persistence;

import domain.model.Post;
import domain.port.out.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaPostRepositoryAdapter implements PostRepository {

    private final SpringDataPostRepository repo;

    public JpaPostRepositoryAdapter(SpringDataPostRepository repo) {
        this.repo = repo;
    }

    @Override
    public Post save(Post post) {
        JpaPostEntity e = repo.save(JpaPostEntity.fromDomain(post));
        return e.toDomain();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return repo.findById(id).map(JpaPostEntity::toDomain);
    }

    @Override
    public List<Post> findAll() {
        return repo.findAll().stream().map(JpaPostEntity::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
