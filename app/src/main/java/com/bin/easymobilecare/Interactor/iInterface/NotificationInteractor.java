package com.bin.easymobilecare.Interactor.iInterface;

import com.bin.easymobilecare.ApiPojo.NotificationResponse;

/**
 * Created by binodPokhrel on 7/3/17.
 */

public interface NotificationInteractor {
    void onSuccess(NotificationResponse notificationResponse);
    void onFailure(String message);
}
