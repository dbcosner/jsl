package edu.osu.expandablelistviewtest1.customclasses;

import java.util.ArrayList;
import java.util.HashMap;

public class DrillsInterface {
    private static HashMap<Integer, ArrayList<String>> sectionADrills =
            new HashMap<Integer, ArrayList<String>>();

    private static HashMap<Integer, ArrayList<String>> sectionBDrills =
            new HashMap<Integer, ArrayList<String>>();

    private char lastDrill;

    public DrillsInterface() {
        // chapter 13
        sectionADrills.put(13, populateSection('A', 'V'));
        sectionBDrills.put(13, populateSection('B', 'P'));

        // chapter 14
        sectionADrills.put(14, populateSection('A', 'S'));
        sectionBDrills.put(14, populateSection('B', 'M'));

        // chapter 15
        sectionADrills.put(15, populateSection('A', 'P'));
        sectionBDrills.put(15, populateSection('B', 'O'));

        // chapter 16
        sectionADrills.put(16, populateSection('A', 'M'));
        sectionBDrills.put(16, populateSection('B', 'N'));

        // chapter 17
        sectionADrills.put(17, populateSection('A', 'Q'));
        sectionBDrills.put(17, populateSection('B', 'R'));

        // chapter 18
        sectionADrills.put(18, populateSection('A', 'M'));
        sectionBDrills.put(18, populateSection('B', 'Q'));

        // chapter 19
        sectionADrills.put(19, populateSection('A', 'O'));
        sectionBDrills.put(19, populateSection('B', 'N'));

        // chapter 20
        sectionADrills.put(20, populateSection('A', 'W'));
        sectionBDrills.put(20, populateSection('B', 'N'));

        // chapter 21
        sectionADrills.put(21, populateSection('A', 'L'));
        sectionBDrills.put(21, populateSection('B', 'N'));

        // chapter 22
        sectionADrills.put(22, populateSection('A', 'Q'));
        sectionBDrills.put(22, populateSection('B', 'Q'));

        // chapter 23
        sectionADrills.put(23, populateSection('A', 'R'));
        sectionBDrills.put(23, populateSection('B', 'M'));

        // chapter 24
        sectionADrills.put(24, populateSection('A', 'O'));
        sectionBDrills.put(24, populateSection('B', 'R'));
    }

    public ArrayList<String> getChapter(char section, int chapter) {
        if (section == 'A') {
            return (sectionADrills.get(chapter));
        } else {
            return(sectionBDrills.get(chapter));
        }
    }

    private ArrayList<String> populateSection(char section, char lastDrill) {
        ArrayList<String> returnList = new ArrayList<String>();
        for (char alphabet = 'A'; alphabet <= lastDrill; alphabet++) {
            String sectionAndDrill = "Section " + section + " Drill " + alphabet;
            returnList.add(sectionAndDrill);
        }
        return returnList;
    }
}
