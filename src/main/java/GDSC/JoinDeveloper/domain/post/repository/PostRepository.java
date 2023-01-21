package GDSC.JoinDeveloper.domain.post.repository;

import GDSC.JoinDeveloper.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post save(Post post);
    Optional<Post> findById(Long id);

}
