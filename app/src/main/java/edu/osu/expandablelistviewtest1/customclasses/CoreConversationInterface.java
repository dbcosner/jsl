package edu.osu.expandablelistviewtest1.customclasses;

import java.util.ArrayList;
import java.util.HashMap;

public class CoreConversationInterface {
    // Key: JSL chapter
    // Value: ArrayList<CoreConversation> of all CCs for that chapter
    private static HashMap<Integer, ArrayList<CoreConversation>> coreConversations = new HashMap<>();

    // Info for individual chapters
    private static ArrayList<CoreConversation> chapter13CoreConversations = new ArrayList<CoreConversation>();
    private static String description = "Mr. Tanaka on the phone";
    private static String imageURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/images/01.jpg";
    private static String videoURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/video/A-01.mp4";
    private static CoreConversation chapter13CoreConversation = new CoreConversation(description, imageURL, videoURL);

    public CoreConversationInterface() {
        // initialize all CC info
        chapter13CoreConversations.add(chapter13CoreConversation);
        coreConversations.put(13, chapter13CoreConversations);
    }

    public ArrayList<CoreConversation> getCoreConversation(int chapter) {
        // return the ArrayList of all CCs for that chapter
        return (coreConversations.get(chapter));
    }

}
