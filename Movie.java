package webprog.java1700oblig3tickets;

public class Movie {
    private String film;

    public Movie(String film){
        this.film = film;
    }
    public Movie () {}

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }
}
