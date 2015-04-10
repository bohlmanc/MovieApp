package com.example.cody.moviedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//Written by Cody Bohlman and Jonathan Brodie

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
        this.title = "";
        this.summary = "";
        this.time = 0;
        this.bundle = getIntent().getExtras();

        this.title = this.bundle.getString(TITLE);
        this.summary = this.bundle.getString(SUMMARY);
        this.time = this.bundle.getLong(TIME);
        this.imageResource = this.bundle.getLong(IMAGE_RESOURCE);
        this.review = this.bundle.getString(REVIEW);

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

        if(id == android.R.id.home) {
            this.finishWithMovie();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Set up the information based on the variables passed in from the main activity
    public void setContent() {
        TextView changeView = (TextView) findViewById(R.id.textView4);

        if (this.bundle == null) {
            System.out.println("Something is really messed up");
        }
        else {
            this.title = this.bundle.getString(this.TITLE);
            changeView.setText(this.title);

            changeView = (TextView) findViewById(R.id.textView6);
            this.summary = getIntent().getStringExtra(this.SUMMARY);
            changeView.setText(this.summary);
            this.imageResource = getIntent().getLongExtra(IMAGE_RESOURCE, 0L);

            ImageView changeImage = (ImageView) findViewById(R.id.imageView);
            changeImage.setImageResource((int) this.imageResource);
        }
    }

    public static void setInfo(String newTitle, int newTime, String newSummary, int newImageResource) {
        title = newTitle;
        time = newTime;
        summary = newSummary;
        imageResource = newImageResource;
    }
    // Keeps the current movie selected
    @Override
    public void onBackPressed() {
        this.finishWithMovie();
    }
    private void finishWithMovie() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(MainActivity.spinnerID, this.title);
        this.setResult(RESULT_OK, returnIntent);
        this.finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
    }


}
