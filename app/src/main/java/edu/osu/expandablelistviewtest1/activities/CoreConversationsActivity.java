package edu.osu.expandablelistviewtest1.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import edu.osu.expandablelistviewtest1.R;
import edu.osu.expandablelistviewtest1.fragments.CoreConversationsFragment;

public class CoreConversationsActivity extends Activity {
    private int chapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_core_conversations);

        Intent intent = getIntent();
        // The chapter, as passed from the TOC
        // The "1" at the end is the default (chapter in this case)
        chapter = intent.getIntExtra("chapter", 1);

        // Remove later:
        TextView testText = (TextView) findViewById(R.id.testText);
        testText.setText("Chapter should be here: " + chapter);

        /*

        // The chapter will need to be passed along once more to
        // the Fragment
        Bundle bundle = new Bundle();
        bundle.putInt("chapter", chapter);
        CoreConversationsFragment coreConversationsFragment = new CoreConversationsFragment();
        coreConversationsFragment.setArguments(bundle);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.layout.activity_core_conversations, coreConversationsFragment);
        fragmentTransaction.commit();

        */
    }

}
