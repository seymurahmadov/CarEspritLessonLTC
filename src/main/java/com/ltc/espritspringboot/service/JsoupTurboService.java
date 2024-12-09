package com.ltc.espritspringboot.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsoupTurboService {



//    @Scheduled(fixedRate = 5000)
    public void getCars() throws IOException {

        int page = 417;


        Document doc = Jsoup.connect("https://turbo.az/autos?page=" + page).get();

        Elements elementsByClass = doc.getElementsByClass("products-i");


        for (Element element : elementsByClass) {

            Elements marka = element.getElementsByClass("products-i__name products-i__bottom-text");


            Elements species = element.getElementsByClass("products-i__attributes products-i__bottom-text");
            String[] split = species.text().split(",");
            String year = split[0];

//            System.out.println(elementsByClass2.text());


            Elements elementsByAttribute = element.getElementsByAttribute("href");
            String links = elementsByAttribute.attr("abs:href");


            Document doc2 = Jsoup.connect(links).get();
            Element color = doc2.getElementsByClass("product-properties__i").get(5);

            System.out.println("Make: " + marka.text() +  " Species : " + species.text() +  " Reng " + color.text().substring(4));


        }


    }

}
