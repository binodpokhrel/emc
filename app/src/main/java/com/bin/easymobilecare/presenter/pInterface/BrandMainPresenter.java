package com.bin.easymobilecare.presenter.pInterface;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.bin.easymobilecare.ui.vInterface.IBrandMainView;

/**
 * Created by binodPokhrel on 7/18/17.
 */

public interface BrandMainPresenter extends MvpPresenter<IBrandMainView> {

    void navigationToBrandFragScreen();
}
