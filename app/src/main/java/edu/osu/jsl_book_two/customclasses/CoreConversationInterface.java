package edu.osu.jsl_book_two.customclasses;

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
        coreConversations.put(17, chapter17CCs);

        //Chapter 18
        ArrayList<CoreConversation> chapter18SectionA = createChapterSections(18, 'A', 5);
        ArrayList<CoreConversation> chapter18SectionB = createChapterSections(18, 'B', 3);
        ArrayList<CoreConversation> chapter18CCs = new ArrayList<CoreConversation>();
        chapter18CCs.addAll(chapter18SectionA);
        chapter18CCs.addAll(chapter18SectionB);
        coreConversations.put(18, chapter18CCs);

        // Chapter 19
        ArrayList<CoreConversation> chapter19SectionA = createChapterSections(19, 'A', 5);
        ArrayList<CoreConversation> chapter19SectionB = createChapterSections(19, 'B', 3);
        ArrayList<CoreConversation> chapter19CCs = new ArrayList<CoreConversation>();
        chapter19CCs.addAll(chapter19SectionA);
        chapter19CCs.addAll(chapter19SectionB);
        coreConversations.put(19, chapter19CCs);


        // Chapter 20
        ArrayList<CoreConversation> chapter20SectionA = createChapterSections(20, 'A', 3);
        ArrayList<CoreConversation> chapter20SectionB = createChapterSections(20, 'B', 4);
        ArrayList<CoreConversation> chapter20CCs = new ArrayList<CoreConversation>();
        chapter20CCs.addAll(chapter20SectionA);
        chapter20CCs.addAll(chapter20SectionB);
        coreConversations.put(20, chapter20CCs);


        // Chapter 21
        ArrayList<CoreConversation> chapter21SectionA = createChapterSections(21, 'A', 4);
        ArrayList<CoreConversation> chapter21SectionB = createChapterSections(21, 'B', 4);
        ArrayList<CoreConversation> chapter21CCs = new ArrayList<CoreConversation>();
        chapter21CCs.addAll(chapter21SectionA);
        chapter21CCs.addAll(chapter21SectionB);
        coreConversations.put(21, chapter21CCs);


        // Chapter 22
        ArrayList<CoreConversation> chapter22SectionA = createChapterSections(22, 'A', 4);
        ArrayList<CoreConversation> chapter22SectionB = createChapterSections(22, 'B', 4);
        ArrayList<CoreConversation> chapter22CCs = new ArrayList<CoreConversation>();
        chapter22CCs.addAll(chapter22SectionA);
        chapter22CCs.addAll(chapter22SectionB);
        coreConversations.put(22, chapter22CCs);


        // Chapter 23
        ArrayList<CoreConversation> chapter23SectionA = createChapterSections(23, 'A', 3);
        ArrayList<CoreConversation> chapter23SectionB = createChapterSections(23, 'B', 4);
        ArrayList<CoreConversation> chapter23CCs = new ArrayList<CoreConversation>();
        chapter23CCs.addAll(chapter23SectionA);
        chapter23CCs.addAll(chapter23SectionB);
        coreConversations.put(23, chapter23CCs);


        //Chapter 24
        ArrayList<CoreConversation> chapter24SectionA = createChapterSections(24, 'A', 3);
        ArrayList<CoreConversation> chapter24SectionB = createChapterSections(24, 'B', 3);
        ArrayList<CoreConversation> chapter24CCs = new ArrayList<CoreConversation>();
        chapter24CCs.addAll(chapter24SectionA);
        chapter24CCs.addAll(chapter24SectionB);
        coreConversations.put(24, chapter24CCs);
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
