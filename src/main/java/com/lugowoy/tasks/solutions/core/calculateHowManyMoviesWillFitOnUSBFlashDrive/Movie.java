package com.lugowoy.tasks.calculateHowManyMoviesWillFitOnUSBFlashDrive;

import com.rits.cloning.Cloner;

import java.io.Serializable;

/**
 * Created by Konstantin Lugowoy on 16.06.2017.
 */

public final class Movie implements Serializable, Cloneable {

    private String nameMovie;
    private double sizeMovie;

    public Movie() {
    }

    public Movie(String nameMovie, double sizeMovie) throws IllegalArgumentException {
        //The setters are used in the constructor, since the class is declared with the modifier final.
        this.setNameMovie(nameMovie);
        this.setSizeMovie(sizeMovie);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;

        Movie movie = (Movie) o;

        if (Double.compare(movie.sizeMovie, sizeMovie) != 0) return false;
        return nameMovie != null ? nameMovie.equals(movie.nameMovie) : movie.nameMovie == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nameMovie != null ? nameMovie.hashCode() : 0;
        temp = Double.doubleToLongBits(sizeMovie);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Movie[" +
                "nameMovie='" + nameMovie + '\'' +
                ", sizeMovie=" + sizeMovie +
                ']';
    }

    @Override
    protected Movie clone() {
        Movie movie = new Movie();
        try {
            movie = (Movie) super.clone();
            movie.setNameMovie(new Cloner().deepClone(this.getNameMovie()));
            movie.setSizeMovie(this.getSizeMovie());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return movie;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        if (checkNameOfMovie(nameMovie)) {
            this.nameMovie = nameMovie;
        }
    }

    public double getSizeMovie() {
        return sizeMovie;
    }

    public void setSizeMovie(double sizeMovie) {
        if (checkSizeMovie(sizeMovie)) {
            this.sizeMovie = sizeMovie;
        }
    }

    private boolean checkNameOfMovie(String nameMovie) {
        if ((nameMovie != null) && (!nameMovie.equals(""))) {
            return true;
        } else {
            throw new IllegalArgumentException("The name of the movie passed by the argument is null or an empty string.");
        }
    }

    private boolean checkSizeMovie(double sizeMovie) {
        if (sizeMovie > 0) {
            return true;
        } else {
            throw new IllegalArgumentException("The size of the movie passed by the argument is less than or equal to 0.");
        }
    }

}
