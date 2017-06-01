package id.cerve.dhanarjkusuma.alibabasub.Util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.Model.Episode;

/**
 * Created by DhanarJKusuma on 6/14/2015.
 */
public class ListEpisodeScraper
{
    public static ArrayList<Episode> getListEpisode(String url)
    {
        ArrayList<Episode> episodes= new ArrayList<>();
        Document document = null;
        if(document==null)
        {
            try
            {
                document= Jsoup.connect(url).get();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        Elements elements = document.select(Episode.TAG_LINK);
        for(Element element : elements)
        {
            Episode ep = new Episode();
            ep.setNama(element.text());
            ep.setLink(element.attr("href"));
            episodes.add(ep);
        }
        elements = document.select(Episode.TAG_GAMBAR);
        if(elements.size()>0)
        {
            for (int i = 0; i < episodes.size(); i++) {
                episodes.get(i).setGambar(elements.attr("src"));
            }
        }
        else
        {
            elements = document.select(Episode.TAG_GAMBAR2);
            for (int i = 0; i < episodes.size(); i++) {
                episodes.get(i).setGambar(elements.attr("src"));
            }
        }

        return episodes;

    }
}
