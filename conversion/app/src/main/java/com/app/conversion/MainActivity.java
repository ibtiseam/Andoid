package com.app.conversion;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText mMonnaie;
    private RadioButton tn, eu;
    private TextView mResultat;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMonnaie = (EditText) findViewById(R.id.et_monnaie);
        mButton = (Button) findViewById(R.id.bnt_convertir);
        mResultat = (TextView) findViewById(R.id.tv_res);
        tn = (RadioButton) findViewById(R.id.rd_Tn);
        eu = (RadioButton) findViewById(R.id.rd_Eu);

        tn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.showContextMenu();
                return false;
            }
        });
        tn.setOnCreateContextMenuListener(this);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 1, 0, "Conversion euro => Dinar");
        menu.add(0, 2, 0, "Conversion Dinar => Euro");
        menu.add(0, 3, 0, "Conversion C <=> F");
        menu.add(0, 4, 0, "Conversion F <=> C");
        menu.add(0, 5, 0, "Quitter");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"Conversion C <=> F");
        menu.add(0,2,0,"Quitter");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1 :
                Intent i = new Intent(MainActivity.this, ConversionTemperature.class);
                startActivity(i);
                break;
            case 2 :
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                float valeurInt = Float.valueOf(mMonnaie.getText().toString());
                String res = String.valueOf(euroToDninar(valeurInt));
                Toast.makeText(this, res, Toast.LENGTH_LONG).show();
                break;
            case 2:
                valeurInt = Float.valueOf(mMonnaie.getText().toString());
                res = String.valueOf(dinarToEuro(valeurInt));
                Toast.makeText(this, res, Toast.LENGTH_LONG).show();
                break;
            case 3:
                Intent i = new Intent(MainActivity.this, ConversionTemperature.class);
                startActivity(i);
                break;
            case 4:
                i = new Intent(MainActivity.this, ConversionTemperature.class);
                startActivity(i);
                break;
            case 5:
                this.finish();
                break;
        }
        return super.onContextItemSelected(item);
    }



    private float euroToDninar(float valeurEuro) {
        return ((float) (valeurEuro * 2.92));
    }

    private float dinarToEuro(float valeurDinar) {
        return ((float) (valeurDinar * 0.31));
    }

    public void convertir(View v) {

        float valeurInt = Float.valueOf(mMonnaie.getText().toString());
        float res;
        if (tn.isChecked()) {
            res = euroToDninar(valeurInt);
            mResultat.setText(String.valueOf(res));
        } else if (eu.isChecked()) {
            res = dinarToEuro(valeurInt);
            mResultat.setText(String.valueOf(res));
        } else {
            Toast.makeText(getApplicationContext(), "Selectioner une option", Toast.LENGTH_SHORT).show();
        }


    }


}