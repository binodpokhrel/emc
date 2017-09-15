package com.bin.easymobilecare.presenter;

import com.bin.easymobilecare.ApiPojo.BrandCategoryResponse;
import com.bin.easymobilecare.ApiPojo.BrandSubCategory;
import com.bin.easymobilecare.Interactor.BrandInteractorImpl;
import com.bin.easymobilecare.Interactor.iInterface.BrandInteractor;
import com.bin.easymobilecare.presenter.pInterface.BrandPresenter;
import com.bin.easymobilecare.ui.vInterface.IBrand;
import com.bin.easymobilecare.viewModel.BrandCategoryViewModel;
import com.bin.easymobilecare.viewModel.BrandSubCatViewModel;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by binodPokhrel on 7/6/17.
 */

public class BrandPresenterImpl extends MvpBasePresenter<IBrand> implements BrandPresenter {
    private List<BrandCategoryViewModel> viewModels = new ArrayList<>();

    @Override
    public void getBrand() {
        BrandInteractorImpl callBrandInteractorImpl = new BrandInteractorImpl();
        callBrandInteractorImpl.getBrand(new BrandInteractor() {
            @Override
            public void success(List<BrandCategoryResponse> response) {
                for (BrandCategoryResponse categoryResponse : response) {
                    BrandCategoryViewModel categoryViewModel = new BrandCategoryViewModel();
                    categoryViewModel.setHeaderTitle(categoryResponse.getName());
                    List<BrandSubCatViewModel> brandSubCatViewModels = new ArrayList<>();
                    for (BrandSubCategory subCategory : categoryResponse.getBrandSubCategory()) {
                        BrandSubCatViewModel bSubCat = new BrandSubCatViewModel();
                        bSubCat.setBrandImage(subCategory.getImage());
                        bSubCat.setCatName(subCategory.getName());
                        bSubCat.setItemCostAmount(subCategory.getSell());
                        bSubCat.setItemName(subCategory.getName());

                         /*---------GENERALINFORMATION-------------*/
                        bSubCat.setGeneralStatus(subCategory.getStatus());
                        bSubCat.setGernalInfoAnnounced(subCategory.getAnnounced());
                        bSubCat.setGernalInfoColors(subCategory.getGencolors());
                        bSubCat.setGernalInfoDimension(subCategory.getDimension());
                        bSubCat.setGernalInfoWeight(subCategory.getWeight());
                        bSubCat.setGernalInfotwoGNetwork(subCategory.getTwog());
                        bSubCat.setGernalInfothreeGNetwork(subCategory.getThreegee());
                        bSubCat.setGernalInfofourGNetwork(subCategory.getFourg());
                        bSubCat.setGernalInfoMessiging(subCategory.getMessage());

                        /*----------HARDWARE AND OS-------------*/
                        bSubCat.setHardwareOS(subCategory.getOs());
                        bSubCat.setHardwareProcessor(subCategory.getProcessor());
                        bSubCat.setHardwareGPU(subCategory.getGpu());
                        bSubCat.setHardwareRAM(subCategory.getRam());
                        bSubCat.setHardwareInternalMemory(subCategory.getInternal());
                        bSubCat.setHardwareExternalMemory(subCategory.getExternalMemo());

                        /*-----------DISPLAY--------------------*/
                        bSubCat.setDisplayType(subCategory.getType());
                        bSubCat.setDisplayColors(subCategory.getDiscolors());
                        bSubCat.setDisplaySize(subCategory.getSize());
                        bSubCat.setDisplayResolution(subCategory.getDisresolution());
                        bSubCat.setDisplayMultiTouch(subCategory.getMultitouch());
                        bSubCat.setDisplayAccelerometer(subCategory.getAcc());
                        bSubCat.setDisplayProximity(subCategory.getProxi());

                        /*------------MULTIMEDIA------------------*/
                        bSubCat.setMultimediaHdmiport(subCategory.getHdmi());
                        bSubCat.setMultimediaGames(subCategory.getGames());
                        bSubCat.setMultimediaJack(subCategory.getJack());
                        bSubCat.setMultimediaJava(subCategory.getJava());
                        bSubCat.setMultimediaLoudSpeaker(subCategory.getSpeaker());
                        bSubCat.setMultimediaRadio(subCategory.getRadioo());

                        /*------------CAMERA-----------------------*/
                        bSubCat.setCameraFeatures(subCategory.getFeatures());
                        bSubCat.setCameraFlash(subCategory.getFlash());
                        bSubCat.setCameraMegaPixel(subCategory.getCamreso());
                        bSubCat.setCameraSecondary(subCategory.getSecondary());
                        bSubCat.setCameraVideo(subCategory.getVideo());

                        /*------------CONNECTIVITY AND DATA RATE---------*/
                        bSubCat.setConnectivityBluetooth(subCategory.getBluetooth());
                        bSubCat.setConnectivityBrowser(subCategory.getBrowser());
                        bSubCat.setConnectivityEdge(subCategory.getEdge());
                        bSubCat.setConnectivityGprs(subCategory.getGprs());
                        bSubCat.setConnectivityGps(subCategory.getGps());
                        bSubCat.setConnectivityThreeG(subCategory.getThreeg());
                        bSubCat.setConnectivityUsb(subCategory.getUsb());
                        bSubCat.setConnectivitywifi(subCategory.getWifi());

                        /*------------USER MEMORY----------------------*/
                        bSubCat.setMemoryCallRecords(subCategory.getCallrec());
                        bSubCat.setMemoryCardslot(subCategory.getSlot());
                        bSubCat.setMemoryInternal(subCategory.getInternal());
                        bSubCat.setMemoryPhonebook(subCategory.getPhonebook());

                        /*------------BATTERY---------------------------*/
                        bSubCat.setBatteryCapacity(subCategory.getCapacity());
                        bSubCat.setBatteryStandby(subCategory.getBatstand());
                        bSubCat.setBatteryTalktime(subCategory.getTalk());
                        bSubCat.setBatteryType(subCategory.getBattype());

                        /*-----------IMPORTANT APPS----------------------*/
                        bSubCat.setImportantappCalender(subCategory.getCalendar());
                        bSubCat.setImportantappDocumentView(subCategory.getDocview());
                        bSubCat.setImportantappNfc(subCategory.getNfc());
                        bSubCat.setImportantappSocialNetwork(subCategory.getSnetwork());
                        bSubCat.setImportantappVoiceCommand(subCategory.getVoicecom());
                        bSubCat.setImportantappVoiceRecord(subCategory.getVoicerec());

                        brandSubCatViewModels.add(bSubCat);
                    }
                    categoryViewModel.setSubCatImage(brandSubCatViewModels);
                    viewModels.add(categoryViewModel);
                }
                if (getView() != null)
                    getView().onListChange(viewModels);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
