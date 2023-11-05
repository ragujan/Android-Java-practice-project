package com.rag.testapp5.activity;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rag.testapp5.databinding.ActivityCartBinding;
import com.rag.testapp5.helper.ManagementCart;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;

    private TextView itemsTotalAmount, taxAmount, deliveryServicesAmount, cartFinalTotalAmount, emptyTxt;

    private double tax;
    private ScrollView scrollView;

    ActivityCartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        binding = binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        managementCart = new ManagementCart(CartActivity.this);

        initView();
        calculateCard();
    }

    private void initView(){

        itemsTotalAmount = binding.itemsTotalAmount;
        taxAmount = binding.taxAmount;
        deliveryServicesAmount = binding.deliveryServicesAmount;
        cartFinalTotalAmount = binding.cartTotal;
        recyclerViewList = binding.myCartRecylerView;
        scrollView = binding.myCartScrollView;
        emptyTxt = binding.emptyCartMessage;



    }
    private void initList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);

    }
    private void calculateCard(){
        double percentTax = 0.02;
        double deliveryCharge = 10.00;

        tax = Math.round((managementCart.getTotalFee() * percentTax) * 100.0)/100.0;

        double total = Math.round((managementCart.getTotalFee() + tax + deliveryCharge) * 100.00)/100.00;

        double itemTotal = Math.round(managementCart.getTotalFee() * 100.00) /100.00;


       itemsTotalAmount.setText("$ "+Double.toString(itemTotal));
       taxAmount.setText("$ "+Double.toString(tax));
       deliveryServicesAmount.setText("$ "+Double.toString(deliveryCharge));
       cartFinalTotalAmount.setText("$ "+Double.toString(deliveryCharge));






    }

}
