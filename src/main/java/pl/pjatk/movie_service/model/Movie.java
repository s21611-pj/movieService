package pl.pjatk.movie_service.model;

public class Movie {

    private Long ID;
    private String movieName;
    private String movieDirector;
    private MovieCategory movieCategory;
    private int movieYear;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public MovieCategory getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(MovieCategory movieCategory) {
        this.movieCategory = movieCategory;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public Movie(Long ID, String movieName, String movieDirector, MovieCategory movieCategory, int movieYear) {
        this.ID = ID;
        this.movieName = movieName;
        this.movieDirector = movieDirector;
        this.movieCategory = movieCategory;
        this.movieYear = movieYear;
    }

    public Movie(String movieName, String movieDirector, MovieCategory movieCategory, int movieYear) {
        this.movieName = movieName;
        this.movieDirector = movieDirector;
        this.movieCategory = movieCategory;
        this.movieYear = movieYear;
    }

    public Movie() {

    }
}
