package edu.osu.expandablelistviewtest1.customclasses;

import java.util.ArrayList;
import java.util.HashMap;

public class DrillsInterface {
    private static HashMap<Integer, ArrayList<String>> drills =
            new HashMap<Integer, ArrayList<String>>();

    public DrillsInterface() {
        // chapter 13
        ArrayList<String> chapter13Drills = new ArrayList<String>();
        chapter13Drills.add("Section A Drill A");
        chapter13Drills.add("Section A Drill B");
        chapter13Drills.add("Section A Drill C");
        chapter13Drills.add("Section A Drill D");
        chapter13Drills.add("Section A Drill E");
        chapter13Drills.add("Section A Drill F");
        chapter13Drills.add("Section A Drill G");
        chapter13Drills.add("Section A Drill H");
        chapter13Drills.add("Section A Drill I");
        chapter13Drills.add("Section A Drill J");
        chapter13Drills.add("Section A Drill K");
        chapter13Drills.add("Section A Drill L");
        chapter13Drills.add("Section A Drill M");
        chapter13Drills.add("Section A Drill N");
        chapter13Drills.add("Section A Drill O");
        chapter13Drills.add("Section A Drill P");
        chapter13Drills.add("Section A Drill Q");
        chapter13Drills.add("Section A Drill R");
        chapter13Drills.add("Section A Drill S");

        drills.put(13, chapter13Drills);

        // chapter 14
        ArrayList<String> chapter14Drills = new ArrayList<String>();
        chapter14Drills.add("Section A Drill A");
        chapter14Drills.add("Section A Drill B");
        chapter14Drills.add("Section A Drill C");
        chapter14Drills.add("Section A Drill D");
        chapter14Drills.add("Section A Drill E");
        chapter14Drills.add("Section A Drill F");
        chapter14Drills.add("Section A Drill G");
        chapter14Drills.add("Section A Drill H");
        chapter14Drills.add("Section A Drill I");
        chapter14Drills.add("Section A Drill J");
        chapter14Drills.add("Section A Drill K");
        chapter14Drills.add("Section A Drill L");
        chapter14Drills.add("Section A Drill M");
        chapter14Drills.add("Section A Drill N");
        chapter14Drills.add("Section A Drill O");
        chapter14Drills.add("Section A Drill P");
        chapter14Drills.add("Section A Drill Q");
        chapter14Drills.add("Section A Drill R");
        chapter14Drills.add("Section A Drill S");
        chapter14Drills.add("Section A Drill T");
        chapter14Drills.add("Section A Drill U");
        chapter14Drills.add("Section A Drill V");

        drills.put(14, chapter14Drills);
    }

    public ArrayList<String> getChapter(int chapter) {
        return (drills.get(chapter));
    }


}
