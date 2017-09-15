package com.bin.easymobilecare.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bin.easymobilecare.R;
import com.bin.easymobilecare.presenter.ProfilePresenterImpl;
import com.bin.easymobilecare.presenter.pInterface.ProfilePresenter;
import com.bin.easymobilecare.ui.coreUi.BaseFragment;
import com.bin.easymobilecare.ui.vInterface.IBrandMainView;
import com.bin.easymobilecare.ui.vInterface.IProfileFragment;


public class ProfileFragment extends BaseFragment<IBrandMainView, IProfileFragment, ProfilePresenter> implements IProfileFragment {


    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public ProfilePresenter createPresenter() {
        return new ProfilePresenterImpl();
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
