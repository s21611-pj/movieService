package pl.pjatk.movie_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.movie_service.model.Movie;
import pl.pjatk.movie_service.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> findAllMovies() {
        return ResponseEntity.ok(movieService.findAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findMovieByID(@PathVariable Long ID) {
        return ResponseEntity.ok(movieService.findMovieByID(ID));
    }
}