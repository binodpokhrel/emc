package com.bin.easymobilecare.ui.coreUi;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.bin.easymobilecare.ui.vInterface.IView;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by pranishshrestha on 5/1/17.
 */

public abstract class BaseActivity<V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V, P> implements IView {

    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContext();
    }

    /**
     * Call from onCreate method from all child classes
     */
    public abstract void setContext();

    @Override
    public void showToast(String message) {
        if (context != null)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
