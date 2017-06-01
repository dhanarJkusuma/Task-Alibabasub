package id.cerve.dhanarjkusuma.alibabasub.Activity;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.Adapter.DaftarAnimeAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Adapter.ReleaseAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Model.DaftarAnime;
import id.cerve.dhanarjkusuma.alibabasub.Model.OnGoing;
import id.cerve.dhanarjkusuma.alibabasub.Model.ReleasePost;
import id.cerve.dhanarjkusuma.alibabasub.R;
import id.cerve.dhanarjkusuma.alibabasub.Util.DaftarScraper;
import id.cerve.dhanarjkusuma.alibabasub.Util.GetMessageError;
import id.cerve.dhanarjkusuma.alibabasub.Util.Scraper;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaftarFragment extends Fragment {
    public static RecyclerView daftarAnime;
    private static Context context;
    public static ArrayList<DaftarAnime> daftarPost;


   @Override
   public void onCreate(Bundle savedInstanceState)
   {
       super.onCreate(savedInstanceState);
       new DownloadDataDaftar().execute();
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_daftar, container, false);
        // Inflate the layout for this fragment
        //listAnime = (ListView) layout.findViewById(R.id.onGoingList);

        daftarAnime = (RecyclerView) layout.findViewById(R.id.daftarList);
        daftarAnime.setHasFixedSize(true);
        GridLayoutManager llm = new GridLayoutManager(context,2);
        daftarAnime.setLayoutManager(llm);
        return layout;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }

    public class DownloadDataDaftar extends AsyncTask<Void,Void,Void>
    {

        MainActivity ma = new MainActivity();
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("Load Data...");
            progressDialog.show();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            DaftarAnimeAdapter adapter = new DaftarAnimeAdapter(daftarPost,context);
            if(adapter.getItemCount()>0)
            {
                daftarAnime.setAdapter(adapter);
                progressDialog.dismiss();
            }

        }

        @Override
        protected Void doInBackground(Void... voids) {
         try
         {
            daftarPost = DaftarScraper.GetDaftarAnime(DaftarAnime.URL,10);
         }
         catch(Exception any)
         {
             progressDialog.dismiss();
            GetMessageError gm = new GetMessageError();
            gm.getMessage(context);
         }
            return null;
        }
    }



}
