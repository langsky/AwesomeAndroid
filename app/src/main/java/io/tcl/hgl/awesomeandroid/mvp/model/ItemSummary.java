package io.tcl.hgl.awesomeandroid.mvp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swd1 on 16-12-29.
 */

public class ItemSummary {

    private final List<Category> categories;

    private String imageUrl;

    private String title;

    private String url;

    public ItemSummary() {
        categories = new ArrayList<>();
        imageUrl = "";
        title = "";
        url = "";
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories.addAll(categories);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String categoryToString() {
        StringBuilder b = new StringBuilder("categories : ");
        for (Category c : categories
                ) {
            b.append(c.getTitle()).append(" ");
        }
        return b.toString();
    }

    @Override
    public String toString() {
        return categoryToString() + " title: " + getTitle() + " url: " + getUrl() + " imageUrl: " + getImageUrl() + '\n';
    }
}
