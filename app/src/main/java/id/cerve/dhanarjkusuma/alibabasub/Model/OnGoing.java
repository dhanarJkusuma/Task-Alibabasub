package id.cerve.dhanarjkusuma.alibabasub.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DhanarJKusuma on 6/13/2015.
 */
public class OnGoing implements Parcelable
{
    public static final String URL ="http://alibabasub.net/tag/on-going/page/";
    public static final String TAG_JUDUL =".entry-summary > h1";
    public static final String TAG_GAMBAR = ".entry-header > img";
    public static final String TAG_ALAMAT = ".entry-summary > h1 > a";
    public static final String TAG_SINOPSIS = ".entry-summary > p";

    private String judul;
    private String gambar;
    private String sinopsis;
    private String alamat;

    public OnGoing()
    {

    }

    public OnGoing(Parcel in)
    {
        judul = in.readString();
        gambar = in.readString();
        sinopsis = in.readString();
        alamat=in.readString();
    }

    public String getAlamat()
    {
        return alamat;
    }

    public void setAlamat(String alamat)
    {
        this.alamat = alamat;
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

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }



    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(judul);
        parcel.writeString(gambar);
        parcel.writeString(sinopsis);
        parcel.writeString(alamat);
    }

    public static final Creator<OnGoing> CREATOR = new Creator<OnGoing>() {
        @Override
        public OnGoing createFromParcel(Parcel parcel) {
            return new OnGoing(parcel);
        }

        @Override
        public OnGoing[] newArray(int i) {
            return new OnGoing[i];
        }
    };
}
