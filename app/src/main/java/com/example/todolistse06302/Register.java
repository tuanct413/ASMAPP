package com.example.todolistse06302;

import android.annotation.SuppressLint;
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

import com.example.todolistse06302.database.DatabaseHelper;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private EditText edtEmailRegister, edtPasswordRegister;
    private Button btnSubmitRegister;

    private FirebaseAuth mAuth;
    private DatabaseHelper dbHelper;
    private TextView txtMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtEmailRegister =findViewById(R.id.txtPassworld);
        edtPasswordRegister =findViewById(R.id.txtEmail);
        btnSubmitRegister =findViewById(R.id.btnRegister);
        txtMessage=findViewById(R.id.txtMessage);
        dbHelper = new DatabaseHelper(this);

        mAuth = FirebaseAuth.getInstance();
        btnSubmitRegister.setOnClickListener(v ->{
            String email = edtEmailRegister.getText().toString();
            String pass = edtPasswordRegister.getText().toString();
          long id =  dbHelper.addUser(email,pass);

            if (id > 0){
                txtMessage.setText("successfully ");

            }
            else {
                txtMessage.setText("Fail");
            }
            txtMessage.setVisibility(View.VISIBLE);
        });
    }
}