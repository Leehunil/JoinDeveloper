package GDSC.JoinDeveloper.domain.comment.repository;

import GDSC.JoinDeveloper.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment save(Comment comment);
    Optional<Comment> findById(Long id);

    @Override
    boolean existsById(Long id);

    @Override
    void delete(Comment entity);
}
