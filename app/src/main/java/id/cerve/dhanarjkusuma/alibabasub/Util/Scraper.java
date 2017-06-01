package id.cerve.dhanarjkusuma.alibabasub.Util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.Model.ReleasePost;

/**
 * Created by DhanarJKusuma on 6/11/2015.
 */
public class Scraper
{
    public static ArrayList<ReleasePost> GetRelease(String url,int jumHalaman)
    {
        int total=0;
        String sementara="";
        ArrayList<ReleasePost> ReleaseAll = new ArrayList<>();
        for (int x=0;x<jumHalaman;x++) {
            ArrayList<ReleasePost> ReleaseAnime = new ArrayList<>();
            Document document = null;

            if (document == null) {
                try {
                    document = Jsoup.connect(url+(x+1)).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Elements elements = document.select(ReleasePost.TAG_JUDUL);
            for (Element element : elements) {
                ReleasePost rp = new ReleasePost();
                rp.setJudul(element.text());
                ReleaseAnime.add(rp);
            }

            elements = document.select(ReleasePost.TAG_ALAMAT);
            for (int i = 0; i < elements.size(); i++) {
                total = elements.size();
                ReleaseAnime.get(i).setAlamat(elements.get(i).attr("href"));
            }
            elements = document.select(ReleasePost.TAG_TANGGAL);
            int current = 0;
            for (int i = 0; i < elements.size(); i++) {
                int count = 0;
                count = i + 1;
                if (count % 3 == 0) {
                    sementara += elements.get(i).text();
                    ReleaseAnime.get(current).setTanggal(sementara);
                    current++;
                    sementara = "";
                } else {
                    sementara += elements.get(i).text() + " ";
                }
            }

            elements = document.select(ReleasePost.TAG_GAMBAR);
            for (int i = 0; i < elements.size(); i++) {
                ReleaseAnime.get(i).setGambar(elements.get(i).attr("src"));
            }
/*        elements = document.select(ReleasePost.TAG_DESKRIPSI);
        for(int i=0;i<elements.size();i++)
        {
            ReleaseAnime.get(i).setDeskripsi(elements.get(i).text());
        }
    */
            ReleaseAll.addAll(ReleaseAnime);
        }
        return ReleaseAll;
    }

}
