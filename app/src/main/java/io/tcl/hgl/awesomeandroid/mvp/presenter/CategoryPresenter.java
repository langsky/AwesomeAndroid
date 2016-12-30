package io.tcl.hgl.awesomeandroid.mvp.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import io.tcl.hgl.awesomeandroid.adapter.CategoryAdapter;
import io.tcl.hgl.awesomeandroid.adapter.TagAdapter;
import io.tcl.hgl.awesomeandroid.mvp.model.Category;
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

public class CategoryPresenter implements TcPresenter {

    private IReView iReView;
    private Context context;


    public CategoryPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void initList() {
        Aapi.categorySubject.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Category>>() {
                    @Override
                    public void onCompleted() {
                        iReView.end();
                    }

                    @Override
                    public void onError(Throwable e) {
                        iReView.error(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Category> categories) {
                        iReView.ongoing();
                        CategoryAdapter adapter = new CategoryAdapter(context, categories);
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
