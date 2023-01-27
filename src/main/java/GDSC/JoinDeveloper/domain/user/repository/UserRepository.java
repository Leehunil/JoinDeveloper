package GDSC.JoinDeveloper.domain.user.repository;

import GDSC.JoinDeveloper.domain.user.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
    Optional<User> findById(Long id);

    @Query("select u from User u join fetch u.posts p " +
            "where u.id = :userId")
    Optional<User> findUserIdAndPost(@Param("userId") Long userId);

    @Query("select u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);
}
