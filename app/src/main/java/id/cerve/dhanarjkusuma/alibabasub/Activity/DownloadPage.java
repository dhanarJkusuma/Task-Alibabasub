package id.cerve.dhanarjkusuma.alibabasub.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.JazzyListView;

import java.util.ArrayList;
import java.util.List;

import id.cerve.dhanarjkusuma.alibabasub.Adapter.DaftarAnimeAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Adapter.DownloadAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Model.Download;
import id.cerve.dhanarjkusuma.alibabasub.R;
import id.cerve.dhanarjkusuma.alibabasub.Util.DownloadScraper;

public class DownloadPage extends ActionBarActivity implements AdapterView.OnItemClickListener {
    private static ArrayList<Download> download;
    private static JazzyListView listView;
    private static String URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_page);
        //download = getIntent().getStringArrayListExtra("data");
        new getLink().execute();
        //listView = (ListView) findViewById(R.id.dataDownload);
        listView = (JazzyListView) findViewById(R.id.dataDownload);
        listView.setTransitionEffect(JazzyHelper.FLIP);
        listView.setOnItemClickListener(this);
        Bundle bundle = getIntent().getExtras();
        URL = bundle.getString("data");

        //Toast.makeText(DownloadPage.this,URL,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_download_page, menu);
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
        String url = download.get(i).getLinkDownload();
        Intent dlNow = new Intent(Intent.ACTION_VIEW);
        dlNow.setData(Uri.parse(url));
        startActivity(dlNow);
    }

    public class getLink extends AsyncTask<Void,Void,Void>
    {

        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(DownloadPage.this);
            progressDialog.setMessage("Memuat Data...");
            progressDialog.show();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            DownloadAdapter adapter = new DownloadAdapter(download,DownloadPage.this);
            listView.setAdapter(adapter);
            progressDialog.dismiss();
        }


        @Override
        protected Void doInBackground(Void... voids) {
            download = DownloadScraper.getDownloadLink(URL);
            return null;
        }
    }
}
