package com.bin.easymobilecare.util.listener;

import android.widget.ImageView;

import com.bin.easymobilecare.viewModel.BrandSubCatViewModel;

/**
 * Created by binodPokhrel on 7/25/17.
 */

public interface OnItemClickListener {
    void onItemClick(ImageView imageView, BrandSubCatViewModel subCatViewModel);
}
