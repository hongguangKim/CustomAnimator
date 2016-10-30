package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {

    private List<String> list;
    private RecyclerView rc;
    private MyAdapter mMyAdapter;
    private CheckBox isAddItem;
    private CheckBox isRemoveItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initData();
        initView();

    }

    private void initView() {
        isAddItem = (CheckBox) findViewById(R.id.addCheck);
        isRemoveItem = (CheckBox) findViewById(R.id.removeCheck);
        rc = (RecyclerView) findViewById(R.id.recyclerview);
        rc.setLayoutManager(new GridLayoutManager(this, 4));
        rc.setItemAnimator(new MyItemAnimators());
        rc.setAdapter(mMyAdapter = new MyAdapter(this, list));
        mMyAdapter.setOnItemClickListener(this);
    }

    public void initData() {
        this.list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add("item" + i);
        }
    }

    @Override
    public void onClick(int position) {
        Log.i("setOnItemClickListener", position + " list=" + list);
        if (isAddItem.isChecked())
            mMyAdapter.addItem(position);
        else if (isRemoveItem.isChecked())
            mMyAdapter.removeItem(position);

    }
}

