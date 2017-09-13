package com.bin.easymobilecare.util;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by binodPokhrel on 7/18/17.
 */

public class App {

    public static Context app;

    public static void replaceFragment(FragmentManager fm , int id , Fragment fragment){
        try {
            fm.beginTransaction().replace(id,fragment).commit();
        }catch (IllegalStateException ie){
            ie.printStackTrace();
        }catch (NullPointerException ne){
            ne.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
