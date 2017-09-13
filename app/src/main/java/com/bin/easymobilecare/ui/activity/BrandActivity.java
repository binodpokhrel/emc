package com.bin.easymobilecare.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import com.bin.easymobilecare.R;
import com.bin.easymobilecare.presenter.BrandMainPresenterImpl;
import com.bin.easymobilecare.presenter.pInterface.BrandMainPresenter;
import com.bin.easymobilecare.ui.coreUi.BaseActivity;
import com.bin.easymobilecare.ui.fragment.Brand.BrandFragment;
import com.bin.easymobilecare.ui.vInterface.IBrandMainView;
import butterknife.ButterKnife;

public class BrandActivity extends BaseActivity<IBrandMainView,BrandMainPresenter> implements IBrandMainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);
        ButterKnife.bind(this);
        presenter.navigationToBrandFragScreen();
    }

    @NonNull
    @Override
    public BrandMainPresenter createPresenter() {
        return new BrandMainPresenterImpl();
    }

    @Override
    public void setContext() {
        super.context=this;
    }

    @Override
    public void navigateToBrandFragment() {
        Fragment brandFragment = BrandFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.brand_container, brandFragment).commit();
    }
}
