package com.bin.easymobilecare.ui.fragment.Brand;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bin.easymobilecare.ui.vInterface.IBrandMainView;
import com.bin.easymobilecare.util.constants.ApiConstants;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.bin.easymobilecare.R;
import com.bin.easymobilecare.ui.coreUi.BaseFragment;
import com.bin.easymobilecare.ui.vInterface.IView;
import com.bin.easymobilecare.viewModel.BrandSubCatViewModel;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by binodPokhrel on 7/30/17.
 */

public class BrandDetailFragment extends BaseFragment<IBrandMainView,IView, MvpPresenter<IView>> implements IView, View.OnClickListener {

    private final static String DETAIL_ITEMS_TRANSITION_VIEW_NAME = "data_name";
    private final static String TRANSITION_VIEW_NAME = "trans_name";

    @Nullable
    @BindView(R.id.generalInfoLinearLayout)
    LinearLayout generalInfoLinearLayout;

    @BindView(R.id.generalInfoImageView)
    ImageView generalInfoImageView;

    @BindView(R.id.detailBrandImageView)
    ImageView detailBrandImageView;

    @BindView(R.id.detailBrandItemPriceTextView)
    TextView detailBrandItemPriceTextView;

    @BindView(R.id.detailBrandItemNameTextView)
    TextView detailBrandItemNameTextView;

    @BindView(R.id.detailBrandRamTextView)
    TextView detailBrandRamTextView;

    @BindView(R.id.detailBrandCameraTextView)
    TextView detailBrandCameraTextView;

    @BindView(R.id.detailBrandTalkTimeTextView)
    TextView detailBrandTalkTimeTextView;

    @BindView(R.id.itemDetailInfo)
    TextView itemDetailInfo;

    @BindView(R.id.harwareAndSoftwareImageView)
    ImageView hardwareAndSoftwareImageView;

    @BindView(R.id.displayImageView)
    ImageView displayImageView;

    @BindView(R.id.multimediaImageView)
    ImageView multimediaImageView;

    @BindView(R.id.cameraImageView)
    ImageView cameraImageView;

    @BindView(R.id.connectivityImageView)
    ImageView connectivityImageView;

    @BindView(R.id.userMemoryImageView)
    ImageView userMemoryImageView;

    @BindView(R.id.batteryImageView)
    ImageView batteryImageView;

    @BindView(R.id.importantAppImageView)
    ImageView importantAppImageView;

    @BindView(R.id.generalId)
    View generalView;

    @BindView(R.id.hSoftwareId)
    View hardwareSoftwareView;

    @BindView(R.id.displayId)
    View displayView;

    @BindView(R.id.multimediaId)
    View multimediaView;

    @BindView(R.id.cameraId)
    View cameraView;

    @BindView(R.id.connectivityId)
    View connectivityView;

    @BindView(R.id.memoryId)
    View memoryView;

    @BindView(R.id.batteryId)
    View batteryView;

    @BindView(R.id.importantAppsId)
    View importantAppView;

    ValueAnimator mAnimator;

    public static BrandDetailFragment create(String transitionName, BrandSubCatViewModel categoryViewModel) {
        BrandDetailFragment fragment = new BrandDetailFragment();
        Bundle args = new Bundle();
        args.putString(TRANSITION_VIEW_NAME, transitionName);
        args.putSerializable(DETAIL_ITEMS_TRANSITION_VIEW_NAME, categoryViewModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detailpage, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setTheSeralizeData();
        generalInfoImageView.setOnClickListener(this);
        hardwareAndSoftwareImageView.setOnClickListener(this);
        displayImageView.setOnClickListener(this);
        multimediaImageView.setOnClickListener(this);
        cameraImageView.setOnClickListener(this);
        connectivityImageView.setOnClickListener(this);
        userMemoryImageView.setOnClickListener(this);
        batteryImageView.setOnClickListener(this);
        importantAppImageView.setOnClickListener(this);
//        setSlideAnimation();
    }

    @Override
    public void setContext() {
        super.context = getActivity();
    }

    @Override
    public MvpBasePresenter createPresenter() {
        return new MvpBasePresenter();
    }

    private void setTheSeralizeData() {
        BrandSubCatViewModel brandSubCatViewModel = (BrandSubCatViewModel) getArguments().getSerializable(DETAIL_ITEMS_TRANSITION_VIEW_NAME);

        assert brandSubCatViewModel != null;
        String brandImage = brandSubCatViewModel.getBrandImage();

        detailBrandItemPriceTextView.setText(String.format(" Rs. %s", brandSubCatViewModel.getItemCostAmount()));
        detailBrandItemNameTextView.setText(brandSubCatViewModel.getCatName() + " " + brandSubCatViewModel.getGeneralStatus());
        detailBrandRamTextView.setText(String.format("Ram\n%s", brandSubCatViewModel.getHardwareRAM()));
        detailBrandCameraTextView.setText(String.format("Rear Camera\n%s", brandSubCatViewModel.getCameraMegaPixel()));
        detailBrandTalkTimeTextView.setText(String.format("Talk Time\n%s", brandSubCatViewModel.getBatteryTalktime()));

        itemDetailInfo.setText("Front Camera :" + brandSubCatViewModel.getCameraSecondary() + "\nStandby Time  :" + brandSubCatViewModel.getBatteryStandby()
                + "\nFM :" + brandSubCatViewModel.getMultimediaRadio() + "\nCapacity :" + brandSubCatViewModel.getBatteryCapacity());

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(ApiConstants.IMAGE_URL + brandImage, detailBrandImageView);
    }

    private void setSlideAnimation() {
        generalInfoLinearLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                generalInfoLinearLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                generalInfoLinearLayout.setVisibility(View.GONE);

                final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                generalInfoLinearLayout.measure(widthSpec, heightSpec);

                mAnimator = slideAnimator(0, generalInfoLinearLayout.getMeasuredHeight(), generalInfoLinearLayout);
                return false;
            }
        });
    }

    private void expand(final View view) {
        //set Visible
        view.setVisibility(View.VISIBLE);//generalInfoLinearLayout

		/* Remove and used in preDrawListener
        final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		mLinearLayout.measure(widthSpec, heightSpec);
		mAnimator = slideAnimator(0, mLinearLayout.getMeasuredHeight());
		*/

        mAnimator.start();
    }

    private void collapse(final View view) {
        int finalHeight = view.getHeight();//generalInfoLinearLayout

        ValueAnimator mAnimator = slideAnimator(finalHeight, 0, view);

        mAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationEnd(Animator animator) {
                //Height=0, but it set visibility to GONE
                view.setVisibility(View.GONE);//generalInfoLinearLayout
            }

            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
        mAnimator.start();
    }

    private ValueAnimator slideAnimator(int start, int end, final View view) {

        ValueAnimator animator = ValueAnimator.ofInt(start, end);


        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //Update Height
                int value = (Integer) valueAnimator.getAnimatedValue();

                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();//generalInfoLinearLayout
                layoutParams.height = value;
                view.setLayoutParams(layoutParams);//generalInfoLinearLayout
            }
        });
        return animator;
    }

    @Override
    public void onClick(View view) {
        switch (view.getTag().toString()) {
            case "1":
                if (generalView.getVisibility() == View.GONE) {
                    hardwareSoftwareView.setVisibility(View.GONE);
                    displayView.setVisibility(View.GONE);
                    multimediaView.setVisibility(View.GONE);
                    cameraView.setVisibility(View.GONE);
                    connectivityView.setVisibility(View.GONE);
                    memoryView.setVisibility(View.GONE);
                    batteryView.setVisibility(View.GONE);
                    importantAppView.setVisibility(View.GONE);
                    generalView.setVisibility(View.VISIBLE);
                } else {
                    generalView.setVisibility(View.GONE);
                }

                break;
            case "2":
                if (hardwareSoftwareView.getVisibility() == View.GONE) {
                    displayView.setVisibility(View.GONE);
                    multimediaView.setVisibility(View.GONE);
                    cameraView.setVisibility(View.GONE);
                    connectivityView.setVisibility(View.GONE);
                    memoryView.setVisibility(View.GONE);
                    batteryView.setVisibility(View.GONE);
                    importantAppView.setVisibility(View.GONE);
                    generalView.setVisibility(View.GONE);

                    hardwareSoftwareView.setVisibility(View.VISIBLE);
                } else {
                    hardwareSoftwareView.setVisibility(View.GONE);
                }
                break;

            case "3":
                if (displayView.getVisibility() == View.GONE) {
                    hardwareSoftwareView.setVisibility(View.GONE);
                    multimediaView.setVisibility(View.GONE);
                    cameraView.setVisibility(View.GONE);
                    connectivityView.setVisibility(View.GONE);
                    memoryView.setVisibility(View.GONE);
                    batteryView.setVisibility(View.GONE);
                    importantAppView.setVisibility(View.GONE);
                    generalView.setVisibility(View.GONE);

                    displayView.setVisibility(View.VISIBLE);
                } else {
                    displayView.setVisibility(View.GONE);
                }
                break;

            case "4":
                if (multimediaView.getVisibility() == View.GONE) {
                    hardwareSoftwareView.setVisibility(View.GONE);
                    displayView.setVisibility(View.GONE);
                    multimediaView.setVisibility(View.GONE);
                    cameraView.setVisibility(View.GONE);
                    connectivityView.setVisibility(View.GONE);
                    memoryView.setVisibility(View.GONE);
                    batteryView.setVisibility(View.GONE);
                    importantAppView.setVisibility(View.GONE);
                    generalView.setVisibility(View.GONE);

                    multimediaView.setVisibility(View.VISIBLE);
                } else {
                    multimediaView.setVisibility(View.GONE);
                }
                break;

            case "5":
                if (cameraView.getVisibility() == View.GONE) {
                    hardwareSoftwareView.setVisibility(View.GONE);
                    displayView.setVisibility(View.GONE);
                    multimediaView.setVisibility(View.GONE);
                    connectivityView.setVisibility(View.GONE);
                    memoryView.setVisibility(View.GONE);
                    batteryView.setVisibility(View.GONE);
                    importantAppView.setVisibility(View.GONE);
                    generalView.setVisibility(View.GONE);

                    cameraView.setVisibility(View.VISIBLE);
                } else {
                    cameraView.setVisibility(View.GONE);
                }
                break;

            case "6":
                if (connectivityView.getVisibility() == View.GONE) {
                    hardwareSoftwareView.setVisibility(View.GONE);
                    displayView.setVisibility(View.GONE);
                    multimediaView.setVisibility(View.GONE);
                    cameraView.setVisibility(View.GONE);
                    memoryView.setVisibility(View.GONE);
                    batteryView.setVisibility(View.GONE);
                    importantAppView.setVisibility(View.GONE);
                    generalView.setVisibility(View.GONE);

                    connectivityView.setVisibility(View.VISIBLE);
                } else {
                    connectivityView.setVisibility(View.GONE);
                }
                break;

            case "7":
                if (memoryView.getVisibility() == View.GONE) {
                    hardwareSoftwareView.setVisibility(View.GONE);
                    displayView.setVisibility(View.GONE);
                    multimediaView.setVisibility(View.GONE);
                    cameraView.setVisibility(View.GONE);
                    connectivityView.setVisibility(View.GONE);
                    batteryView.setVisibility(View.GONE);
                    importantAppView.setVisibility(View.GONE);
                    generalView.setVisibility(View.GONE);

                    memoryView.setVisibility(View.VISIBLE);
                } else {
                    memoryView.setVisibility(View.GONE);
                }
                break;

            case "8":
                if (batteryView.getVisibility() == View.GONE) {
                    hardwareSoftwareView.setVisibility(View.GONE);
                    displayView.setVisibility(View.GONE);
                    multimediaView.setVisibility(View.GONE);
                    cameraView.setVisibility(View.GONE);
                    connectivityView.setVisibility(View.GONE);
                    memoryView.setVisibility(View.GONE);
                    importantAppView.setVisibility(View.GONE);
                    generalView.setVisibility(View.GONE);

                    batteryView.setVisibility(View.VISIBLE);
                } else {
                    batteryView.setVisibility(View.GONE);
                }
                break;

            case "9":
                if (importantAppView.getVisibility() == View.GONE) {
                    hardwareSoftwareView.setVisibility(View.GONE);
                    displayView.setVisibility(View.GONE);
                    multimediaView.setVisibility(View.GONE);
                    cameraView.setVisibility(View.GONE);
                    connectivityView.setVisibility(View.GONE);
                    memoryView.setVisibility(View.GONE);
                    batteryView.setVisibility(View.GONE);
                    generalView.setVisibility(View.GONE);

                    importantAppView.setVisibility(View.VISIBLE);
                } else {
                    importantAppView.setVisibility(View.GONE);
                }
                break;
        }


    }
}
