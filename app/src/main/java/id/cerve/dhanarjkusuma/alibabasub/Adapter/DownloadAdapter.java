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
import java.util.Collections;
import java.util.List;

import id.cerve.dhanarjkusuma.alibabasub.Model.DetailEpisode;
import id.cerve.dhanarjkusuma.alibabasub.Model.Download;
import id.cerve.dhanarjkusuma.alibabasub.R;

/**
 * Created by DhanarJKusuma on 6/14/2015.
 */
public class DownloadAdapter extends BaseAdapter {
    private Context context;
    ArrayList<Download> data;

    public DownloadAdapter(ArrayList<Download> data,Context context)
    {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_download, parent, false);

            holder = new Holder();
            holder.link = (TextView) convertView.findViewById(R.id.link);
            convertView.setTag(holder);
        }
        else
        {
            holder = (Holder) convertView.getTag();
        }
        holder.link.setText(data.get(position).getNama());
        return convertView;
    }
    private class Holder
    {
        TextView link;

    }
}
