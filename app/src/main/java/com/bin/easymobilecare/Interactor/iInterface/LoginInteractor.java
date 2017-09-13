package com.bin.easymobilecare.Interactor.iInterface;

import com.bin.easymobilecare.ApiPojo.Login.LoginStatusResponse;

/**
 * Created by binodPokhrel on 7/14/17.
 */

public interface LoginInteractor {
    void success(LoginStatusResponse loginStatusResponse);
    void onFailure(String message);
}
