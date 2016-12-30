package io.tcl.hgl.awesomeandroid.utils;

import org.jsoup.nodes.Element;

/**
 * Created by swd1 on 16-12-30.
 */

public class TagParser {

    public static String getTitle(Element element) {
        String title = "";
        if (element != null)
            title = element.text();
        return title;
    }

    public static String getUrl(Element element) {
        String url = "";
        if (element != null)
            url = element.attr("href");
        return url;
    }

    public static String getTopic(Element element) {
        String topic = "";
        if (element != null)
            topic = element.attr("title");
        return topic;
    }

}
