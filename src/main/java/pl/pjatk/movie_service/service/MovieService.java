package pl.pjatk.movie_service.service;

import org.springframework.stereotype.Service;
import pl.pjatk.movie_service.model.Movie;
import pl.pjatk.movie_service.model.MovieCategory;
import pl.pjatk.movie_service.repository.MovieRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(Long id) throws RuntimeException{
        Optional<Movie> movieSearch = movieRepository.findById(id);
        if (movieSearch.isPresent()){
            return movieSearch.get();
        }
        else {
            throw new RuntimeException();
        }
    }

    public Movie addMovie (Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie (Movie movie, Long id) throws RuntimeException {
        Optional<Movie> movieAdd = movieRepository.findById(id);
        if (movieAdd.isPresent()){
            Movie putMovie = movie;
            putMovie.setID(id);
            return movieRepository.save(putMovie);
        } else {
            throw new RuntimeException();
        }
    }

    public void deleteMovie (Long id) {
        movieRepository.deleteById(id);
    }

    public void updateMovieAvailability(Long id) {
        movieRepository.updateAvailabilityToTrue(id);
    }

    public void updateMovieAvailabilityToFalse(Long id) {
        movieRepository.updateAvailabilityToFalse(id);
    }
}


//@Service
//public class MovieService {
//
//    public List<Movie> findAllMovies() {
//        return List.of(
//                new Movie(1L, "Titanic", "Wojtek Turek", MovieCategory.DRAMA, 2020)
//        );
//    }
//
//    public Movie findMovieByID(Long ID) {
//        return new Movie(2L, "nic", "rezyser", MovieCategory.COMEDY, 1990);
//    }
//
//    public Movie createMovie (Movie movie) {
//        return movie;
//    }
//
//    public Movie updateMovie (Movie movie, Long ID) {
//        return new Movie(ID, movie.getName(), movie.getDirector(), movie.getCategory(), movie.getYear());
//    }
//
//    public Long deleteMovieByID(Long ID) {
//        return ID;
//    }
//
//}
