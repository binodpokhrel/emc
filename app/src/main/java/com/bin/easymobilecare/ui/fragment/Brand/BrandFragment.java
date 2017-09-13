package com.bin.easymobilecare.ui.fragment.Brand;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bin.easymobilecare.R;
import com.bin.easymobilecare.presenter.BrandPresenterImpl;
import com.bin.easymobilecare.presenter.pInterface.BrandPresenter;
import com.bin.easymobilecare.ui.coreUi.BaseFragment;
import com.bin.easymobilecare.ui.vInterface.IBrand;
import com.bin.easymobilecare.ui.vInterface.IBrandMainView;
import com.bin.easymobilecare.ui.viewAdapter.BrandCategoryAdapter;
import com.bin.easymobilecare.util.RecyclerSectionItemDecoration;
import com.bin.easymobilecare.viewModel.BrandCategoryViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by binodPokhrel on 7/14/17.
 */

public class BrandFragment extends BaseFragment<IBrandMainView,IBrand,BrandPresenter> implements IBrand{

    @BindView(R.id.brandRecyclerView)
    RecyclerView brandRecyclerView;

    @BindView(R.id.bannerViewFlipper)
    ViewFlipper bannerViewFlipper;

    int[] bannerImage = {R.drawable.banner1,R.drawable.banner2,R.drawable.banner3};

    RecyclerView.Adapter brandAdapter;
    List<BrandCategoryViewModel> viewModel = new ArrayList<>();

    public static BrandFragment newInstance(){
        BrandFragment brandFragment = new BrandFragment();
        Bundle args = new Bundle();
        brandFragment.setArguments(args);
        return brandFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_brand,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getBrand();
        for(int i = 0 ; i < bannerImage.length ; i++){
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(bannerImage[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            bannerViewFlipper.addView(imageView);
            Animation in = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            Animation out = AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right);
            bannerViewFlipper.setInAnimation(in);
            bannerViewFlipper.setOutAnimation(out);
            bannerViewFlipper.setFlipInterval(3000);
            bannerViewFlipper.setAutoStart(true);
        }
    }

    @Override
    public void setContext() {
        super.context = getActivity();
    }

    @Override
    public BrandPresenter createPresenter() {
        return new BrandPresenterImpl();
    }

    @Override
    public void onListChange(final List<BrandCategoryViewModel> viewModel) {
        this.viewModel = viewModel;
        brandRecyclerView.setHasFixedSize(true);
        brandRecyclerView.setLayoutManager( new LinearLayoutManager(context));

        brandAdapter = new BrandCategoryAdapter(getActivity(), viewModel);
        brandRecyclerView.setAdapter(brandAdapter);

        RecyclerSectionItemDecoration sectionItemDecoration = new RecyclerSectionItemDecoration(getResources().getDimensionPixelSize(R.dimen.headerHeight),
                true, getSectionCallback(viewModel));
        brandRecyclerView.addItemDecoration(sectionItemDecoration);
    }

    private RecyclerSectionItemDecoration.SectionCallback getSectionCallback(final List<BrandCategoryViewModel> viewModels) {
        return new RecyclerSectionItemDecoration.SectionCallback() {
            @Override
            public boolean isSection(int position) {
                return position == 0
                        || !Objects.equals(viewModels.get(position).getHeaderTitle(), viewModels.get(position - 1)
                        .getHeaderTitle());
            }

            @Override
            public String getSectionHeader(int position) {
                return viewModels.get(position)
                        .getHeaderTitle();
            }
        };

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof IBrandMainView){
            listner = (IBrandMainView)context;
        }else {
            throw new RuntimeException(context.toString()+"must implement IBrandMainView");
        }
    }

}
