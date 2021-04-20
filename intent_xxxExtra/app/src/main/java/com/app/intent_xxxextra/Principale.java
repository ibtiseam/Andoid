package com.app.intent_xxxextra;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
public class Principale extends Activity {
    Button bouton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bouton=(Button)findViewById(R.id.bouton);
        bouton.setOnClickListener(new OnClickListener(){
            public void onClick (View view){
                Intent intent=new Intent(Principale.this,Enfant1.class);
                startActivityForResult(intent,1);
            }
        });
    }
    public void onActivityResult (int requestCode, int resultCode, Intent data){
        switch (resultCode){
            case RESULT_OK:
                String age=data.getStringExtra("maclé");
                Toast.makeText(this,"Vous avez "+age+" ans", Toast.LENGTH_SHORT).show();
                return;
            case RESULT_CANCELED:
                Toast.makeText(this,"Vous ne voulez pas donner votre age",Toast.LENGTH_SHORT).show();
                return;
        }
    }
}
