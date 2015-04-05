package edu.osu.expandablelistviewtest1.activities;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import edu.osu.expandablelistviewtest1.R;

public class StreamAudioActivity extends Activity {
    // Private variables
    private final String LOG_TAG = "##### StreamAudioActivity.java";
    private MediaPlayer mMediaPlayer = null;
    private String mUrl;

    // enum for checking MediaPlayer state
    private enum AudioState {
        IDLE, INITIALIZED, PREPARED, STARTED, PAUSED, STOPPED
    }
    private AudioState mState; // set to IDLE on onCreate

    // UI components
    private ProgressBar mProgressBar;
    private TextView mStatusText;
    private SeekBar mSeekBar;
    private Button mPlayButton;
    private Button mPauseButton;
    private Button mStopButton;

    // Event handlers
    private final View.OnClickListener playButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            if (mState != AudioState.STARTED) {
                if(mState == AudioState.IDLE) {
                    new StartAudioTask().execute(mUrl);
                } else if (mState == AudioState.PAUSED) {
                    mMediaPlayer.start();
                    mState = AudioState.STARTED;
                    mStatusText.setText("Playing...");
                    mAudioProgressHandler.postDelayed(mAudioProgressRunnable, 500);
                } else if (mState == AudioState.STOPPED) {
                    try {
                        mMediaPlayer.prepare();
                    } catch (Exception e) {
                        Log.d(LOG_TAG, "playButtonListener - Failure when attempting mMediaPlayer.prepare() - " + e);
                    }
                    mState = AudioState.PREPARED;
                    mMediaPlayer.start();
                    mState = AudioState.STARTED;
                    mStatusText.setText("Playing...");
                    mAudioProgressHandler.postDelayed(mAudioProgressRunnable, 500);
                } else {
                    Log.d(LOG_TAG, "playButtonListener - Attempt to play from illegal AudioState - " + mState);
                }
            }
        }
    };

    private final View.OnClickListener pauseButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            if (mState == AudioState.STARTED) {
                mMediaPlayer.pause();
                mState = AudioState.PAUSED;
                mStatusText.setText("Paused");
                mAudioProgressHandler.removeCallbacks(mAudioProgressRunnable);
            } else {
                Log.d(LOG_TAG, "pauseButtonListener - Attempt to pause from illegal AudioState - " + mState);
            }
        }
    };

    private final View.OnClickListener stopButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            if (mState == AudioState.STARTED || mState == AudioState.PAUSED) {
                mMediaPlayer.seekTo(0); // return to the beginning of the track
                mMediaPlayer.stop();
                mSeekBar.setProgress(0);
                mState = AudioState.STOPPED;
                mStatusText.setText("Stopped");
                mAudioProgressHandler.removeCallbacks(mAudioProgressRunnable);
            } else if (mMediaPlayer == null) {
                Log.d(LOG_TAG, "Attempt to stop mMediaPlayer when mMediaPlayer is null");
            } else {
                Log.d(LOG_TAG, "stopButtonListener - Attempt to pause from illegal AudioState - " + mState);
            }
        }
    };

    private final SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        // Implemented to adhere to API requirements
        public void onStopTrackingTouch(SeekBar seekBar) {}
        public void onStartTrackingTouch(SeekBar seekBar) {}

        // Actual work
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if(fromUser) {
                mMediaPlayer.seekTo(progress);
            }
        }
    };

    // Background tasks (AsyncTasks, Handlers and Runnables, etc.

    // Based on: http://stackoverflow.com/questions/18361978/android-seekbar-is-not-updated-using-a-handler-on-4-1-2-device
    private Handler mAudioProgressHandler = new Handler();
    private Runnable mAudioProgressRunnable = new Runnable() {
        public void run() {
            // Make sure the mMediaPlayer is not null, to avoid issues when going into onPause, etc.
            if (mMediaPlayer != null) {
                int progress = mMediaPlayer.getCurrentPosition();
                //System.out.println("#### int progress - "+ progress);

                // Need to keep setting max to get around Android bug:
                // http://stackoverflow.com/questions/10278467/seekbar-not-setting-actual-progress-setprogress-not-working-on-early-android
                mSeekBar.setMax(mMediaPlayer.getDuration());
                mSeekBar.setProgress(progress);

                int minutes = ((progress / 1000) / 60) % 60;
                //System.out.println("#### minutes - " + minutes);
                int seconds = ((progress / 1000) % 60) % 60;
                //System.out.println("#### seconds - " + seconds);
                String minutesAsString = (minutes < 10) ? "0" : "";
                String secondsAsString = (seconds < 10) ? "0" : "";

                //System.out.println("Track: " + minutesAsString + minutes + ":" + secondsAsString + seconds);
                mStatusText.setText("Track: " + minutesAsString + minutes + ":" + secondsAsString + seconds);

                // Repeat every 500 milliseconds
                mAudioProgressHandler.postDelayed(this, 500); // this == this instance of mAudioProgressRunnable
            }
        }
    };

    private class StartAudioTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... urls) {
            String audioSource = urls[0];

            // Fake "work" for testing
            /*try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
            }*/

            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                mMediaPlayer.setDataSource(audioSource);
                mState = AudioState.INITIALIZED;
            } catch (Exception e) {
                Log.d(LOG_TAG, "StartAudioTask.doInBackground(~) - Failure when attempting mMediaPlayer.setDataSource(~) - " + e);
            }
            try {
                mMediaPlayer.prepare();
                mState = AudioState.PREPARED;
            } catch (Exception e) {
                Log.d(LOG_TAG, "StartAudioTas.doInBackground(~) - Failure when attempting mMediaPlayer.prepare() - " + e);
            }
            mMediaPlayer.start();
            mState = AudioState.STARTED;

            Log.d(LOG_TAG, "StartAudioTask.doInBackground(~) - work completed");
            return null;
        }

        protected void onPreExecute() {
            mProgressBar.setVisibility(View.VISIBLE);
            mStatusText.setText("Buffering...");
            Log.d(LOG_TAG, "StartAudioTask.onPreExecute() - called");
        }

        protected void onPostExecute(Void input) {
            Log.d(LOG_TAG, "StartAudioTask.onPostExecute() - called");

            mProgressBar.setVisibility(View.INVISIBLE);
            mStatusText.setText("Playing...");

            // Set up the SeekBar
            mSeekBar.setMax(mMediaPlayer.getDuration());
            mSeekBar.setOnSeekBarChangeListener(mOnSeekBarChangeListener);
            mSeekBar.setVisibility(View.VISIBLE);

            // Start progress tracking
            mAudioProgressHandler.postDelayed(mAudioProgressRunnable, 500);
        }
    }

    // onCreate, etc.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_audio);

        Intent intent = getIntent();
        mUrl = intent.getStringExtra("audioURL");
        String trackTitle = intent.getStringExtra("trackTitle");

        // Initialize UI elements
        TextView streamAudioTrackTitle = (TextView) findViewById(R.id.streamAudioTrackTitle);
        streamAudioTrackTitle.setText(trackTitle);

        mProgressBar = (ProgressBar) findViewById(R.id.activityMainProgressBar);
        mSeekBar = (SeekBar) findViewById(R.id.activityMainSeekBar);
        mStatusText = (TextView) findViewById(R.id.activityMainStatusText);
        mPlayButton = (Button) findViewById(R.id.activityMainPlayButton);
        mPauseButton = (Button) findViewById(R.id.activityMainPauseButton);
        mStopButton = (Button) findViewById(R.id.activityMainStopButton);

        // Set event listeners
        mPlayButton.setOnClickListener(playButtonListener);
        mPauseButton.setOnClickListener(pauseButtonListener);
        mStopButton.setOnClickListener(stopButtonListener);

        // Do other fun stuff
        mProgressBar.setVisibility(View.INVISIBLE);
        mSeekBar.setVisibility(View.INVISIBLE);
        mStatusText.setText("Track: 00:00");
        mState = AudioState.IDLE;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mState = AudioState.STOPPED;
        }
        // Stop tracking progress
        mAudioProgressHandler.removeCallbacks(mAudioProgressRunnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mState = AudioState.IDLE;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
