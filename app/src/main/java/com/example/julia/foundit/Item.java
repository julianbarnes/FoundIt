package com.example.julia.foundit;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by julia on 3/11/2018.
 */

public class Item implements Serializable {
    private String title;
    private String desc;

    public Item(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle(){
        return title;
    }
    public String getDesc() {
        return desc;
    }

}
