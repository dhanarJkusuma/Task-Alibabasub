package id.cerve.dhanarjkusuma.alibabasub.Activity;

import android.app.Activity;
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

import id.cerve.dhanarjkusuma.alibabasub.Adapter.OnGoingAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Adapter.ReleaseAdapter;
import id.cerve.dhanarjkusuma.alibabasub.Model.OnGoing;
import id.cerve.dhanarjkusuma.alibabasub.Model.ReleasePost;
import id.cerve.dhanarjkusuma.alibabasub.R;
import id.cerve.dhanarjkusuma.alibabasub.Util.GetMessageError;
import id.cerve.dhanarjkusuma.alibabasub.Util.OnGoingScraper;
import id.cerve.dhanarjkusuma.alibabasub.Util.Scraper;

public class OnGoingFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static RecyclerView onAnime;
    private static Context context;
    public static ArrayList<OnGoing> onGoingPost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new DownloadDataOnGoing().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_on_going, container, false);
        // Inflate the layout for this fragment
        //listAnime = (ListView) layout.findViewById(R.id.onGoingList);

        onAnime = (RecyclerView) layout.findViewById(R.id.onGoingList);
        onAnime.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        onAnime.setLayoutManager(llm);
        return layout;

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }

    public class DownloadDataOnGoing extends AsyncTask<Void,Void,Void>
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
            if (onGoingPost == null || onGoingPost.isEmpty())
            {
                Toast.makeText(getActivity(), "Tes", Toast.LENGTH_SHORT).show();
            }
            else
            {
                OnGoingAdapter adapter = new OnGoingAdapter(onGoingPost, context);
                onAnime.setAdapter(adapter);
            }
            progressDialog.dismiss();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try
            {
                onGoingPost = OnGoingScraper.GetOnGoing(OnGoing.URL,3);
            }
            catch(Exception any)
            {

            }
            return null;
        }


    }


}
