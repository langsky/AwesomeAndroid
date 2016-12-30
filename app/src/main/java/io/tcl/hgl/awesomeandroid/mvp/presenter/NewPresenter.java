package io.tcl.hgl.awesomeandroid.mvp.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import io.tcl.hgl.awesomeandroid.adapter.NewAdapter;
import io.tcl.hgl.awesomeandroid.mvp.model.ItemSummary;
import io.tcl.hgl.awesomeandroid.mvp.presenter.abs.SummaryPresenter;
import io.tcl.hgl.awesomeandroid.mvp.view.abs.IReView;
import io.tcl.hgl.awesomeandroid.mvp.view.abs.IView;
import io.tcl.hgl.awesomeandroid.network.Aapi;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by swd1 on 16-12-30.
 */

public class NewPresenter implements SummaryPresenter {

    private IReView iView;
    private Context context;

    @Override
    public void bindView(IView iView) {
        this.iView = (IReView) iView;
    }


    public NewPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void initList() {
        Aapi.newSubject.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ItemSummary>>() {
                    @Override
                    public void onCompleted() {
                        iView.end();
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView.error(e.toString());
                    }

                    @Override
                    public void onNext(List<ItemSummary> summaries) {
                        iView.ongoing();
                        NewAdapter adapter = new NewAdapter(context, summaries);
                        LinearLayoutManager manager = new LinearLayoutManager(context);
                        iView.setReAdapter(adapter);
                        iView.setReLayoutManager(manager);
                        iView.end();
                    }

                });
    }

    @Override
    public void favorItem(int position) {

    }
}
