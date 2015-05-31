package edu.osu.expandablelistviewtest1.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import edu.osu.expandablelistviewtest1.R;
import edu.osu.expandablelistviewtest1.customclasses.CoreConversation;
import edu.osu.expandablelistviewtest1.customclasses.CoreConversationInterface;
import edu.osu.expandablelistviewtest1.customclasses.WifiConnectionChecker;

public class CoreConversationsActivity extends Activity {
    // http://streaming.osu.edu/audio/jpn09su03/07/7a1.mp3
    private int chapter;
    private static String TAG = "#### CoreConversationsActivity.java";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (WifiConnectionChecker.connectedToWifi(this)) {
            setContentView(R.layout.activity_core_conversations);
            TextView coreConversationHeader = (TextView) findViewById(R.id.coreConversationHeader);

            Intent intent = getIntent();
            // The chapter, as passed from the TOC
            // The "1" at the end is the default (chapter in this case)
            chapter = intent.getIntExtra("chapter", 1);

            // Set the header now that we have the chapter:
            coreConversationHeader.setText("JSL Chapter " + chapter + ": Core Conversations");

        /* For testing purposes:

        TextView testText = (TextView) findViewById(R.id.testText);
        testText.setText("Chapter should be here: " + chapter);

        ImageView testImage = (ImageView) findViewById(R.id.testImage);
        ImageDownloader imageDownloader = new ImageDownloader();

        //String imageURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/images/01.jpg";
        CoreConversationInterface coreConversationInterface = new CoreConversationInterface();
        ArrayList<CoreConversation> thisChapter = coreConversationInterface.getCoreConversation(chapter);
        String imageURL = thisChapter.get(0).getImageURL();


        imageDownloader.download(imageURL, testImage);
        */

            // Get CCs and populate list
            CoreConversationInterface coreConversationInterface = new CoreConversationInterface();
            ArrayList<CoreConversation> thisChapter = coreConversationInterface.getCoreConversation(chapter);

            ArrayAdapter<CoreConversation> coreConversationAdapter = new CoreConversationAdapter(
                    this, R.layout.list_children_core_conversations, thisChapter);
            ListView listView = (ListView) findViewById(R.id.coreConversationListParent);
            listView.setAdapter(coreConversationAdapter);
        } else {
            Toast.makeText(this, getString(R.string.no_wifi), Toast.LENGTH_LONG).show();
        }
    }

    // Adapter class for adapting CoreConversation objects
    private class CoreConversationAdapter extends ArrayAdapter<CoreConversation> {
        private ArrayList<CoreConversation> coreConversations;
        // Needed in onClick listener:
        private final Context context;

        public CoreConversationAdapter(Context context, int childViewLayout, ArrayList<CoreConversation> coreConversations) {
            super(context, childViewLayout, coreConversations);
            this.coreConversations = coreConversations;
            this.context = context;
        }

        @Override
        public View getView(int position, View childView, ViewGroup parent) {
            View v = childView;

            if (v == null) {
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(R.layout.list_children_core_conversations, null);
            }

            // made "final" to use in onClickListener
            final CoreConversation coreConversation = coreConversations.get(position);

            if (coreConversation != null) {
                TextView coreConversationChildrenHeader = (TextView) v.findViewById(R.id.coreConversationChildrenHeader);
                ImageView coreConversationChildrenImage = (ImageView) v.findViewById(R.id.coreConversationChildrenImage);
                TextView coreConversationChildrenDescription = (TextView) v.findViewById(R.id.coreConversationChildrenDescription);
                if (coreConversationChildrenHeader != null) {
                    coreConversationChildrenHeader.setText(coreConversation.getTitle());
                }
                if (coreConversationChildrenImage != null) {
                    ImageDownloader imageDownloader = new ImageDownloader();
                    imageDownloader.download(coreConversation.getImageURL(), coreConversationChildrenImage);
                }
                if (coreConversationChildrenDescription != null) {
                    coreConversationChildrenDescription.setText(coreConversation.getDescription());
                }
            }

            final ViewGroup finalParent = parent;
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (WifiConnectionChecker.connectedToWifi(finalParent.getContext())) {
                        Intent intent;
                        intent = new Intent(context, StreamVideoActivity.class);

                        String videoSource = coreConversation.getVideoURL();

                        Log.d(TAG, "Video URL: " + videoSource);
                        intent.putExtra("videoURL", videoSource);

                        //TODO: implement the following
                        intent.putExtra("trackTitle", "Video Track Title");

                        // startActivity belongs to Context
                        context.startActivity(intent);
                    } else {
                       Toast.makeText(finalParent.getContext(), finalParent.getContext().getString(R.string.no_wifi), Toast.LENGTH_LONG).show();
                    }
                }
            });
            return v;
        }
    }

    // http://android-developers.blogspot.com/2010/07/multithreading-for-performance.html
    public class ImageDownloader {
        public void download(String url, ImageView imageView) {
            if (cancelPotentialDownload(url, imageView)) {
                BitmapDownloaderTask task = new BitmapDownloaderTask(imageView);
                DownloadedDrawable downloadedDrawable = new DownloadedDrawable(task);
                imageView.setImageDrawable(downloadedDrawable);
                task.execute(url);
            }
        }
    }

    private static boolean cancelPotentialDownload(String url, ImageView imageView) {
        BitmapDownloaderTask bitmapDownloaderTask = getBitmapDownloaderTask(imageView);

        if (bitmapDownloaderTask != null) {
            String bitmapUrl = bitmapDownloaderTask.url;
            if ((bitmapUrl == null) || (!bitmapUrl.equals(url))) {
                bitmapDownloaderTask.cancel(true);
            } else {
                // The same URL is already being downloaded.
                return false;
            }
        }
        return true;
    }

    private static BitmapDownloaderTask getBitmapDownloaderTask(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof DownloadedDrawable) {
                DownloadedDrawable downloadedDrawable = (DownloadedDrawable)drawable;
                return downloadedDrawable.getBitmapDownloaderTask();
            }
        }
        return null;
    }

    static Bitmap downloadBitmap(String url) {
        final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
        final HttpGet getRequest = new HttpGet(url);

        try {
            HttpResponse response = client.execute(getRequest);
            final int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                Log.w("ImageDownloader", "Error " + statusCode + " while retrieving bitmap from " + url);
                return null;
            }

            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = null;
                try {
                    inputStream = entity.getContent();
                    final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    return bitmap;
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    entity.consumeContent();
                }
            }
        } catch (Exception e) {
            // Could provide a more explicit error message for IOException or IllegalStateException
            getRequest.abort();
            Log.w("ImageDownloader", "Error while retrieving bitmap from " + url + ": " + e.toString());
        } finally {
            if (client != null) {
                client.close();
            }
        }
        return null;
    }

    class BitmapDownloaderTask extends AsyncTask<String, Void, Bitmap> {
        private String url;
        private final WeakReference<ImageView> imageViewReference;

        public BitmapDownloaderTask(ImageView imageView) {
            imageViewReference = new WeakReference<ImageView>(imageView);
        }

        @Override
        // Actual download method, run in the task thread
        protected Bitmap doInBackground(String... params) {
            // params comes from the execute() call: params[0] is the url.
            return downloadBitmap(params[0]);
        }

        @Override
        // Once the image is downloaded, associate it with the imageView
        protected void onPostExecute(Bitmap bitmap) {
            if(isCancelled()) {
                bitmap = null;
            }

            if (imageViewReference != null) {
                ImageView imageView = imageViewReference.get();
                BitmapDownloaderTask bitmapDownloaderTask = getBitmapDownloaderTask(imageView);
                // Change bitmap only if this process is still associated with it
                if (this == bitmapDownloaderTask) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }

    static class DownloadedDrawable extends ColorDrawable {
        private final WeakReference<BitmapDownloaderTask> bitmapDownloaderTaskReference;

        public DownloadedDrawable(BitmapDownloaderTask bitmapDownloaderTask) {
            super(Color.BLACK);
            bitmapDownloaderTaskReference =
                    new WeakReference<BitmapDownloaderTask>(bitmapDownloaderTask);
        }

        public BitmapDownloaderTask getBitmapDownloaderTask() {
            return bitmapDownloaderTaskReference.get();
        }
    }
}
