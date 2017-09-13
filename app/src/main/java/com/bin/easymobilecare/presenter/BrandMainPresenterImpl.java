package com.bin.easymobilecare.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.bin.easymobilecare.presenter.pInterface.BrandMainPresenter;
import com.bin.easymobilecare.ui.vInterface.IBrandMainView;

/**
 * Created by binodPokhrel on 7/18/17.
 */

public class BrandMainPresenterImpl extends MvpBasePresenter<IBrandMainView> implements BrandMainPresenter{

    @Override
    public void navigationToBrandFragScreen() {
        getView().navigateToBrandFragment();
    }
}
