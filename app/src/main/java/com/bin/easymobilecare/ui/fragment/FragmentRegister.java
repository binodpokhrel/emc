package com.bin.easymobilecare.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bin.easymobilecare.R;
import com.bin.easymobilecare.presenter.RegisterPresenterImpl;
import com.bin.easymobilecare.presenter.pInterface.RegisterPresenter;
import com.bin.easymobilecare.ui.coreUi.BaseFragment;
import com.bin.easymobilecare.ui.vInterface.LoginMainView;
import com.bin.easymobilecare.ui.vInterface.RegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by binodPokhrel on 8/28/17.
 */

public class FragmentRegister extends BaseFragment<LoginMainView,RegisterView,RegisterPresenter> implements RegisterView{

    @BindView(R.id.backToLoginBtn)
    Button backToLoginScreen;

    public static FragmentRegister newInstance() {
        FragmentRegister fragment = new FragmentRegister();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void setContext() {
        super.context = getContext();
    }

    @Override
    public RegisterPresenter createPresenter() {
        return new RegisterPresenterImpl();
    }

    @OnClick(R.id.backToLoginBtn)
    public void navigationToLoingScreen(){
        listner.navigateToLoginScreen();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof LoginMainView){
            listner = (LoginMainView)context;
        }else {
            throw new RuntimeException(context.toString()+"Must implement LoginMainView");
        }
    }
}
