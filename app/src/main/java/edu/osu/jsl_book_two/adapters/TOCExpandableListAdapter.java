// Based on code from:
// http://www.vogella.com/tutorials/AndroidListView/article.html#expandablelistview

package edu.osu.jsl_book_two.adapters;

import android.app.Activity;
import android.content.Intent;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

// Custom activities
import edu.osu.jsl_book_two.R;
import edu.osu.jsl_book_two.activities.CoreConversationsActivity;
import edu.osu.jsl_book_two.activities.DrillsActivity;
import edu.osu.jsl_book_two.customclasses.Group;
import edu.osu.jsl_book_two.customclasses.WifiConnectionChecker;

public class TOCExpandableListAdapter extends BaseExpandableListAdapter {

    private final SparseArray<Group> groups;
    public LayoutInflater inflater;
    public Activity activity;

    public TOCExpandableListAdapter(Activity act, SparseArray<Group> groups) {
        activity = act;
        this.groups = groups;
        inflater = act.getLayoutInflater(); // pass an Activity to be able to do this
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groups.get(groupPosition).children.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        // Children correspond to chapter sections
        final String chapterSection = (String) getChild(groupPosition, childPosition);

        // Groups DON'T correspond to chapters
        final int chapter = groups.get(groupPosition).chapter;

        TextView text = null;
        if (convertView == null) {
            // Get the XML for the child Views (CCs and Drills)
            convertView = inflater.inflate(R.layout.list_children_toc, null);
        }

        // convertView is a View, so we can use its findViewById method
        text = (TextView) convertView.findViewById(R.id.textView1);
        text.setText(chapterSection);

        final ViewGroup finalParent = parent;
        convertView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(WifiConnectionChecker.connectedToWifi(finalParent.getContext())) {

                    //Toast.makeText(activity, children,
                    //        Toast.LENGTH_SHORT).show();
                    Intent intent;

                    // Don't forget the .class when calling custom activities through Intent
                    if (chapterSection.equals("Core Conversations")) {
                        intent = new Intent(activity, CoreConversationsActivity.class);
                    }  else {
                        intent = new Intent(activity, DrillsActivity.class);
                    }
                    intent.putExtra("chapter", chapter);

                    // startActivity belongs to Context
                    activity.startActivity(intent);
                } else {
                    Toast.makeText(finalParent.getContext(), finalParent.getContext().getString(R.string.no_wifi), Toast.LENGTH_LONG).show();
                }
            }
        });
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups.get(groupPosition).children.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);

    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_group_toc, null);
        }
        Group group = (Group) getGroup(groupPosition);
        ((CheckedTextView) convertView).setText(group.chapterAsString);
        ((CheckedTextView) convertView).setChecked(isExpanded);

        // Personal addition for test
        if(isExpanded) {
            ((CheckedTextView) convertView).setCheckMarkDrawable(R.drawable.ic_action_collapse);
        } else {
            ((CheckedTextView) convertView).setCheckMarkDrawable(R.drawable.ic_action_expand);
        }
        // end of addition

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
