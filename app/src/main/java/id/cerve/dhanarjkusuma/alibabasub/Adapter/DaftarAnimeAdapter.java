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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.Activity.DetailAnime;
import id.cerve.dhanarjkusuma.alibabasub.Model.DaftarAnime;
import id.cerve.dhanarjkusuma.alibabasub.R;

/**
 * Created by DhanarJKusuma on 6/13/2015.
 */
public class DaftarAnimeAdapter extends RecyclerView.Adapter<DaftarAnimeAdapter.DaftarAnimeViewHolder>
{
    private static ArrayList<DaftarAnime> daftarItem;
    private static Context context;
    public DaftarAnimeAdapter(ArrayList<DaftarAnime> daftarList,Context context)
    {
        this.daftarItem = daftarList;
        this.context = context;
    }
    @Override
    public DaftarAnimeAdapter.DaftarAnimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_daftaranime,parent,false);
        DaftarAnimeViewHolder mvh = new DaftarAnimeViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(DaftarAnimeAdapter.DaftarAnimeViewHolder holder, final int position) {
        holder.daftar_title
                .setText(daftarItem.get(position).getJudul());

        //alamat = releaseItem.get(position).getAlamat();
        Picasso.with(context)
                .load(daftarItem.get(position).getGambar())
                .into(holder.daftar_photo);
        holder.itemView
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context,DetailAnime.class);
                        intent.putExtra("dataAnime", daftarItem.get(position).getLink());
                        context.startActivity(intent);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return daftarItem.size();
    }
    public class DaftarAnimeViewHolder extends RecyclerView.ViewHolder
    {
        CardView cv;
        TextView daftar_title;
        ImageView daftar_photo;
        public DaftarAnimeViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.rv);
            daftar_title = (TextView) itemView.findViewById(R.id.judul);
            daftar_photo = (ImageView) itemView.findViewById(R.id.gambar);
        }
    }
}
