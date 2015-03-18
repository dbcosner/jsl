package edu.osu.expandablelistviewtest1.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.osu.expandablelistviewtest1.R;

public class CoreConversationsFragment extends Fragment {
    private int chapter;
    private String chapterAsString;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chapter = getArguments().getInt("chapter");
        chapterAsString = String.valueOf(chapter);
    }

    // For some reason, Fragments don't use setContentView(), need to
    // use this method instead
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_core_conversations, container, false);
        TextView text = (TextView) rootView.findViewById(R.id.coreConversationText);
        text.setText("Testing: " + chapterAsString);

        return rootView;
    }
}
