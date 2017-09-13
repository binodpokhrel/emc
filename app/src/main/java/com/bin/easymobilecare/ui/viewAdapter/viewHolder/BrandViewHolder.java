package com.bin.easymobilecare.ui.viewAdapter.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bin.easymobilecare.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by binodPokhrel on 7/6/17.
 */

public class BrandViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.ivItemGridImage)
    public ImageView ivItemGridImage;

    @BindView(R.id.catNameTextView)
    public TextView catNameTextView;

    public BrandViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}
