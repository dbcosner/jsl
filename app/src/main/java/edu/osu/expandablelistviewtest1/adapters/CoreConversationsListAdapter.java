package edu.osu.expandablelistviewtest1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.osu.expandablelistviewtest1.R;
import edu.osu.expandablelistviewtest1.customclasses.CoreConversation;

/**
 * Based on code from:
 * http://www.perfectapk.com/android-listfragment-tutorial.html
 */
public class CoreConversationsListAdapter extends ArrayAdapter<CoreConversation> {

    public CoreConversationsListAdapter(Context context, List<CoreConversation> coreConversations) {
        super(context, R.layout.fragment_core_conversations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            // inflate the item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fragment_core_conversations, parent, false);

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.ivIcon);
            viewHolder.title = (TextView) convertView.findViewById(R.id.coreConversationTitle);
            viewHolder.description = (TextView) convertView.findViewById(R.id.coreConversationDescription);
            convertView.setTag(viewHolder);
        } else {
            // just recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // update the item view
        CoreConversation coreConversation = getItem(position);
        viewHolder.icon.setImageDrawable(coreConversation.icon);
        viewHolder.title.setText(coreConversation.title);
        viewHolder.description.setText(coreConversation.description);

        return convertView;
        }

    /**
     * The view holder design pattern prevents using findViewById()
     * repeatedly in the getView() method of the adapter.
     *
     * @see http://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder
     */
    private static class ViewHolder {
        ImageView icon;
        TextView title;
        TextView description;
    }
}
