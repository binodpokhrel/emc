package com.bin.easymobilecare.presenter.pInterface;

import com.bin.easymobilecare.ui.vInterface.LoginView;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

/**
 * Created by pranishshrestha on 5/1/17.
 */

public interface LoginPresenter extends MvpPresenter<LoginView> {

    void doLogin(String username, String password);

}
