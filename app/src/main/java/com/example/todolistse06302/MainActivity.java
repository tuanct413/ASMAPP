package com.example.todolistse06302;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText edtEmail,edtPassword;
    private Button btnLogin;
    private SharedPreferences sharedPreferences;
    private FirebaseAuth mAtuth;
    private TextView txtError;
    private Button btnRegister;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        mAtuth = FirebaseAuth.getInstance();

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtError = findViewById(R.id.txtErorr);
        btnRegister = findViewById(R.id.btnRegister);
        if (sharedPreferences.getBoolean("isLoggedIn", false)) {
            txtError.setText("you are already logged in");
        }
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRegister();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });


    }

    private void loginUser(){

        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()){
            txtError.setText("Please fill all fields");
            txtError.setVisibility(View.VISIBLE);
            return;
        }
        mAtuth.signInWithEmailAndPassword(email , password)
                .addOnCompleteListener(this,task ->{
            if (task.isSuccessful()){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn",true);
                editor.apply();
                txtError.setText("Login successful");
                txtError.setVisibility(View.VISIBLE);
            }else {
                txtError.setText("Login failed");
            }
        });


    }

    private void navigateToHome(){
            Intent intent = new Intent(MainActivity.this,HomeSreen.class);
            startActivity(intent);
            finish();

    }
    private void navigateToRegister(){
        Intent intent = new Intent(MainActivity.this,Register.class);
        startActivity(intent);
        finish();
    }

}