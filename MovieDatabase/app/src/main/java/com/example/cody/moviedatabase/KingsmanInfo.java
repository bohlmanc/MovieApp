package com.example.cody.moviedatabase;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;


public class KingsmanInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kingsman_info);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kingsman_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_web) {
            Intent intent = new Intent(this, Web.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
            return true;
        }
        if(id == R.id.action_About) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
            return true;
        }
        if(id == R.id.action_info) {
            Intent intent = new Intent(this, Info.class);
            overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
            return true;
        }

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
