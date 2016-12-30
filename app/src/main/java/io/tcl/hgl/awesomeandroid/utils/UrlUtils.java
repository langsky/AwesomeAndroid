package io.tcl.hgl.awesomeandroid.utils;

/**
 * Created by swd1 on 16-12-30.
 */

public class UrlUtils {
    public static String addTag(String tag) {
        return C.BASE_URL + "/" + tag;
    }

    public static String addCategory(String category) {
        return C.BASE_URL + "/" + category;
    }
}
