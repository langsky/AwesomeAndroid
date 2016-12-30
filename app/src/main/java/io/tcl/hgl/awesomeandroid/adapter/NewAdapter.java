package io.tcl.hgl.awesomeandroid.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.tcl.hgl.awesomeandroid.databinding.ItemSummaryBinding;
import io.tcl.hgl.awesomeandroid.mvp.model.ItemSummary;

/**
 * Created by swd1 on 16-12-30.
 */

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ItemView> {


    private Context context;
    private List<ItemSummary> summaryList;

    public NewAdapter(Context context, List<ItemSummary> summaries) {
        this.context = context;
        this.summaryList = summaries;
    }


    @Override
    public ItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = ItemSummaryBinding.inflate(LayoutInflater.from(context), parent, false).getRoot();
        return new ItemView(v);
    }

    @Override
    public void onBindViewHolder(ItemView holder, int position) {
        holder.binding.setItem(summaryList.get(position));
    }

    @Override
    public int getItemCount() {
        return summaryList.size();
    }


    class ItemView extends RecyclerView.ViewHolder {

        ItemSummaryBinding binding;

        ItemView(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView); //caution
        }

    }
}
