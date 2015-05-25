package edu.osu.expandablelistviewtest1.customclasses;

import java.util.ArrayList;
import java.util.HashMap;

public class CoreConversationInterface {
    // Key: JSL chapter
    // Value: ArrayList<CoreConversation> of all CCs for that chapter
    private static HashMap<Integer, ArrayList<CoreConversation>> coreConversations = new HashMap<>();

    // Should have used these for everything, but implemented from 17 on
    private int chapter;
    private char section;
    private int numberOfSections;
    private String rootURL = "http://www.cbusdesigns.com/jsl-app";
    private ArrayList<String> titles;
    private ArrayList<String> descriptions;
    private CoreConversation aCoreConversation;
    private ArrayList<CoreConversation> anArrayListOfCCs;

    public CoreConversationInterface() {
        // initialize all CC info
        createChapters();
    }

    public ArrayList<CoreConversation> getCoreConversation(int chapter) {
        // return the ArrayList of all CCs for that chapter
        return (coreConversations.get(chapter));
    }

    private void createChapters(){
        // Chapter 13
        ArrayList<CoreConversation> chapter13CoreConversations = new ArrayList<CoreConversation>();

        String title = "Chapter 13 Core Conversation A-1 Title";
        String description = "Chapter 13 Core Conversation A-1 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        String imageURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/images/A-01.jpg";
        String videoURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/video/A-01.mp4";
        CoreConversation chapter13cca1 = new CoreConversation(title, description, imageURL, videoURL);
        chapter13CoreConversations.add(chapter13cca1);

        title = "Chapter 13 Core Conversation A-2 Title";
        description = "Chapter 13 Core Conversation A-2 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/images/A-02.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/video/A-02.mp4";
        CoreConversation chapter13cca2 = new CoreConversation(title, description, imageURL, videoURL);
        chapter13CoreConversations.add(chapter13cca2);

        title = "Chapter 13 Core Conversation A-3 Title";
        description = "Chapter 13 Core Conversation A-3 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/images/A-03.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/video/A-03.mp4";
        CoreConversation chapter13cca3 = new CoreConversation(title, description, imageURL, videoURL);
        chapter13CoreConversations.add(chapter13cca3);

        title = "Chapter 13 Core Conversation A-4 Title";
        description = "Chapter 13 Core Conversation A-4 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/images/A-04.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/video/A-04.mp4";
        CoreConversation chapter13cca4 = new CoreConversation(title, description, imageURL, videoURL);
        chapter13CoreConversations.add(chapter13cca4);

        title = "Chapter 13 Core Conversation A-5 Title";
        description = "Chapter 13 Core Conversation A-5 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/images/A-05.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/video/A-05.mp4";
        CoreConversation chapter13cca5 = new CoreConversation(title, description, imageURL, videoURL);
        chapter13CoreConversations.add(chapter13cca5);

        title = "Chapter 13 Core Conversation B-1 Title";
        description = "Chapter 13 Core Conversation B-1 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/images/B-01.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/video/B-01.mp4";
        CoreConversation chapter13ccb1 = new CoreConversation(title, description, imageURL, videoURL);
        chapter13CoreConversations.add(chapter13ccb1);

        title = "Chapter 13 Core Conversation B-2 Title";
        description = "Chapter 13 Core Conversation B-2 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/images/B-02.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/video/B-02.mp4";
        CoreConversation chapter13ccb2 = new CoreConversation(title, description, imageURL, videoURL);
        chapter13CoreConversations.add(chapter13ccb2);

        coreConversations.put(13, chapter13CoreConversations);

        // Chapter 14
        ArrayList<CoreConversation> chapter14CoreConversations = new ArrayList<CoreConversation>();

        title = "Chapter 14 Core Conversation A-1 Title";
        description = "Chapter 14 Core Conversation A-1 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter14/coreconversation/images/A-01.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter14/coreconversation/video/A-01.mp4";
        CoreConversation chapter14cca1 = new CoreConversation(title, description, imageURL, videoURL);
        chapter14CoreConversations.add(chapter14cca1);

        title = "Chapter 14 Core Conversation A-2 Title";
        description = "Chapter 14 Core Conversation A-2 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter14/coreconversation/images/A-02.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter14/coreconversation/video/A-02.mp4";
        CoreConversation chapter14cca2 = new CoreConversation(title, description, imageURL, videoURL);
        chapter14CoreConversations.add(chapter14cca2);

        title = "Chapter 14 Core Conversation A-3 Title";
        description = "Chapter 14 Core Conversation A-3 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter14/coreconversation/images/A-03.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter14/coreconversation/video/A-03.mp4";
        CoreConversation chapter14cca3 = new CoreConversation(title, description, imageURL, videoURL);
        chapter14CoreConversations.add(chapter14cca3);

        title = "Chapter 14 Core Conversation B-1 Title";
        description = "Chapter 14 Core Conversation B-1 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter14/coreconversation/images/B-01.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter14/coreconversation/video/B-01.mp4";
        CoreConversation chapter14ccb1 = new CoreConversation(title, description, imageURL, videoURL);
        chapter14CoreConversations.add(chapter14ccb1);

        title = "Chapter 14 Core Conversation B-2 Title";
        description = "Chapter 14 Core Conversation B-2 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter14/coreconversation/images/B-02.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter14/coreconversation/video/B-02.mp4";
        CoreConversation chapter14ccb2 = new CoreConversation(title, description, imageURL, videoURL);
        chapter14CoreConversations.add(chapter14ccb2);

        title = "Chapter 14 Core Conversation B-3 Title";
        description = "Chapter 14 Core Conversation B-3 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter14/coreconversation/images/B-03.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter14/coreconversation/video/B-03.mp4";
        CoreConversation chapter14ccb3 = new CoreConversation(title, description, imageURL, videoURL);
        chapter14CoreConversations.add(chapter14ccb3);

        coreConversations.put(14, chapter14CoreConversations);

        // Chapter 15
        ArrayList<CoreConversation> chapter15CoreConversations = new ArrayList<CoreConversation>();

        title = "Chapter 15 Core Conversation A-1 Title";
        description = "Chapter 15 Core Conversation A-1 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter15/coreconversation/images/A-01.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter15/coreconversation/video/A-01.mp4";
        CoreConversation chapter15cca1 = new CoreConversation(title, description, imageURL, videoURL);
        chapter15CoreConversations.add(chapter15cca1);

        title = "Chapter 15 Core Conversation A-2 Title";
        description = "Chapter 15 Core Conversation A-2 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter15/coreconversation/images/A-02.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter15/coreconversation/video/A-02.mp4";
        CoreConversation chapter15cca2 = new CoreConversation(title, description, imageURL, videoURL);
        chapter15CoreConversations.add(chapter15cca2);

        title = "Chapter 15 Core Conversation A-3 Title";
        description = "Chapter 15 Core Conversation A-3 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter15/coreconversation/images/A-03.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter15/coreconversation/video/A-03.mp4";
        CoreConversation chapter15cca3 = new CoreConversation(title, description, imageURL, videoURL);
        chapter15CoreConversations.add(chapter15cca3);

        title = "Chapter 15 Core Conversation B-1 Title";
        description = "Chapter 15 Core Conversation B-1 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter15/coreconversation/images/B-01.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter15/coreconversation/video/B-01.mp4";
        CoreConversation chapter15ccb1 = new CoreConversation(title, description, imageURL, videoURL);
        chapter15CoreConversations.add(chapter15ccb1);

        title = "Chapter 15 Core Conversation B-2 Title";
        description = "Chapter 15 Core Conversation B-2 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter15/coreconversation/images/B-02.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter15/coreconversation/video/B-02.mp4";
        CoreConversation chapter15ccb2 = new CoreConversation(title, description, imageURL, videoURL);
        chapter15CoreConversations.add(chapter15ccb2);

        title = "Chapter 15 Core Conversation B-3 Title";
        description = "Chapter 15 Core Conversation B-3 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter15/coreconversation/images/B-03.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter15/coreconversation/video/B-03.mp4";
        CoreConversation chapter15ccb3 = new CoreConversation(title, description, imageURL, videoURL);
        chapter15CoreConversations.add(chapter15ccb3);

        coreConversations.put(15, chapter15CoreConversations);

        // Chapter 16
        ArrayList<CoreConversation> chapter16CoreConversations = new ArrayList<CoreConversation>();

        title = "Chapter 16 Core Conversation A-1 Title";
        description = "Chapter 16 Core Conversation A-1 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter16/coreconversation/images/A-01.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter16/coreconversation/video/A-01.mp4";
        CoreConversation chapter16cca1 = new CoreConversation(title, description, imageURL, videoURL);
        chapter16CoreConversations.add(chapter16cca1);

        title = "Chapter 16 Core Conversation A-2 Title";
        description = "Chapter 16 Core Conversation A-2 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter16/coreconversation/images/A-02.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter16/coreconversation/video/A-02.mp4";
        CoreConversation chapter16cca2 = new CoreConversation(title, description, imageURL, videoURL);
        chapter16CoreConversations.add(chapter16cca2);

        title = "Chapter 16 Core Conversation A-3 Title";
        description = "Chapter 16 Core Conversation A-3 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter16/coreconversation/images/A-03.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter16/coreconversation/video/A-03.mp4";
        CoreConversation chapter16cca3 = new CoreConversation(title, description, imageURL, videoURL);
        chapter16CoreConversations.add(chapter16cca3);

        title = "Chapter 16 Core Conversation A-4 Title";
        description = "Chapter 16 Core Conversation A-4 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter16/coreconversation/images/A-04.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter16/coreconversation/video/A-04.mp4";
        CoreConversation chapter16cca4 = new CoreConversation(title, description, imageURL, videoURL);
        chapter16CoreConversations.add(chapter16cca4);

        title = "Chapter 16 Core Conversation B-1 Title";
        description = "Chapter 16 Core Conversation B-1 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter16/coreconversation/images/B-01.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter16/coreconversation/video/B-01.mp4";
        CoreConversation chapter16ccb1 = new CoreConversation(title, description, imageURL, videoURL);
        chapter16CoreConversations.add(chapter16ccb1);

        title = "Chapter 16 Core Conversation B-2 Title";
        description = "Chapter 16 Core Conversation B-2 description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
        imageURL = "http://www.cbusdesigns.com/jsl-app/chapter16/coreconversation/images/B-02.jpg";
        videoURL = "http://www.cbusdesigns.com/jsl-app/chapter16/coreconversation/video/B-02.mp4";
        CoreConversation chapter16ccb2 = new CoreConversation(title, description, imageURL, videoURL);
        chapter16CoreConversations.add(chapter16ccb2);

        coreConversations.put(16, chapter16CoreConversations);

        // Chapter 17
        chapter = 17;

        // Section A
        titles = null;
        descriptions = null;
        for (int i = 0; i < numberOfSections; i++) {
            int iAdjusted = ++i;
            titles.add( "Chapter " + chapter + " Core Conversation " + section + "-" + iAdjusted + " Title");
            descriptions.add("Chapter " + chapter + " Core Conversation " + section + "-" + iAdjusted + " description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.");
        }

        section = 'A';
        numberOfSections = 4;
        anArrayListOfCCs = null;
        for (int i = 0; i < numberOfSections; i++) {
            title = titles.get(i);
            description = descriptions.get(i);
            //TODO: remove leading zeroes from CC file names (images and videos)
            int iAdjusted = ++i;
            imageURL = rootURL + "/chapter" + chapter + "/coreconversation/images/" + section + "-" + iAdjusted + ".jpg";
            videoURL = rootURL + "/chapter" + chapter + "/coreconversation/video/" + section + "-" + iAdjusted + ".mp4";
            aCoreConversation = new CoreConversation(title, description, imageURL, videoURL);
            anArrayListOfCCs.add(aCoreConversation);
        }

        // Section B
        titles = null;
        descriptions = null;
        for (int i = 0; i < numberOfSections; i++) {
            int iAdjusted = ++i;
            titles.add( "Chapter " + chapter + " Core Conversation " + section + "-" + iAdjusted + " Title");
            descriptions.add("Chapter " + chapter + " Core Conversation " + section + "-" + iAdjusted + " description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.");
        }

        section = 'B';
        numberOfSections = 3;
        anArrayListOfCCs = null;
        for (int i = 0; i < numberOfSections; i++) {
            title = titles.get(i);
            description = descriptions.get(i);
            //TODO: remove leading zeroes from CC file names (images and videos)
            int iAdjusted = ++i;
            imageURL = rootURL + "/chapter" + chapter + "/coreconversation/images/" + section + "-" + iAdjusted + ".jpg";
            videoURL = rootURL + "/chapter" + chapter + "/coreconversation/video/" + section + "-" + iAdjusted + ".mp4";
            aCoreConversation = new CoreConversation(title, description, imageURL, videoURL);
            anArrayListOfCCs.add(aCoreConversation);
        }

        // Add to the Hash Map
        coreConversations.put(chapter, anArrayListOfCCs);
    }

}
