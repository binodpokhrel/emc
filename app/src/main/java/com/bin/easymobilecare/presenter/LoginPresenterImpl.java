package com.bin.easymobilecare.presenter;

import com.bin.easymobilecare.ApiPojo.Login.LoginStatusResponse;
import com.bin.easymobilecare.Interactor.LoginInteractorImpl;
import com.bin.easymobilecare.Interactor.iInterface.LoginInteractor;
import com.bin.easymobilecare.presenter.pInterface.LoginPresenter;
import com.bin.easymobilecare.ui.vInterface.LoginView;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

/**
 * Created by pranishshrestha on 5/1/17.
 */

public class LoginPresenterImpl extends MvpBasePresenter<LoginView> implements LoginPresenter {

    @Override
    public void doLogin(String username, String password) {
        if (isViewAttached()) {
//            getView().showLoading();
            LoginInteractorImpl loginInteractor = new LoginInteractorImpl();
            loginInteractor.getLoginData(username, password, new LoginInteractor() {
                @Override
                public void success(LoginStatusResponse loginStatusResponse) {

                }

                @Override
                public void onFailure(String message) {

                }
            });
        }
    }

}
