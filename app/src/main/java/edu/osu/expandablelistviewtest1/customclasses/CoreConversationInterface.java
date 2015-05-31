package edu.osu.expandablelistviewtest1.customclasses;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class CoreConversationInterface {
    private final String TAG = "#### CoreConversationInterface: ";
    // Key: JSL chapter
    // Value: ArrayList<CoreConversation> of all CCs for that chapter
    private static HashMap<Integer, ArrayList<CoreConversation>> coreConversations = new HashMap<>();
    private String rootURL = "http://www.cbusdesigns.com/jsl-app";
    private ArrayList<String> titles;
    private ArrayList<String> descriptions;
    private CoreConversation aCoreConversation;

    private String title;
    private String description;
    private String imageURL;
    private String videoURL;

    public CoreConversationInterface() {
        // initialize all CC info
        createChapters();
    }

    // Needed to work with custom list adapter
    public ArrayList<CoreConversation> getCoreConversation(int chapter) {
        // return the ArrayList of all CCs for that chapter
        return (coreConversations.get(chapter));
    }

    private void createChapters() {
        titles = new ArrayList<String>();
        descriptions = new ArrayList<String>();

        //Chapter 13
        ArrayList<CoreConversation> chapter13SectionA = createChapterSections(13, 'A', 5);
        ArrayList<CoreConversation> chapter13SectionB = createChapterSections(13, 'B', 2);
        ArrayList<CoreConversation> chapter13CCs = new ArrayList<CoreConversation>();
        chapter13CCs.addAll(chapter13SectionA);
        chapter13CCs.addAll(chapter13SectionB);
        coreConversations.put(13, chapter13CCs);

        // Chapter 14
        ArrayList<CoreConversation> chapter14SectionA = createChapterSections(14, 'A', 3);
        ArrayList<CoreConversation> chapter14SectionB = createChapterSections(14, 'B', 3);
        ArrayList<CoreConversation> chapter14CCs = new ArrayList<CoreConversation>();
        chapter14CCs.addAll(chapter14SectionA);
        chapter14CCs.addAll(chapter14SectionB);
        coreConversations.put(14, chapter14CCs);

        // Chapter 15
        ArrayList<CoreConversation> chapter15SectionA = createChapterSections(15, 'A', 3);
        ArrayList<CoreConversation> chapter15SectionB = createChapterSections(15, 'B', 3);
        ArrayList<CoreConversation> chapter15CCs = new ArrayList<CoreConversation>();
        chapter15CCs.addAll(chapter15SectionA);
        chapter15CCs.addAll(chapter15SectionB);
        coreConversations.put(15, chapter15CCs);

        // Chapter 16
        ArrayList<CoreConversation> chapter16SectionA = createChapterSections(16, 'A', 4);
        ArrayList<CoreConversation> chapter16SectionB = createChapterSections(16, 'B', 2);
        ArrayList<CoreConversation> chapter16CCs = new ArrayList<CoreConversation>();
        chapter16CCs.addAll(chapter16SectionA);
        chapter16CCs.addAll(chapter16SectionB);
        coreConversations.put(16, chapter16CCs);

        // Chapter 17
        ArrayList<CoreConversation> chapter17SectionA = createChapterSections(17, 'A', 4);
        ArrayList<CoreConversation> chapter17SectionB = createChapterSections(17, 'B', 3);
        ArrayList<CoreConversation> chapter17CCs = new ArrayList<CoreConversation>();
        chapter17CCs.addAll(chapter17SectionA);
        chapter17CCs.addAll(chapter17SectionB);
        coreConversations.put(17, chapter16CCs);

        //Chapter 18


        // Chapter 19


        // Chapter 20


        // Chapter 21


        // Chapter 22


        // Chapter 23


        //Chapter 24
    }



    private ArrayList<CoreConversation> createChapterSections(int chapter, char section, int numberOfCCs) {
        titles.clear();
        descriptions.clear();
        for (int i = 0; i < numberOfCCs; i++) {
            String iAdjusted;
            if (i < 9) {
                iAdjusted = "0" + (i + 1);
            } else {
                iAdjusted = "" + (i + 1);
            }
            String currentTitle = "Section " + section + " Core Conversation " + (i + 1);
            Log.d(TAG, "Attempting to create: " + currentTitle);
            titles.add(currentTitle);

            String currentDescription = "Chapter " + chapter + " Core Conversation " + section + "-" + iAdjusted + " description Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.";
            Log.d(TAG, "Attempting to create: " + currentDescription);
            descriptions.add(currentDescription);
        }

        ArrayList<CoreConversation> anArrayListOfCCs = new ArrayList<CoreConversation>();
        for (int i = 0; i < numberOfCCs; i++) {
            title = titles.get(i);
            description = descriptions.get(i);
             String iAdjusted;
            if (i < 9) {
                iAdjusted = "0" + (i + 1);
            } else {
                iAdjusted = "" + (i + 1);
            }
            imageURL = rootURL + "/chapter" + chapter + "/coreconversation/images/" + section + "-" + iAdjusted + ".jpg";
            videoURL = rootURL + "/chapter" + chapter + "/coreconversation/video/" + section + "-" + iAdjusted + ".mp4";
            aCoreConversation = new CoreConversation(title, description, imageURL, videoURL);
            anArrayListOfCCs.add(aCoreConversation);
        }
        return(anArrayListOfCCs);
    }

}
