package io.tcl.hgl.awesomeandroid.mvp.view.abs;

/**
 * Created by swd1 on 16-12-30.
 */

public interface IView {
    void begin();

    void ongoing();

    void end();

    void error(String e);
}
