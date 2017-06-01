package id.cerve.dhanarjkusuma.alibabasub.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.Adapter.DaftarAnimeAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Adapter.OnGoingAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Adapter.ReleaseAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Adapter.ViewPagerAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Model.DaftarAnime;
import id.cerve.dhanarjkusuma.alibabasub.Model.OnGoing;
import id.cerve.dhanarjkusuma.alibabasub.Model.ReleasePost;
import id.cerve.dhanarjkusuma.alibabasub.R;
import id.cerve.dhanarjkusuma.alibabasub.Util.DaftarScraper;
import id.cerve.dhanarjkusuma.alibabasub.Util.OnGoingScraper;
import id.cerve.dhanarjkusuma.alibabasub.Util.Scraper;
import id.cerve.dhanarjkusuma.alibabasub.Util.SlidingTabLayout;


public class MainActivity extends ActionBarActivity {
    private static Toolbar toolbar;


    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Baru Rilis","On-Going","Semua Anime"};
    int Numboftabs =3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);


        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);


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

        //noinspection SimplifiableIfStatement


        if(id==R.id.action_about)
        {
            Intent intent = new Intent(MainActivity.this,About.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }



    }


