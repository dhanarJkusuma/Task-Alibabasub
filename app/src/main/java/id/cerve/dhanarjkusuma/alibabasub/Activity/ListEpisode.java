package id.cerve.dhanarjkusuma.alibabasub.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.JazzyListView;

import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.Adapter.DownloadAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Adapter.EpisodeAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Model.Download;
import id.cerve.dhanarjkusuma.alibabasub.Model.Episode;
import id.cerve.dhanarjkusuma.alibabasub.R;
import id.cerve.dhanarjkusuma.alibabasub.Util.ListEpisodeScraper;

public class ListEpisode extends ActionBarActivity implements AdapterView.OnItemClickListener {
    private static ArrayList<Episode> episodes;
    private static JazzyListView episodelist;
    private static String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_episode);
        episodelist = (JazzyListView) findViewById(R.id.episodelist);
        episodelist.setTransitionEffect(JazzyHelper.FADE);
        Bundle bundle = getIntent().getExtras();
        URL = bundle.getString("dataAnime");
        new getEpisodeList().execute();
        episodelist.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_episode, menu);
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(ListEpisode.this,DetailEpisode.class);
        intent.putExtra("rilis",episodes.get(i).getLink());
        startActivity(intent);
    }

    public class getEpisodeList extends AsyncTask<Void,Void,Void>
    {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(ListEpisode.this);
            progressDialog.setMessage("Mencari Episode");
            progressDialog.show();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            EpisodeAdapter adapter = new EpisodeAdapter(episodes,ListEpisode.this);
            episodelist.setAdapter(adapter);
            progressDialog.dismiss();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            episodes = ListEpisodeScraper.getListEpisode(URL);
            return null;
        }
    }
}
