/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ext.phonedir;

import com.core.debug.Debug;
import ext.business.BusinessData;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author daan-
 */
public class PhoneDirLookup {
    
    public static void main(String[] args){
        String compname = "social%20deal";
        String city = "den bosch";
        lookup(compname, city);
    
    }
    
    
    public static List<BusinessData> lookup(String companyName, String city){
        List<BusinessData> list = new ArrayList<>();
        companyName = companyName.trim().replaceAll("\\s", "%20" );
        if(city.toLowerCase().contains("hertogenbosch")){
            city = "den-bosch";
        }else{
            city = city.replaceAll("\\s", "-");
        }
        try{
            String url = "https://www.detelefoongids.nl/" + companyName + "/" + city + "/3-1";
            Document doc = Jsoup.connect(url)
            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36")
            .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
                    //.header("Upgrade-Insecure-Requests	","1")
            .timeout(5000)
            .get();
            
            
            if(doc != null){
                Elements businessCards = doc.getElementsByClass("business-card");
                if(businessCards != null && !businessCards.isEmpty()){
                    for(Element businessCard:businessCards){
                        processBusinessCardElement(businessCard);
                    }
                }else{
                    Debug.out("No Business-card elements returned");
                    System.out.println(doc.html());
                }
            }else{
                Debug.out("Could not parse Document");
            }
            
            
            
            
        }catch(Exception e){}
        return list;
    }
    
    
    public static void processBusinessCardElement(Element businessCardElement){
        Elements spans = businessCardElement.getElementsByTag("span");
        for(Element span:spans){
            Attributes attrs = span.attributes();
            for(Attribute attr:attrs.asList()){
                System.out.println(attr.getKey() + "=" + attr.getValue());
            }
            System.out.println(span.text()+ "\n\n");
        }
    }
}
