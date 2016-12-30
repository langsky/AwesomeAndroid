package io.tcl.hgl.awesomeandroid.mvp.dragger;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gigamole.navigationtabbar.ntb.NavigationTabBar;

import java.util.ArrayList;
import java.util.Observer;

import io.tcl.hgl.awesomeandroid.R;
import io.tcl.hgl.awesomeandroid.adapter.MainAdapter;
import io.tcl.hgl.awesomeandroid.databinding.ActivityMainBinding;
import rx.Subscriber;
import rx.functions.Action1;
import rx.subjects.AsyncSubject;

public class MainActivity extends AppCompatActivity {

    MainAdapter adapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        adapter = new MainAdapter(getSupportFragmentManager(), this);
        binding.viewPager.setAdapter(adapter);
        binding.viewPager.setCurrentItem(0);
        binding.viewPager.setOffscreenPageLimit(5);

        initTabBar();
    }

    private void initTabBar() {
        final String[] colors = getResources().getStringArray(R.array.default_preview);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getDrawable(R.drawable.ic_new),
                        Color.parseColor(colors[0]))
                        .title("New")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getDrawable(R.drawable.ic_tag),
                        Color.parseColor(colors[1]))
                        .title("Tag")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getDrawable(R.drawable.ic_category),
                        Color.parseColor(colors[2]))
                        .title("Category")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getDrawable(R.drawable.ic_favor),
                        Color.parseColor(colors[3]))
                        .title("Favorite")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getDrawable(R.drawable.ic_about),
                        Color.parseColor(colors[4]))
                        .title("About")
                        .build()
        );
        binding.ntb.setViewPager(binding.viewPager, 0);
        binding.ntb.setModels(models);
    }


}
