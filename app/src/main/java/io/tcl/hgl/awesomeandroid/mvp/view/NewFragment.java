package io.tcl.hgl.awesomeandroid.mvp.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.tcl.hgl.awesomeandroid.adapter.NewAdapter;
import io.tcl.hgl.awesomeandroid.databinding.FragmentNewBinding;
import io.tcl.hgl.awesomeandroid.mvp.view.abs.IReView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewFragment extends Fragment implements IReView {

    private static final String TAG = "NewFragment";

    FragmentNewBinding binding;

    public NewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void begin() {
        Log.i(TAG, "Begin");
    }

    @Override
    public void ongoing() {
        Log.e(TAG, "ongoing");
    }

    @Override
    public void end() {
        Log.i(TAG, "end");
    }

    @Override
    public void error(String e) {
        Log.e(TAG, e);
    }

    @Override
    public void setReAdapter(RecyclerView.Adapter adapter) {
        binding.setAdapter((NewAdapter) adapter);
    }

    @Override
    public void setReLayoutManager(RecyclerView.LayoutManager manager) {
        binding.setLayoutManager(manager);
    }
}
