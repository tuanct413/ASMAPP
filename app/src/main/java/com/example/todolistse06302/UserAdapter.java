package com.example.todolistse06302;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.example.todolistse06302.database.DatabaseHelper;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private List<User> users;
//
     private  Tuannguuvailoz tuanngu;

    private DatabaseHelper db;
    public UserAdapter(Context context,List<User>users) {
        this.context = context;
        this.users = users;
       this.db = new DatabaseHelper(context);

    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return users.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.activity_register, null);

        User user = users.get(i);
        if (user != null){
            EditText txtEmail = view.findViewById(R.id.edtEmail);

            txtEmail.setText(user.getEmail());
            EditText txtPassword = view.findViewById(R.id.edtPassword);
            txtPassword.setText(user.getPassword());
        }



        return view;
    }
}
