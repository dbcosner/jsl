package edu.osu.expandablelistviewtest1.customclasses;

import java.util.ArrayList;
import java.util.HashMap;

public class DrillsInterface {
    private static HashMap<Integer, ArrayList<String>> drills =
            new HashMap<Integer, ArrayList<String>>();

    public DrillsInterface() {
        // chapter 13
        ArrayList<String> chapter13Drills = new ArrayList<String>();
        chapter13Drills.add("Chapter 13 Section A Drill A");
        chapter13Drills.add("Chapter 13 Section A Drill B");
        chapter13Drills.add("Chapter 13 Section A Drill C");
        chapter13Drills.add("Chapter 13 Section A Drill D");
        chapter13Drills.add("Chapter 13 Section A Drill E");
        chapter13Drills.add("Chapter 13 Section A Drill F");
        chapter13Drills.add("Chapter 13 Section A Drill G");
        chapter13Drills.add("Chapter 13 Section A Drill H");
        chapter13Drills.add("Chapter 13 Section A Drill I");
        chapter13Drills.add("Chapter 13 Section A Drill J");
        chapter13Drills.add("Chapter 13 Section A Drill K");
        chapter13Drills.add("Chapter 13 Section A Drill L");
        chapter13Drills.add("Chapter 13 Section A Drill M");
        chapter13Drills.add("Chapter 13 Section A Drill N");
        chapter13Drills.add("Chapter 13 Section A Drill O");
        chapter13Drills.add("Chapter 13 Section A Drill P");
        chapter13Drills.add("Chapter 13 Section A Drill Q");
        chapter13Drills.add("Chapter 13 Section A Drill R");
        chapter13Drills.add("Chapter 13 Section A Drill S");

        drills.put(13, chapter13Drills);
    }

    public ArrayList<String> getChapter(int chapter) {
        return (drills.get(chapter));
    }


}
