package GDSC.JoinDeveloper.domain.post.repository;

import GDSC.JoinDeveloper.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post save(Post post);
    Optional<Post> findById(Long id);

    @Override
    boolean existsById(Long id);

    @Override
    void delete(Post post);

    @Query("select p from Post p join fetch p.user u")
    List<Post> findAll();

    @Query("select p from Post p join fetch p.user u join fetch p.comments c " +
            "where p.id = postId")
    Optional<Post> findByPostId(@Param("postId") Long postId);
}
