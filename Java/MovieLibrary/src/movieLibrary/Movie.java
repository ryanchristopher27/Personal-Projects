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
    
    // Rating Variables
    public int plotRating;
    public int themeRating;
    public int visualsRating;
    public int actingRating;
    public int soundRating;
    public int cinemaRating;
    public int averageRating;
    
    // Additional Variables
    public int length;
    public String notes;
    
    // Movie Class Constructors
    public Movie() {
        title = "None";
        genre = "None";
        rating = 50;
        plotRating = 50;
        themeRating = 50;
        visualsRating = 50;
        actingRating = 50;
        soundRating = 50;
        cinemaRating = 50;
        averageRating = 50;
        length = 0;
        notes = "";
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
    public void setLength(int length) {
        this.length = length;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    // Specific Rating Setters
    public void setPlotRating(int plotRating) {
        this.plotRating = plotRating;
    }
    public void setThemeRating(int themeRating) {
        this.themeRating = themeRating;
    }
    public void setVisualsRating(int visualsRating) {
        this.visualsRating = visualsRating;
    }
    public void setActingRating(int actingRating) {
        this.actingRating = actingRating;
    }
    public void setSoundRating(int soundRating) {
        this.soundRating = soundRating;
    }
    public void setCinemaRating(int cinemaRating) {
        this.cinemaRating = cinemaRating;
    }
    public void setAverageRating() {
        int sum = this.plotRating + this.themeRating + this.visualsRating + this.actingRating + this.soundRating + this.cinemaRating + this.rating;
        this.averageRating = (int)(sum / 7);
    }
    
    
    // Movie Class Getters
    public String getTitle() {
        return this.title;
    }
    public String getGenre() {
        return this.genre;
    }
    public int getRating() {
        return this.rating;
    }
    public int getLength() {
        return this.length;
    }
    public String getNotes() {
        return this.notes;
    }
    // Sepcific Rating Getters
    public int getPlotRating() {
        return this.plotRating;
    }
    public int getThemeRating() {
        return this.themeRating;
    }
    public int getVisualsRating() {
        return this.visualsRating;
    }
    public int getActingRating() {
        return this.actingRating;
    }
    public int getSoundRating() {
        return this.soundRating;
    }
    public int getCinemaRating() {
        return this.cinemaRating;
    }
    public int getAverageRating() {
        return this.averageRating;
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
