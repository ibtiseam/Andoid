package com.app.intent_implicitex2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class Principale extends Activity {
    Button bouton;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bouton=(Button)findViewById(R.id.bouton);
        bouton.setOnClickListener(new OnClickListener () {
            public void onClick (View view) {
                Uri uri=Uri.parse("tel:96260416");
                Intent intent = new Intent (Intent.ACTION_CALL,uri);
                startActivity(intent);
            }

        });
    }
}