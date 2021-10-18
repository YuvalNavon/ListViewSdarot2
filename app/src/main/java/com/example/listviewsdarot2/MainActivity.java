package com.example.listviewsdarot2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int series_check;
    double a1;
    double diff;
    EditText first;
    EditText diff_t;
    Switch sw;


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

        if (sw.isChecked() == false)
        {
            series_check =  0;
        }
        else
        {
            series_check = 1;
        }
        if (first.getText().toString().isEmpty() == false && diff_t.getText().toString().isEmpty() == false && !first.getText().toString().equals(".") && !diff_t.getText().toString().equals(".") && !first.getText().toString().equals("-.") && !diff_t.getText().toString().equals("-.") && !first.getText().toString().equals("+") && !diff_t.getText().toString().equals("+") && !first.getText().toString().equals("-") && !diff_t.getText().toString().equals("-") && !first.getText().toString().equals("+.") && !diff_t.getText().toString().equals("+."))
        {
            Intent si = new Intent(this, results.class);
            a1 = Double.parseDouble(first.getText().toString());
            diff = Double.parseDouble(diff_t.getText().toString());
            si.putExtra("first", a1);
            si.putExtra("m", diff);
            si.putExtra("series_type", series_check);
            startActivity(si);
        }
        else
            {
                Toast.makeText(getApplicationContext(), "Please input all pararmeters correctly!", Toast.LENGTH_SHORT).show();

            }


    }

}