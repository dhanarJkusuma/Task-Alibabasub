package id.cerve.dhanarjkusuma.alibabasub.Util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import id.cerve.dhanarjkusuma.alibabasub.Model.DaftarAnime;
import id.cerve.dhanarjkusuma.alibabasub.Model.DetailAnime;
import id.cerve.dhanarjkusuma.alibabasub.Model.DetailEpisode;

/**
 * Created by DhanarJKusuma on 6/14/2015.
 */
public class EpisodeScraper
{
    public static ArrayList<DetailEpisode> GetAnimeEpisode(String url)
    {
        ArrayList<DetailEpisode> animes = new ArrayList<>();
        Document document = null;
        if(document == null)
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

        Elements elements = document.select(DetailEpisode.TAG_JUDUL);
        DetailEpisode de = new DetailEpisode();
        de.setJudul(elements.text());

        elements = document.select(DetailEpisode.TAG_CONTENT);
        de.setContent(elements.text());

        elements = document.select(DetailEpisode.TAG_GAMBAR);
        if(elements.size()>0)
        {
            de.setGambar(elements.attr("src"));
        }
        else
        {
                elements = document.select(DetailEpisode.TAG_GAMBAR3);
                de.setGambar(elements.attr("src"));

        }

        animes.add(de);

        return animes;
    }
}
