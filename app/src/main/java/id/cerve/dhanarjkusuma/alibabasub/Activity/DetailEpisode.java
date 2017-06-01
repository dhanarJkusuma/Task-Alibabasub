package id.cerve.dhanarjkusuma.alibabasub.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.melnykov.fab.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import id.cerve.dhanarjkusuma.alibabasub.Adapter.DownloadAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Adapter.ReleaseAdapter;
import id.cerve.dhanarjkusuma.alibabasub.R;
import id.cerve.dhanarjkusuma.alibabasub.Util.AnimeScraper;
import id.cerve.dhanarjkusuma.alibabasub.Util.EpisodeScraper;

public class DetailEpisode extends ActionBarActivity implements View.OnClickListener {
    private static String URL;
    private static TextView judul;
    private static TextView content;
    private static ImageView gambar;
    private static List<String> dataDL;
    private static Button download;
    private static ArrayList<id.cerve.dhanarjkusuma.alibabasub.Model.DetailEpisode> animedetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_episode);
        Bundle bundle = getIntent().getExtras();
        URL = bundle.getString("rilis");
        gambar = (ImageView) findViewById(R.id.gambar);
        judul = (TextView) findViewById(R.id.judul);
        content = (TextView) findViewById(R.id.content);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.show();
        fab.setOnClickListener(this);
        new getData().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_episode, menu);
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
    public void onClick(View view) {
        Intent intent = new Intent(DetailEpisode.this,DownloadPage.class);
        intent.putExtra("data",URL);
        startActivity(intent);
    }

    public class getData extends AsyncTask<Void,Void,Void>
    {
        ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(DetailEpisode.this);
            pDialog.setMessage("Memuat Data...");
            pDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            judul.setText(animedetail.get(0).getJudul());
            content.setText(animedetail.get(0).getContent());
            Picasso.with(getApplicationContext())
                    .load(animedetail.get(0).getGambar())
                    .into(gambar);

            pDialog.dismiss();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            animedetail = EpisodeScraper.GetAnimeEpisode(URL);
            return null;
        }
    }
}
