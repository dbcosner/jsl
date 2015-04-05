package edu.osu.expandablelistviewtest1.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import edu.osu.expandablelistviewtest1.R;

public class StreamVideoActivity extends Activity {
    private String LOG_TAG = "#### StreamVideoActivity: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_video);
        VideoView videoView = (VideoView) findViewById(R.id.activityStreamVideoVideoView);

        Intent intent = getIntent();
        String videoURL = intent.getStringExtra("videoURL");
        Uri videoUri = Uri.parse(videoURL);
        Log.d(LOG_TAG, "URL passed to StreamVideoActivity: " + videoURL);
        String trackTitle = intent.getStringExtra("trackTitle");
        Log.d(LOG_TAG, "Track title passed to StreamVideoActivity: " + trackTitle);

        videoView.setVideoURI(videoUri);

        // Create video playback control buttons
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        videoView.start();
    }
}
