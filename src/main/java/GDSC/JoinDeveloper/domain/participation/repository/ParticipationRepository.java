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
    @Override
    boolean existsById(Long id);

    @Query("select pa from Participation pa join fetch pa.user u join fetch pa.post p " +
            "where u.id = :userId")
    List<Participation> findByUserId(@Param("userId") Long userId);

    @Query("select pa from Participation pa join fetch pa.user u join fetch pa.post p " +
            "where p.id = :postId")
    List<Participation> findByPostId(@Param("postId") Long postId);

    @Query("select pa from Participation pa join pa.user u join fetch pa.post p " +
            "where u.id =:userId and p.id =:postId")
    Optional<Participation> findByUidAndPid(@Param("userId") Long userId, @Param("postId") Long postId);
}
