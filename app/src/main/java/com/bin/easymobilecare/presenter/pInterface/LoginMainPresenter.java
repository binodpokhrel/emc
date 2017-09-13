package com.bin.easymobilecare.presenter.pInterface;

import com.bin.easymobilecare.ui.vInterface.LoginMainView;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

/**
 * Created by pranishshrestha on 5/1/17.
 */

public interface LoginMainPresenter extends MvpPresenter<LoginMainView> {

    void checkLoginSession();

}
