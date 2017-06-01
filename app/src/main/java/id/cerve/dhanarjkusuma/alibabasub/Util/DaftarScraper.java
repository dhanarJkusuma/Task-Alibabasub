package id.cerve.dhanarjkusuma.alibabasub.Util;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.Model.DaftarAnime;

/**
 * Created by DhanarJKusuma on 6/13/2015.
 */
public class DaftarScraper
{
    public static ArrayList<DaftarAnime> GetDaftarAnime (String url,int jumlahHal)
    {
        ArrayList<DaftarAnime> daftarAnimeAll = new ArrayList<>();
        for(int x=0;x<jumlahHal;x++) {
            ArrayList<DaftarAnime> daftarAnime = new ArrayList<>();
            Document document = null;
            if (document == null) {
                try {
                    document = Jsoup.connect(url+(x+1)).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Elements elements = document.select(DaftarAnime.TAG_JUDUL);
            for (Element element : elements) {
                DaftarAnime da = new DaftarAnime();
                da.setJudul(element.text());
                daftarAnime.add(da);
            }
            elements = document.select(DaftarAnime.TAG_GAMBAR);
            for (int i = 0; i < elements.size(); i++) {
                daftarAnime.get(i).setGambar(elements.get(i).attr("src"));
            }
            elements = document.select(DaftarAnime.TAG_SINOPSIS);
            for (int i = 0; i < elements.size(); i++) {
                daftarAnime.get(i).setSinopsis(elements.get(i).text());
            }
            elements = document.select(DaftarAnime.TAG_LINK);
            for (int i = 0; i < elements.size(); i++) {
                daftarAnime.get(i).setLink(elements.get(i).attr("href"));
            }

            daftarAnimeAll.addAll(daftarAnime);
        }
        return daftarAnimeAll;
    }
}
