package com.app.zapiskztest.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.zapiskztest.API.ApiService;
import com.app.zapiskztest.API.RetroClient;
import com.app.zapiskztest.Adapter.RecyclerMastersAdapter;
import com.app.zapiskztest.Model.Info;
import com.app.zapiskztest.Model.Master;
import com.app.zapiskztest.Model.SalonInfo;
import com.app.zapiskztest.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DescriptionActivity extends AppCompatActivity {

    Info info;
    SalonInfo salonInfo;

    private ArrayList<Master> mastersList;
    private RecyclerMastersAdapter recyclerMastersAdapter;

    TextView infoName;
    TextView infoType;
    TextView infoAddress;
    TextView infoRating;
    TextView infoInstagram;
    TextView infoCheckRating;
    TextView infoMasters;
    TextView infoRatesCount;
    TextView infoTime;
    RecyclerView recyclerInfoMasters;
    ImageButton infoBackButton;
    ImageView salonImage;


    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(DescriptionActivity.this, MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onCreate(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        final ProgressDialog dialog;

        dialog = new ProgressDialog(DescriptionActivity.this);
        dialog.setMessage("Загрузка");
        dialog.show();

        Integer chosedId = (Integer)getIntent().getSerializableExtra("chosedId");
        String urlImage = (String)getIntent().getSerializableExtra("chosedImageUrl");

        salonImage = findViewById(R.id.imageswitcher_image_1);
        if (urlImage.contains("picture-missing")){
            Picasso.with(this)
                    .load(R.drawable.default_salon)
                    .error(R.drawable.salon_avatar)
                    .fit()
                    .into(salonImage);
        } else{
            String url = "http://zp.jgroup.kz"+urlImage;
            Picasso.with(this)
                    .load(url)
                    .error(R.drawable.salon_avatar)
                    .fit()
                    .into(salonImage);
        }

        infoName = findViewById(R.id.textview_info_name);
        infoType = findViewById(R.id.textview_info_type);
        infoAddress = findViewById(R.id.textview_info_address);
        infoRating = findViewById(R.id.textview_info_rating);
        infoInstagram = findViewById(R.id.textview_info_instagram);
        infoTime = findViewById(R.id.textview_info_time);
        infoCheckRating = findViewById(R.id.textview_info_check_rating);
        infoMasters = findViewById(R.id.textview_info_masters);
        infoRatesCount = findViewById(R.id.textview_info_rates_count);
        recyclerInfoMasters = findViewById(R.id.recycleview_info_masters);
        infoBackButton = findViewById(R.id.imagebutton_info_back);
        infoBackButton.setOnClickListener(btnClick);

        mastersList = new ArrayList<>();

        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerInfoMasters.setLayoutManager(layoutManager);

        ApiService apiService =
                RetroClient.getRetrofitInstance().create(ApiService.class);

        Call<Info> callPopular = apiService.getSalonInfo(chosedId);
        callPopular.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {

                info = response.body();

                if (info != null){
                    salonInfo = info.getSalon();
                    infoName.setText(salonInfo.getName());
                    infoType.setText(salonInfo.getType());

                    String newAddress = salonInfo.getAddress().replaceAll("<br />", "\n");
                    infoAddress.setText(newAddress);

                    if (salonInfo.getInstagramProfile().equals("")){
                        infoInstagram.setText("Instagram отсутствует");
                    } else {
                        infoInstagram.setText(salonInfo.getInstagramProfile());
                    }

                    infoRating.setText(salonInfo.getAverageRating().toString());
                    infoRatesCount.setText(salonInfo.getReviewCount().toString() + "\nотзывов");

                    String substrStartTime = salonInfo.getWorkStartTime().substring(salonInfo.getWorkStartTime().length() - 5);
                    String substrEndTime = salonInfo.getWorkEndTime().substring(salonInfo.getWorkEndTime().length() - 5);
                    infoTime.setText("Время работы " + substrStartTime + " - " + substrEndTime);

                    switch (salonInfo.getCheckRating().toString()){
                        case "1.0":
                            infoCheckRating.setText("$");
                            break;
                        case "2.0":
                            infoCheckRating.setText("$$");
                            break;
                        case "3.0":
                            infoCheckRating.setText("$$$");
                            break;
                    }

                    mastersList = info.getMasters();
                    recyclerMastersAdapter = new RecyclerMastersAdapter(DescriptionActivity.this, mastersList);
                    recyclerInfoMasters.setAdapter(recyclerMastersAdapter);

                    dialog.dismiss();

                }
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {
                Log.e("CheckInputJson", "onFailure");
            }
        });


    }
}
