package com.example.cody.moviedatabase;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.app.Activity;
import android.webkit.WebViewClient;


public class TrailerActivity extends Activity {
    private String searchURL="https://www.youtube.com/results?search_query=";
    public static String RAW_NAME="currentMovie";
    private String currentURL="";

    public void setCurrentMovie(String movieName) {
        this.currentURL="";
        movieName=movieName.toLowerCase();
        for (int i=0; i<movieName.length(); i++) {
            if (movieName.substring(i,i).equals(" ")) {
                this.currentURL+="+";
            }
            else {
                this.currentURL+=movieName.charAt(i);
            }
        }
        this.currentURL=searchURL+currentURL+"+trailer";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("We're creating a new activity!!!");
        Bundle extras = getIntent().getExtras();
        String currentMovie;
        if (extras != null) {
            currentMovie= extras.getString(this.RAW_NAME);
            this.setCurrentMovie(currentMovie);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);

        this.openTrailer();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trailer, menu);
        return true;
    }

    public void openTrailer() {
        WebView myWebView = (WebView) findViewById(R.id.trailerView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl(currentURL);

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
