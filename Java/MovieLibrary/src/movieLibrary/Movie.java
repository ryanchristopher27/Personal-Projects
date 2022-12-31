/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieLibrary;

import java.io.Serializable;

/**
 *
 * @author Ryan Christopher
 */
public class Movie implements Serializable {
    // Variables
    public String title;
    public String genre;
    public int rating;
    
    // Movie Class Constructors
    public Movie() {
        title = "None";
        genre = "None";
        rating = 0;
    }
    public Movie(String title) {
        this.title = title;
    }
    public Movie(String title, String genre) {
        this(title);
        
        this.genre = genre;
    }
    public Movie(String title, String genre, int rating) {
        this(title, genre);
        
        this.rating = rating;
    }
    
    // Movie Class Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    // Movie Class Getters
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public int getRating() {
        return rating;
    }
    
    public boolean isInRatingRange(String ratingRange) {
        if (ratingRange.equals("90-100") && this.rating >= 90 && this.rating <= 100) {
            return true;
        }
        else if (ratingRange.equals("80-90") && this.rating >= 80 && this.rating <= 90) {
            return true;
        }
        else if (ratingRange.equals("70-80") && this.rating >= 70 && this.rating <= 80) {
            return true;
        }
        else if (ratingRange.equals("60-70") && this.rating >= 60 && this.rating <= 70) {
            return true;
        }
        else if (ratingRange.equals("50-60") && this.rating >= 50 && this.rating <= 60) {
            return true;
        }
        else if (ratingRange.equals("40-50") && this.rating >= 40 && this.rating <= 50) {
            return true;
        }
        else if (ratingRange.equals("30-40") && this.rating >= 30 && this.rating <= 40) {
            return true;
        }
        else if (ratingRange.equals("20-30") && this.rating >= 20 && this.rating <= 30) {
            return true;
        }
        else if (ratingRange.equals("10-20") && this.rating >= 10 && this.rating <= 20) {
            return true;
        }
        else if (ratingRange.equals("0-10") && this.rating >= 0 && this.rating <= 10) {
            return true;
        }
        else if (ratingRange.equals("All")) {
            return true;
        }
        return false;
    }
}
