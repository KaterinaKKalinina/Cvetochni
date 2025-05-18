package com.example.testlogin;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        TextView textViewCart = findViewById(R.id.textViewCart);

        // Получаем данные из Intent
        String productName = getIntent().getStringExtra("product_name");
        String productPrice = getIntent().getStringExtra("product_price");

        // Отображаем выбранный товар
        if (productName != null && productPrice != null) {
            textViewCart.setText("Выбранный товар:\n" + productName + "\nЦена: " + productPrice);
        } else {
            textViewCart.setText("Корзина пуста");
        }
    }
}
