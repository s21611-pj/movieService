package pl.pjatk.movie_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<Movie>> findAllMovies(){
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findMovieByID(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable Long id) {
        return ResponseEntity.ok(movieService.updateMovie(movie, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieByID(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/availability/{id}")
    public ResponseEntity<Void> updateMovieAvailability(@PathVariable Long id) {
        movieService.updateMovieAvailability(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/availability/false/{id}")
    public ResponseEntity<Void> updateMovieAvailabilityToFalse(@PathVariable Long id) {
        movieService.updateMovieAvailabilityToFalse(id);
        return ResponseEntity.noContent().build();
    }

}

//@RestController
//@RequestMapping("/movies")
//public class MovieController {
//
//    private MovieService movieService;
//
//    public MovieController(MovieService movieService) {
//        this.movieService = movieService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Movie>> findAllMovies() {
//        return ResponseEntity.ok(movieService.findAllMovies());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Movie> findMovieByID(@PathVariable Long ID) {
//        return ResponseEntity.ok(movieService.findMovieByID(ID));
//    }
//
//    @PostMapping
//    public ResponseEntity<Movie> createMovie (@RequestBody Movie movie) {
//        return ResponseEntity.ok(movieService.createMovie(movie));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable Long ID) {
//        return ResponseEntity.ok(movieService.updateMovie(movie, ID));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteMovieByID(@PathVariable Long ID) {
//        movieService.deleteMovieByID(ID);
//        return ResponseEntity.ok().build();
//    }
//}
