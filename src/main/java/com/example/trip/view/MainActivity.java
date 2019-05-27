package com.example.trip.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trip.R;
import com.example.trip.model.Retrofit;
import com.example.trip.model.Tripjson;
import com.example.trip.model.Url;
import com.example.trip.model.inter;
import com.example.trip.presenter.Presenter;
import com.example.trip.model.*;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements inter.Iview{

Presenter presenter;
    static adpter adapter;
    static RecyclerView recyclerView;
    LinearLayout linpb ,linerror;
    TextView txerror;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
linerror=(LinearLayout)findViewById(R.id.Linererror);


        linpb=(LinearLayout)findViewById(R.id.Linerpb);
        txerror=(TextView)findViewById(R.id.txerror);
        presenter=new Presenter(this,this);

      if (!checking.created){

          presenter.request();
      }else {
          Creatrecycle(checking.json);
          linerror.setVisibility(View.GONE);
          linpb.setVisibility(View.GONE);
      }

    }





    @Override
    public void respons(List<Tripjson> result) {
      if ( result==null ||result.size()<1){
          checking.created=false;
          setlinpb(false,0);
          setlinerror(true,"NO Data",500);
          final Handler handler = new Handler();
          handler.postDelayed(new Runnable() {
              @Override
              public void run() {
                  setlinerror(false,"9348",0);
                  setlinpb(true,500);
                  presenter.request();
              }
          }, 1500);


      }else {
           setlinpb(false,0);

 Creatrecycle(result);}

    }

    @Override
    public void responsFailur(final String error) {
setlinpb(false,0);


        setlinerror(true,error,500);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setlinerror(false,error,0);
                setlinpb(true,500);
                presenter.request();
            }
        }, 1500);





    }
    public void Creatrecycle( List<Tripjson> JsonResult){


        final LinearLayoutManager mManager=new LinearLayoutManager(this);
        mManager.setReverseLayout(false);
        mManager.setStackFromEnd(false);
        recyclerView.setLayoutManager(mManager);
        adapter = new adpter(this,JsonResult);

        recyclerView.setAdapter(adapter);



    }
    public void setlinpb(boolean i ,long delay){
        if (i){
            linpb.setVisibility(View.VISIBLE);
            txerror.setText("no Data");

            linpb.animate()
                    .scaleY(1.0f)
                    .setDuration(500)
                    .setStartDelay(delay)
                    .setListener(null);
        }else {
            linpb.animate()
                    .scaleY(0.0f)

                    .setStartDelay(delay)
                    .setDuration(500)

                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            linpb.setVisibility(View.GONE);

                        }
                    });
        }

    }
    public void setlinerror(boolean i, String msg ,long delay){
if (i){
    linerror.setVisibility(View.VISIBLE);
    txerror.setText("no Data");
    linerror.animate()
            .scaleY(1.0f)
            .setStartDelay(delay)
            .setDuration(500)
            .setListener(null);

}else {
    linerror.animate()

            .scaleY(0.0f)
            .setStartDelay(delay)
            .setDuration(500)
            .setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    linerror.setVisibility(View.GONE);

                }
            });

}
    }
}
