package com.example.trip.presenter;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.trip.model.Tripjson;
import com.example.trip.model.checking;
import com.example.trip.model.inter;
import com.example.trip.model.Retrofit;

import com.example.trip.model.Url;

import java.util.List;

public class Presenter implements inter.Ipresenter{
Context context;

inter.Iview view;
Retrofit request;


    public Presenter(inter.Iview view , Context context){
        this.view=view;
this.context=context;

    }


    @Override
    public void request() {
        if (!checking.created){
            request=new Retrofit(Url.url,this);
            request.gettrip();
        }else {
           view.respons(checking.json);
        }


    }

    @Override
    public void rejectdate(List<Tripjson> result,String error) {
if (error.equals("200")){
    view.respons(result);
}else {
    view.responsFailur(error);
}
    }


}
