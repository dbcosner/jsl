package edu.osu.expandablelistviewtest1.customclasses;

import android.graphics.drawable.Drawable;

public class CoreConversation {
    public final Drawable icon;
    public final String title;
    public final String description;

    public CoreConversation(Drawable icon, String title, String description) {
        this.icon = icon;
        this.title = title;
        this.description = description;
    }
}
