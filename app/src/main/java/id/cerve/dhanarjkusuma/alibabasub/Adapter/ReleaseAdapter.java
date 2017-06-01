package id.cerve.dhanarjkusuma.alibabasub.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


import id.cerve.dhanarjkusuma.alibabasub.Activity.MainActivity;
import id.cerve.dhanarjkusuma.alibabasub.Model.DetailEpisode;
import id.cerve.dhanarjkusuma.alibabasub.Model.ReleasePost;
import id.cerve.dhanarjkusuma.alibabasub.R;

/**
 * Created by DhanarJKusuma on 6/11/2015.
 */
public class ReleaseAdapter extends RecyclerView.Adapter<ReleaseAdapter.ReleaseViewHolder>
{
    String alamat;
    private static ArrayList<ReleasePost> releaseItem;
    private static Context context;
    public ReleaseAdapter(ArrayList<ReleasePost> releaseItem,Context context)
    {
        this.releaseItem = releaseItem;
        this.context = context;
    }

    @Override
    public ReleaseAdapter.ReleaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_release,parent,false);
        ReleaseViewHolder mvh = new ReleaseViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(ReleaseAdapter.ReleaseViewHolder holder, final int position)
    {
        MainActivity ma = new MainActivity();
        holder.release_title
                .setText(releaseItem.get(position).getJudul());
        holder.release_date
                .setText(releaseItem.get(position).getTanggal());
        Picasso.with(context)
                .load(releaseItem.get(position).getGambar())
                .into(holder.release_photo);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, id.cerve.dhanarjkusuma.alibabasub.Activity.DetailEpisode.class);
                intent.putExtra("rilis",releaseItem.get(position).getAlamat());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return releaseItem.size();
    }

    public class ReleaseViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView release_title;
        TextView release_date;
        ImageView release_photo;
        ReleaseViewHolder(View itemView)
        {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.rv);
            release_title = (TextView) itemView.findViewById(R.id.judul);
            release_date = (TextView) itemView.findViewById(R.id.tanggal);
            release_photo = (ImageView) itemView.findViewById(R.id.gambar);

        }


    }

}