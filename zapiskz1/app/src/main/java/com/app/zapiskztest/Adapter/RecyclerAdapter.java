package com.app.zapiskztest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.zapiskztest.R;
import com.app.zapiskztest.Model.Salon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Salon> salons;
    Context context;

    public RecyclerAdapter(Context context, ArrayList<Salon> salons) {
        this.context = context;
        this.salons = salons;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.salon_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        Salon salon  = salons.get(position);
        holder.nameView.setText(salon.getName());
        holder.companyView.setText(salon.getType());

        switch (salon.getCheckRating().toString()){
            case "1.0":
                holder.checkRatingView.setText("$");
                break;
            case "2.0":
                holder.checkRatingView.setText("$$");
                break;
            case "3.0":
                holder.checkRatingView.setText("$$$");
                break;
        }

        if (salon.getPictureUrl().contains("picture-missing")){
            Picasso.with(context)
                    .load(R.drawable.default_salon)
                    .error(R.drawable.salon_avatar)
                    .fit()
                    .into(holder.imageView);
        } else{
            String url = "http://zp.jgroup.kz"+salon.getPictureUrl();
            Picasso.with(context)
                    .load(url)
                    .error(R.drawable.salon_avatar)
                    .fit()
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return salons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameView, companyView, checkRatingView;
        ViewHolder(View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.imageview_image);
            nameView = (TextView) view.findViewById(R.id.textview_name);
            companyView = (TextView) view.findViewById(R.id.textview_type);
            checkRatingView = view.findViewById(R.id.textview_check_rating);
        }
    }
}