package GDSC.JoinDeveloper.domain.participation.repository;

import GDSC.JoinDeveloper.domain.participation.entity.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    Participation save(Participation participation);
    Optional<Participation> findById(Long id);

}
