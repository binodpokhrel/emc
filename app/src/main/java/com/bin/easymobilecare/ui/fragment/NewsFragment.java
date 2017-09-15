package com.bin.easymobilecare.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bin.easymobilecare.R;
import com.bin.easymobilecare.presenter.NewsPresenterImpl;
import com.bin.easymobilecare.presenter.pInterface.NewsPresenter;
import com.bin.easymobilecare.ui.coreUi.BaseFragment;
import com.bin.easymobilecare.ui.vInterface.IBrandMainView;
import com.bin.easymobilecare.ui.vInterface.INewsFragment;


public class NewsFragment extends BaseFragment<IBrandMainView, INewsFragment, NewsPresenter> implements INewsFragment {


    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public NewsPresenter createPresenter() {
        return new NewsPresenterImpl();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setContext() {
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_, container, false);
    }

}
