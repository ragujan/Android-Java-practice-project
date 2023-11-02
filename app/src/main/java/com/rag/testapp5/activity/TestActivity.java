package com.rag.testapp5.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rag.testapp5.R;
import com.rag.testapp5.adapter.CategoryAdapter;
import com.rag.testapp5.adapter.GridAdapter;
import com.rag.testapp5.databinding.ActivityTestBinding;
import com.rag.testapp5.domain.CategoryDomain;
import com.rag.testapp5.domain.FoodItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    ActivityTestBinding activityTestBinding;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle bundleView) {
        super.onCreate(bundleView);
        activityTestBinding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(activityTestBinding.getRoot());

        recyclerViewGridItems();
    }

    public void recyclerViewGridItems() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(TestActivity.this, 2);
        recyclerView = findViewById(R.id.testRecyclerView);
        recyclerView.setLayoutManager(gridLayoutManager);

        List<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza", "cat_1"));
        categoryList.add(new CategoryDomain("Burger", "cat_2"));
        categoryList.add(new CategoryDomain("Hot Dog", "cat_3"));
        categoryList.add(new CategoryDomain("Drink", "cat_4"));
        categoryList.add(new CategoryDomain("Donut", "cat_5"));
        categoryList.add(new CategoryDomain("Pizza", "cat_1"));
        categoryList.add(new CategoryDomain("Burger", "cat_2"));
        categoryList.add(new CategoryDomain("Hot Dog", "cat_3"));
        categoryList.add(new CategoryDomain("Drink", "cat_4"));
        categoryList.add(new CategoryDomain("Donut", "cat_5"));
        categoryList.add(new CategoryDomain("Pizza", "cat_1"));
        categoryList.add(new CategoryDomain("Burger", "cat_2"));
        categoryList.add(new CategoryDomain("Hot Dog", "cat_3"));
        categoryList.add(new CategoryDomain("Drink", "cat_4"));
        categoryList.add(new CategoryDomain("Donut", "cat_5"));



        adapter = new CategoryAdapter(categoryList);

        recyclerView.setAdapter(adapter);
    }
}
