package id.cerve.dhanarjkusuma.alibabasub.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DhanarJKusuma on 6/14/2015.
 */
public class Episode implements Parcelable
{
    public static String TAG_GAMBAR=".entry-content > p > a > img";
    public static String TAG_GAMBAR2=".entry-content > h3 > a > img";
    public static String TAG_LINK=".su-posts > li > a";

    private String gambar;
    private String nama;
    private String link;


    public Episode()
    {

    }

    public Episode(Parcel in)
    {
        nama=in.readString();
        link=in.readString();
        gambar=in.readString();
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGambar()
    {
        return gambar;
    }

    public void setGambar(String gambar)
    {
        this.gambar = gambar;
    }

    @Override
    public int describeContents()
    {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(nama);
        parcel.writeString(link);
        parcel.writeString(gambar);
    }

    public static final  Creator<Episode> CREATOR = new Creator<Episode>()
    {
        @Override
        public Episode createFromParcel(Parcel parcel) {
            return new Episode(parcel);
        }

        @Override
        public Episode[] newArray(int i) {
            return new Episode[i];
        }
    };
}
