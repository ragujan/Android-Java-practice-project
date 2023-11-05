package com.rag.testapp5.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rag.testapp5.R;
import com.rag.testapp5.adapter.CategoryAdapter;
import com.rag.testapp5.adapter.GridAdapter;
import com.rag.testapp5.adapter.RecommendedAdapter;
import com.rag.testapp5.adapter.TopSellingAdapter;
import com.rag.testapp5.databinding.ActivityMenu2Binding;
import com.rag.testapp5.databinding.ActivityMenuBinding;
import com.rag.testapp5.databinding.IntroFragmentBinding;
import com.rag.testapp5.domain.CategoryDomain;
import com.rag.testapp5.domain.FoodDomain;
import com.rag.testapp5.domain.FoodItem;
import com.rag.testapp5.domain.TopSellingFoodDomain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2, topSellingAdapter, allFoodsAdapter;
    private RecyclerView recyclerViewCategoryList, recylerViewPopulerList, recylerViewTopSellingList, recyclerViewAllFoods;

    private ActivityMenu2Binding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_2);
        binding = ActivityMenu2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerViewCategory();
        recyclerViewPopular();
        setRecylerViewTopSelling();
        recyclerViewGridItems();
        binding.carBtnNavText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

        binding.cartBtnNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

    }


    private void setRecylerViewTopSelling() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recylerViewTopSellingList = findViewById(R.id.topSellingRecylerView);
        recylerViewTopSellingList.setLayoutManager(linearLayoutManager);



        List<TopSellingFoodDomain> topSellingFoodDomains = new LinkedList<>();
        topSellingFoodDomains.add(new TopSellingFoodDomain("Potato Chips", 100.00, "potato_chips"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Poke BBQ", 1400.00, "poke_bbq"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Veggie Burger", 500.00, "veggie_burger"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Smoothie Juice", 1200.00, "smoothi_juice"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Beef Fry", 1500.00, "beef_fry"));

        topSellingFoodDomains.add(new TopSellingFoodDomain("Potato Chips", 100.00, "potato_chips"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Poke BBQ", 1400.00, "poke_bbq"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Veggie Burger", 500.00, "veggie_burger"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Smoothie Juice", 1200.00, "smoothi_juice"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Beef Fry", 1500.00, "beef_fry"));


        topSellingFoodDomains.add(new TopSellingFoodDomain("Potato Chips", 100.00, "potato_chips"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Poke BBQ", 1400.00, "poke_bbq"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Veggie Burger", 500.00, "veggie_burger"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Smoothie Juice", 1200.00, "smoothi_juice"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Beef Fry", 1500.00, "beef_fry"));

        topSellingFoodDomains.add(new TopSellingFoodDomain("Potato Chips", 100.00, "potato_chips"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Poke BBQ", 1400.00, "poke_bbq"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Veggie Burger", 500.00, "veggie_burger"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Smoothie Juice", 1200.00, "smoothi_juice"));
        topSellingFoodDomains.add(new TopSellingFoodDomain("Beef Fry", 1500.00, "beef_fry"));
        topSellingAdapter = new TopSellingAdapter(topSellingFoodDomains);
        recylerViewTopSellingList.setAdapter(topSellingAdapter);
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recylerViewPopulerList = findViewById(R.id.recyclerView2);
        recylerViewPopulerList.setLayoutManager(linearLayoutManager);

        List<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni Pizza", "pizza1", "slices pepperoni", 13.0, 5, 5, 1000));
        foodList.add(new FoodDomain("Cheese Burger", "burger", "special sauce, lettuce, tomato ", 15.20, 5, 5, 1000));
        foodList.add(new FoodDomain("Vegetable Burger", "pizza3", "Olive oil, vegetable oil, pittled kalamata", 25.0, 5, 5, 1000));
        foodList.add(new FoodDomain("Doner Kebab Gyro", "kebab", "Olive oil, vegetable oil, pittled kalamata", 25.0, 5, 5, 1000));
        foodList.add(new FoodDomain("Pasta", "pasta", "Olive oil, vegetable oil, pittled kalamata", 25.0, 5, 5, 1000));

        adapter2 = new RecommendedAdapter(foodList);
        recylerViewPopulerList.setAdapter(adapter2);

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView11);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        List<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza", "cat_1"));
        categoryList.add(new CategoryDomain("Burger", "cat_2"));
        categoryList.add(new CategoryDomain("Hot Dog", "cat_3"));
        categoryList.add(new CategoryDomain("Drink", "cat_4"));
        categoryList.add(new CategoryDomain("Donut", "cat_5"));


        adapter = new CategoryAdapter(categoryList);

        recyclerViewCategoryList.setAdapter(adapter);

    }
    public void recyclerViewGridItems() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MenuActivity.this, 2,RecyclerView.VERTICAL,false);
        recyclerViewAllFoods = findViewById(R.id.allFoodRecylerView);
        recyclerViewAllFoods.setLayoutManager(gridLayoutManager);

        List<FoodItem> foodItems = new LinkedList<>();

        foodItems.add(new FoodItem("Pepporani Pizza","pizza1"));
        foodItems.add(new FoodItem("Cheese Burger","burger"));
        foodItems.add(new FoodItem("Vegetable Burger","pizza3"));
        foodItems.add(new FoodItem("Doner Kebab Gyro","kebab"));
        foodItems.add(new FoodItem("Pasta","pasta"));


        foodItems.add(new FoodItem("Pepporani Pizza","pizza1"));
        foodItems.add(new FoodItem("Cheese Burger","burger"));
        foodItems.add(new FoodItem("Vegetable Burger","pizza3"));
        foodItems.add(new FoodItem("Doner Kebab Gyro","kebab"));
        foodItems.add(new FoodItem("Pasta","pasta"));

        foodItems.add(new FoodItem("Pepporani Pizza","pizza1"));
        foodItems.add(new FoodItem("Cheese Burger","burger"));
        foodItems.add(new FoodItem("Vegetable Burger","pizza3"));
        foodItems.add(new FoodItem("Doner Kebab Gyro","kebab"));
        foodItems.add(new FoodItem("Pasta","pasta"));


        foodItems.add(new FoodItem("Pepporani Pizza","pizza1"));
        foodItems.add(new FoodItem("Cheese Burger","burger"));
        foodItems.add(new FoodItem("Vegetable Burger","pizza3"));
        foodItems.add(new FoodItem("Doner Kebab Gyro","kebab"));
        foodItems.add(new FoodItem("Pasta","pasta"));

        allFoodsAdapter = new GridAdapter(foodItems);
        recyclerViewAllFoods.setAdapter(allFoodsAdapter);

    }
}
