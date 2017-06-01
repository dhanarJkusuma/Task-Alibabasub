package id.cerve.dhanarjkusuma.alibabasub.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DhanarJKusuma on 6/10/2015.
 */
public class ReleasePost implements Parcelable
{
    public static final String URL = "http://alibabasub.net/page/";
    public static final String TAG_JUDUL = ".entry-summary h1";
    public static final String TAG_TANGGAL = ".entry-summary > .meta88";
    public static final String TAG_GAMBAR = ".entry-header > img";
    public static final String TAG_DESKRIPSI = "";
    public static final String TAG_ALAMAT=".entry-title > a";


    private String judul;
    private String tanggal;
    private String gambar;
    private String deskripsi;
    private String alamat;


    public ReleasePost()
    {

    }

    public ReleasePost(Parcel in)
    {
        judul = in.readString();
        tanggal = in.readString();
        gambar = in.readString();
        deskripsi = in.readString();
        alamat = in.readString();
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

    public String getDeskripsi()
    {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi)
    {
        this.deskripsi = deskripsi;
    }

    public String getAlamat()
    {
        return alamat;
    }

    public void setAlamat(String alamat)
    {
        this.alamat = alamat;
    }

    public String getTanggal()
    {
        return tanggal;
    }

    public void setTanggal(String tanggal)
    {
        this.tanggal = tanggal;
    }



    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(judul);
        parcel.writeString(tanggal);
        parcel.writeString(gambar);
        parcel.writeString(deskripsi);
        parcel.writeString(alamat);
    }

    public static final Creator<ReleasePost> CREATOR = new Creator<ReleasePost>() {
        @Override
        public ReleasePost createFromParcel(Parcel parcel) {
            return new ReleasePost(parcel);
        }

        @Override
        public ReleasePost[] newArray(int i) {
            return new ReleasePost[i];
        }
    };
}
