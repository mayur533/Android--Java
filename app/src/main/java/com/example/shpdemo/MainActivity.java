package com.example.shpdemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void save(View view) {
        EditText ed= findViewById(R.id.inptxt);
        SharedPreferences sharedPreferences=getSharedPreferences("Data",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String s=ed.getText().toString();
        editor.putString(getString(R.string.text),s);
        editor.apply();
    }

    public void disp(View view) {
        EditText ed= findViewById(R.id.inptxt);
        SharedPreferences sharedPreferences=getSharedPreferences("Data",MODE_PRIVATE);
        ed.setText(sharedPreferences.getString(getString(R.string.text),""));
    }
}