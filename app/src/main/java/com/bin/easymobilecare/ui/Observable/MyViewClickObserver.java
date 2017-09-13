package com.bin.easymobilecare.ui.Observable;

import java.util.Observable;

/**
 * Created by binodPokhrel on 7/17/17.
 */

public class MyViewClickObserver extends Observable{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        setChanged();
        notifyObservers();
    }
}
