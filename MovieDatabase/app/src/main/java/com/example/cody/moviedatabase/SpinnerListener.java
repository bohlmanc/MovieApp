/**
 * Created by Jeff Ondich on 4/4/14.
 * For CS 342, Carleton College
 */

package com.example.cody.moviedatabase;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;


public class SpinnerListener implements OnItemSelectedListener {


    public static String movieTitle;

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        movieTitle = parent.getItemAtPosition(pos).toString();
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + movieTitle,
                Toast.LENGTH_SHORT).show();
        MainActivity.setTitle(getMovieTitle());
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public String getMovieTitle() {
        return movieTitle;
    }
}