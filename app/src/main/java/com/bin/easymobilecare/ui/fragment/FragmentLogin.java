package com.bin.easymobilecare.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bin.easymobilecare.R;
import com.bin.easymobilecare.presenter.LoginPresenterImpl;
import com.bin.easymobilecare.presenter.pInterface.LoginPresenter;
import com.bin.easymobilecare.ui.coreUi.BaseFragment;
import com.bin.easymobilecare.ui.vInterface.LoginMainView;
import com.bin.easymobilecare.ui.vInterface.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pranishshrestha on 5/1/17.
 */
public class FragmentLogin extends BaseFragment<LoginMainView,LoginView, LoginPresenter>implements LoginView {

    @BindView (R.id.loginSkipTextView)
    TextView loginScreenSkipTextViewBtn;

    @BindView(R.id.insertUserNameEditText)
    EditText insertUserName;

    @BindView(R.id.insertPasswordEditText)
    EditText insertPassword;

    @BindView(R.id.loginBtn)
    Button loginBtn;

    public static FragmentLogin newInstance() {
        FragmentLogin fragment = new FragmentLogin();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenterImpl();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void setContext() {
        super.context = getContext();
    }

    @Override
    public void onResume() {
       // AnalyticsUtil.addView(context, AnalyticsConstants.SCR_FRAGMENT_LOGIN);
        super.onResume();
    }

    @OnClick (R.id.loginBtn)
    public void loginBtn(){
        presenter.doLogin(insertUserName.getText().toString(),insertPassword.getText().toString());

//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setEmail(insertUserName.getText().toString());
//        loginRequest.setPassword(insertPassword.getText().toString());
//        presenter.doLogin(loginRequest);
    }

    @OnClick(R.id.signupBtn)
    public void navigateToRegisterScreen(){
        listner.navigateToSignupScreen();
    }

    @OnClick(R.id.loginSkipTextView)
    public void navigatgeToBrandScreen(){
        listner.navigateToBrandScreen();
    }

    @Override
    public void showError() {

    }

    @Override
    public void loginSuccessful() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof LoginMainView){
            listner = (LoginMainView)context;
        }else {
            throw new RuntimeException(context.toString()+" must implement LoginMainView");
        }
    }
}
