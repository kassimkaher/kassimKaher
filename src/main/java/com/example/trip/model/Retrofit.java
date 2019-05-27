package com.example.trip.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    inter.Ipresenter handel;
    retrofit2.Retrofit retrofit;
    public Retrofit(String Url ,inter.Ipresenter handel){
        this.handel=handel;
         retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Defining retrofit api service

    }
    public void gettrip(){
        ApiInterface service = retrofit.create(ApiInterface.class);

        //Defining the user object as we need to pass it with the call


        //defining the call
        Call<List<Tripjson>> call = service.getTrip("BGW","BEY","2019-05-30","e","0","1","0");

        //calling the api
        call.enqueue(new Callback<List<Tripjson>>() {
            @Override
            public void onResponse(Call<List<Tripjson>> call, Response<List<Tripjson>> response) {
                //hiding progress dialog
                List<Tripjson> result=null;
checking.created=true;

String error="200";
try {
    result=response.body();
    checking.json=result;
}catch (Exception e){
    error=e.getMessage();
}
                handel.rejectdate(result,error);

                //displaying the message from the response as toast
                // Toast.makeText(getApplicationContext(), response.body().getData().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Tripjson>>
                                          call, Throwable t) {
String name = t.getMessage();
                checking.created=true;
                handel.rejectdate(null,name);
            }
        });
    }



}
