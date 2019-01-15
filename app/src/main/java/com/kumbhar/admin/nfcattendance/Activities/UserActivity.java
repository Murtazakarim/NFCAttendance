package com.kumbhar.admin.nfcattendance.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.kumbhar.admin.nfcattendance.Adapters.AnswersAdapter;
import com.kumbhar.admin.nfcattendance.Models.Data;
import com.kumbhar.admin.nfcattendance.Models.Item;
import com.kumbhar.admin.nfcattendance.Models.SOAnswersResponse;
import com.kumbhar.admin.nfcattendance.R;
import com.kumbhar.admin.nfcattendance.Services.ApiUtil;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    TextView userInfo;

    private AnswersAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        init();
        callUserDeials();



        mAdapter = new AnswersAdapter(this, new ArrayList<Item>(0), new AnswersAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {
                Toast.makeText(UserActivity.this, "Post id is" + id, Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

    }

    private void callUserDeials() {

        ApiUtil.getServiceClass().getUserDetails("2k15/blcs/16").enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });

        ApiUtil.getServiceClass().login("mustafa","12345678").enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });

        ApiUtil.getServiceClass().getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {
                if(response.isSuccessful()) {
                    mAdapter.updateAnswers(response.body().getItems());
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }

            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {

            }
        });
    }

    private void init() {
        userInfo = findViewById(R.id.user_info);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_answers);
    }
}
