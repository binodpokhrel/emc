package com.bin.easymobilecare.viewModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by binodPokhrel on 7/6/17.
 */

public class BrandCategoryViewModel implements Serializable{

    private String headerTitle;
    private List<BrandSubCatViewModel> subCatImage;

    public List<BrandSubCatViewModel> getSubCatImage() {
        return subCatImage;
    }

    public void setSubCatImage(List<BrandSubCatViewModel> subCatImage) {
        this.subCatImage = subCatImage;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }


}
