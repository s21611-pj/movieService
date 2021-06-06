package pl.pjatk.movie_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.pjatk.movie_service.model.Movie;
import pl.pjatk.movie_service.model.MovieCategory;

import javax.transaction.Transactional;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE movie m SET m.available = true WHERE m.ID = :id ", nativeQuery = true)
    void updateAvailabilityToTrue(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE movie m SET m.available = false WHERE m.ID = :id ", nativeQuery = true)
    void updateAvailabilityToFalse(Long id);

    Optional<Movie> findMovieByAvailableAndCategoryAndID(boolean available, MovieCategory category, Long ID);
}
