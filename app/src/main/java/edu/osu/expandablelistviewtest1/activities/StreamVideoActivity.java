package edu.osu.expandablelistviewtest1.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.MediaController;
import android.widget.VideoView;

import edu.osu.expandablelistviewtest1.R;

public class StreamVideoActivity extends Activity {
    private String LOG_TAG = "#### StreamVideoActivity: ";
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_video);


        Intent intent = getIntent();
        String videoURL = intent.getStringExtra("videoURL");
        Uri videoUri = Uri.parse(videoURL);
        Log.d(LOG_TAG, "URL passed to StreamVideoActivity: " + videoURL);
        String trackTitle = intent.getStringExtra("trackTitle");
        Log.d(LOG_TAG, "Track title passed to StreamVideoActivity: " + trackTitle);

        videoView = (VideoView) findViewById(R.id.activityStreamVideoVideoView);
        videoView.setVideoURI(videoUri);
        // Create video playback control buttons
        MediaController mediaController = new MyMediaController(this);
        //MediaController mediaController = new MediaController(this);
        //mediaController.setAnchorView(videoView);
        videoView.start();
        // The following has to come after videoView.start() to prevent the controller
        // from not showing up sometimes
        videoView.setMediaController(mediaController);

    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.stopPlayback();
        videoView = null;
    }


    //http://stackoverflow.com/questions/6530250/android-media-controller-shows-display-for-a-short-time

    private class MyMediaController extends MediaController {
        public MyMediaController(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public MyMediaController(Context context, boolean useFastForward) {
            super(context, useFastForward);
        }

        public MyMediaController(Context context) {
            super(context);
        }

        @Override
        public void show(int timeout) {
            super.show(0);
        }

        // http://stackoverflow.com/questions/6051825/android-back-button-and-mediacontroller
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            if(event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                ((Activity) getContext()).finish();
            }
            return super.dispatchKeyEvent(event);
        }
    }
}
