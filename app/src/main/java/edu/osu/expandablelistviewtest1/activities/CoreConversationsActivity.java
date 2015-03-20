package edu.osu.expandablelistviewtest1.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.osu.expandablelistviewtest1.R;
import edu.osu.expandablelistviewtest1.fragments.CoreConversationsFragment;

public class CoreConversationsActivity extends Activity {
    private int chapter;
    private static String TAG = "CoreConversationsActivity.java";

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

        ImageView testImage = (ImageView) findViewById(R.id.testImage);
        ImageDownloader imageDownloader = new ImageDownloader();

        String imageURL = "http://www.cbusdesigns.com/jsl-app/chapter13/coreconversation/images/01.jpg";
        imageDownloader.download(imageURL, testImage);

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

    /*
    // http://stackoverflow.com/questions/8992964/android-load-from-url-to-bitmap
    public static Bitmap getBitmapFromURL(String source) {
        try {
            URL url = new URL(source);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (Exception e) {
            Log.d(TAG, " -- " + e);
            return null;
        }
    }
    */

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
