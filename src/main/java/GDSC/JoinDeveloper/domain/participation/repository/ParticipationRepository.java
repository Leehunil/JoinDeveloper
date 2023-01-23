package GDSC.JoinDeveloper.domain.participation.repository;

import GDSC.JoinDeveloper.domain.participation.entity.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    Participation save(Participation participation);
    Optional<Participation> findById(Long id);

    @Query("select pa from Participation pa join fetch pa.user u join fetch pa.post p " +
            "where u.id = userId")
    List<Participation> findByUserId(@Param("userId") Long userId);
}
