package com.bin.easymobilecare.ui.viewAdapter.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bin.easymobilecare.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by binodPokhrel on 7/6/17.
 */

public class BrandCategoryViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.headerTextView)
    public TextView headerTextView;

    @BindView(R.id.brandCategoryRecyclerView)
    public RecyclerView categoryRecyclerView;

    @BindView(R.id.seeMoreResultsTextView)
    public TextView seeMoreResultsTextView;

    public BrandCategoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
