package id.cerve.dhanarjkusuma.alibabasub.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DhanarJKusuma on 6/14/2015.
 */
public class DetailAnime implements Parcelable
{
    public static String TAG_JUDUL=".entry-header > h1";
    public static String TAG_GAMBAR=".entry-content > p > a > img";
    public static String TAG_GAMBAR2 = ".entrycontent > h3 > a > img";

    public static String TAG_CONTENT=".entry-content";


    private String judul;
    private String gambar;
    private String content;
    private String genre;

    public DetailAnime()
    {

    }

    public DetailAnime(Parcel in)
    {
        judul = in.readString();
        gambar = in.readString();
        content = in.readString();
        genre = in.readString();
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
        int awal = content.indexOf("Sinopsis");

        int akhir = content.indexOf("Informasi");
        if(akhir == -1)
        {
            akhir=content.indexOf("Information");
        }
        if(awal==-1)
        {
            this.content ="Tidak ada Sinopsis";
        }
        else
        {
            this.content = content.substring(awal,akhir);
        }


    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        int awal = genre.indexOf("Genre");
        int akhir = genre.indexOf("Durasi");
        if(akhir == -1)
        {
            akhir=genre.indexOf("Duration");
            if(akhir == -1)
            {
                akhir=genre.indexOf("Silakan");
            }
        }

        this.genre= genre.substring(awal,akhir);

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
        parcel.writeString(genre);
    }

    public static Creator<DetailAnime> CREATOR = new Creator<DetailAnime>() {
        @Override
        public DetailAnime createFromParcel(Parcel parcel) {
            return new DetailAnime(parcel);
        }

        @Override
        public DetailAnime[] newArray(int i) {
            return new DetailAnime[i];
        }
    };
}
