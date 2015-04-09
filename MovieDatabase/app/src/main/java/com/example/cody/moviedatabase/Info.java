package com.example.cody.moviedatabase;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Info extends Activity {

    public static String title, summary, review;
    public static long time, imageResource;
    public static String TITLE = "title";
    public static String SUMMARY = "summary";
    public static String TIME = "time";
    public static String IMAGE_RESOURCE = "imageID";
    public static String REVIEW = "review";
    public Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        title = "";
        summary = "";
        time = 0;
        bundle = getIntent().getExtras();

        title = bundle.getString(TITLE);
        summary = bundle.getString(SUMMARY);
        time = bundle.getLong(TIME);
        imageResource = bundle.getLong(IMAGE_RESOURCE);
        System.out.println("IMRC" + imageResource);
        review = bundle.getString(REVIEW);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setContent();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_main) {
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setContent() {
        TextView changeView = (TextView) findViewById(R.id.textView4);
        System.out.println("TEXTVIEW4: " + R.id.textView4);

        if (bundle == null) {
            System.out.println("Something is really messed up");
        }
        else {
            title = bundle.getString(this.TITLE);
            System.out.println("TEXTVIEW: " + title);
            changeView.setText(title);

            changeView = (TextView) findViewById(R.id.textView6);
            summary = getIntent().getStringExtra(SUMMARY);
            changeView.setText(summary);

            changeView = (TextView) findViewById(R.id.textView5);
            time = getIntent().getLongExtra(TIME, -1L);
            changeView.setText("Running time: " + time + " minutes.");

            imageResource = getIntent().getLongExtra(IMAGE_RESOURCE, 0L);

            System.out.println("Title: " + title + ".\nSummary: " + summary + "\nTime: " + time + ".");
            System.out.println("IMAGE RESOURCE: " + imageResource);
            ImageView changeImage = (ImageView) findViewById(R.id.imageView);
            System.out.println("IR" + findViewById((int) imageResource));
            changeImage.setImageResource((int) imageResource);
        }
        /*
        title = getIntent().getStringExtra(TITLE);
        System.out.println("TEXTVIEW: " + title);
        changeView.setText(title);

        changeView = (TextView) findViewById(R.id.textView4);
        summary = getIntent().getStringExtra(SUMMARY);
        changeView.setText(summary);

        changeView = (TextView) findViewById(R.id.textView6);
        time = getIntent().getLongExtra(TIME, -1);
        changeView.setText("Running time: " + time + " minutes.");

        imageResource = getIntent().getLongExtra(IMAGE_RESOURCE, 0);


        System.out.println("Title: " + title + ".\nSummary: " + summary + "\nTime: " + time + ".");
        System.out.println("IMAGE RESOURCE: " + imageResource);
        ImageView changeImage = (ImageView) findViewById((int) imageResource);
        changeImage.setImageResource((int) imageResource);
        */
    }

    public static void setInfo(String newTitle, int newTime, String newSummary, int newImageResource) {
        title = newTitle;
        time = newTime;
        summary = newSummary;
        imageResource = newImageResource;
    }


}
