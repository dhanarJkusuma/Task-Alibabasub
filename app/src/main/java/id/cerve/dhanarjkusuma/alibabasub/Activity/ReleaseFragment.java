package id.cerve.dhanarjkusuma.alibabasub.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.Adapter.DaftarAnimeAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Adapter.OnGoingAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Adapter.ReleaseAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Model.DaftarAnime;
import id.cerve.dhanarjkusuma.alibabasub.Model.OnGoing;
import id.cerve.dhanarjkusuma.alibabasub.Model.ReleasePost;
import id.cerve.dhanarjkusuma.alibabasub.R;
import id.cerve.dhanarjkusuma.alibabasub.Util.GetMessageError;
import id.cerve.dhanarjkusuma.alibabasub.Util.Scraper;

public class ReleaseFragment extends Fragment
{
    private static Context context;
    public static RecyclerView relAnime;
    public static ArrayList<ReleasePost> animepost;
    public static ArrayList<OnGoing> onGoingPost;
    public static ArrayList<DaftarAnime> daftarPost;
    public static ListView listAnime;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View layout = inflater.inflate(R.layout.fragment_release, container, false);
        // Inflate the layout for this fragment
        // listAnime = (ListView) layout.findViewById(R.id.releaseAnime);

        relAnime = (RecyclerView) layout.findViewById(R.id.releaseList);
        relAnime.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        relAnime.setLayoutManager(llm);

        if (savedInstanceState != null)
        {
            animepost = savedInstanceState.getParcelableArrayList("animepost");
            ReleaseAdapter adapter = new ReleaseAdapter(animepost, context);
            ReleaseFragment.relAnime.setAdapter(adapter);
        }
        else
            new DownloadData().execute();
        return layout;

    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("animepost", animepost);
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        context = activity;
    }

    public class DownloadData extends AsyncTask<Void, Void, Void>
    {

        // MainActivity ma = new MainActivity();
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("Load Data...");
            progressDialog.show();

        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            if (animepost == null || animepost.isEmpty())
            {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Tes", Toast.LENGTH_SHORT).show();
            } else
            {
                ReleaseAdapter adapter = new ReleaseAdapter(animepost, context);
                ReleaseFragment.relAnime.setAdapter(adapter);
                progressDialog.dismiss();
            }

        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            try
            {
                animepost = Scraper.GetRelease(ReleasePost.URL, 3);
            } catch (Exception any)
            {

            }
            return null;
        }
    }


}
