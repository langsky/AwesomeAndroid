package io.tcl.hgl.awesomeandroid.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import io.tcl.hgl.awesomeandroid.databinding.HeaderTagBinding;
import io.tcl.hgl.awesomeandroid.databinding.ItemTagBinding;
import io.tcl.hgl.awesomeandroid.mvp.model.Tag;

/**
 * Created by swd1 on 16-12-30.
 */

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ItemView> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private Context context;
    private List<Tag> tagList;

    public TagAdapter(Context context, List<Tag> tagList) {
        this.context = context;
        this.tagList = tagList;
    }

    @Override
    public ItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_HEADER:
                view = HeaderTagBinding.inflate(LayoutInflater.from(context), parent, false).getRoot();
                return new ItemView(view, TYPE_HEADER);
            case TYPE_ITEM:
                view = ItemTagBinding.inflate(LayoutInflater.from(context), parent, false).getRoot();
                return new ItemView(view, TYPE_ITEM);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(ItemView holder, int position) {
        if (holder.viewType == TYPE_HEADER) {
            holder.headerTagBinding.setTitle("Tag");
            return;
        }
        holder.itemTagBinding.setTag(tagList.get(position - 1));
    }

    @Override
    public int getItemCount() {
        return tagList.size() + 1;
    }

    class ItemView extends RecyclerView.ViewHolder {
        int viewType;
        ItemTagBinding itemTagBinding;
        HeaderTagBinding headerTagBinding;

        ItemView(View itemView, int viewType) {
            super(itemView);
            this.viewType = viewType;
            switch (viewType) {
                case TYPE_HEADER:
                    headerTagBinding = DataBindingUtil.bind(itemView);
                    break;
                case TYPE_ITEM:
                    itemTagBinding = DataBindingUtil.bind(itemView);
                    break;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_HEADER;
        return TYPE_ITEM;
    }
}
