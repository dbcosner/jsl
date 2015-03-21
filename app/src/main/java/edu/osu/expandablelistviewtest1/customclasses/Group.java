// Based on code from:
// http://www.vogella.com/tutorials/AndroidListView/article.html#expandablelistview

package edu.osu.expandablelistviewtest1.customclasses;
import java.util.ArrayList;
import java.util.List;

public class Group {

    public String chapterAsString;
    public int chapter;
    public final List<String> children = new ArrayList<String>();

    public Group(int chapter) {
       this.chapter = chapter;
        this.chapterAsString = "Chapter " + chapter;
    }

}