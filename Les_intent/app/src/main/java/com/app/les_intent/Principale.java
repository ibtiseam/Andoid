package com.app.les_intent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
public class Principale extends Activity {
    Button bouton_1;
    Button bouton_2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bouton_1=(Button)findViewById(R.id.bouton1);
        bouton_2=(Button)findViewById(R.id.bouton2);
        bouton_1.setOnClickListener(new OnClickListener(){
            public void onClick (View view){
                Intent intent=new Intent(Principale.this,Enfant1.class);
                startActivityForResult(intent,1);
            }
        });
        bouton_2.setOnClickListener(new OnClickListener(){
            public void onClick (View view){
                Intent intent=new Intent(Principale.this,Enfant2.class);
                startActivityForResult(intent,2);
            }
        });
    }
    public void onActivityResult (int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case (1):
                switch (resultCode){
                    case RESULT_OK:
                        Toast.makeText(this,"Enfant1 OK", Toast.LENGTH_SHORT).show();
                        return;
                    case RESULT_CANCELED:
                        Toast.makeText(this,"Enfant1 Annuler", Toast.LENGTH_SHORT).show();
                        return;
                }
            case (2):
                switch (resultCode){
                    case RESULT_OK:
                        Toast.makeText(this,"Enfant2 OK", Toast.LENGTH_SHORT).show();
                        return;
                    case RESULT_CANCELED:
                        Toast.makeText(this,"Enfant2 Annuler", Toast.LENGTH_SHORT).show();
                        return;
                }
        }

    }
}
