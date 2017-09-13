package com.bin.easymobilecare.ui.viewAdapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bin.easymobilecare.R;
import com.bin.easymobilecare.ui.viewAdapter.viewHolder.BrandViewHolder;
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
 * Created by binodPokhrel on 7/6/17.
 */

public class BrandAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Activity context;
    private List<BrandSubCatViewModel> brandViewModels;
    public final OnItemClickListner clickListener;

    public BrandAdapter(Activity context, List<BrandSubCatViewModel> brandCategoryViewModels,OnItemClickListner clickListener) {
        this.context = context;
        this.brandViewModels = brandCategoryViewModels;
        this.clickListener = clickListener;
        configImageLoader();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.adapter_brand, parent, false);
        return new BrandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final BrandViewHolder viewHolder = (BrandViewHolder) holder;
        BrandSubCatViewModel brandSubCatViewModel = brandViewModels.get(position);
        String imageUri = brandSubCatViewModel.getBrandImage();
        viewHolder.catNameTextView.setText(brandSubCatViewModel.getCatName());
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(ApiConstants.IMAGE_URL + imageUri, viewHolder.ivItemGridImage);

        viewHolder.ivItemGridImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(position,viewHolder.ivItemGridImage);

                Log.e("BrandAdapter===",position+"");
            }
        });
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
        int size = brandViewModels.size();
        if (size > 5)
            return 5;
        else
            return size;
    }

}
