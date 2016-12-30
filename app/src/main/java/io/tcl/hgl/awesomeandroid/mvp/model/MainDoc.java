package io.tcl.hgl.awesomeandroid.mvp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swd1 on 16-12-30.
 */

public class MainDoc implements IModel {

    private final List<ItemSummary> summaryList;
    private final List<Tag> tagList;
    private final List<Category> categoryList;

    private MainDoc() {
        summaryList = new ArrayList<>();
        tagList = new ArrayList<>();
        categoryList = new ArrayList<>();
    }

    private static class H {
        private static final MainDoc instance = new MainDoc();
    }

    public static MainDoc getInstance() {
        return H.instance;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList.addAll(categoryList);
    }

    public void setSummaryList(List<ItemSummary> summaryList) {
        this.summaryList.addAll(summaryList);
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList.addAll(tagList);
    }

    @Override
    public List<ItemSummary> provideSummaryList() {
        return summaryList;
    }

    @Override
    public List<Tag> provideTagList() {
        return tagList;
    }

    @Override
    public List<Category> provideCategoryList() {
        return categoryList;
    }


}
