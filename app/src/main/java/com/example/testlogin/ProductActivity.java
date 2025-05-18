package com.example.testlogin;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//Рабочий вариант без добавления в корзину
/*
public class ProductActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProducts;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));

        List<Product> productList = new ArrayList<>();

        // Добавьте товары в список (замените на ваши данные)
        productList.add(new Product("Товар 1", "Цена: 1000 руб.", R.drawable.product1));
        productList.add(new Product("Товар 2", "Цена: 1500 руб.", R.drawable.product2));
        productList.add(new Product("Товар 3", "Цена: 2000 руб.", R.drawable.product3));

        // Инициализация адаптера и установка его в RecyclerView
        productAdapter = new ProductAdapter(productList);
        recyclerViewProducts.setAdapter(productAdapter);
    }
}*/
// Вариант с рабочей кнопкой выбрать товар
public class ProductActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vb);

        recyclerView = findViewById(R.id.recycler_view);

        // Инициализация списка продуктов
        productList = new ArrayList<>();
        productList.add(new Product("Товар 1", "$10", R.drawable.product1));
        productList.add(new Product("Товар 2", "$20", R.drawable.product2));
        productList.add(new Product("Товар 3", "Цена: 2000 руб.", R.drawable.product3));

        // Настройка адаптера и RecyclerView
        productAdapter = new ProductAdapter(productList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productAdapter);
    }
}

