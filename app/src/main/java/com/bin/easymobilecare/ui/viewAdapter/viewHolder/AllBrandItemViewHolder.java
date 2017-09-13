package com.bin.easymobilecare.ui.viewAdapter.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bin.easymobilecare.R;
import com.bin.easymobilecare.ui.viewAdapter.AllBrandItemAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by binodPokhrel on 7/27/17.
 */

public class AllBrandItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.bannerImageView)
    public ImageView bannerImageView;

    @BindView(R.id.amountTextView)
    public TextView deviceAmountTextView;

    @BindView(R.id.deviceNameTextView)
    public TextView deviceNameTextView;

    @BindView(R.id.statusTextView)
    public TextView deviceStatusTextView;

    private AllBrandItemAdapter adapter;

    public AllBrandItemViewHolder(View itemView,AllBrandItemAdapter adapter) {
        super(itemView);
        this.adapter = adapter;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (adapter != null && adapter.clickListener != null) {
            adapter.clickListener.onItemClick(getAdapterPosition(), bannerImageView);
        }
    }
}
