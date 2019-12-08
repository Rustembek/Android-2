package com.app.zapiskztest.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.zapiskztest.Model.Master;
import com.app.zapiskztest.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerMastersAdapter extends RecyclerView.Adapter<RecyclerMastersAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Master> masters;
    Context context;

    public RecyclerMastersAdapter(Context context, ArrayList<Master> masters) {
        this.context = context;
        this.masters = masters;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerMastersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.master_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerMastersAdapter.ViewHolder holder, int position) {
        Master master  = masters.get(position);
        holder.masterName.setText(master.getName());
        holder.masterProfession.setText(master.getProfession());

        if (master.getAvatarUrl()!=null){
            if (master.getAvatarUrl().contains("picture-missing")){
                Picasso.with(context)
                        .load(R.drawable.default_master)
                        .error(R.drawable.salon_avatar)
                        .fit()
                        .into(holder.imageView);
            } else {
                String url = "http://zp.jgroup.kz"+master.getAvatarUrl();
                Picasso.with(context)
                        .load(url)
                        .error(R.drawable.default_master)
                        .fit()
                        .into(holder.imageView);
            }
        } else {
            Picasso.with(context)
                    .load(R.drawable.default_master)
                    .error(R.drawable.salon_avatar)
                    .fit()
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return masters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView masterName, masterProfession;
        ViewHolder(View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.imageview_info_item_photo);
            masterName = (TextView) view.findViewById(R.id.textview_info_item_name);
            masterProfession = (TextView) view.findViewById(R.id.textview_info_item_profession);
        }
    }
}
