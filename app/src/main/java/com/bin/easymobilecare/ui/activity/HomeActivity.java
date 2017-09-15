package com.bin.easymobilecare.ui.activity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bin.easymobilecare.R;
import com.bin.easymobilecare.presenter.BrandMainPresenterImpl;
import com.bin.easymobilecare.presenter.pInterface.BrandMainPresenter;
import com.bin.easymobilecare.ui.coreUi.BaseActivity;
import com.bin.easymobilecare.ui.fragment.Brand.BrandFragment;
import com.bin.easymobilecare.ui.fragment.NewsFragment;
import com.bin.easymobilecare.ui.fragment.ProfileFragment;
import com.bin.easymobilecare.ui.fragment.RepairFragment;
import com.bin.easymobilecare.ui.fragment.ServiceFragment;
import com.bin.easymobilecare.ui.vInterface.IBrandMainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeActivity extends BaseActivity<IBrandMainView, BrandMainPresenter> implements IBrandMainView {

    @BindView(R.id.homeLinearLayout)
    LinearLayout homeLinearLayout;

    @BindView(R.id.serviceLinearLayout)
    LinearLayout serviceLinearLayout;

    @BindView(R.id.repairLinearLayout)
    LinearLayout repairLinearLayout;

    @BindView(R.id.newsLinearLayout)
    LinearLayout newsLinearLayout;

    @BindView(R.id.profileLinearLayout)
    LinearLayout profileLinearLayout;

    @BindView(R.id.homeImageView)
    ImageView homeImgaeView;

    @BindView(R.id.homeTextView)
    TextView homeTextView;

    @BindView(R.id.serviceImageView)
    ImageView serviceImageView;

    @BindView(R.id.serviceTextView)
    TextView serviceTextView;

    @BindView(R.id.repairImageView)
    ImageView repairImageView;

    @BindView(R.id.repairTextView)
    TextView repairTextView;

    @BindView(R.id.newsImageView)
    ImageView newsImageView;

    @BindView(R.id.newsTextView)
    TextView newsTextView;

    @BindView(R.id.profileImageView)
    ImageView profileImageView;

    @BindView(R.id.profileTextView)
    TextView profileTextView;

    int green;
    int gray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter.navigationToBrandFragScreen();

        green = ContextCompat.getColor(this, R.color.colorPrimaryDark);
        gray = ContextCompat.getColor(this, R.color.light_btn_gray);
        ButterKnife.bind(this);

        homeImgaeView.setColorFilter(green, PorterDuff.Mode.SRC_ATOP);
        homeTextView.setTextColor(green);

    }

    @NonNull
    @Override
    public BrandMainPresenter createPresenter() {
        return new BrandMainPresenterImpl();
    }

    @Override
    public void setContext() {
        super.context = this;
    }


    @OnClick({R.id.homeLinearLayout, R.id.serviceLinearLayout, R.id.repairLinearLayout, R.id.newsLinearLayout, R.id.profileLinearLayout})
    public void onLayoutClick(LinearLayout linearLayout) {
        switch (linearLayout.getId()) {
            case R.id.homeLinearLayout:
                homeImgaeView.setColorFilter(green, PorterDuff.Mode.SRC_ATOP);
                homeTextView.setTextColor(green);

                serviceImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                serviceTextView.setTextColor(gray);

                repairImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                repairTextView.setTextColor(gray);

                newsImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                newsTextView.setTextColor(gray);

                profileImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                profileTextView.setTextColor(gray);

                navigateToBrandFragment();

                break;
            case R.id.serviceLinearLayout:
                serviceImageView.setColorFilter(green, PorterDuff.Mode.SRC_ATOP);
                serviceTextView.setTextColor(green);

                homeImgaeView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                homeTextView.setTextColor(gray);

                repairImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                repairTextView.setTextColor(gray);

                newsImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                newsTextView.setTextColor(gray);

                profileImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                profileTextView.setTextColor(gray);

                navigateToServiceFragment();
                break;

            case R.id.repairLinearLayout:

                serviceImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                serviceTextView.setTextColor(gray);

                homeImgaeView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                homeTextView.setTextColor(gray);

                repairImageView.setColorFilter(green, PorterDuff.Mode.SRC_ATOP);
                repairTextView.setTextColor(green);

                newsImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                newsTextView.setTextColor(gray);

                profileImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                profileTextView.setTextColor(gray);

                navigateToRepairFragment();

                break;

            case R.id.newsLinearLayout:
                serviceImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                serviceTextView.setTextColor(gray);

                homeImgaeView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                homeTextView.setTextColor(gray);

                repairImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                repairTextView.setTextColor(gray);

                newsImageView.setColorFilter(green, PorterDuff.Mode.SRC_ATOP);
                newsTextView.setTextColor(green);

                profileImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                profileTextView.setTextColor(gray);

                navigateToNewsFragment();
                break;

            case R.id.profileLinearLayout:
                serviceImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                serviceTextView.setTextColor(gray);

                homeImgaeView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                homeTextView.setTextColor(gray);

                repairImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                repairTextView.setTextColor(gray);

                newsImageView.setColorFilter(gray, PorterDuff.Mode.SRC_ATOP);
                newsTextView.setTextColor(gray);

                profileImageView.setColorFilter(green, PorterDuff.Mode.SRC_ATOP);
                profileTextView.setTextColor(green);

                navigateToProfileFragment();
                break;
        }
    }

    @Override
    public void navigateToBrandFragment() {
        Fragment brandFragment = BrandFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.dataFragmentFrameLayout, brandFragment).commit();
    }

    @Override
    public void navigateToServiceFragment() {
        Fragment fragment = ServiceFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.dataFragmentFrameLayout, fragment).commit();
    }

    @Override
    public void navigateToRepairFragment() {
        Fragment fragment = RepairFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.dataFragmentFrameLayout, fragment).commit();
    }

    @Override
    public void navigateToNewsFragment() {
        Fragment fragment = NewsFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.dataFragmentFrameLayout, fragment).commit();
    }

    @Override
    public void navigateToProfileFragment() {
        Fragment fragment = ProfileFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.dataFragmentFrameLayout, fragment).commit();
    }
}
