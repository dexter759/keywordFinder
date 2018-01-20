import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;


public class Glavno {

    public ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> zadatak (String element,String url,String mainUrl,ArrayList<String> keywords){
        System.out.println(url);


        ArrayList<String> urls = new ArrayList<>();

        try {

            Document doc = null;
            try {
                doc = Jsoup.connect(url).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int i = 0;
            Element link2 = null;
            try {
                link2 = doc.select(element).last();
            } catch (Exception e) {
                System.out.println(e);
            }
            String linkTextEnd = "";
            if (link2 != null) {
                linkTextEnd = link2.text();
            }
            String linkText = null;
            do {
                try {

                    Element link = doc.select(element).get(i);
                    linkText = link.text();
                    if (element.equals("a")) {
                        String linkHref = link.attr("href");
                        if (!linkHref.contains("#") && !linkHref.contains("youtube") && !linkHref.contains("facebook")) {
                            if (!linkHref.contains("http://")){
                                linkHref=mainUrl+linkHref;
                            }
                           if(!urls.contains(linkHref)) {
                               urls.add(linkHref);
                           }
                        }
                    }
                    i++;//
                    for(String keyword:keywords) {
                        String linkText2 = linkText.toLowerCase();
                        if(linkText2.contains(keyword)) {
                            System.out.println(element + ": " + linkText + "\n");
                            if(!result.contains(url+" "+linkText)){
                                result.add(url+" "+linkText);
                            }
                        }
                    }
//            }
                } catch (Exception ignored) {

                }
            } while (!linkText.equals(linkTextEnd));
        }catch (Exception ignored){
        }
        for(String result:result){
            System.out.println(result);
        }
        return urls;
    }

}
