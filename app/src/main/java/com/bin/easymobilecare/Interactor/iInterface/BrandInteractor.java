package com.bin.easymobilecare.Interactor.iInterface;

import com.bin.easymobilecare.ApiPojo.BrandCategoryResponse;

import java.util.List;

/**
 * Created by binodPokhrel on 7/6/17.
 */

public interface BrandInteractor {
    void success(List<BrandCategoryResponse> response);
    void onFailure(String message);
}
