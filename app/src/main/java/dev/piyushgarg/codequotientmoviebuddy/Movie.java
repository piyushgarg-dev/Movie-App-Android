package dev.piyushgarg.codequotientmoviebuddy;

public class Movie {
    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    private Double vote_average;


    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getVote_count() {
        return vote_count;
    }

    public void setVote_count(double vote_count) {
        this.vote_count = vote_count;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    private double popularity;
    private double vote_count;
    private String poster_path;
    private double id;
    private String original_title;
    private String title;
    private String overview;

    public Movie(double popularity, double vote_count, String poster_path, double id, String original_title, String title, String overview,double vote_average) {
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.poster_path = poster_path;
        this.id = id;
        this.original_title = original_title;
        this.title = title;
        this.overview = overview;
    }
}
