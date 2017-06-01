package id.cerve.dhanarjkusuma.alibabasub.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DhanarJKusuma on 6/14/2015.
 */
public class Download implements Parcelable {
    public static String TAG_LINK =".ext-link ";

    private String Nama;
    private String linkDownload;

    /*
    private String linkDownload480;
    private String linkDownload720;
    */
    public Download()
    {

    }
    public Download(Parcel in)
    {

        Nama=in.readString();
        linkDownload = in.readString();
        /*
        linkDownload480 = in.readString();
        linkDownload720 = in.readString();
        */
    }


    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(linkDownload);
        parcel.writeString(Nama);
       // parcel.writeString(linkDownload480);
       // parcel.writeString(linkDownload720);
    }


    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getLinkDownload() {
        return linkDownload;
    }

    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }

    /*
        public String getLinkDownload480() {
            return linkDownload480;
        }

        public void setLinkDownload480(String linkDownload480) {
            this.linkDownload480 = linkDownload480;
        }

        public String getLinkDownload720() {
            return linkDownload720;
        }

        public void setLinkDownload720(String linkDownload720) {
            this.linkDownload720 = linkDownload720;
        }

    */
    public static Creator<Download> CREATOR = new Creator<Download>() {
        @Override
        public Download createFromParcel(Parcel parcel) {
            return new Download(parcel);
        }

        @Override
        public Download[] newArray(int i) {
            return new Download[i];
        }
    };
}
