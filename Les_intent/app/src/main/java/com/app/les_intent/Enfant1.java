package com.app.les_intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class Enfant1 extends Activity {
    Button B_OK;
    Button B_AN;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        B_OK=(Button)findViewById(R.id.boutonOK1);
        B_AN=(Button)findViewById(R.id.boutonANNULER1);
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
