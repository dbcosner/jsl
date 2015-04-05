package edu.osu.expandablelistviewtest1;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ExpandableListView;

import edu.osu.expandablelistviewtest1.adapters.TOCExpandableListAdapter;
import edu.osu.expandablelistviewtest1.customclasses.Group;

public class MainActivity extends Activity {
    // more efficient than HashMap for mapping integers to objects
    // groups is an array of Group objects, which each have a
    // String for the chapter and an ArrayList of Strings for
    // children (CCs / Drills)
    SparseArray<Group> groups = new SparseArray<Group>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createData();

        // Create a ListView using the ListView "listView" in activity_main.xml
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.activityMainListView);
        TOCExpandableListAdapter adapter = new TOCExpandableListAdapter(this,
                groups);

        // Give the ListView its adapter
        listView.setAdapter(adapter);
    }
/*
    public void createData() {
        for (int j = 0; j < 5; j++) {
            Group group = new Group("Test " + j);
            for (int i = 0; i < 5; i++) {
                group.children.add("Sub Item" + i);
            }
            groups.append(j, group);
        }
    }*/

    // Used to create the chapter headings which are clicked to expand
    public void createData() {
        final int FIRST_CHAPTER = 13;
        final int LAST_CHAPTER = 24;
        // Create chapter headings
        int counter = 0; // group numbers can't correspond to chapters, unfortunately
        for (int i = FIRST_CHAPTER; i<=LAST_CHAPTER; i++) {
            Group group = new Group(i);
            group.children.add("Core Conversations");
            group.children.add("Drills");
            groups.append(counter, group);
            counter++;
        }
    }

}