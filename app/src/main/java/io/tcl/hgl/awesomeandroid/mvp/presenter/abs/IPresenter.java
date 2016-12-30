package io.tcl.hgl.awesomeandroid.mvp.presenter.abs;

import io.tcl.hgl.awesomeandroid.mvp.view.abs.IView;

/**
 * Created by swd1 on 16-12-30.
 */

public interface IPresenter<V extends IView> {

    void bindView(V v);

}
