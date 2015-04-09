package com.example.cody.moviedatabase;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import android.app.ListActivity;
import android.widget.Spinner;
import android.widget.ImageView;
import android.os.Bundle;


public class MainActivity extends ListActivity {

    private Spinner spinner;
    public static String titleSelected;
    private String[] titles, reviews, summaries;
    private int[] times, ratings;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titles = new String[] {"Do You Believe?", "Cinderella", "Get Hard", "The Gunman", "Home",
                                "Insurgent", "It Follows", "Kingsman: The Secret Service",
                                "The Second Best Exotic Marigold Hotel", "Run All Night"};
        times = new int[] {120, 105, 100, 115, 94, 119, 100, 129, 122, 114};
        ratings = new int[] {54, 76, 63, 56, 68, 70, 76, 82, 68, 71};
        reviews = new String[] {"Wherever you fall on the spectrum of spirituality, the only answer to \"Do You Believe?\" is \"No.\"",
                                "Based on the classic fairy tale, but borrowing heavily from the 1950 film, Cinderella is enchanting, a wonderful and stylish film with a charming lead and emotional narrative.",
                                "Dumb, juvenile comedy has its place when it\'s funny. Unfortunately, too often in Get Hard, it\'s not.",
                                "A dull, generic retread, made far worse by Penn\'s self-seriousness as an actor, by the banal political pieties he\'s grafted on as producer and co-writer, and by the presence of a pitifully retrograde female lead role.",
                                "\"Home\" is a fine selection for a second quarter film and a great choice for your children.",
                                "I appreciate the attempt to try to make this world -- an obliterated, totalitarian Chicago -- as watchable as possible. But there\'s too much to keep straight.",
                                "The next time some old lady starts following you with an emotionless stare on her face, you are going to lose your mind.",
                                "One of the most smartly-crafted action films of recent years... [but] it has some grim, grim thoughts about human beings and society.",
                                "There is way too much going on. Parallel stories for all of these characters mean most all of them aren\'t fully developed.",
                                "Run All Night is a taut, edgy affair that features Neeson in peak action form and allows him to partially atone for the indignity of Taken 3."};
        summaries = new String[] {"When a pastor is shaken by the visible faith of a street-corner preacher, he is reminded that true belief always requires action. His response ignites a journey that impacts everyone it touches in ways that only God could orchestrate.",
                                  "When her father unexpectedly passes away, young Ella finds herself at the mercy of her cruel stepmother and her daughters. Never one to give up hope, Ella\'s fortunes begin to change after meeting a dashing stranger.",
                                  "When millionaire James King is nailed for fraud and bound for San Quentin, he turns to Darnell Lewis to prep him to go behind bars.",
                                  "A sniper on a mercenary assassination team, kills the minister of mines of the Congo. Terrier\'s successful kill shot forces him into hiding. Returning to the Congo years later, he becomes the target of a hit squad himself.",
                                  "Oh, an alien on the run from his own people, lands on Earth and makes friends with the adventurous Tip, who is on a quest of her own.",
                                  "Beatrice Prior must confront her inner demons and continue her fight against a powerful alliance which threatens to tear her society apart with the help from others on her side.",
                                  "A young woman is followed by an unknown supernatural force after getting involved in a sexual confrontation.",
                                  "A spy organization recruits an unrefined, but promising street kid into the agency\'s ultra-competitive training program, just as a global threat emerges from a twisted tech genius.",
                                  "As the Best Exotic Marigold Hotel has only a single remaining vacancy - posing a rooming predicament for two fresh arrivals - Sonny pursues his expansionist dream of opening a second hotel.",
                                  "Mobster and hit man Jimmy Conlon has one night to figure out where his loyalties lie: with his estranged son, Mike, whose life is in danger, or his longtime best friend, mob boss Shawn Maguire, who wants Mike to pay for the death of his own son."};
        images = new int[] {R.drawable.believe, R.drawable.cinderella, R.drawable.gethard, R.drawable.gunman,
                            R.drawable.home, R.drawable.insurgent, R.drawable.itfollows, R.drawable.kingsman,
                            R.drawable.marigold, R.drawable.run};

        ArrayList<String> listItems = new ArrayList<String>();
        listItems.add("Information");
        listItems.add("Movie Trailer");
        listItems.add("Reviews");

        ListDemoAdapter adapter = new ListDemoAdapter(this, R.layout.list_cell, listItems);
        ListView listView = (ListView) this.findViewById(android.R.id.list);
        listView.setAdapter(adapter);

        addListenerOnSpinnerItemSelection();

    }

    public static void setTitle(String t) {
        titleSelected = t;
        System.out.println(titleSelected);
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

        if (id == R.id.action_About) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new SpinnerListener());
    }


    @Override
    public void onListItemClick(ListView parent, View v, int position, long id) {
        TextView textView = (TextView) v.findViewById(R.id.listCellTextView);
        if (v != null && textView != null) {

            Intent nextActivity = new Intent(this, Info.class);

            Bundle bundle = new Bundle();

            CharSequence activityKey = textView.getText();
            int index = 11;
            for(int x = 0; x < titles.length; x++) {
                if(titles[x].equals(titleSelected)) {
                    index = x;
                }
            }

            String title = titles[index];
            String review = reviews[index];
            int time = times[index];
            int rating = times[index];
            String summary = summaries[index];
            long image = images[index];


            if (activityKey.equals("Information")) {
                System.out.println("IMAGE: " + image);
                nextActivity.putExtra(Info.TITLE, title);
                nextActivity.putExtra(Info.SUMMARY, summary);
                nextActivity.putExtra(Info.TIME, time);
                nextActivity.putExtra(Info.IMAGE_RESOURCE, image);
                System.out.println("Image should be: " + image);

                //Info.setInfo(title, time, summary, image);
            }
            else if (activityKey.equals("Movie Trailer")) {
                nextActivity = new Intent(this, Web.class);

            }
            else if (activityKey.equals("Reviews")) {
                nextActivity = new Intent(this, About.class); // NEED TO CHANGE THIS TO THE REVIEWS PAGE
            }
            startActivity(nextActivity);
            overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
        }
    }

}
