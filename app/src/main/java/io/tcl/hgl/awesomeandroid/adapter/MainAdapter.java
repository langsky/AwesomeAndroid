package io.tcl.hgl.awesomeandroid.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import io.tcl.hgl.awesomeandroid.mvp.presenter.CategoryPresenter;
import io.tcl.hgl.awesomeandroid.mvp.presenter.NewPresenter;
import io.tcl.hgl.awesomeandroid.mvp.presenter.TagPresenter;
import io.tcl.hgl.awesomeandroid.mvp.view.AboutFragment;
import io.tcl.hgl.awesomeandroid.mvp.view.CategoryFragment;
import io.tcl.hgl.awesomeandroid.mvp.view.FavorFragment;
import io.tcl.hgl.awesomeandroid.mvp.view.NewFragment;
import io.tcl.hgl.awesomeandroid.mvp.view.TagFragment;
import io.tcl.hgl.awesomeandroid.mvp.view.abs.IView;

/**
 * Created by swd1 on 16-12-30.
 */

public class MainAdapter extends FragmentStatePagerAdapter {

    private NewPresenter newPresenter;
    private TagPresenter tagPresenter;
    private CategoryPresenter categoryPresenter;

    public MainAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.newPresenter = new NewPresenter(context);
        this.tagPresenter = new TagPresenter(context);
        this.categoryPresenter = new CategoryPresenter(context);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            default:
            case 0:
                fragment = new NewFragment();
                newPresenter.bindView((IView) fragment);
                newPresenter.initList();
                break;
            case 1:
                fragment = new TagFragment();
                tagPresenter.bindView((IView) fragment);
                tagPresenter.initList();
                break;
            case 2:
                fragment = new CategoryFragment();
                categoryPresenter.bindView((IView) fragment);
                categoryPresenter.initList();
                break;
            case 3:
                fragment = new FavorFragment();
                break;
            case 4:
                fragment = new AboutFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
