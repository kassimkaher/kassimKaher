package com.example.trip.model;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;

import android.opengl.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trip.R;
import com.squareup.picasso.Picasso;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class adpter extends RecyclerView.Adapter<adpter.ViewHolder> {


    public List<String> vnumber, type , imei , dname, time;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    ConstraintLayout constrnow=null;
    List<Tripjson> tripinfo;
    Context ctx;



    // data is passed into the constructor
    public adpter(Context context, List<Tripjson> tripinfo) {
        this.mInflater = LayoutInflater.from(context);
        this.tripinfo=tripinfo;
        this.ctx=context;



    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item, parent, false); ;



        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        String plac="null";
        if (tripinfo.get(position).getDepCityName().size()>0){
            for (int i=0;i<tripinfo.get(position).getDepCityName().size();i++){
                plac=plac+" , "+tripinfo.get(position).getDepCityName().get(i);
            }
        }
        holder.tx_places.setText(plac);
        holder.tx_totalDur.setText(tripinfo.get(position).getTotalDuration());
        holder.tx_depAirport.setText(tripinfo.get(position).getDepartingAirportName().get(0));
        holder.tx_arrAirport.setText(tripinfo.get(position).getArrAirportName().get(0));
        holder.tx_stops.setText(tripinfo.get(position).getStops()+"");
        holder.tx_price.setText(tripinfo.get(position).getPrice());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return tripinfo.size();
    }




    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener , View.OnLongClickListener {
        TextView tx_places,tx_totalDur,tx_depAirport,tx_arrAirport,tx_stops,tx_price  ;
      ArrayList<TextView> txcity,txcitya,txdat,txdata,txflighmod,txflighnum,txairport,txovertim,txairline;
        TextView txdat3,txdat1,txdat2,txdat3a,txdat1a,txdat2a;
        TextView txovertim3,txovertim1,txovertim2;
        TextView txairline3,txairline1,txairline2;
        TextView txcity1,txcity2,txcity3,txcity1a,txcity2a,txcity3a;
        ImageView im1,im2,im3;
        ArrayList<ImageView>im;
        TextView txflighmod3,txflighmod1,txflighmod2,txflighnum3,txflighnum1,txflighnum2;
        TextView txairport3,txairport1,txairport2;

       ConstraintLayout consdetalis;
        CardView cardView;


        ViewHolder(View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cardv);
            consdetalis=itemView.findViewById(R.id.consdetails);
            txcity =new ArrayList<TextView>();
            txcitya =new ArrayList<TextView>();
            txdat =new ArrayList<TextView>();
            txdata =new ArrayList<TextView>();
            txflighmod =new ArrayList<TextView>();
            txflighnum =new ArrayList<TextView>();
            txairport =new ArrayList<TextView>();
            txairline =new ArrayList<TextView>();
            txovertim =new ArrayList<TextView>();
            im=new ArrayList<ImageView>();


tx_places=itemView.findViewById(R.id.txplace);
            tx_totalDur=itemView.findViewById(R.id.txtotalDuration);
            tx_depAirport=itemView.findViewById(R.id.txdepair);
            tx_arrAirport=itemView.findViewById(R.id.txarrAirport);
            tx_stops=itemView.findViewById(R.id.txstops);
            tx_price=itemView.findViewById(R.id.txprice);




          txcity1=itemView.findViewById(R.id.txcity);
          txcity2=itemView.findViewById(R.id.txcity1);
          txcity3=itemView.findViewById(R.id.txcity2);

            txcity.add(txcity1);
            txcity.add(txcity2);
            txcity.add(txcity3);


            txdat1=itemView.findViewById(R.id.txdat);
            txdat2=itemView.findViewById(R.id.txdat1);
            txdat3=itemView.findViewById(R.id.txdat2);

            txdat.add(txdat1);
            txdat.add(txdat2);
            txdat.add(txdat3);

            txovertim1=itemView.findViewById(R.id.txovertim);
            txovertim2=itemView.findViewById(R.id.txovertim1);
            txovertim3=itemView.findViewById(R.id.txovertim2);
            txovertim.add(txovertim1);
            txovertim.add(txovertim2);
            txovertim.add(txovertim3);

            txcity1a=itemView.findViewById(R.id.txcitya);
            txcity2a=itemView.findViewById(R.id.txcity1a);
            txcity3a=itemView.findViewById(R.id.txcity2a);
            txcitya.add(txcity1a);
            txcitya.add(txcity2a);
            txcitya.add(txcity3a);


            txdat1a=itemView.findViewById(R.id.txdata);
            txdat2a=itemView.findViewById(R.id.txdat1a);
            txdat3a=itemView.findViewById(R.id.txdat2a);

            txdata.add(txdat1a);
            txdata.add(txdat2a);
            txdata.add(txdat3a);

            im1=itemView.findViewById(R.id.im1);
            im2=itemView.findViewById(R.id.im2);
            im3=itemView.findViewById(R.id.im3);

            im.add(im1);
            im.add(im2);
            im.add(im3);

            txairline1=itemView.findViewById(R.id.txairline);
            txairline2=itemView.findViewById(R.id.txairline1);
            txairline3=itemView.findViewById(R.id.txairline2);
            txairline.add(txairline1);
            txairline.add(txairline2);
            txairline.add(txairline3);

            txflighmod1=itemView.findViewById(R.id.txflightmod);
            txflighmod2=itemView.findViewById(R.id.txflightmod1);
            txflighmod3=itemView.findViewById(R.id.txflightmod2);

            txflighmod.add(txflighmod1);
            txflighmod.add(txflighmod2);
            txflighmod.add(txflighmod3);

            txflighnum1=itemView.findViewById(R.id.txflightnum);
            txflighnum2=itemView.findViewById(R.id.txflightnum1);
            txflighnum3=itemView.findViewById(R.id.txflightnum2);

            txflighnum.add(txflighnum1);
            txflighnum.add(txflighnum2);
            txflighnum.add(txflighnum3);


            txairport1=itemView.findViewById(R.id.txarrAirport);
            txairport2=itemView.findViewById(R.id.txarrairport1);
            txairport3=itemView.findViewById(R.id.txarrairport2);

            txairport.add(txairport1);
            txairport.add(txairport2);
            txairport.add(txairport3);








            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
int position=getAdapterPosition();
            String plac="null";
            if (tripinfo.get(position).getDepCityName().size()>0){
                for (int i=0;i<tripinfo.get(position).getDepCityName().size();i++){
                    plac=plac+" , "+tripinfo.get(position).getDepCityName().get(i);
                }
            }



            for (int i=0;i<tripinfo.get(position).getDepCityName().size();i++){ txcity.get(i).setText(tripinfo.get(position).getDepCityName().get(i)); txcity.get(i).setVisibility(View.VISIBLE); }
            for (int i=0;i<tripinfo.get(position).getArrCityName().size();i++){ txcitya.get(i).setText(tripinfo.get(position).getArrCityName().get(i)); txcitya.get(i).setVisibility(View.VISIBLE);}
            for (int i=0;i<tripinfo.get(position).getDepDateAndTime().size();i++){ txdat.get(i).setText(tripinfo.get(position).getDepDateAndTime().get(i));txdat.get(i).setVisibility(View.VISIBLE); }
            for (int i=0;i<tripinfo.get(position).getArrDateAndTime().size();i++){ txdata.get(i).setText(tripinfo.get(position).getArrDateAndTime().get(i)); txdata.get(i).setVisibility(View.VISIBLE);}
for (int i=0;i<tripinfo.get(position).getAirlineLogo().size();i++){
    Picasso.get().load(tripinfo.get(position).getAirlineLogo().get(i)).into(im.get(i));
    im.get(i).setVisibility(View.VISIBLE);

}
            for (int i=0;i<tripinfo.get(position).getLayOverTime().size();i++){ txovertim.get(i).setText(tripinfo.get(position).getLayOverTime().get(i));  txovertim.get(i).setVisibility(View.VISIBLE);}
            for (int i=0;i<tripinfo.get(position).getAirlineName().size();i++){ txairline.get(i).setText(tripinfo.get(position).getArrAirportName().get(i)); txairline.get(i).setVisibility(View.VISIBLE);}
            for (int i=0;i<tripinfo.get(position).getFlightModel().size();i++){ txflighmod.get(i).setText(tripinfo.get(position).getFlightModel().get(i)); txflighmod.get(i).setVisibility(View.VISIBLE);}
            for (int i=0;i<tripinfo.get(position).getFlightNumber().size();i++){ txflighnum.get(i).setText(tripinfo.get(position).getFlightNumber().get(i));txflighnum.get(i).setVisibility(View.VISIBLE); }
            for (int i=0;i<tripinfo.get(position).getArrAirportName().size();i++){ txairport.get(i).setText(tripinfo.get(position).getArrAirportName().get(i));txairport.get(i).setVisibility(View.VISIBLE); }

            if (consdetalis.getVisibility()== View.GONE){

                if (constrnow!=null){
                    constrnow.animate()
                            .translationY(0)
                            .alpha(0.0f)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    constrnow.setVisibility(View.GONE);
                                }
                            });
                }

                consdetalis.animate()
                        .translationY(100)
                        .alpha(1.0f)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                consdetalis.setVisibility(View.VISIBLE);
                                constrnow=consdetalis;
                            }
                        });
            }else {  consdetalis.animate()
                    .translationY(0)
                    .alpha(0.0f)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            consdetalis.setVisibility(View.GONE);
                        }
                    });}


        }

        @Override
        public boolean onLongClick(View v) {
            if (mClickListener!=null)mClickListener.onitemlongClic(v,getAdapterPosition());
            return true;
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return imei.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
        void onitemlongClic(View view, int position);

    }

public static void setProgress(){

}

}