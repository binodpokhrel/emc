package com.bin.easymobilecare.ui.viewAdapter;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bin.easymobilecare.R;
import com.bin.easymobilecare.ui.activity.HomeActivity;
import com.bin.easymobilecare.ui.fragment.Brand.AllBrandItemListFragment;
import com.bin.easymobilecare.ui.viewAdapter.viewHolder.BrandCategoryViewHolder;
import com.bin.easymobilecare.util.listener.OnItemClickListener;
import com.bin.easymobilecare.viewModel.BrandCategoryViewModel;

import java.util.List;

/**
 * Created by binodPokhrel on 7/6/17.
 */

public class BrandCategoryAdapter extends RecyclerView.Adapter<BrandCategoryViewHolder> {
    private OnItemClickListener listener;
    private Activity context;
    private List<BrandCategoryViewModel> brandViewModels;

    public BrandCategoryAdapter(Activity context, List<BrandCategoryViewModel> brandCategoryViewModels, OnItemClickListener listener) {
        this.context = context;
        this.brandViewModels = brandCategoryViewModels;
        this.listener = listener;
    }

    @Override
    public BrandCategoryViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.adapter_category_header, parent, false);
        return new BrandCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BrandCategoryViewHolder holder, int position) {
        final BrandCategoryViewModel categoryViewModel = brandViewModels.get(position);

        Log.e("OnBindParentPosition==", position + "");

        holder.headerTextView.setText(categoryViewModel.getHeaderTitle());
        holder.seeMoreResultsTextView.setText(String.format("see all %s", categoryViewModel.getHeaderTitle()));
        holder.categoryRecyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 9);
        holder.categoryRecyclerView.setLayoutManager(gridLayoutManager);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int size = categoryViewModel.getSubCatImage().size();
                return getCase(position, size);
            }
        });


        holder.seeMoreResultsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity) context).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.dataFragmentFrameLayout, AllBrandItemListFragment.create(categoryViewModel))
                        .addToBackStack(null)
                        .commit();
            }
        });

        BrandAdapter brandAdapter = new BrandAdapter(context, categoryViewModel.getSubCatImage(), listener);
        holder.categoryRecyclerView.setAdapter(brandAdapter);

        holder.categoryRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {

            }
        });
    }

    private int getCase(int position, int size) {
        int i = position % 5;
        int value = 9;
        switch (i) {
            case 0:
                value = 5;
              /*  if (position == size - 1)
                    value = 9;
                else
                    value = 5;*/
                break;
            case 1:
                value = 4;
                break;
            case 2:
               /* if (position == size - 1)
                    value = 9;
                else
                    value = 4;*/
                value = 4;
                break;
            case 3:
                value = 5;
                break;
            case 4:
                value = 9;
                break;
        }
        return value;
    }

    @Override
    public int getItemCount() {
        return brandViewModels.size();
    }

}
