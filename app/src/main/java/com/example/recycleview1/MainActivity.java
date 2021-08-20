package com.example.recycleview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinkedList<HashMap<String,String>> Alist=new LinkedList<HashMap<String,String>>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DATAadd();

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recycleview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this, Alist);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //下拉刷新
        swipeRefreshLayout = findViewById(R.id.refreshLayout);
        swipeRefreshLayout.setOnRefreshListener(()->{
            Alist.clear();
            DATAadd();
            mAdapter.notifyDataSetChanged();
            swipeRefreshLayout.setRefreshing(false);

    });


}
    private void DATAadd()
    {
        for(int i=0;i<=30;i++)
        {
            HashMap<String,String> map=new HashMap<String,String>();
            map.put("title",String.valueOf(new Random().nextInt(100)+0));
            Alist.add(map);
        }
    }


}