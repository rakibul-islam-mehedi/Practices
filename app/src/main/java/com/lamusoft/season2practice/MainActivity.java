package com.lamusoft.season2practice;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edName;
    private Button saveBtn, storageBtn;
    private TextView tvDisplay;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
        setClickListener();
    }

    private void setClickListener() {

        saveBtn.setOnClickListener(v -> {
            String name = edName.getText().toString();
            editor.putString("name", name);
            editor.putInt("age", 21);
            editor.apply();
        });

        storageBtn.setOnClickListener(v -> {

            //Get data from SharedPreference
            String name = sharedPreferences.getString("name", "Empty");
            int age = sharedPreferences.getInt("age", 0);

            //Print in TextView
            tvDisplay.setText("Name: "+name +"\n Age: "+ age);



        });

    }

    private void initialization() {
        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();
        edName = findViewById(R.id.edName);
        saveBtn = findViewById(R.id.saveBtn);
        storageBtn = findViewById(R.id.storageBtn);
        tvDisplay = findViewById(R.id.tvDisplay);

    }
}