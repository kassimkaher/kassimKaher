package com.example.trip.model;

import android.graphics.Bitmap;

import java.util.List;

public class inter {
    public interface Iview {
        void respons(List<Tripjson> result);
        void responsFailur(String error);
    }
    public interface Ipresenter {

        void request();
        void rejectdate(List<Tripjson> result,String error);

    }

}
