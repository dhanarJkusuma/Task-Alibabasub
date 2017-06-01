package id.cerve.dhanarjkusuma.alibabasub.Util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.Model.DetailAnime;

/**
 * Created by DhanarJKusuma on 6/14/2015.
 */
public class AnimeScraper
{
    public static ArrayList<DetailAnime> getDataAnime (String url)
    {
        ArrayList<DetailAnime> dataAnime=new ArrayList<>();

        Document document=null;
        if(document==null)
        {
            try
            {
                document = Jsoup.connect(url).get();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        Elements elements = document.select(DetailAnime.TAG_JUDUL);
        DetailAnime da = new DetailAnime();
        da.setJudul(elements.text());
        dataAnime.add(da);


        elements = document.select(DetailAnime.TAG_GAMBAR);
        if(elements.size()>0)
        {
            dataAnime.get(0).setGambar(elements.attr("src"));
        }
        else
        {
            elements = document.select(DetailAnime.TAG_GAMBAR2);
            dataAnime.get(0).setGambar(elements.attr("src"));
        }

        elements = document.select(DetailAnime.TAG_CONTENT);
        dataAnime.get(0).setContent(elements.text());

        elements = document.select(DetailAnime.TAG_CONTENT);
        dataAnime.get(0).setGenre(elements.text());

        return dataAnime;
    }
}
