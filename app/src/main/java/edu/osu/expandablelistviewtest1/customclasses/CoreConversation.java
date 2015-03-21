package edu.osu.expandablelistviewtest1.customclasses;

public class CoreConversation {
    private String description = "Description not set.";
    private String imageURL = "imageURL not set.";
    private String audioURL = "audioURL not set.";

    public CoreConversation(String description, String imageURL, String audioURL) {
        this.description = description;
        this.imageURL = imageURL;
        this.audioURL = audioURL;
    }

    // Getters
    public String getDescription() { return this.description; }
    public String getImageURL() { return this.imageURL; }
    public String getAudioURL() { return this.audioURL; }

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
