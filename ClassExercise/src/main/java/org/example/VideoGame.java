package org.example;

public class VideoGame {

    private String genre;
    private String type;
    private String rating;
    private boolean isMultiplayer;
    private boolean isOnline;

    public VideoGame(String genre, String type, String rating, boolean isMultiplayer, boolean isOnline){
        this.genre = genre;
        this.type = type;
        this.rating = rating;
        this.isMultiplayer = isMultiplayer;
        this.isOnline = isOnline;
    }

    public String getRating(){
        return this.rating;
    }

    public void setRating(String rating){
        this.rating = rating;
    }
}
