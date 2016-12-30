package io.tcl.hgl.awesomeandroid.mvp.view.abs;

import android.support.v7.widget.RecyclerView;

/**
 * Created by swd1 on 16-12-30.
 */

public interface IReView extends IView {
    void setReAdapter(RecyclerView.Adapter adapter);
    void setReLayoutManager(RecyclerView.LayoutManager manager);
}
