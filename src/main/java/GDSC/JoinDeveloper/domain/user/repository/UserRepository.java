package GDSC.JoinDeveloper.domain.user.repository;

import GDSC.JoinDeveloper.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
    Optional<User> findById(Long id);
}
