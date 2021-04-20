package com.app.intent_xxxextra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
public class Enfant1 extends Activity {
    Button B_OK;
    Button B_AN;
    EditText votre_age;
    private String age;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        B_OK=(Button)findViewById(R.id.boutonOK);
        B_AN=(Button)findViewById(R.id.boutonANNULER);
        votre_age=(EditText)findViewById(R.id.editT);
        B_OK.setOnClickListener (new OnClickListener () {
            public void onClick (View view) {
                age=votre_age.getText().toString();
                Intent resultat= new Intent ();
                resultat.putExtra("maclé",age);
                setResult(RESULT_OK, resultat);
                finish();
            }
        });
        B_AN.setOnClickListener (new OnClickListener () {
            public void onClick (View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}