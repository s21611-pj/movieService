package pl.pjatk.movie_service.service;

import org.springframework.stereotype.Service;
import pl.pjatk.movie_service.model.Movie;
import pl.pjatk.movie_service.model.MovieCategory;

import java.util.List;

@Service
public class MovieService {

    public List<Movie> findAllMovies() {
        return List.of(
                new Movie(1L, "Titanic", "Wojtek Turek", MovieCategory.DRAMA, 2020)
        );
    }

    public Movie findMovieByID(Long ID) {
        return new Movie(2L, "nic", "rezyser", MovieCategory.COMEDY, 1990);
    }

    public Movie createMovie (Movie movie) {
        return movie;
    }

    public Movie updateMovie (Movie movie, Long ID) {
        return new Movie(ID, movie.getMovieName(), movie.getMovieDirector(), movie.getMovieCategory(), movie.getMovieYear());
    }

    public Long deleteMovieByID(Long ID) {
        return ID;
    }

}
