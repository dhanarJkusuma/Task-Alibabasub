package id.cerve.dhanarjkusuma.alibabasub.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DhanarJKusuma on 6/13/2015.
 */
public class DaftarAnime implements Parcelable
{

    public static String URL="http://alibabasub.net/daftar-anime/page/";
    public static String TAG_JUDUL=".entry-summary > h1";

    public static String TAG_LINK=".entry-summary > h1 > a";
    public static String TAG_GAMBAR=".entry-header > img";
    public static String TAG_SINOPSIS=".entry-summary > p";


    private String judul;
    private String gambar;
    private String sinopsis;
    private String link;

    public DaftarAnime()
    {

    }

    public DaftarAnime(Parcel in)
    {
        judul = in.readString();
        gambar = in.readString();
        sinopsis = in.readString();
        link=in.readString();
    }



    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(judul);
        parcel.writeString(gambar);
        parcel.writeString(sinopsis);
        parcel.writeString(link);
    }

    public static final Creator<DaftarAnime> CREATOR = new Creator<DaftarAnime>() {
        @Override
        public DaftarAnime createFromParcel(Parcel parcel) {
            return new DaftarAnime(parcel);
        }

        @Override
        public DaftarAnime[] newArray(int i) {
            return new DaftarAnime[i];
        }
    };
}
