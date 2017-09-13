package com.bin.easymobilecare.ui.vInterface;

import com.bin.easymobilecare.viewModel.BrandCategoryViewModel;

import java.util.List;

/**
 * Created by binodPokhrel on 7/6/17.
 */

public interface IBrand extends IView {

    void onListChange(List<BrandCategoryViewModel> viewModel);
}
