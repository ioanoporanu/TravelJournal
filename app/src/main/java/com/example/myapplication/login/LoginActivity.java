package com.example.myapplication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.MainActivity;
import com.example.myapplication.NavigationDrawer;
import com.example.myapplication.R;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    Handler h = new Handler();
    public String username;
    public String email;
    public String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();
        EditText usernameLogin = findViewById(R.id.enterUsername);
        EditText emailLogin = findViewById(R.id.enterEmail);
        EditText passwordLogin = findViewById(R.id.enterPassword);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameLogin.getText().toString();
                password = passwordLogin.getText().toString();
                email = emailLogin.getText().toString();
                Intent i = new Intent(LoginActivity.this, NavigationDrawer.class);

                i.putExtra("username", username);
                i.putExtra("email", email);
                i.putExtra("password", password);

                startActivity(i);
                finish();
            }
        });

    }
}