package com.bin.easymobilecare.ui.coreUi;

import android.content.Context;
import android.os.Bundle;

import com.bin.easymobilecare.ui.vInterface.IView;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by pranishshrestha on 5/1/17.
 */

public abstract class BaseFragment<L extends MvpView,V extends MvpView, P extends MvpPresenter<V>> extends MvpFragment<V, P> implements IView {
    public Context context;
    public L listner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContext();
    }

    public abstract void setContext();

    @Override
    public void showToast(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
