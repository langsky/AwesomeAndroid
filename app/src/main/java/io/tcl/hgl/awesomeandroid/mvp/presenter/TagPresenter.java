package io.tcl.hgl.awesomeandroid.mvp.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import io.tcl.hgl.awesomeandroid.adapter.TagAdapter;
import io.tcl.hgl.awesomeandroid.mvp.model.Tag;
import io.tcl.hgl.awesomeandroid.mvp.presenter.abs.TcPresenter;
import io.tcl.hgl.awesomeandroid.mvp.view.abs.IReView;
import io.tcl.hgl.awesomeandroid.mvp.view.abs.IView;
import io.tcl.hgl.awesomeandroid.network.Aapi;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;


/**
 * Created by swd1 on 16-12-30.
 */

public class TagPresenter implements TcPresenter {

    private IReView iReView;
    private Context context;


    public TagPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void initList() {
        Aapi.tagSubject.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Tag>>() {
                    @Override
                    public void onCompleted() {
                        iReView.end();
                    }

                    @Override
                    public void onError(Throwable e) {
                        iReView.error(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Tag> tags) {
                        iReView.ongoing();
                        TagAdapter adapter = new TagAdapter(context, tags);
                        LinearLayoutManager manager = new LinearLayoutManager(context);
                        iReView.setReAdapter(adapter);
                        iReView.setReLayoutManager(manager);
                        iReView.end();
                    }
                });
    }

    @Override
    public void bindView(IView iView) {
        this.iReView = (IReView) iView;
    }
}
