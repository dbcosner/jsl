package edu.osu.expandablelistviewtest1.fragments;

import android.app.ListFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.osu.expandablelistviewtest1.R;
import edu.osu.expandablelistviewtest1.customclasses.CoreConversation;

public class CoreConversationsFragment extends ListFragment {
    private int chapter;
    private List<CoreConversation> coreConversations;        // ListView items list

    @Override
    public void onCreate(Bundle savedInstanceState) {
        chapter = getArguments().getInt("chapter");


        // initialize the items list
        coreConversations = new ArrayList<CoreConversation>();
        Resources resources = getResources();

        /*coreConversations.add(new CoreConversation(resources.getDrawable(R.drawable.aim), getString(R.string.aim), getString(R.string.aim_description)));
        coreConversations.add(new CoreConversation(resources.getDrawable(R.drawable.bebo), getString(R.string.bebo), getString(R.string.bebo_description)));
        coreConversations.add(new CoreConversation(resources.getDrawable(R.drawable.youtube), getString(R.string.youtube), getString(R.string.youtube_description)));
*/
        // Last answer in:
        // http://stackoverflow.com/questions/12193036/android-loop-through-strings-xml-file
        String chapterString = "chapter_" + chapter;
        ArrayList<String> coreConversationsTitlesAndDescriptions =
                getResources().getIdentifier("chapter13CCTitlesAndDescriptions", "core_conversations_titles_and_descriptions", this.getPackageName());


        // initialize and set the list adapter
        setListAdapter(new ListViewDemoAdapter(getActivity(), coreConversations));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // retrieve theListView item
        CoreConversation item = coreConversations.get(position);

        // do something
        Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();
    }
}
