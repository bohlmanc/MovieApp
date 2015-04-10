package com.example.cody.moviedatabase;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.app.Activity;

//Written by Cody Bohlman and Jonathan Brodie

public class ReviewActivity extends Activity {
    public static String TITLE="movieTitle";
    public static String REVIEW="movieReview";
    public static String RATING="movieRating";
    private String movieName="";
    private String movieReview="";
    private int movieRating;
    @Override

    //Custom on create that also incorporates the passed in variables from the main activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        String currentName;
        String review;
        long rating;
        if (extras != null) {
            currentName= extras.getString(this.TITLE);
            review=extras.getString(this.REVIEW);
            rating=extras.getLong(this.RATING);
            this.setMovie(currentName);
            this.setReview(review);
            this.setRating((int) rating);

        }
        setContentView(R.layout.activity_review);
        this.setContent();
    }
    //sets the movie name
    public void setMovie(String movieName) {
        this.movieName=movieName;
    }
    //Set the review string
    public void setReview(String review) {
        this.movieReview=review;
    }
    //Set the movie rating
    public void setRating(int rating) { this.movieRating=rating;}

    //set up the screen's content
    public void setContent() {
        TextView changeView = (TextView) findViewById(R.id.titleView);
        changeView.setText(this.movieName);

        changeView = (TextView) findViewById(R.id.reviewView);
        changeView.setText(this.movieReview);

        TextView progressOfBar = (TextView) findViewById(R.id.progressOfBar);
        System.out.println("RATING=" + this.movieRating);


        class ProgressBarRunnable implements Runnable {
            private int maximum;
            private int movieRating;
            private ProgressBar pBar;
            private TextView barProgress;
            private ProgressBarRunnable(int rating, int max, TextView progress) {
                movieRating = rating;
                maximum = max;
                barProgress = progress;
                pBar = (ProgressBar) findViewById(R.id.progressBar);
            }
            public void run() {
                int factor = 20000;
                pBar.setMax(factor * 100);
                for (int x = 0; x < (this.movieRating * factor); x++) {
                    pBar.setProgress(x);

                }
            }
        }

        Thread thread = new Thread(new ProgressBarRunnable(this.movieRating, 100, progressOfBar));
        thread.setDaemon(true);
        thread.start();

        TextView score = (TextView) findViewById(R.id.progressOfBar);
        score.setText("IMDB Rating: " + this.movieRating + " / 100");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_review, menu);
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
        } else if(id == android.R.id.home) {
            this.finishWithMovie();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    // Keeps the current movie selected
    @Override
    public void onBackPressed() {
        this.finishWithMovie();
    }
    private void finishWithMovie() {
        System.out.println("foo");
        Intent returnIntent = new Intent();
        returnIntent.putExtra(MainActivity.spinnerID, this.movieName);
        System.out.println(this.movieName);
        this.setResult(RESULT_OK, returnIntent);
        this.finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
    }
}
