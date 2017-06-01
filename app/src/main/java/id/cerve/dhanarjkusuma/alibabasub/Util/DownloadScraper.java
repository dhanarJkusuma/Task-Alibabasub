package id.cerve.dhanarjkusuma.alibabasub.Util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import id.cerve.dhanarjkusuma.alibabasub.Model.Download;

/**
 * Created by DhanarJKusuma on 6/14/2015.
 */
public class DownloadScraper
{
    public static ArrayList<Download> getDownloadLink(String url)
    {
        ArrayList<Download> link=new ArrayList<>();
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

        Elements elements = document.select(Download.TAG_LINK);
        for(int i=0;i<elements.size();i++)
        {
            if(i>=3 && i<=6)
            {
                Download dl = new Download();
                dl.setNama(elements.get(i).text()+" 480p ");
                link.add(dl);
            }
            else if(i>6&& i<=10)
            {
                Download dl = new Download();
                dl.setNama(elements.get(i).text()+" 720p ");
                link.add(dl);
            }
        }
        elements = document.select(Download.TAG_LINK);
        int count=0;
        for(int i=0;i<elements.size();i++)
        {

                if (i >= 3 && i <= 10)
                {
                    link.get(count).setLinkDownload(elements.get(i).attr("href"));
                    count++;
                }
        }
            /*
            if(i>=3 && i<=6)
            {
                Download dl = new Download();
                dl.setLinkDownload480(elements.get(i).attr("href"));
                link.add(dl);
            }
            if(i>6&& i<=10)
            {
                Download dl = new Download();
                dl.setLinkDownload720(elements.get(i).attr("href"));
                link.add(dl);
            }
            */

        return link;
    }
}
