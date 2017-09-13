package com.bin.easymobilecare.ui.vInterface;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by pranishshrestha on 5/1/17.
 */

public interface IView extends MvpView {

    void showToast(String message);

    void showLoading();

    void hideLoading();

}
