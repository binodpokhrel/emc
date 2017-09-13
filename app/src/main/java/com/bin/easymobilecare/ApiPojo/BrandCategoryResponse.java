package com.bin.easymobilecare.ApiPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by binodPokhrel on 7/6/17.
 */

public class BrandCategoryResponse {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("subCat")
    @Expose
    private List<BrandSubCategory> subCat = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BrandSubCategory> getBrandSubCategory() {
        return subCat;
    }

    public void setBrandSubCategory(List<BrandSubCategory> subCat) {
        this.subCat = subCat;
    }

}
