package com.bin.easymobilecare.ui.fragment.Brand;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bin.easymobilecare.R;
import com.bin.easymobilecare.ui.coreUi.BaseFragment;
import com.bin.easymobilecare.ui.vInterface.IBrandMainView;
import com.bin.easymobilecare.ui.vInterface.IView;
import com.bin.easymobilecare.ui.viewAdapter.AllBrandItemAdapter;
import com.bin.easymobilecare.util.DetailsTransition;
import com.bin.easymobilecare.util.listener.OnItemClickListener;
import com.bin.easymobilecare.viewModel.BrandCategoryViewModel;
import com.bin.easymobilecare.viewModel.BrandSubCatViewModel;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bin.easymobilecare.util.constants.TrainsitionConstant.DATA_TRANSITION_NAME;

/**
 * Created by binodPokhrel on 7/27/17.
 */

public class AllBrandItemListFragment extends BaseFragment<IBrandMainView, IView, MvpPresenter<IView>> implements IView, OnItemClickListener {

    @BindView(R.id.listAllbrandItemsRecyclerView)
    RecyclerView listAllBrandItem;

    public static AllBrandItemListFragment create(BrandCategoryViewModel categoryViewModel) {
        AllBrandItemListFragment fragment = new AllBrandItemListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DATA_TRANSITION_NAME, categoryViewModel);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_allbrand_item, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public MvpBasePresenter createPresenter() {
        return new MvpBasePresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BrandCategoryViewModel brandCategoryViewModel = (BrandCategoryViewModel) getArguments().getSerializable(DATA_TRANSITION_NAME);
        AllBrandItemAdapter adapter = new AllBrandItemAdapter(getActivity(), brandCategoryViewModel.getSubCatImage(), this);
        listAllBrandItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        listAllBrandItem.setAdapter(adapter);
    }

    @Override
    public void setContext() {
        super.context = getActivity();
    }

    public void showTargetFragment(ImageView forImageView, BrandSubCatViewModel subCatViewModel) {
        String transitionName = ViewCompat.getTransitionName(forImageView);
        BrandDetailFragment fragment = BrandDetailFragment.create(transitionName, subCatViewModel);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            showTargetFragmentLollipop(fragment, forImageView);
            return;
        }
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.dataFragmentFrameLayout, fragment)
                .addToBackStack("")
                .commit();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void showTargetFragmentLollipop(BrandDetailFragment fragment, ImageView forImageView) {
        fragment.setSharedElementEnterTransition(new DetailsTransition());
        fragment.setEnterTransition(new Fade());
        setExitTransition(new Fade());
        fragment.setSharedElementReturnTransition(new DetailsTransition());

        String transitionName = ViewCompat.getTransitionName(forImageView);
        getFragmentManager()
                .beginTransaction()
                .addSharedElement(forImageView, transitionName)
                .replace(R.id.dataFragmentFrameLayout, fragment)
                .addToBackStack("")
                .commit();
    }

    @Override
    public void onItemClick(ImageView imageView, BrandSubCatViewModel subCatViewModel) {
        showTargetFragment(imageView, subCatViewModel);
    }
}


