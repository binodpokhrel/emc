package com.bin.easymobilecare.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.bin.easymobilecare.R;
import com.bin.easymobilecare.presenter.LoginMainPresenterImpl;
import com.bin.easymobilecare.presenter.pInterface.LoginMainPresenter;
import com.bin.easymobilecare.ui.coreUi.BaseActivity;
import com.bin.easymobilecare.ui.fragment.FragmentLogin;
import com.bin.easymobilecare.ui.fragment.FragmentRegister;
import com.bin.easymobilecare.ui.vInterface.LoginMainView;

public class LoginActivity extends BaseActivity<LoginMainView, LoginMainPresenter> implements LoginMainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //checkLoginSession is the method of LoginMainPresenter which is exposed to its mainview(LoginActivity)
        presenter.checkLoginSession();
    }

    @NonNull
    @Override
    public LoginMainPresenter createPresenter() {
        return new LoginMainPresenterImpl();
    }

    @Override
    public void setContext() {
        super.context = this;
    }

    @Override
    public void navigateToLoginScreen() {
        Fragment fragmentLogin = FragmentLogin.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.login_container, fragmentLogin).commit();
    }

    @Override
    public void navigateToBrandScreen() {
        startActivity(new Intent(this,HomeActivity.class));
        finish();
    }

    @Override
    public void navigateToSignupScreen() {
        Fragment fragmentRegister = FragmentRegister.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.login_container, fragmentRegister).commit();
    }

}
