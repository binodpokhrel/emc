package com.bin.easymobilecare.ui.viewAdapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bin.easymobilecare.R;
import com.bin.easymobilecare.ui.viewAdapter.viewHolder.AllBrandItemViewHolder;
import com.bin.easymobilecare.util.constants.ApiConstants;
import com.bin.easymobilecare.util.listener.OnItemClickListner;
import com.bin.easymobilecare.viewModel.BrandSubCatViewModel;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.List;

/**
 * Created by binodPokhrel on 7/27/17.
 */

public class AllBrandItemAdapter extends RecyclerView.Adapter<AllBrandItemViewHolder>{
    Activity context;
    private List<BrandSubCatViewModel> brandViewModels;
    public final OnItemClickListner clickListener;

    public AllBrandItemAdapter(Activity context, List<BrandSubCatViewModel> brandViewModels,OnItemClickListner clickListener) {
        this.context = context;
        this.brandViewModels = brandViewModels;
        this.clickListener = clickListener;
        configImageLoader();
    }

    @Override
    public AllBrandItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_allbrand_items,parent,false);
        return new AllBrandItemViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(AllBrandItemViewHolder holder, int position) {
        AllBrandItemViewHolder viewHolder = holder;
        BrandSubCatViewModel brandSubCatViewModel = brandViewModels.get(position);
        String imageUri = brandSubCatViewModel.getBrandImage();
        viewHolder.deviceAmountTextView.setText("Rs. "+brandSubCatViewModel.getItemCostAmount());
        viewHolder.deviceNameTextView.setText(brandSubCatViewModel.getItemName());
        viewHolder.deviceStatusTextView.setText(brandSubCatViewModel.getGeneralStatus());

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(ApiConstants.IMAGE_URL + imageUri, viewHolder.bannerImageView);
    }

    private void configImageLoader() {
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisk(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
    }

    @Override
    public int getItemCount() {
        return brandViewModels.size();
    }

}
