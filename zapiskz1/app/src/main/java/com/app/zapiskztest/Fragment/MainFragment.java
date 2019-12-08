package com.app.zapiskztest.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.zapiskztest.API.ApiService;
import com.app.zapiskztest.Activity.DescriptionActivity;
import com.app.zapiskztest.Adapter.RecyclerItemClickListener;
import com.app.zapiskztest.R;
import com.app.zapiskztest.Adapter.RecyclerAdapter;
import com.app.zapiskztest.API.RetroClient;
import com.app.zapiskztest.Model.Salon;
import com.app.zapiskztest.Model.SalonList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    private RecyclerView recyclerViewPopular;
    private RecyclerView recyclerViewRecommended;
    private RecyclerView recyclerViewRecentlyAdded;
    private ArrayList<Salon> salonListPopular;
    private ArrayList<Salon> salonListRecommended;
    private ArrayList<Salon> salonListRecentlyAdded;

    private RecyclerAdapter adapter;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        final ProgressDialog dialog;

        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Загрузка");
        dialog.show();

        recyclerViewPopular = view.findViewById(R.id.recycleview_popular);
        recyclerViewRecommended = view.findViewById(R.id.recycleview_recommended);
        recyclerViewRecentlyAdded = view.findViewById(R.id.recycleview_recently_added);

        LinearLayoutManager layoutManagerPopular= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerRecommended= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerRecentlyAdded= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopular.setLayoutManager(layoutManagerPopular);
        recyclerViewRecommended.setLayoutManager(layoutManagerRecommended);
        recyclerViewRecentlyAdded.setLayoutManager(layoutManagerRecentlyAdded);

        salonListPopular = new ArrayList<>();
        salonListRecommended = new ArrayList<>();
        salonListRecentlyAdded = new ArrayList<>();

        ApiService apiService =
                RetroClient.getRetrofitInstance().create(ApiService.class);

        Call<SalonList> callPopular = apiService.getSalonsPopular();
        callPopular.enqueue(new Callback<SalonList>() {
            @Override
            public void onResponse(Call<SalonList> call, Response<SalonList> response) {

                salonListPopular = response.body().getSalons();
                adapter = new RecyclerAdapter(getActivity(), salonListPopular);

                recyclerViewPopular.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<SalonList> call, Throwable t) {
                Log.e("CheckInputJson", "onFailure");
            }
        });


        Call<SalonList> callRecommended = apiService.getSalonsRecommended();
        callRecommended.enqueue(new Callback<SalonList>() {
            @Override
            public void onResponse(Call<SalonList> call, Response<SalonList> response) {

                salonListRecommended = response.body().getSalons();
                adapter = new RecyclerAdapter(getActivity(), salonListRecommended);

                recyclerViewRecommended.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<SalonList> call, Throwable t) {
                Log.e("CheckInputJson", "onFailure");
            }
        });


        Call<SalonList> callRecentlyAdded = apiService.getSalonsRecentlyAdded();
        callRecentlyAdded.enqueue(new Callback<SalonList>() {
            @Override
            public void onResponse(Call<SalonList> call, Response<SalonList> response) {

                salonListRecentlyAdded = response.body().getSalons();
                adapter = new RecyclerAdapter(getActivity(), salonListRecentlyAdded);

                recyclerViewRecentlyAdded.setAdapter(adapter);
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<SalonList> call, Throwable t) {
                Log.e("CheckInputJson", "onFailure");
            }
        });


        recyclerViewPopular.addOnItemTouchListener(
            new RecyclerItemClickListener(getContext(), recyclerViewPopular ,new RecyclerItemClickListener.OnItemClickListener() {
                @Override public void onItemClick(View view, int position) {

                    Intent chosedId = new Intent(getActivity(), DescriptionActivity.class);
                    chosedId.putExtra("chosedId", salonListPopular.get(position).getId());
                    chosedId.putExtra("chosedImageUrl", salonListPopular.get(position).getPictureUrl());
                    startActivity(chosedId);

                }

                @Override public void onLongItemClick(View view, int position) {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String text = "Салон: " + salonListPopular.get(position).getName();
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(sharingIntent, "Share"));
                }
            })
        );

        recyclerViewRecommended.addOnItemTouchListener(
            new RecyclerItemClickListener(getContext(), recyclerViewRecommended ,new RecyclerItemClickListener.OnItemClickListener() {
                @Override public void onItemClick(View view, int position) {

                    Intent chosedId = new Intent(getActivity(), DescriptionActivity.class);
                    chosedId.putExtra("chosedId", salonListRecommended.get(position).getId());
                    chosedId.putExtra("chosedImageUrl", salonListRecommended.get(position).getPictureUrl());
                    startActivity(chosedId);}

                @Override public void onLongItemClick(View view, int position) {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String text = "Салон: " + salonListPopular.get(position).getName();
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(sharingIntent, "Share"));
                }
            })
        );


        recyclerViewRecentlyAdded.addOnItemTouchListener(
            new RecyclerItemClickListener(getContext(), recyclerViewRecentlyAdded ,new RecyclerItemClickListener.OnItemClickListener() {
                @Override public void onItemClick(View view, int position) {

                    Intent chosedId = new Intent(getActivity(), DescriptionActivity.class);
                    chosedId.putExtra("chosedId", salonListRecentlyAdded.get(position).getId());
                    chosedId.putExtra("chosedImageUrl", salonListRecentlyAdded.get(position).getPictureUrl());
                    startActivity(chosedId);}

                @Override public void onLongItemClick(View view, int position) {
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String text = "Салон: " + salonListPopular.get(position).getName();
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(sharingIntent, "Share"));
                }
            })
        );

        return view;
    }

}
