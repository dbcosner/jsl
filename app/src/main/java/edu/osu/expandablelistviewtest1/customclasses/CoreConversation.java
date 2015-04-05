package edu.osu.expandablelistviewtest1.customclasses;

public class CoreConversation {
    private String description = "Description not set.";
    private String imageURL = "imageURL not set.";
    private String videoURL = "videoURL not set.";

    public CoreConversation(String description, String imageURL, String videoURL) {
        this.description = description;
        this.imageURL = imageURL;
        this.videoURL = videoURL;
    }

    // Getters
    public String getDescription() { return this.description; }
    public String getImageURL() { return this.imageURL; }
    public String getVideoURL() { return this.videoURL; }

    /*
    // Setters
    public void setDescription(String description) {
        this.description = description;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }
    */

}
