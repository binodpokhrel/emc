package com.bin.easymobilecare.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bin.easymobilecare.R;
import com.bin.easymobilecare.presenter.RepairPresenterImpl;
import com.bin.easymobilecare.presenter.pInterface.RepairPresenter;
import com.bin.easymobilecare.ui.coreUi.BaseFragment;
import com.bin.easymobilecare.ui.vInterface.IBrandMainView;
import com.bin.easymobilecare.ui.vInterface.IRepairFragment;


public class RepairFragment extends BaseFragment<IBrandMainView, IRepairFragment, RepairPresenter> implements IRepairFragment {


    public static RepairFragment newInstance() {
        RepairFragment fragment = new RepairFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public RepairPresenter createPresenter() {
        return new RepairPresenterImpl();
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
