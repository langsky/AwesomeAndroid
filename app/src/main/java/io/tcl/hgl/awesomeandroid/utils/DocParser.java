package io.tcl.hgl.awesomeandroid.utils;

import android.util.Log;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import io.tcl.hgl.awesomeandroid.mvp.model.Category;
import io.tcl.hgl.awesomeandroid.mvp.model.ItemSummary;
import io.tcl.hgl.awesomeandroid.mvp.model.MainDoc;
import io.tcl.hgl.awesomeandroid.mvp.model.Tag;

/**
 * Created by swd1 on 16-12-30.
 */

public class DocParser {

    private static final String TAG = "DocParser";

    public static List<ItemSummary> getSummaryList(Document document) {
        Elements elements = document.getElementsByTag("article");
        List<ItemSummary> summaryList = new ArrayList<>();
        if (elements != null) {
            for (Element e : elements) {
                ItemSummary s = new ItemSummary();
                s.setTitle(ItemParser.getTitleUrl(e)[0]);
                s.setUrl(ItemParser.getTitleUrl(e)[1]);
                s.setCategories(ItemParser.getCategories(e));
                s.setImageUrl(ItemParser.getImageUrl(e));
                Log.i(TAG, s.toString());
                summaryList.add(s);
            }
        }
        MainDoc.getInstance().setSummaryList(summaryList);
        return summaryList;
    }

    public static List<Tag> getTags(Document document) {
        Element element = document.getElementsByClass("widget wp_widget_tag_cloud").first();
        Elements elements = element.select("a[href]");
        List<Tag> tagList = new ArrayList<>();
        if (elements != null) {
            for (Element e : elements) {
                Tag t = new Tag();
                t.setTitle(TagParser.getTitle(e));
                t.setUrl(TagParser.getUrl(e));
                t.setTopic(TagParser.getTopic(e));
                Log.i(TAG, t.toString());
                tagList.add(t);
            }
        }
        MainDoc.getInstance().setTagList(tagList);
        return tagList;
    }

    public static List<Category> getCategories(Document document) {
        Element element = document.getElementsByClass("widget widget_tag_cloud").first();
        Elements elements = element.select("a[href]");
        List<Category> categoryList = new ArrayList<>();
        if (elements != null) {
            for (Element e : elements) {
                Category c = new Category();
                c.setTitle(CategoryParser.getTitle(e));
                c.setUrl(CategoryParser.getUrl(e));
                Log.i(TAG, c.toString());
                categoryList.add(c);
            }
        }
        MainDoc.getInstance().setCategoryList(categoryList);
        return categoryList;
    }

}
