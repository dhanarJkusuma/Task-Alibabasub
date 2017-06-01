package id.cerve.dhanarjkusuma.alibabasub.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.Model.Episode;
import id.cerve.dhanarjkusuma.alibabasub.R;

/**
 * Created by DhanarJKusuma on 6/14/2015.
 */
public class EpisodeAdapter extends BaseAdapter
{
    private ArrayList<Episode> episodes;
    private Context context;

    public EpisodeAdapter(ArrayList<Episode> episodes,Context context)
    {
        this.episodes = episodes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return episodes.size();
    }

    @Override
    public Object getItem(int i) {
        return episodes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_episode,parent,false);
            holder = new Holder();
            holder.Nama = (TextView) convertView.findViewById(R.id.itemEpisode);
            holder.gambar = (ImageView) convertView.findViewById(R.id.gambar);
            convertView.setTag(holder);
        }
        else
        {
            holder = (Holder) convertView.getTag();
        }
        holder.Nama
                .setText(episodes.get(position).getNama());

        Picasso.with(context)
                .load(episodes.get(position).getGambar())
                .into(holder.gambar);

        return convertView;
    }
    private class Holder
    {
        TextView Nama;
        ImageView gambar;
    }
}
