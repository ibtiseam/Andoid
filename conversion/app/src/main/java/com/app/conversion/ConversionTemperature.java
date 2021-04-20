package com.app.conversion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ConversionTemperature extends AppCompatActivity {
    Button ansBtn, againbns;
    TextView showAns;
    EditText getVal;
    RadioButton c2f,f2c;
    Double x ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature_conversion);
        ansBtn= findViewById(R.id.ansBtn);
        showAns = findViewById(R.id.showAns);
        getVal = findViewById(R.id.getVal);
        c2f = findViewById(R.id.c2f);
        f2c = findViewById(R.id.f2c);
        againbns = findViewById(R.id.againBtn);

        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getVal.getText().toString().isEmpty()){
                    showAns.setText("donner une temperature svp");
                }else{
                    x = Double.parseDouble(getVal.getText().toString());
                    if (c2f.isChecked()){
                        x= (x*9)/5+32;
                        //x= Double.parseDouble(new DecimalFormat(]"##.##").format(x));
                        showAns.setText(String.format("%.2f C",x));
                        showAns.setText(x + "Degree F");
                    }
                    else if (f2c.isChecked()){
                        x= (x-32)*5/9;
                        //x= Double.parseDouble(new DecimalFormat("##.##").format(x));
                        showAns.setText(String.format("%.2f C",x));
                    }else {
                        showAns.setText("selectioner une option !");
                    }

                }
            }
        });
        againbns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAns.setText("0.0");
                getVal.setText("");
                c2f.setChecked(false);
                f2c.setChecked(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"Conversion Euro <=> Dinar");
        menu.add(0,2,0,"Quitter");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1 :
                Intent i = new Intent(ConversionTemperature.this, MainActivity.class);
                startActivity(i);
                break;
            case 2 :
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}