package io.tcl.hgl.awesomeandroid.utils;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import io.tcl.hgl.awesomeandroid.mvp.model.Category;

/**
 * Created by swd1 on 16-12-29.
 */

public class ItemParser {

    public static List<Category> getCategories(Element element) {
        final Elements elements = element.getElementsByClass("post-categories");
        final List<Category> categories = new ArrayList<>();
        if (elements != null) {
            for (Element e :
                    elements) {
                Category c = new Category();
                c.setTitle(e.text());
                c.setUrl(e.attr("abs:href"));
                categories.add(c);
            }
        }
        return categories;
    }

    public static String[] getTitleUrl(Element element) {
        final Element e = element.getElementsByClass("post-title").first().select("a[href]").first();
        final String[] result = new String[2];
        if (e != null) {
            String title = e.text();
            String url = e.attr("href");
            result[0] = title;
            result[1] = url;
        }
        return result;
    }

    public static String getImageUrl(Element element) {
        final Element e = element.getElementsByClass("post-image").first();
        if (e != null) {
            return e.getElementsByTag("img").attr("src");
        }
        return "";
    }

}
