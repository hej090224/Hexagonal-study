package adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPostRepository extends JpaRepository<JpaUserEntity, Long>{
}
