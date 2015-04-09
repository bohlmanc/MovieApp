package com.example.cody.moviedatabase;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.app.Activity;


public class ReviewActivity extends Activity {
    public static String TITLE="movieTitle";
    public static String REVIEW="movieReview";
    public static String RATING="movieRating";
    private String movieName="";
    private String movieReview="";
    private int movieRating;
    @Override
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
            System.out.println("INT=" + rating);

        }
        setContentView(R.layout.activity_review);
        this.setContent();
    }
    public void setMovie(String movieName) {
        this.movieName=movieName;
    }
    public void setReview(String review) {
        this.movieReview=review;
    }
    public void setRating(int rating) { this.movieRating=rating;}
    public void setContent() {
        TextView changeView = (TextView) findViewById(R.id.titleView);
        changeView.setText(this.movieName);

        changeView = (TextView) findViewById(R.id.reviewView);
        changeView.setText(this.movieReview);
        ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
        System.out.println("RATING=" + this.movieRating);
        bar.setMax(100);
        bar.setProgress(this.movieRating);

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
        }

        return super.onOptionsItemSelected(item);
    }
}
