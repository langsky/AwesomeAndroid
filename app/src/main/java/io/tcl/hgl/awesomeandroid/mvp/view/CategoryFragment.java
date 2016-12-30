package io.tcl.hgl.awesomeandroid.mvp.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.tcl.hgl.awesomeandroid.databinding.FragmentCategoryBinding;
import io.tcl.hgl.awesomeandroid.databinding.FragmentTagBinding;
import io.tcl.hgl.awesomeandroid.mvp.view.abs.IReView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements IReView {

    private static final String TAG = "CategoryFragment";

    private FragmentCategoryBinding binding;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void setReAdapter(RecyclerView.Adapter adapter) {
        binding.setAdapter(adapter);
    }

    @Override
    public void setReLayoutManager(RecyclerView.LayoutManager manager) {
        binding.setManager(manager);
    }

    @Override
    public void begin() {

    }

    @Override
    public void ongoing() {

    }

    @Override
    public void end() {

    }

    @Override
    public void error(String e) {

    }
}
