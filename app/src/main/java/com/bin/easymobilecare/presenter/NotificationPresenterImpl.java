package com.bin.easymobilecare.presenter;

import com.bin.easymobilecare.ApiPojo.NotificationResponse;
import com.bin.easymobilecare.Interactor.NotificationInteractorImpl;
import com.bin.easymobilecare.Interactor.iInterface.NotificationInteractor;

/**
 * Created by binodPokhrel on 7/3/17.
 */

public class NotificationPresenterImpl {

    public void getNotification(){
        NotificationInteractorImpl interactor = new NotificationInteractorImpl();
        interactor.getNotification(new NotificationInteractor() {
            @Override
            public void onSuccess(NotificationResponse notificationResponse) {

            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

}
