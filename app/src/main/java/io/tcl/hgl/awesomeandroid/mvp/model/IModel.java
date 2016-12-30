package io.tcl.hgl.awesomeandroid.mvp.model;

import java.util.List;

/**
 * Created by swd1 on 16-12-30.
 */

public interface IModel {
    List<ItemSummary> provideSummaryList();

    List<Tag> provideTagList();

    List<Category> provideCategoryList();
}
