package id.cerve.dhanarjkusuma.alibabasub.Activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import id.cerve.dhanarjkusuma.alibabasub.R;

public class About extends ActionBarActivity {

    private TextView keterangan;
    private ImageView namaApps;
    String tmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        keterangan = (TextView) findViewById(R.id.keterangan);
        namaApps = (ImageView) findViewById(R.id.namaApps);
        tmp = "Dikembangkan oleh : ";
        tmp += "\n Aninda Cyntia";
        tmp += "\n Agus Suparno";
        tmp += "\n Dhanar Januardhi K";
        tmp += "\n Eko Priyanto";
        keterangan.setText(tmp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
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
