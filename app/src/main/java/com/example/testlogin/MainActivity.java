package com.example.testlogin;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.testlogin.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonRegister;
    private Button buttonLogin;
    private TextView textViewResult;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewResult = findViewById(R.id.textViewResult);

        databaseHelper = new DatabaseHelper(this);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void registerUser() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        if (databaseHelper.registerUser(username, password)) {
            Toast.makeText(this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
            textViewResult.setText("");
            editTextUsername.setText("");
            editTextPassword.setText("");
        } else {
            Toast.makeText(this, "Ошибка регистрации", Toast.LENGTH_SHORT).show();
        }
    }

    private void loginUser() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        if (databaseHelper.checkUser(username, password)) {
            textViewResult.setText("Вход успешен!");
            Toast.makeText(this, "Добро пожаловать!", Toast.LENGTH_SHORT).show();
            editTextUsername.setText("");
            editTextPassword.setText("");
            Intent intent = new Intent(MainActivity.this, ProductActivity.class);
            startActivity(intent);
        } else {
            textViewResult.setText("Неверный логин или пароль");
            Toast.makeText(this, "Попробуйте снова", Toast.LENGTH_SHORT).show();
        }
    }
}