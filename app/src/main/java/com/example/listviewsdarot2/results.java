package com.example.listviewsdarot2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class results extends AppCompatActivity implements AdapterView.OnItemClickListener {
    double a1, m, sum;
    TextView a1_t, m_t, n_t, sn_t;
    Intent gi;
    ListView list;
    String[] terms_sum = new String[20];
    double[] terms_dou = new double[20];
    String[] terms = new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        gi = getIntent();

        int type = gi.getIntExtra("series_type",0);
        a1 = gi.getDoubleExtra("first", 0);
        m = gi.getDoubleExtra("m", 0);
        if (type == 0)
        {
            terms_dou[0] = a1;
            sum = a1;
            terms[0] = String.valueOf(a1);
            terms_sum[0] = String.valueOf(a1);

            for (int i=1; i<20;i++)
            {

                terms_dou[i] = terms_dou[i-1]+m;
                terms[i] = String.valueOf(terms_dou[i]);
                sum = sum + terms_dou[i];
                terms_sum[i] = String.valueOf(sum);
            }
        }
        if (type == 1)
        {
            terms_dou[0] = a1;
            sum = a1;
            terms[0] = String.valueOf(a1);
            terms_sum[0] = String.valueOf(a1);

            for (int i=1; i<20;i++)
            {

                terms_dou[i] = terms_dou[i-1]*m;
                terms[i] = String.valueOf(terms_dou[i]);
                sum = sum + terms_dou[i];
                terms_sum[i] = String.valueOf(sum);
            }
        }


        list = (ListView) findViewById(R.id.listview);
        list.setOnItemClickListener(this);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        a1_t = (TextView) findViewById(R.id.a1_1);
        m_t = (TextView) findViewById(R.id.m_1);
        n_t = (TextView) findViewById(R.id.n);
        sn_t = (TextView) findViewById(R.id.sum_to_n);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, terms);
        list.setAdapter(adp);
        a1_t.setText(terms[0]);
        m_t.setText(String.valueOf(m));
    }
    public void goback(View view)
    {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            n_t.setText(terms[position]);
            sn_t.setText(terms_sum[position]);
    }
}