package com.lugowoy.tasks.solutions.core.determineTimeForWhichMovieIsDownloaded;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 16.06.2017.
 */

public class Movie implements Cloneable, Serializable {

    private String nameMovie;
    private double sizeMovieInGb;

    public Movie() {
    }

    public Movie(String nameMovie, double sizeMovieInGb) {
        this.nameMovie = nameMovie;
        this.sizeMovieInGb = sizeMovieInGb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.getSizeMovieInGb(), getSizeMovieInGb()) == 0 &&
                Objects.equals(getNameMovie(), movie.getNameMovie());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameMovie(), getSizeMovieInGb());
    }

    @Override
    public String toString() {
        return "Movie[" +
                "nameMovie='" + nameMovie + '\'' +
                ", sizeMovieInGb=" + sizeMovieInGb +
                ']';
    }

    @Override
    public Movie clone() {
        Movie movie = new Movie();
        try {
            movie = (Movie) super.clone();
            movie.setNameMovie(new Cloner().deepClone(this.getNameMovie()));
            movie.setSizeMovieInGb(this.getSizeMovieInGb());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return movie;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public double getSizeMovieInGb() {
        return sizeMovieInGb;
    }

    public void setSizeMovieInGb(double sizeMovieInGb) {
        this.sizeMovieInGb = sizeMovieInGb;
    }

}
