package com.app.intent_putextrat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
public class Enfant1 extends Activity {
    Button B_OK;
    Button B_AN;
    TextView textV;
    private String nom;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        // get extra
        Bundle infoNom = this.getIntent().getExtras();
        if(infoNom != null){
            nom=infoNom.getString("monNom");
        }
        textV=(TextView)findViewById(R.id.textV);
        textV.setText("Bonjour "+nom+" bienvenu dans l'activité Enfant1");

        B_OK=(Button)findViewById(R.id.boutonOK);
        B_AN=(Button)findViewById(R.id.boutonANNULER);
        B_OK.setOnClickListener (new OnClickListener () {
            public void onClick (View view) {
                setResult(RESULT_OK);
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
