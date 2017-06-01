package id.cerve.dhanarjkusuma.alibabasub.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DhanarJKusuma on 6/14/2015.
 */
public class DetailEpisode implements Parcelable
{
    public static String TAG_JUDUL=".entry-header > h1";
    public static String TAG_GAMBAR=".entry-header > img";
    public static String TAG_GAMBAR3 = "main > article > img";
    public static String TAG_CONTENT=".entry-content";



    private String judul;
    private String gambar;
    private String content;

    public DetailEpisode()
    {

    }

    public DetailEpisode(Parcel in)
    {
        judul = in.readString();
        gambar = in.readString();
        content = in.readString();

    }

    public String getJudul()
    {
        return judul;
    }

    public void setJudul(String judul)
    {
        this.judul = judul;
    }

    public String getGambar()
    {
        return gambar;
    }

    public void setGambar(String gambar)
    {
        this.gambar = gambar;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        int awal = content.indexOf("Informasi");
        int isi = 10;
        String tmp;
        if(awal == -1)
        {
            awal = content.indexOf("Information");
            isi = 10;
        }
        int akhir = content.indexOf("Sub");
        tmp = content.substring(isi,akhir);
        this.content = "Informasi : \n"+tmp;
    }

    @Override
    public int describeContents()
    {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(judul);
        parcel.writeString(gambar);
        parcel.writeString(content);


    }
    public static final Parcelable.Creator<DetailEpisode> CREATOR = new Creator<DetailEpisode>() {
        @Override
        public DetailEpisode createFromParcel(Parcel parcel)
        {
            return new DetailEpisode(parcel);
        }

        @Override
        public DetailEpisode[] newArray(int i)
        {
            return new DetailEpisode[i];
        }
    };
}
