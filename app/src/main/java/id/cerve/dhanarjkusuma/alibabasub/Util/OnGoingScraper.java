package id.cerve.dhanarjkusuma.alibabasub.Util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.Model.OnGoing;
import id.cerve.dhanarjkusuma.alibabasub.Model.ReleasePost;

/**
 * Created by DhanarJKusuma on 6/13/2015.
 */
public class OnGoingScraper
{
    public static ArrayList<OnGoing> GetOnGoing(String url,int jumlahHal)
    {
        ArrayList<OnGoing> OnGoingAll = new ArrayList<>();
        for(int x=0;x<jumlahHal;x++) {
            ArrayList<OnGoing> OnGoingAnime = new ArrayList<>();
            Document document = null;
            if (document == null) {
                try {
                    document = Jsoup.connect(url+(x+1)).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Elements elements = document.select(OnGoing.TAG_JUDUL);
            for (Element element : elements) {
                OnGoing og = new OnGoing();
                og.setJudul(element.text());
                OnGoingAnime.add(og);
            }
            elements = document.select(OnGoing.TAG_GAMBAR);
            for (int i = 0; i < elements.size(); i++) {
                OnGoingAnime.get(i).setGambar(elements.get(i).attr("src"));
            }
            elements = document.select(OnGoing.TAG_SINOPSIS);
            for (int i = 0; i < elements.size(); i++) {
                OnGoingAnime.get(i).setSinopsis(elements.get(i).text());
            }
            elements = document.select(OnGoing.TAG_ALAMAT);
            for(int i=0;i<elements.size();i++)
            {
                OnGoingAnime.get(i).setAlamat(elements.get(i).attr("href"));
            }

            OnGoingAll.addAll(OnGoingAnime);
        }
        return OnGoingAll;
    }

}
