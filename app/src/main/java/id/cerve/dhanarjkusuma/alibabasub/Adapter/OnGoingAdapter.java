package id.cerve.dhanarjkusuma.alibabasub.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.Activity.DetailAnime;
import id.cerve.dhanarjkusuma.alibabasub.Activity.DetailOnGoing;
import id.cerve.dhanarjkusuma.alibabasub.Model.OnGoing;
import id.cerve.dhanarjkusuma.alibabasub.Model.ReleasePost;
import id.cerve.dhanarjkusuma.alibabasub.R;

/**
 * Created by DhanarJKusuma on 6/13/2015.
 */
public class OnGoingAdapter extends RecyclerView.Adapter<OnGoingAdapter.OnGoingViewHolder>
{
    private static ArrayList<OnGoing> onGoingItem;
    private static Context context;

    public OnGoingAdapter(ArrayList<OnGoing> onGoingItem,Context context )
    {
        this.onGoingItem= onGoingItem;
        this.context = context;
    }

    @Override
    public OnGoingAdapter.OnGoingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_ongoing,parent,false);
        OnGoingViewHolder mvh = new OnGoingViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(OnGoingAdapter.OnGoingViewHolder holder, final int position) {
        holder.ongoing_title
                .setText(onGoingItem.get(position).getJudul());
        holder.onging_sinopsis
                .setText(onGoingItem.get(position).getSinopsis());
        //alamat = releaseItem.get(position).getAlamat();
        Picasso.with(context)
                .load(onGoingItem.get(position).getGambar())
                .into(holder.onging_photo);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailAnime.class);
                intent.putExtra("dataAnime",onGoingItem.get(position).getAlamat());
                context.startActivity(intent);
                //Toast.makeText(context," "+ onGoingItem.get(position).getAlamat(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return onGoingItem.size();
    }

    public class OnGoingViewHolder extends RecyclerView.ViewHolder
    {
        CardView cv;
        TextView ongoing_title;
        TextView onging_sinopsis;
        ImageView onging_photo;

        public OnGoingViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.rv);
            ongoing_title = (TextView) itemView.findViewById(R.id.judul);
            onging_sinopsis = (TextView) itemView.findViewById(R.id.sinopsis);
            onging_photo = (ImageView) itemView.findViewById(R.id.gambar);
        }
    }

}
