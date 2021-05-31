package pl.pjatk.movie_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.pjatk.movie_service.model.Movie;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findById(Long id);

    List<Movie> findAll();

    Movie save(Movie movie);

    @Modifying
    @Transactional
    @Query(value = "UPDATE movie m SET m.available = true WHERE m.ID = :id ", nativeQuery = true)
    void updateAvailabilityToTrue(Long id);
}
