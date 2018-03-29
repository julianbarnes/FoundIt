package com.example.julia.foundit;

/**
 * Created by julia on 3/29/2018.
 */

public class AWSProvider {
    private static final AWSProvider ourInstance = new AWSProvider();

    public static AWSProvider getInstance() {
        return ourInstance;
    }

    private AWSProvider() {
    }
}
