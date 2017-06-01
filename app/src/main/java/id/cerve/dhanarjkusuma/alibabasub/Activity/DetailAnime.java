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
import android.widget.TextView;

import com.melnykov.fab.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.R;
import id.cerve.dhanarjkusuma.alibabasub.Util.AnimeScraper;

public class DetailAnime extends ActionBarActivity {

    private String URL;
    private static TextView judul;
    private static ImageView gambar;

    private static TextView content;
    private static ArrayList<id.cerve.dhanarjkusuma.alibabasub.Model.DetailAnime> detailAnime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_anime);
        judul = (TextView) findViewById(R.id.judul);
        gambar = (ImageView) findViewById(R.id.gambar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.show();
        content = (TextView) findViewById(R.id.content);
        Bundle bundle = getIntent().getExtras();
        URL = bundle.getString("dataAnime");
        new getDataAnime().execute();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailAnime.this,ListEpisode.class);
                intent.putExtra("dataAnime",URL);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_anime, menu);
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

    public class getDataAnime extends AsyncTask<Void,Void,Void>
    {
        ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(DetailAnime.this);
            pDialog.setMessage("Memuat Data...");
            pDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            judul.setText(detailAnime.get(0).getJudul());
            content.setText(detailAnime.get(0).getContent()+"\n\n"+detailAnime.get(0).getGenre());
            Picasso.with(getApplicationContext())
                    .load(detailAnime.get(0).getGambar())
                    .into(gambar);

            pDialog.dismiss();

        }


        @Override
        protected Void doInBackground(Void... voids) {
            detailAnime = AnimeScraper.getDataAnime(URL);
            return null;

        }
    }
}
