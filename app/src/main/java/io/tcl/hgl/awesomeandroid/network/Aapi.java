package io.tcl.hgl.awesomeandroid.network;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

import io.tcl.hgl.awesomeandroid.mvp.model.Category;
import io.tcl.hgl.awesomeandroid.mvp.model.ItemSummary;
import io.tcl.hgl.awesomeandroid.mvp.model.Tag;
import io.tcl.hgl.awesomeandroid.utils.C;
import io.tcl.hgl.awesomeandroid.utils.DocParser;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.ReplaySubject;

/**
 * Created by swd1 on 16-12-29.
 */

public class Aapi {

    private static final ReplaySubject<Document> subject = ReplaySubject.create();
    public static final ReplaySubject<List<ItemSummary>> newSubject = ReplaySubject.create();
    public static final ReplaySubject<List<Category>> categorySubject = ReplaySubject.create();
    public static final ReplaySubject<List<Tag>> tagSubject = ReplaySubject.create();


    //get main page
    public static void getMainPage() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (!NetworkState.isNetworkAvailable()) {
                    subject.onError(new Throwable("no network"));
                }
                subscriber.onNext(C.BASE_URL);
                subscriber.onCompleted();
            }
        }).map(new Func1<String, Document>() {
            @Override
            public Document call(String s) {
                try {
                    Document document = Jsoup.connect(s).userAgent("Chrome/54.0.2840.100").get();
                    subject.onNext(document);
                    return document;
                } catch (IOException e) {
                    e.printStackTrace();
                    subject.onError(e.getCause());
                    return null;
                }
            }
        }).subscribeOn(Schedulers.io()).subscribe();
        initData();
    }

    public static void getPage(final String url) {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (!NetworkState.isNetworkAvailable())
                    subject.onError(new Throwable("no network"));
                subscriber.onNext(url);
                subscriber.onCompleted();
            }
        }).map(new Func1<String, Document>() {
            @Override
            public Document call(String s) {
                try {
                    Document document = Jsoup.connect(s).userAgent("Chrome/54.0.2840.100").get();
                    subject.onNext(document);
                    return document;
                } catch (IOException e) {
                    e.printStackTrace();
                    subject.onError(e.getCause());
                    return null;
                }
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    private static void initData() {
        subject.observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Document>() {
            @Override
            public void call(Document document) {
                newSubject.onNext(DocParser.getSummaryList(document));
                tagSubject.onNext(DocParser.getTags(document));
                categorySubject.onNext(DocParser.getCategories(document));
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                newSubject.onError(throwable);
                tagSubject.onError(throwable);
                categorySubject.onError(throwable);
            }
        });
    }

}
