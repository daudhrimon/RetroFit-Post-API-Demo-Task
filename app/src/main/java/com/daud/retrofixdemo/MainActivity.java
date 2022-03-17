package com.daud.retrofixdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView countTv;
    private ProgressBar progressBar;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTv = findViewById(R.id.countTv);
        progressBar = findViewById(R.id.progressBar);
        apiInterface = RetrofitInit.getRetro().create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        apiInterface.getData().enqueue(new Callback<ResponseMc>() {
            @Override
            public void onResponse(Call<ResponseMc> call, Response<ResponseMc> response) {
                if (response.isSuccessful()){
                    List<Entry> list = response.body().getEntries();
                    if (list.size() > 0){
                        progressBar.setVisibility(View.GONE);
                        countTv.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.VISIBLE);
                        countTv.setText("Count: "+response.body().getCount());
                        recyclerView.setAdapter(new MyAdapter(MainActivity.this,list));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseMc> call, Throwable t) {

            }
        });
    }
}