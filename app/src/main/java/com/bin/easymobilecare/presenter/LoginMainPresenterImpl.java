package com.bin.easymobilecare.presenter;

import com.bin.easymobilecare.presenter.pInterface.LoginMainPresenter;
import com.bin.easymobilecare.ui.vInterface.LoginMainView;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

/**
 * Created by pranishshrestha on 5/1/17.
 */

public class LoginMainPresenterImpl extends MvpBasePresenter<LoginMainView> implements LoginMainPresenter {

    @Override
    public void checkLoginSession() {
        getView().navigateToLoginScreen();
    }

    @Override
    public void attachView(LoginMainView view) {
        super.attachView(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }

}
