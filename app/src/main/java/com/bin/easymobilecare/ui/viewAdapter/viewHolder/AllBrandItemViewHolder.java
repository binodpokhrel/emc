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

public class AllBrandItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.bannerImageView)
    public ImageView bannerImageView;

    @BindView(R.id.amountTextView)
    public TextView deviceAmountTextView;

    @BindView(R.id.deviceNameTextView)
    public TextView deviceNameTextView;

    @BindView(R.id.statusTextView)
    public TextView deviceStatusTextView;

    public AllBrandItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
