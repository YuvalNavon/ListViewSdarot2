package com.example.listviewsdarot2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    char series_check;
    int a1;
    int diff;
    EditText first;
    EditText diff_t;
    Switch sw;
    Intent gi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = (EditText) findViewById(R.id.a1);
        diff_t = (EditText) findViewById(R.id.m);
        sw = (Switch) findViewById(R.id.switch1);
    }

    public void calculate (View view)
    {
        if (first.getText().toString().isEmpty() || diff_t.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please input all pararmeters!", Toast.LENGTH_SHORT).show();
        }
        if (sw.isChecked() == false)
        {
            series_check = 'a';
        }
        else
        {
            series_check = 'g';
        }
        Intent si = new Intent(this, results.class);
        si.putExtra("first", a1);
        si.putExtra("m", diff);

    }

}