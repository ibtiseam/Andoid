package com.app.intent_putextrat;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Principale extends Activity {
    Button bouton;
    EditText texte_nom;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bouton=(Button)findViewById(R.id.bouton);
        bouton.setOnClickListener(new OnClickListener(){
            public void onClick (View view){
                texte_nom=(EditText)findViewById(R.id.editT);
                String nom = texte_nom.getText().toString();
                Intent intent=new Intent(Principale.this,Enfant1.class);
                intent.putExtra("monNom", nom);
                startActivityForResult(intent,1);
            }
        });
    }
    public void onActivityResult (int requestCode, int resultCode, Intent data){
        switch (resultCode){
            case RESULT_OK:
                Toast.makeText(this,"Enfant1 OK", Toast.LENGTH_SHORT).show();
                return;
            case RESULT_CANCELED:
                Toast.makeText(this,"Enfant1 Annuler", Toast.LENGTH_SHORT).show();
                return;
        }
    }
}