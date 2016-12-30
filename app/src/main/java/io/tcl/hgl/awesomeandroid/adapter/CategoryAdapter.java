package io.tcl.hgl.awesomeandroid.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.tcl.hgl.awesomeandroid.databinding.HeaderCategoryBinding;
import io.tcl.hgl.awesomeandroid.databinding.ItemCategoryBinding;
import io.tcl.hgl.awesomeandroid.mvp.model.Category;


/**
 * Created by swd1 on 16-12-30.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ItemView> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private Context context;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @Override
    public ItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_HEADER:
                view = HeaderCategoryBinding.inflate(LayoutInflater.from(context), parent, false).getRoot();
                return new ItemView(view, TYPE_HEADER);
            case TYPE_ITEM:
                view = ItemCategoryBinding.inflate(LayoutInflater.from(context), parent, false).getRoot();
                return new ItemView(view, TYPE_ITEM);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(ItemView holder, int position) {
        if (holder.viewType == TYPE_HEADER) {
            holder.headerCategoryBinding.setTitle("Category");
            return;
        }
        holder.itemCategoryBinding.setCategory(categoryList.get(position - 1));
    }

    @Override
    public int getItemCount() {
        return categoryList.size() + 1;
    }

    class ItemView extends RecyclerView.ViewHolder {
        int viewType;
        ItemCategoryBinding itemCategoryBinding;
        HeaderCategoryBinding headerCategoryBinding;

        ItemView(View itemView, int viewType) {
            super(itemView);
            this.viewType = viewType;
            switch (viewType) {
                case TYPE_HEADER:
                    headerCategoryBinding = DataBindingUtil.bind(itemView);
                    break;
                case TYPE_ITEM:
                    itemCategoryBinding = DataBindingUtil.bind(itemView);
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
